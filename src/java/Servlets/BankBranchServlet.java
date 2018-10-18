/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AccountDAO;
import DAO.BankBranchDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Compte;
import models.BankBranch;

/**
 * La Servlet liée à l'objet BankBranch.
 * @author MGU
 */
public class BankBranchServlet extends HttpServlet {
    private final BankBranchDAO bankBranchDAO = BankBranchDAO.getInstance();
    private final AccountDAO accountDAO = AccountDAO.getInstance();
    
    public static final String VUE = "WEB-INF/formulaireBranche.jsp";
    public static final String ADRESSE = "adresse";
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String adresse = request.getParameter(ADRESSE);
                
        try {
            createBranch(adresse);
            List<BankBranch> listBranches = findAllBranches();     
            request.setAttribute("listBranches", listBranches);
            request.getRequestDispatcher("/listeBranches.jsp").forward(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        switch(action) {
            case "list":
                List<BankBranch> listBranches = findAllBranches();     
                request.setAttribute("listBranches", listBranches);
                request.getRequestDispatcher("/listeBranches.jsp").forward(request, response);
                break;
                
            case "delete":
                String brancheId = request.getParameter("id");
                BankBranch brancheToDelete = findById(brancheId);
                removeBranch(brancheToDelete);
                
                List<BankBranch> newListBranches = findAllBranches();     
                request.setAttribute("listBranches", newListBranches);
                request.getRequestDispatcher("/listeBranches.jsp").forward(request, response);
                break;
                
            default:
                try(PrintWriter out = response.getWriter()){
                    out.print("action inconnue...");   
                }catch(Exception e){}
                break;
        }
    }
    
    /**
     * Méthode permettant de créer une branche.
     * @param infoBranch
     * @return la branche (ID inclus)
     */
    public BankBranch createBranch(String infoBranch){
        BankBranch branch = new BankBranch();
        branch.setAdresse(infoBranch);      
        bankBranchDAO.create(branch);
        return branch;        
    }
    
    /**
     * Permet de mettre à jour une branche.
     * @param infoBranch
     * @param idBranch
     * @return la branhe modifiée
     */
    public BankBranch updateBranch(String infoBranch, String idBranch){
        BankBranch branch = findById(idBranch);
        branch.setAdresse(infoBranch); 
        bankBranchDAO.update(branch);
        return branch;        
    }
    
    /**
     * Permet de rechercher une Branche dans la DB.
     * @param id
     * @return la branche associée à l'ID
     */
    public BankBranch findById(String id){
        return bankBranchDAO.find(id);
    }
    
    /**
     * Méthode permettant de retourner l'ensemble des branches de la DB.
     * @return l'ensemble des branches de la DB
     */
    public List<BankBranch> findAllBranches(){
        return bankBranchDAO.findAll();
    }
          
    /**
     * Permet de supprimer une branche passée en paramètre.
     * @param branch 
     */
    public void removeBranch(BankBranch branch){
        CompteServlet accountControler = new CompteServlet();
        try{
            List<Compte> comptes = accountControler.findAllByBranchId(branch);
            for (Compte account : comptes) {
                account.setBankbranch(null);
                accountDAO.update(account);
            }
            bankBranchDAO.delete(branch);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
