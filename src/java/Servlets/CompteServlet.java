/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AccountDAO;
import DAO.BankBranchDAO;
import DAO.ClientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Compte;
import models.BankBranch;
import models.Client;

/**
 * La Servlet liée à l'objet Compte.
 * @author MGU
 */
public class CompteServlet extends HttpServlet {
    private final AccountDAO accountDAO = AccountDAO.getInstance();
    private final ClientDAO clientDAO = ClientDAO.getInstance();
    private final BankBranchDAO bankBranchDAO = BankBranchDAO.getInstance();
    
    public static final String VUE = "WEB-INF/formulaireCompte.jsp";
    public static final String LIBELLE = "libelle";
    public static final String IBAN = "iban";
    public static final String SOLDE = "solde";
    public static final String CLIENT = "client";
    public static final String BRANCHE = "branche";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String libelle = request.getParameter(LIBELLE);
        String iban = request.getParameter(IBAN);
        String solde = request.getParameter(SOLDE);
        String clientIdToAttach = request.getParameter(CLIENT);
        String branchIdToAttach = request.getParameter(BRANCHE);
        
        String[] infosCompte = {libelle, iban, solde, branchIdToAttach};
        
        Client clientToAttach = clientDAO.find(clientIdToAttach);
       
        try {
            Compte compteCree = createAccount(infosCompte);
            addClientToAccount(clientToAttach, compteCree.getAccount_id());
            List<Compte> listComptes = findAllAccounts();     
            request.setAttribute("listComptes", listComptes);
            request.getRequestDispatcher("/listeComptes.jsp").forward(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        switch(action) {
            case "create":
                List<Client> listClients = (List<Client>) clientDAO.findAll(); 
                List<BankBranch> listBranches = (List<BankBranch>) bankBranchDAO.findAll();
                request.setAttribute("listClients", listClients);
                request.setAttribute("listBranches", listBranches);
                request.getRequestDispatcher("/formulaireCompte.jsp").forward(request, response);
                break;
                
            case "list":
                List<Compte> listComptes = findAllAccounts();     
                request.setAttribute("listComptes", listComptes);
                request.getRequestDispatcher("/listeComptes.jsp").forward(request, response);
                break;
                
            case "delete":
                String compteId = request.getParameter("id");
                Compte compteToDelete = findById(compteId);
                removeAccount(compteToDelete);
                
                List<Compte> newListComptes = findAllAccounts();     
                request.setAttribute("listComptes", newListComptes);
                request.getRequestDispatcher("/listeComptes.jsp").forward(request, response);
                break;
                
            default:
                try(PrintWriter out = response.getWriter()){
                    out.print("action inconnue...");   
                }catch(Exception e){}
                break;
        }
    }
    
    /**
     * Méthode permettant de créer un compte.
     * @param infoAccount
     * @return le compte (ID inclus)
     */
    public Compte createAccount(String[] infoAccount){
        Compte account = new Compte();
        account.setIban(infoAccount[0]);
        account.setLibelle(infoAccount[1]);
        account.setSolde(new Double(infoAccount[2]));
        account.setBankbranch(bankBranchDAO.find(infoAccount[3]));
        accountDAO.create(account);
        return account;      
    }
    
    /**
     * Permet de mettre à jour un compte.
     * @param infoAccount
     * @param idAccount
     * @return le compte modifié
     */
    public Compte updateAccount(String[] infoAccount, String idAccount){
        Compte account = findById(idAccount);
        account.setIban(infoAccount[0]);
        account.setLibelle(infoAccount[1]);
        account.setSolde(new Double(infoAccount[2]));
        account.setBankbranch(bankBranchDAO.find(infoAccount[3]));
        accountDAO.update(account);
        return account;        
    }
    
    /**
     * Permet de mettre à jour un compte.
     * @param account
     * @return le compte modifié
     */
    public Compte updateAccount(Compte account){
       accountDAO.update(account);
       return account;
       
    }
    
    /**
     * Permet de rechercher un Compte dans la DB.
     * @param id
     * @return le compte associé à l'ID
     */
    public Compte findById(String id){
        return accountDAO.find(id);
    }
    
    /**
     * Méthode permettant de retourner l'ensemble des comptes de la DB.
     * @return l'ensemble des comptes de la DB
     */
    public List<Compte> findAllAccounts(){
        return accountDAO.findAll();
    }
        
    /**
     * Permet de supprimer un compte passé en paramètre.
     * @param account 
     */
    public void removeAccount(Compte account){
        accountDAO.delete(account);
    }
    
    /**
     * Permet de récupérer tout les Compte qui sont associés à la BankBranch 
     * passé en paramètre.
     * @param branch
     * @return 
     */
    public List<Compte> findAllByBranchId(BankBranch branch){
        return accountDAO.findAllByBranchId(branch);
    }
    
    /**
     * Permet d'ajouter un Client à un Compte.
     * @param client
     * @param accountId 
     */
    public void addClientToAccount(Client client, String accountId){
        Compte account =  findById(accountId);
        account.getMesClients().add(client);
        client.getMescomptes().add(account);
        accountDAO.update(account);
        ClientDAO.getInstance().update(client);
    }
    
}
