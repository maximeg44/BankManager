/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import DAO.BankBranchDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.BankBranch;

/**
 * Web Services qui sont liés à une agence bancaire.
 * @author yoelb
 */
@WebService(serviceName = "BankBranchWS")
public class BankBranchWS {

    /**
     * Web Method permettant de créer une nouvelle branche.
     * @param adresse adresse postale de la branche
     * @return l'objet crée.
     */
    @WebMethod(operationName = "createBankBranch")
    public String createBankBranch(@WebParam(name = "adresse") String adresse) {
        BankBranch branch = new BankBranch();
        branch.setAdresse(adresse);
        BankBranchDAO.getInstance().create(branch);
        return "Branch créee";
    }
}
