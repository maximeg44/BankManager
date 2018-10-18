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
            List<BankBranch> listBranches = (List<BankBranch>) bankBranchDAO.findAll();     
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
                List<BankBranch> listBranches = (List<BankBranch>) bankBranchDAO.findAll();
                // Je pense à changer par la ligne en dessous :
                //List<BankBranch> listBranches = findAllBankBranh();
                request.setAttribute("listBranches", listBranches);
                request.getRequestDispatcher("/listeBranches.jsp").forward(request, response);
                break;
                
            case "delete":
                String brancheId = request.getParameter("id");
                BankBranch brancheToDelete = bankBranchDAO.find(brancheId);
                removeBranch(brancheToDelete);
                
                List<BankBranch> newListBranches = (List<BankBranch>) bankBranchDAO.findAll();
                // Je pense à changer par la ligne en dessous :
                //List<BankBranch> listBranches = findAllBankBranh();
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
    * @param : String infoBranch
    * @return : BankBranch
    * Méthode permettant de créer une BankBranch avec une adresse passé en paramètre
    * retourne une BankBranch (inclus l'ID db...)
    */
    public BankBranch createBranch(String infoBranch){
        BankBranch branch = new BankBranch();
        branch.setAdresse(infoBranch);      
        bankBranchDAO.create(branch);
        return branch;        
    }
    
    /**
    * @param : String infoBranch
    * @param : String idBranch
    * @return : BankBranch
    * Méthode permettant d'update une BankBranch avec un id et la nouvelle adresse
    * retourne la BankBranch modifié
    */
    public BankBranch updateBranch(String infoBranch, String idBranch){
        BankBranch branch = findById(idBranch);
        branch.setAdresse(infoBranch); 
        bankBranchDAO.update(branch);
        
        return branch;        
    }
    
    /**
    * @param : String
    * @return : BankBranch
    * Méthode permettant de retourner une BankBranch en fonction d'un ID passé en paramètre
    */
    public BankBranch findById(String id){
        return bankBranchDAO.find(id);
    }
    
    /**
    * @return : List<BankBranch>
    * Méthode permettant de retouner la liste de tous les BankBranch
    */
    public List<BankBranch> findAllBankBranh(){
        return bankBranchDAO.findAll();
    }
    
    /**
    * @param : BankBranch
    * Méthode permettant de supprimer une BankBranch
    * la méthode supprime également le lien dans les Comptes appartenant à la 
    * BankBranch supprimé
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
