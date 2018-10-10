/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.BankBranch;

/**
 *
 * @author MGU
 */
public class BankBranchDAO extends AbstractDAO {
    
    public BankBranchDAO(){
        super();
    }   

    @Override
    public BankBranch find(int id) {
        return em.find(BankBranch.class, id);
    }

    @Override
    public List<BankBranch> findAll() {
        List<BankBranch> listBankBranchs = em.createQuery("select b from BankBranch as b").getResultList();
        return listBankBranchs;
    }
    
}
