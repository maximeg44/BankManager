/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import models.BankBranch;

/**
 *
 * @author MGU
 */
public class BankBranchDAO extends AbstractDAO {

    private EntityManager em;
    private EntityManagerFactory emf;
    
    public BankBranchDAO(){
        super();
    }   

    @Override
    public Object find(int id) {
        return em.find(BankBranch.class, id);
    }

    @Override
    public List<BankBranch> findAll() {
        List<BankBranch> listBankBranchs = em.createQuery("Select * FROM BankBranch").getResultList();
        return listBankBranchs;
    }
    
}
