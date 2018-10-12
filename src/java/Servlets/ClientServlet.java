/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AccountDAO;
import DAO.ClientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Client;
import models.Compte;

/**
 *
 * @author MGU
 */
public class ClientServlet extends HttpServlet {
    private final ClientDAO clientDAO = ClientDAO.getInstance();
    private final AccountDAO accountDAO = AccountDAO.getInstance();
    
    public static final String VUE = "WEB-INF/formulaireClient.jsp";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String DATE_NAISSANCE = "dateNaissance";
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nom = request.getParameter(NOM);
        String prenom = request.getParameter(PRENOM);
        String dateNaissance = request.getParameter(DATE_NAISSANCE);
        
        String[] infosClient = {nom, prenom, dateNaissance};
        
        try {
            createClient(infosClient);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Client> listClients = (List<Client>) clientDAO.findAll();     
        request.setAttribute("listClients", listClients);
        request.getRequestDispatcher("/listeClients.jsp").forward(request, response);

    }
    
    
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
            List<Compte> comptes = client.getMescomptes();
            //List<Account> comptes = accountDAO.findAccountByClient(client);
            for (Compte account : comptes) {
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
