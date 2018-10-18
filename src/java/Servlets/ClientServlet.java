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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Client;
import models.Compte;

/**
 * La Servlet liée à l'objet Client.
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
            List<Client> listClients = (List<Client>) clientDAO.findAll();     
            request.setAttribute("listClients", listClients);
            request.getRequestDispatcher("/listeClients.jsp").forward(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        switch(action) {
            case "list":
                List<Client> listClients = (List<Client>) clientDAO.findAll();
                //Je pense à changer par la ligne en dessous :
                // List<Client> listClients = findAll();
                request.setAttribute("listClients", listClients);
                request.getRequestDispatcher("/listeClients.jsp").forward(request, response);
                break;
                
            case "delete":
                String clientId = request.getParameter("id");
                Client clientToDelete = clientDAO.find(clientId);
                //Je pense à changer par la ligne en dessous :
                // Client clientToDelete = find(clientId);
                removeClient(clientToDelete);
                
                List<Client> newListClients = (List<Client>) clientDAO.findAll();
                //Je pense à changer par la ligne en dessous :
                // List<Client> newListClients = findAll();
                request.setAttribute("listClients", newListClients);
                request.getRequestDispatcher("/listeClients.jsp").forward(request, response);
                break;
                
            default:
                try(PrintWriter out = response.getWriter()){
                    out.print("action inconnue...");   
                }catch(Exception e){}
                break;
        }

    }
    
    /**
    * @param : String[]
    * @return : Client
    * Méthode permettant de créer un client en passant l'ensemble des informations dans un tableau de String
    * Retourne le client créer (ID inclus..)
    */
    public Client createClient(String[] infoClient){
        Client client = new Client();
        client.setNom(infoClient[0]);
        client.setPrenom(infoClient[1]);
        client.setNaissance(new Date(infoClient[2]));        
        clientDAO.create(client);
        return client;        
    }
    
    /**
    * @param : String[]
    * @param : String
    * @return : Client
    * Mise à jour d'un client avec en paramètre les informations de modification et l'id du client
    * retourne le client modifié
    */
    public Client updateClient(String[] infoClient, String idClient){
        Client client = findById(idClient);
        client.setNom(infoClient[0]);
        client.setPrenom(infoClient[1]);
        client.setNaissance(new Date(infoClient[2]));
        clientDAO.update(client);
        
        return client;        
    }
    
    /**
    * @param : String
    * @return : Client
    * Recherche dans la DB un client en fonction d'un id passé en paramètre
    * retourne le client correspondant à l'ID
    */
    public Client findById(String id){
        return clientDAO.find(id);
    }
    
    /**
    * @return : List<Client>
    * Retourne sous forme de liste l'ensemble des clients de la DB
    */
    public List<Client> findAllClients(){
        return clientDAO.findAll();
    }
    
    /**
    * @param : Client
    * Permet de supprimer un client de la DB
    * Supprime le lien entre le client et ses comptes
    * Supprime également le compte s'il n'a plus de propriétaire
    */
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
