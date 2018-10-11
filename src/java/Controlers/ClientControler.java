/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import DAO.AccountDAO;
import DAO.ClientDAO;
import java.util.Date;
import java.util.List;
import models.Client;
import models.Account;

/**
 *
 * @author MGU
 */
public class ClientControler {
    private ClientDAO clientDAO = ClientDAO.getInstance();
    private AccountDAO accountDAO = AccountDAO.getInstance();
    
    
    public Client createClient(String[] infoClient){
        Client client = new Client();
        client.setNom(infoClient[0]);
        client.setPrenom(infoClient[1]);
        client.setNaissance(new Date(infoClient[2]));        
        clientDAO.create(client);
        return client;        
    }
    
    public Client updateClient(String[] infoClient, String idClient){
        Client client = findById(idClient);
        client.setNom(infoClient[0]);
        client.setPrenom(infoClient[1]);
        client.setNaissance(new Date(infoClient[2]));
        clientDAO.update(client);
        
        return client;        
    }
    
    public Client findById(String id){
        return clientDAO.find(id);
    }
    
    public List<Client> findAllClients(){
        return clientDAO.findAll();
    }
       
    
    
    public void removeClient(Client client){
        try{
            List<Account> comptes = client.getMescomptes();
            //List<Account> comptes = accountDAO.findAccountByClient(client);
            for (Account account : comptes) {
                account.getMesClients().remove(client);
                
                if (account.getMesClients().isEmpty()) {
                    accountDAO.delete(accountDAO.find(account.getAccount_id()));
                }
            }
            clientDAO.delete(client);
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
