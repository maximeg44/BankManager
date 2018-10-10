/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import DAO.AccountDAO;
import DAO.ClientDAO;
import DAO.DAO;
import java.util.List;
import models.Client;
import models.Account;

/**
 *
 * @author MGU
 */
public class Controler {
    private ClientDAO clientDAO = ClientDAO.getInstance();
    private AccountDAO accountDAO = AccountDAO.getInstance();
    
    
    public void removeClient(Client client){
        try{
            List<Account> comptes = client.getMescomptes();
            for (Account account : comptes) {
                account.getMesClients().remove(client);
                /*
                if (account.getMesClients().isEmpty()) {
                    accountDAO.delete(account);
                }*/
            }
            clientDAO.delete(client);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
}
