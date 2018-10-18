/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Classe Compte qui définit les éléments qui caractérisent l'objet en spécifiant 
 * les relations avec les autres objets.
 * @author MGU
 */
@Entity
public class Compte implements Serializable {
    @Id
    @GeneratedValue
    @Column(length = 11, nullable = false, unique = true)
    private String account_id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "compte_client",
            joinColumns = @JoinColumn(name = "a_id", referencedColumnName = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id", referencedColumnName = "id_client"))
    private List<Client> mesClients = new ArrayList<>();


    private String libelle;

    @Column(length = 27)
    private String iban;


    @Column(scale = 2)
    private Double solde;
    
    @ManyToOne
    private BankBranch bankbranch;

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
    
    public BankBranch getBankbranch() {
        return bankbranch;
    }

    public void setBankbranch(BankBranch bankbranch) {
        this.bankbranch = bankbranch;
    }

}