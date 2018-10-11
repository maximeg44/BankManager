/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import DAO.AccountDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author yoelb
 */
@WebService(serviceName = "AccountWS")
public class AccountWS {

    @WebMethod(operationName = "deleteAccount")
    public String deleteAccount(@WebParam(name = "idAccount") String idAccount) {
        AccountDAO.getInstance().delete(AccountDAO.getInstance().find(idAccount));
        return "Compte supprimé ";
    }
}
