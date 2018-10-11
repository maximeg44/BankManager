

import Servlets.CompteServlet;
import Servlets.BankBranchServlet;
import Servlets.ClientServlet;
import models.Compte;
import models.BankBranch;

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
    //OK
    ClientServlet clientControler = new ClientServlet();
    String[] info = new String[3];
    info[0]= "Nom";
    info[1] = "Prenom";
    info[2] = "1991/06/12";
    Client client1 = clientControler.createClient(info);
    
    //OK
    CompteServlet accountControler = new CompteServlet();
    String[] infoAccount = new String[3];
    infoAccount[0]= "Iban";
    infoAccount[1] = "Libelle";
    infoAccount[2] = "500";
    Compte account1 = accountControler.createAccount(infoAccount);
    
    
    //OK
    BankBranchServlet branchControler = new BankBranchServlet();
    String infoBranch = "Adresse";
    BankBranch branch= branchControler.createBranch(infoBranch);
    
    
    //OK
    infoAccount[1]= "Libelle2";
   // accountControler.updateAccount(infoAccount, "102");
    
    //OK
    account1.setBankbranch(branch);
    accountControler.updateAccount(account1);
    accountControler.addClientToAccount(client1, account1.getAccount_id());
    
    //OK
    /*branchControler.removeBranch(branch);
    
    clientControler.removeClient(client1);
    
    Client cli = clientControler.findById(client1.getId_client());
    
    clientControler.removeClient(cli);
    **/
    
    
    
    
    
    
    
    
    
    
    
    
    

    }
    
}
