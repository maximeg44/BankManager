/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import DAO.AccountDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.Compte;

/**
 * Web Services qui sont liés à un compte.
 * @author yoelb
 */
@WebService(serviceName = "AccountWS")
public class CompteWS {
    
    /**
     * Web Method permettant de rechercher un Compte en fonction de son identifiant.
     * @param idAccount l'id du compte.
     * @return le compte recherché.
     */
    @WebMethod(operationName = "findAccountById")
    public Compte findAccountById(@WebParam(name = "idAccount") String idAccount) {
        return AccountDAO.getInstance().find(idAccount);
    }
    
    /**
     * Web Method qui retourne tous les comptes sauvegardés en base.
     * @return la liste des comptes sauvegardés en base.
     */
    @WebMethod(operationName = "findAllAccounts")
    public List<Compte> findAllAccounts() {
        return AccountDAO.getInstance().findAll();
    }
    
    /**
     * Web Method permettant de supprimer un compte en fonction de son identifiant.
     * @param idAccount l'id du compte à supprimer.
     * @return un message de succès de l'action.
     */
    @WebMethod(operationName = "deleteAccount")
    public String deleteAccount(@WebParam(name = "idAccount") String idAccount) {
        AccountDAO.getInstance().delete(AccountDAO.getInstance().find(idAccount));
        return "Compte supprimé ";
    }
}
