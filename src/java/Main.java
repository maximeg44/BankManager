

import DAO.ClientDAO;
import DAO.DAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    DAO dao = new ClientDAO();
    /*DAO dao2 = new ClientDAO();
    
    Client client = new Client();
    Client client2 = new Client();
    
    client.setNom("Kervarec");
    client.setPrenom("Samuel");
    Date date = new Date("12/06/1991");
    client.setNaissance(date);
    dao.create(client);
    
    client2.setNom("BENABOU");
    client2.setPrenom("Samuel");
    Date date2 = new Date("12/06/1995");
    client2.setNaissance(date2);
    dao2.create(client2);
    
    System.out.println("TOOOOOOOOOOOOOOOOOo");
    System.out.println(client.getId_client());
    dao.delete(client);*/
    
    List<Client> list;
    
    list = new ArrayList<>();
    list = dao.findAll();
    
    System.out.println(list.get(0).getId_client());
    
        
    
    // * Test pour les comptes bancaires
      //  list = new ArrayList()<>;

    
    
    
    }
    
}
