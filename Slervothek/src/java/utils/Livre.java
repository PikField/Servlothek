/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.*;

/**
 *
 * @author Quentin
 */
public class Livre {
    private String titre;
    private String auteur;
    private boolean  disponible;
    private Date sortie;
    private Date emprunt;
    private Date aRendre;
    private Utilisateur utilisateur;
    
    public Livre(){
        this.auteur = "";
        this.disponible = true;
        this.sortie = null;
        this.titre = "";
        this.utilisateur = null;
        this.aRendre = null;
        this.emprunt = null;
    }

    public Date getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Date emprunt) {
        this.emprunt = emprunt;
    }

    public Date getaRendre() {
        return aRendre;
    }

    public void setaRendre(Date aRendre) {
        this.aRendre = aRendre;
    }
    public Livre(String titre, String auteur, boolean disponible, Date sortie, Utilisateur utilisateur){
        this.auteur = auteur;
        this.disponible = disponible;
        this.sortie = sortie;
        this.titre = titre;
        this.utilisateur = utilisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Date getSortie() {
        return sortie;
    }

    public void setSortie(Date sortie) {
        this.sortie = sortie;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public String toString(){
        String s =  "" + this.titre +" par "+this.auteur +" dispo: "+ this.disponible;
        return s;
        
    }
}
