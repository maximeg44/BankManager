/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author MGU
 */
@Entity
public class Account {
    @Id
    @GeneratedValue
    @Column(length = 11, nullable = false, unique = true)
    private String account_id;

    @ManyToMany
    @JoinTable(name = "compte_client",
            joinColumns = @JoinColumn(name = "a_id", referencedColumnName = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id", referencedColumnName = "id_client"))
    private List<Client> mesClients;


    private String libelle;

    @Column(length = 27)
    private String iban;

    @Column(scale = 2)
    private Double solde;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public List<Client> getMesClients() {
        return mesClients;
    }

    public void setMesClients(List<Client> mesClients) {
        this.mesClients = mesClients;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}