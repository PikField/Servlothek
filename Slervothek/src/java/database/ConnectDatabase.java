/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

//import com.sun.activation.registries.LogSupport.log;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Utilisateur;

/**
 *
 * @author Quentin
 */
public class ConnectDatabase {
    
    public Connection cnx = null;
    
    public ConnectDatabase(){
        this.cnx=null;
        String nomDuDriver = "org.apache.derby.jdbc.ClientDriver";
        String urlBD = "jdbc:derby://localhost:1527/servlothek;user=root;password=root;";        
        try {
            Class.forName(nomDuDriver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }      
        try {
            this.cnx =DriverManager.getConnection(urlBD);            
        } catch (SQLException ex) {
            //log(ex.getMessage());
            System.exit(-1);
        }        
    }
    
    
    public List<Utilisateur> getUtilisateurs(){
        ResultSet rs = null;
        List<Utilisateur> listUtilisateurs = null;
        try {
            listUtilisateurs =new ArrayList<>();
            rs =   this.cnx.createStatement().executeQuery("select NOM, PRENOM, MAIL, ROLE from UTILISATEUR");
           while(rs.next()){
               Utilisateur u = new Utilisateur();
               u.setMail(rs.getString("MAIL"));
               u.setNom(rs.getString("NOM"));
               u.setPrenom(rs.getString("PRENOM"));
               u.setRole(rs.getBoolean("ROLE"));
               listUtilisateurs.add(u);
               
           }
           return listUtilisateurs;
        } catch (SQLException ex) {
            ex.getMessage();
            System.exit(-1);
        }
        return null;
    }
    
    public void quitDB(){
        try {
            this.cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
}
