/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static com.sun.activation.registries.LogSupport.log;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Utilisateur;

/**
 *
 * @author Quentin
 */
public class TestDB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        ConnectDatabase cd = new ConnectDatabase();
        List<Utilisateur> listUtilisateur = cd.getUtilisateurs();
        
        
        
        
        
        
        /*
        Connection cnx=null;
        String nomDuDriver = "org.apache.derby.jdbc.ClientDriver";
        String urlBD = "jdbc:derby://localhost:1527/servlothek;user=root;password=root;";        
        try {
            Class.forName(nomDuDriver);
        } catch (ClassNotFoundException ex) {
            log(ex.getMessage());
            System.exit(-1);
        }      
        try {
            cnx =DriverManager.getConnection(urlBD);            
        } catch (SQLException ex) {
            log(ex.getMessage());
            System.exit(-1);
        }   
        
       */
   
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestDB ok</title>");            
            out.println("</head>");
            out.println("<body>");
            listUtilisateur.forEach((s)->{out.println("     "+s.getNom());});
            out.println("<h1>Servlet TestDB  ok 5 at " + request.getContextPath() + "</h1>");
            /*try {
                while(rs.next()){
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String mail = rs.getString("MAIL");
                    boolean role = rs.getBoolean("ROLE");
                    //out.println("Nom: "+nom+" Prenom: "+prenom+" rôle: "+role + "mail: "+mail);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
