/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AccountDAO;
import DAO.ClientDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Compte;
import models.BankBranch;
import models.Client;

/**
 *
 * @author MGU
 */
public class CompteServlet extends HttpServlet {
    private final AccountDAO accountDAO = AccountDAO.getInstance();
    
    public static final String VUE = "WEB-INF/formulaireCompte.jsp";
    public static final String LIBELLE = "libelle";
    public static final String IBAN = "iban";
    public static final String SOLDE = "solde";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String libelle = request.getParameter(LIBELLE);
        String iban = request.getParameter(IBAN);
        String solde = request.getParameter(SOLDE);
        
        String[] infosCompte = {libelle, iban, solde};
        System.out.println(infosCompte);
       
        try {
            
            createAccount(infosCompte);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Compte> listComptes = (List<Compte>) accountDAO.findAll();     
        request.setAttribute("listComptes", listComptes);
        request.getRequestDispatcher("/listeComptes.jsp").forward(request, response);

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
