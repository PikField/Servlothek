/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.GestionCoockies;

import utils.Utilisateur;
/**
 *
 * @author adminGRIT
 */
public class CRUDUtilisateur extends HttpServlet {

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
        
        //GestionCoockies.DetectFakeConnection(request, response);

        List<Utilisateur> users = new ArrayList<>();
        
        if(request.getAttribute("users") != null)
            users = (List<Utilisateur>) request.getAttribute("users");

        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            out.println(" <!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CRUD Livre</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println("<input type=button onclick=window.location.href='/Slervothek/pageHomeAdmin'; value='Retour' />");
            out.println("<form action='/Slervothek/ServletDeconnexion'>");
            out.println("<input type=submit value='Déconnexion' />");
            out.println("</form>");

            out.println("<center><h1>Création, Lecture, Modification, Suppression d'Utilisateur</h1></center>");
            out.println("  <br/>");

            out.println(" <h3>Information : </h3>");

            out.println("<table align='center' style='width:500px'>");
            out.println("<tr>");
            out.println(" <td style='padding:10px; border:dotted'>");

            out.println("  <br/>");
            out.println("  <form action='/Slervothek/ServletTempoCreationUser' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='creation'>");
            out.println("  <table>");
            out.println("  <tr>");
            out.println("  <td width='50%'>");
            out.println("Nom de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='lastname' name='nomuser' type='text' required/>");
            out.println("  </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>");
            out.println("Prénom de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='firstname' name='prenomuser' type='text' required/>");
            out.println("  </td>");
            out.println("  </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("Mail de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='email' name='mailuser' type='text' required/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("Mot de passe utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='password' name='mdpuser' type='text' required/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("  Rôle Admin :");
            out.println(" </td>");
            out.println(" <td>");
            out.println(" <input id='role' name='roleadmin' type='checkbox'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" </table> ");

            out.println("<input type=submit style='float:right' value='Création utilisateur'  />");
            out.println("  </form>");
            
            out.println("  </td>");
            out.println("   </tr>");
            out.println("<tr>");
            out.println(" <td>");

            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("	<td style='padding:10px; border:dotted'>");
            out.println("  <br/>");

            out.println(" <form action='/Slervothek/ServletTempoSupressionUser' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='suppression'>");
            out.println(" <table>");

            out.println(" <tr>");
            out.println(" <td width='50%'>");
            out.println("Mail de l'utilisateur:");
            out.println(" </td>");
            out.println("   <td>");
            out.println("  <input id='email' name='mailuser' type='text' required/>");
            out.println("  </td>");
            out.println("  </tr>");


            out.println("  </table>");

            out.println("  <input type=submit style='float:right' value='Supprimer'  />");
            out.println("  </form>");
            
            
            out.println("  </td>");
            out.println("   </tr>");
            out.println("<tr>");
            out.println(" <td>");

            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("<td style='padding:10px; border:dotted'>");

            out.println(" <br/>");
            out.println(" <form action='/Slervothek/ServletTempoRechercheUser' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='recherche'>");
            out.println("  <table>");
            out.println("  <tr>");
            out.println("  <td width='50%'>");
            out.println("Nom de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='lastname' name='nomuser' type='text'/>");
            out.println("  </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>");
            out.println("Prénom de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='firstname' name='prenomuser' type='text'/>");
            out.println("  </td>");
            out.println("  </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("Mail de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='email' name='mailuser' type='text'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("  Rôle Admin :");
            out.println(" </td>");
            out.println(" <td>");
            out.println(" <input id='role' name='roleadmin' type='checkbox'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" </table> ");

            out.println("  <input type=submit style='float:right' value='Recherche'  />");
            out.println("   </form>");
            
            
            out.println("  </td>");
            out.println("   </tr>");
            out.println("<tr>");
            out.println(" <td>");
            
            out.println("  </td>");
            out.println("   </tr>");

            out.println("<tr>");
            out.println(" <td style='padding:10px; border:dotted'>");

            out.println("  <br/>");
            out.println("  <form action='/Slervothek/ServletTempoModificationUser' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='modification'>");
            out.println("  <table>");
            out.println("  <tr>");
            out.println("  <td width='50%'>");
            out.println("Nom de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='lastname' name='nomuser' type='text' required/>");
            out.println("  </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>");
            out.println("Prénom de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='firstname' name='prenomuser' type='text' required/>");
            out.println("  </td>");
            out.println("  </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("Mail de l'utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='email' name='mailuser' type='text' required/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("Mot de passe utilisateur :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='password' name='mdpuser' type='text' required/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("  Rôle Admin :");
            out.println(" </td>");
            out.println(" <td>");
            out.println(" <input id='role' name='roleadmin' type='checkbox'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" </table> ");

            out.println("<input type=submit style='float:right' value='Modification utilisateur'  />");
            out.println("  </form>");

            out.println(" </td>");
            out.println(" </tr>");
            
            
            out.println(" </table>");
            out.println("<h3>Résultat : </h3>");
            
            
            
            out.println(" <table>");
            
            out.println(" <tr>");
            out.println(" <td style='text-align:center'>");
                out.println("mail");
                

            
            out.println(" </td>");
            out.println(" <td>");
                out.println("nom");
            out.println(" </td>");
            
            out.println(" </td>");
            out.println(" <td>");
                out.println("prenom");
            out.println(" </td>");
            out.println(" </tr>");
            
            for(int i = 0;i<users.size();i++){
            
                
            out.println(" <tr>");
            out.println(" <td>");
                out.println(" "+users.get(i).getMail());
                

            
            out.println(" </td>");
            out.println(" <td>");
                out.println(" "+users.get(i).getNom());
            out.println(" </td>");
            out.println(" <td>");
                out.println("  "+users.get(i).getPrenom());
            out.println(" </td>");
            out.println(" </tr>");
            
            
                  out.println("<br/>");
            
            }
            
            
            out.println(" </table>");
            
            out.println("  </body>");
            out.println(" </html>");

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
