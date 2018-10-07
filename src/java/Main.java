

import DAO.ClientDAO;
import DAO.DAO;
import java.util.Date;

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
    DAO dao = new ClientDAO();
    Client client = new Client();
    client.setNom("Kervarec");
    client.setPrenom("Samuel");
    Date date = new Date("12/06/1991");
    client.setNaissance(date);
    dao.create(client);
    System.out.println("Test");
    
    
    
    
    
    }
    
}
