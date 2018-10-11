/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import DAO.ClientDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.Client;

/**
 *
 * @author yoelb
 */
@WebService(serviceName = "ClientWS")
public class ClientWS {

    @WebMethod(operationName = "findClientById")
    public Client findClientById(@WebParam(name = "idClient") String idClient) {
        return ClientDAO.getInstance().find(idClient);
    }
    
    @WebMethod(operationName = "findAllClients")
    public List<Client> findAllClients() {
        return ClientDAO.getInstance().findAll();
    }
}
