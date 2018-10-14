/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe BankBranch qui définit les éléments qui caractérisent l'objet en 
 * spécifiant les relations avec les autres objets.
 * @author MGU
 */
@Entity
public class BankBranch implements Serializable{
    @Id
    @GeneratedValue
    @Column(length = 5, nullable = false, unique = true)
    private int codeAgence;

    private String adresse;
    

    public int getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(int codeAgence) {
        this.codeAgence = codeAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }        
    
}
