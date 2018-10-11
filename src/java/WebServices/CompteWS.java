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
 *
 * @author yoelb
 */
@WebService(serviceName = "AccountWS")
public class CompteWS {
    
    @WebMethod(operationName = "findAccountById")
    public Compte findAccountById(@WebParam(name = "idAccount") String idAccount) {
        return AccountDAO.getInstance().find(idAccount);
    }
    
    @WebMethod(operationName = "findAllAccounts")
    public List<Compte> findAllAccounts() {
        return AccountDAO.getInstance().findAll();
    }
    
    
    @WebMethod(operationName = "deleteAccount")
    public String deleteAccount(@WebParam(name = "idAccount") String idAccount) {
        AccountDAO.getInstance().delete(AccountDAO.getInstance().find(idAccount));
        return "Compte supprimé ";
    }
}
