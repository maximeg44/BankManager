/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.BankBranch;

/**
 * BankBranchDAO qui étend la classe abstraite du DAO.
 * @author MGU
 */
public class BankBranchDAO extends AbstractDAO<BankBranch> {
    
    private static final BankBranchDAO instanceBank = new BankBranchDAO();
    
    public static BankBranchDAO getInstance(){
        return instanceBank;
    }
    
    public BankBranchDAO(){
        super();
    }   

    /**
     * Méthode pour chercher une agence bancaire en fonction de son identifiant.
     * @param id l'id de l'agence à chercher.
     * @return l'agence cherchée.
     */
    public BankBranch find(String id) {
        return em.find(BankBranch.class, id);
    }


    /**
     * Méthode qui retourne la liste de toutes les agences présentes en base.
     * @return la liste de toutes les agences présentes en base.
     */
    public List<BankBranch> findAll() {
        List<BankBranch> listBankBranchs = em.createQuery("select b from BankBranch as b").getResultList();
        return listBankBranchs;
    }
    
}
