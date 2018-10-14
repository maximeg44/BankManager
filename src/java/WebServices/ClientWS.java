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
 * Web Services qui sont liés à un client.
 * @author yoelb
 */
@WebService(serviceName = "ClientWS")
public class ClientWS {

    /**
     * Web Method permettant de rechercher un Client en fonction de son identifiant.
     * @param idClient l'id du client.
     * @return le client recherché.
     */
    @WebMethod(operationName = "findClientById")
    public Client findClientById(@WebParam(name = "idClient") String idClient) {
        return ClientDAO.getInstance().find(idClient);
    }
    
    /**
     * Web Method qui retourne tous les clients sauvegardés en base.
     * @return la liste des clients sauvegardés en base.
     */
    @WebMethod(operationName = "findAllClients")
    public List<Client> findAllClients() {
        return ClientDAO.getInstance().findAll();
    }
    
    /**
     * Web Method permettant de supprimer un client en fonction de son identifiant.
     * @param idClient l'id du client à supprimer.
     * @return un message de succès de l'action.
     */
    @WebMethod(operationName = "deleteClient")
    public String deleteClient(@WebParam(name = "idClient") String idClient) {
        ClientDAO.getInstance().delete(ClientDAO.getInstance().find(idClient));
        return "Client supprimé ";
    }
}
