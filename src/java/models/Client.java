/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

/**
 *
 * @author MGU
 */
@Entity
public class Client {
    @Id
    @GeneratedValue
    @Column(length = 8)
    private int id_client;

    private String nom;

    private String prenom;

     @Temporal(javax.persistence.TemporalType.DATE)
    private Date naissance;

    @ManyToMany(mappedBy = "mesClients")
    private List<Account> mescomptes;


    
    public  Client(){}
    
    public Client(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }


    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public List<Account> getMescomptes() {
        return mescomptes;
    }

    public void setMescomptes(List<Account> mescomptes) {
        this.mescomptes = mescomptes;
    }    
}
