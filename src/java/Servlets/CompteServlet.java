/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AccountDAO;
import DAO.ClientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    
    public static final String VUE = "WEB-INF/formulaireCompte.jsp";
    public static final String LIBELLE = "libelle";
    public static final String IBAN = "iban";
    public static final String SOLDE = "solde";
    public static final String CLIENT = "client";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String libelle = request.getParameter(LIBELLE);
        String iban = request.getParameter(IBAN);
        String solde = request.getParameter(SOLDE);
        String clientIdToAttach = request.getParameter(CLIENT);
        
        String[] infosCompte = {libelle, iban, solde};
        
        Client clientToAttach = clientDAO.find(clientIdToAttach);
       
        try {
            Compte compteCree = createAccount(infosCompte);
            addClientToAccount(clientToAttach, compteCree.getAccount_id());
            List<Compte> listComptes = (List<Compte>) accountDAO.findAll();     
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
                request.setAttribute("listClients", listClients);
                request.getRequestDispatcher("/formulaireCompte.jsp").forward(request, response);
                break;
                
            case "list":
                List<Compte> listComptes = (List<Compte>) accountDAO.findAll();     
                request.setAttribute("listComptes", listComptes);
                request.getRequestDispatcher("/listeComptes.jsp").forward(request, response);
                break;
                
            case "delete":
                String compteId = request.getParameter("id");
                Compte compteToDelete = accountDAO.find(compteId);
                removeAccount(compteToDelete);
                
                List<Compte> newListComptes = (List<Compte>) accountDAO.findAll();     
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
    
    
    public Compte createAccount(String[] infoAccount){
        Compte account = new Compte();
        account.setIban(infoAccount[0]);
        account.setLibelle(infoAccount[1]);
        account.setSolde(new Double(infoAccount[2]));        
        accountDAO.create(account);
        return account;        
    }
    
    public Compte updateAccount(String[] infoAccount, String idAccount){
        Compte account = findById(idAccount);
        account.setIban(infoAccount[0]);
        account.setLibelle(infoAccount[1]);
        account.setSolde(new Double(infoAccount[2]));   
        accountDAO.update(account);
        
        return account;        
    }
    
    public Compte updateAccount(Compte account){
       accountDAO.update(account);
       return account;
       
    }
    
    public Compte findById(String id){
        return accountDAO.find(id);
    }
    
    public List<Compte> findAllAccounts(){
        return accountDAO.findAll();
    }
           
    public void removeAccount(Compte account){
        accountDAO.delete(account);
    }
    
    public List<Compte> findAllByBranchId(BankBranch branch){
        return accountDAO.findAllByBranchId(branch);
    }
    
    public void addClientToAccount(Client client, String accountId){
        Compte account =  findById(accountId);
        account.getMesClients().add(client);
        client.getMescomptes().add(account);
        accountDAO.update(account);
        ClientDAO.getInstance().update(client);
    }
    
}
