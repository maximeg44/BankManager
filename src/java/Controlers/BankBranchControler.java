/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import DAO.AccountDAO;
import DAO.BankBranchDAO;
import java.util.List;
import models.Account;
import models.BankBranch;

/**
 *
 * @author MGU
 */
public class BankBranchControler {
    private BankBranchDAO bankBranchDAO = BankBranchDAO.getInstance();
    private AccountDAO accountDAO = AccountDAO.getInstance();
    
    
    public BankBranch createBranch(String infoBranch){
        BankBranch branch = new BankBranch();
        branch.setAdresse(infoBranch);      
        bankBranchDAO.create(branch);
        return branch;        
    }
    
    public BankBranch updateBranch(String infoBranch, String idBranch){
        BankBranch branch = findById(idBranch);
        branch.setAdresse(infoBranch); 
        bankBranchDAO.update(branch);
        
        return branch;        
    }
    
    public BankBranch findById(String id){
        return bankBranchDAO.find(id);
    }
    
    public List<BankBranch> findAllClients(){
        return bankBranchDAO.findAll();
    }
           
    public void removeBranch(BankBranch branch){
        AccountControler accountControler = new AccountControler();
        try{
            List<Account> comptes = accountControler.findAllByBranchId(branch);
            for (Account account : comptes) {
                account.setBankbranch(null);
                accountDAO.update(account);
            }
            bankBranchDAO.delete(branch);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
