/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Quentin
 */
public class Utilisateur {
    private String nom;
    private String prenom;
    private String mail;
    private boolean role;

    public Utilisateur(){
        this.nom = "";
        this.prenom = "";
        this.mail = "";
        this.role = false;
    }
    public Utilisateur(String nom, String prenom, String mail, boolean role) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.role = role;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
    

    
    
}
