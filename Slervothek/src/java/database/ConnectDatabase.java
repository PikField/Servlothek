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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Livre;
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
    
    public List<Utilisateur> getUtilisateurs(String nom , String prenom, String mail , Boolean estAdmin ){
        ResultSet rs = null;
        String filtreN = "", filtreP ="", filtreM = "", filtreA ="";
        List<Utilisateur> listusers = new ArrayList<>();
        String filtre = "";
        List<String> filtres = new ArrayList<>();
        
        if(nom != "" && nom !=null){
            filtreN += " NOM like '%"+nom+"%' ";
            filtres.add(filtreN);
        }
        if(prenom!= "" && prenom != null ){
            filtreP += " PRENOM LIKE '%"+prenom+"%' ";
            filtres.add(filtreP);
        }
        if(prenom!= "" && prenom != null ){
            
            filtreM += " MAIL LIKE '%"+mail+"%' ";
            filtres.add(filtreM);
        }
        if( estAdmin != null){
            filtreA +=" ROLE = "+estAdmin+" ";
            filtres.add(filtreA);
        }
        
        try {
            listusers =new ArrayList<>();
            for(int i=0;i<filtres.size();i++){
                if(filtre == "")
                    filtre = " WHERE "+filtres.get(i);
                else
                    filtre += " AND "+filtres.get(i);
            }
            
            String req = "select NOM, PRENOM, MAIL, ROLE from UTILISATEUR ";
            req += filtre;
           
            rs =   this.cnx.createStatement().executeQuery(req);
            
           while(rs.next()){
               
               Utilisateur u = new Utilisateur();
               u.setMail(rs.getString("MAIL"));
               u.setNom(rs.getString("NOM"));
               u.setPrenom(rs.getString("PRENOM"));
               u.setRole(rs.getBoolean("ROLE"));
               listusers.add(u);
           }
           return listusers;
        } catch (SQLException ex) {
            ex.getMessage();
            System.exit(-1);
        }
        return null;
    }
    
    
    
    public Utilisateur getUtilisateur(String mail){
        ResultSet rs = null;
        Utilisateur utilisateur = null;
        try {
            rs =   this.cnx.createStatement().executeQuery("select ID, NOM, PRENOM, MAIL, ROLE from UTILISATEUR WHERE MAIL='"+mail+"'");
            if(rs.next()){
               utilisateur = new Utilisateur();
               utilisateur.setMail(rs.getString("MAIL"));
               utilisateur.setNom(rs.getString("NOM"));
               utilisateur.setPrenom(rs.getString("PRENOM"));
               utilisateur.setRole(rs.getBoolean("ROLE"));
           }
           return utilisateur;
        } catch (SQLException ex) {
            ex.getMessage();
            System.exit(-1);
        }
        return null;
    }
    
    public Utilisateur getUtilisateur(String mail,String mdp){
        ResultSet rs = null;
        Utilisateur utilisateur = null;
        try {
            rs =   this.cnx.createStatement().executeQuery("select ID, NOM, PRENOM, MAIL, ROLE from UTILISATEUR WHERE MAIL='"+mail+"' AND MDP='"+mdp+"'");
            if(rs.next()){
               utilisateur = new Utilisateur();
               utilisateur.setMail(rs.getString("MAIL"));
               utilisateur.setNom(rs.getString("NOM"));
               utilisateur.setPrenom(rs.getString("PRENOM"));
               utilisateur.setRole(rs.getBoolean("ROLE"));
           }
           return utilisateur;
        } catch (SQLException ex) {
            ex.getMessage();
            System.exit(-1);
        }
        return null;
    }
    
    public int addUser(String mail, String prenom, String nom, String mdp, boolean role){
        String req = "insert into UTILISATEUR(NOM, PRENOM, MAIL, MDP) VALUES ('"+nom+"', '"+prenom+"', '"+mail+"', '"+mdp+"')";
        ResultSet rs = null; 
        try {
            //executeUpdate
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int deleteUser(String mail){
        String req = "delete from UTILISATEUR WHERE MAIL LIKE '"+mail+"'";
        ResultSet rs = null; 
        try {
            //executeUpdate
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int updateUser(String mail, String prenom, String nom, String mdp, boolean role){
        String req = "update UTILISATEUR SET NOM = '"+nom+"', prenom = '"+prenom+"', mdp = '"+mdp+"', role = "+role+"  WHERE MAIL LIKE '"+mail+"'";
        ResultSet rs = null; 
        try {
            //executeUpdate
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    
    
    /// --------------------------------- LIVRES -------------------------------
    public List<Livre> getLivres(String titre , String auteur , Boolean dispo ){
        ResultSet rs = null;
        String filtreT = "", filtreD ="", filtreA = "";
        List<Livre> listLivres = null;
        String filtre = "";
        if(titre != "" && titre !=null){
            filtreT += " TITRE like '%"+titre+"%' ";
        }
        if(auteur!= "" && auteur != null ){
            
            filtreA += " AUTEUR LIKE '%"+auteur+"%' ";
        }
        if( dispo != null){
            filtreD +=" DISPONIBLE = "+dispo+" ";
        }
        
        try {
            listLivres =new ArrayList<>();
            if(filtreT != "" && filtreA!= ""){
                filtre += filtreT + " AND " + filtreA;
            }else if (filtreT!= "" && filtreD != ""){
                 filtre += filtreT + " AND " + filtreD;
            }else{
                filtre += filtreT;
            }
            if(filtreA != "" && filtreD !=""){
                filtre += filtreA + " AND " + filtreD;
            }
            if(filtreD != "" && filtreT == "" && filtreA == ""){
                filtre += filtreD;
            }
            String req = "select TITRE, AUTEUR, SORTIE, DISPONIBLE from LIVRE ";
           
            if (filtre != ""){
                req+= " WHERE "+filtre;
            }
            rs =   this.cnx.createStatement().executeQuery(req);
            
           while(rs.next()){
               Livre l = new Livre();
               l.setAuteur(rs.getString("AUTEUR"));
               l.setTitre(rs.getString("TITRE"));
               l.setSortie(rs.getDate("SORTIE"));
               l.setDisponible(rs.getBoolean("DISPONIBLE"));              
               listLivres.add(l);
               
           }
           return listLivres;
        } catch (SQLException ex) {
            ex.getMessage();
            System.exit(-1);
        }
        return null;
    }
    
    
    public List<Livre> getLivresEmprunteParUtilisateur(String mail){
        ResultSet rs = null;
        List<Livre> listLivres = null;
        try {
            listLivres =new ArrayList<>();
            rs =   this.cnx.createStatement().executeQuery("SELECT L.TITRE, L.AUTEUR, L.SORTIE, L.DISPONIBLE, U.NOM, U.PRENOM, U.MAIL, U.ROLe FROM LIVRE as L INNER JOIN EMPRUNT ON L.ID = EMPRUNT.LIVRE, UTILISATEUR as U INNER JOIN EMPRUNT ON U.ID = EMPRUNT.UTILISATEUR  WHERE U.MAIL LIKE '"+mail+"'");
           while(rs.next()){
               Livre l = new Livre();
               l.setAuteur(rs.getString("AUTEUR"));
               l.setTitre(rs.getString("TITRE"));
               l.setSortie(rs.getDate("SORTIE"));
               l.setDisponible(rs.getBoolean("DISPONIBLE"));              
               listLivres.add(l);
               
           }
           return listLivres;
        } catch (SQLException ex) {
            ex.getMessage();
            return null;
            //System.exit(-1);
        }
        //return null;
    }
    
    public Livre getLivre(String auteur, String titre){
        ResultSet rs = null;
        Livre l = new Livre();
        try {
            rs =   this.cnx.createStatement().executeQuery("select TITRE, AUTEUR, SORTIE, DISPONIBLE from LIVRE WHERE TITRE LIKE '"+titre+"' AND AUTEUR LIKE '"+auteur+"'");
           while(rs.next()){
               
               l.setAuteur(rs.getString("AUTEUR"));
               l.setTitre(rs.getString("TITRE"));
               l.setSortie(rs.getDate("SORTIE"));
               l.setDisponible(rs.getBoolean("DISPONIBLE"));              
           }
           return l;
        } catch (SQLException ex) {
            ex.getMessage();
            System.exit(-1);
        }
        return null;
    }
    
    
     public List<Livre> getLivresEmpruntes(){
        ResultSet rs = null;
        List<Livre> listLivres = null;
        try {
            listLivres =new ArrayList<>();
            rs =   this.cnx.createStatement().executeQuery( "SELECT L.TITRE, L.AUTEUR, L.SORTIE, U.NOM, U.PRENOM, U.MAIL, U.ROLE FROM LIVRE as L, EMPRUNT as E, UTILISATEUR as U WHERE E.LIVRE = L.ID AND E.UTILISATEUR = U.ID");
           while(rs.next()){
               Livre l = new Livre();
               l.setAuteur(rs.getString("AUTEUR"));
               l.setTitre(rs.getString("TITRE"));
               l.setSortie(rs.getDate("SORTIE"));
               l.setDisponible(false);
               Utilisateur u = new Utilisateur();
               u.setMail(rs.getString("MAIL"));
               u.setNom(rs.getString("NOM"));
               u.setPrenom(rs.getString("PRENOM"));
               u.setRole(rs.getBoolean("ROLE"));
               l.setUtilisateur(u);
               listLivres.add(l);
            }
            return listLivres;
        } catch (SQLException ex) {
            ex.getMessage();
            System.exit(-1);
        }
        return null;
    }
    
        public int addLivre(String auteur, String titre, String sortie,  boolean dispo){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.err.println(""+LocalDate.parse(sortie, formatter));
            Date date = Date.valueOf(LocalDate.parse(sortie, formatter));
            
        String req = "insert into LIVRE(TITRE, AUTEUR, SORTIE, DISPONIBLE) VALUES ('"+titre+"', '"+auteur+"', '"+date+"', "+dispo+")";
        ResultSet rs = null; 
        try {
            //executeUpdate
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public int deleteLivre(String titre, String auteur){
        String req = "delete from LIVRE WHERE TITRE LIKE '"+titre+"' AND AUTEUR LIKE '"+auteur+"'";
        ResultSet rs = null; 
        try {
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public int updateLivre(String titre, String auteur, String sortie, boolean dispo){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date = Date.valueOf(LocalDate.parse(sortie, formatter));
        String req = "update LIVRE SET TITRE = '"+titre+"', AUTEUR = '"+auteur+"', sortie = '"+date+"', DISPONIBLE = "+dispo+"  WHERE TITRE LIKE '"+titre+"' AND AUTEUR LIKE '"+auteur+"'";
        ResultSet rs = null; 
        try {
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public int updateDispoLivre(String titre, String auteur, boolean dispo){

        String req = "update LIVRE SET  DISPONIBLE = "+dispo+"  WHERE TITRE LIKE '"+titre+"' AND AUTEUR LIKE '"+auteur+"'";
        ResultSet rs = null; 
        try {
            //executeUpdate
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
  
    public int addEmprunt(String auteur, String titre, String debut,String fin, String mail){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date dateDebut = Date.valueOf(LocalDate.parse(debut, formatter));
        Date dateFin = Date.valueOf(LocalDate.parse(fin, formatter));
        String req = "insert into EMPRUNT(LIVRE, UTILISATEUR, DEBUT, FIN) VALUES ((SELECT ID from LIVRE where AUTEUR like '"+auteur+"' AND TITRE like '"+titre+"'), (select ID from UTILISATEUR where MAIL LIKE '"+mail+"'), '"+dateDebut+"', '"+dateFin+"')";
        ResultSet rs = null; 
        try {
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
             updateDispoLivre(titre, auteur, false);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public int deleteEmprunt(String titre, String auteur, String mail){
        String req = "delete from EMPRUNT WHERE LIVRE = (SELECT ID from LIVRE where AUTEUR like '"+auteur+"' AND TITRE like '"+titre+"') AND UTILISATEUR = (select ID from UTILISATEUR where MAIL LIKE '"+mail+"')";
        ResultSet rs = null; 
        try {
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
             updateDispoLivre(titre, auteur, true);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
     public int deleteEmprunt(String titre, String auteur){
        String req = "delete from EMPRUNT WHERE LIVRE = (SELECT ID from LIVRE where AUTEUR like '"+auteur+"' AND TITRE like '"+titre+"') ";
        ResultSet rs = null; 
        try {
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
             updateDispoLivre(titre, auteur, true);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public int updateEmprunt(String auteur, String titre, String debut,String fin, String mail){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date dateDebut = Date.valueOf(LocalDate.parse(debut, formatter));
        Date dateFin = Date.valueOf(LocalDate.parse(fin, formatter));
        String req = "update EMPRUNT set LIVRE = (SELECT ID from LIVRE where AUTEUR like '"+auteur+"' AND TITRE like '"+titre+"'), UTILISATEUR = (select ID from UTILISATEUR where MAIL LIKE '"+mail+"'), debut = '"+dateDebut+"', fin = '"+dateFin+"'";
        ResultSet rs = null; 
        try {
            //executeUpdate
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    
    
    public void quitDB(){
        try {
            this.cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
