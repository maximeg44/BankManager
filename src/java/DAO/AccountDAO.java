/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.Query;
import models.Compte;
import models.BankBranch;

/**
 * AccountDAO qui étend la classe abstraite du DAO.
 * @author MGU
 */
public class AccountDAO extends AbstractDAO<Compte> {
    
    private static final AccountDAO instanceAccount = new AccountDAO();
    
    public static AccountDAO getInstance(){
        return instanceAccount;
    }
    
    public AccountDAO(){
        super();
    }   

    /**
     * Méthode pour chercher un compte en fonction de son identifiant.
     * @param id l'id du compte à chercher.
     * @return le compte cherché.
     */
    public Compte find(String id) {
        return em.find(Compte.class, id);
    }


    /**
     * Méthode qui retourne la liste de tous les comptes présents en base.
     * @return la liste de tous les comptes présents en base.
     */
    public List<Compte> findAll() {
        List<Compte> listAccounts = em.createQuery("select a from Compte as a").getResultList();
        return listAccounts;
    }
    
    /**
     * Méthode qui retourne la liste de tous les comptes appartenant à une même branche.
     * @param branch la branche à laquelle doivent appartenir les comptes.
     * @return la liste de tous les comptes appartenant à la même branche.
     */
    public List<Compte> findAllByBranchId(BankBranch branch){
        List<Compte> listAccounts;
        Query query   = em.createQuery("select a from Compte as a where a.bankbranch = :branch");
        query.setParameter("branch",branch);
        listAccounts = query.getResultList();
        return listAccounts;
    }
   
}
