

import Controlers.Controler;
import DAO.AccountDAO;
import DAO.ClientDAO;
import DAO.DAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Account;

import models.Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MGU
 */
public class Main {
    public static void main(String args[]){
    
    /**
     * Test pour les clients
     */
    
    /*
    // Test OK
    AccountDAO dao = AccountDAO.getInstance();
    
    Account account = new Account();
    account.setIban("iban");
    account.setLibelle("libelle");
    account.setSolde(new Double(30000));
    
    Client client1 = new Client();
    client1.setNaissance(new Date(2018,12,31));
    client1.setNom("nom");
    client1.setPrenom("prenom");
    
    Client client2 = new Client();
    client2.setNaissance(new Date(2018,12,31));
    client2.setNom("nom2");
    client2.setPrenom("prenom2");
    
    List<Client> listClients = new ArrayList<>();
    listClients.add(client1);
    listClients.add(client2);
    
    account.setMesClients(listClients);
    
    dao.create(account);
    
    Account account2 = new Account();
    account2.setIban("iban2");
    account2.setLibelle("libelle2");
    account2.setSolde(new Double(30000));
    
    Client client3 = new Client();
    client3.setNaissance(new Date(2018,12,31));
    client3.setNom("nom3");
    client3.setPrenom("prenom3");
    
    List<Client> listClients2 = new ArrayList<>();
    listClients2.add(client3);
    
     account2.setMesClients(listClients2);
    
    dao.create(account2);
   
*/
    
    AccountDAO dao = AccountDAO.getInstance();
    dao.delete(dao.find("4"));
    
    
    

    }
    
}
