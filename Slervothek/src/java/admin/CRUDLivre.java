/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.GestionCoockies;

/**
 *
 * @author adminGRIT
 */
public class CRUDLivre extends HttpServlet {

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
        
        GestionCoockies.DetectFakeConnection(request, response);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CRUD Livre</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Création, Lecture, Modification Suppression de livre</h1></center>");
             out.println("<br/>");
            
            out.println("<h3>Information : "+"</h3>");
            
            
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>");
            out.println("<br/>");
           out.println(" <form>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>");
            out.println("ID du Livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='id_livre' name='iddulivre' type='text'/>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Titre du livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='titre' name='titredulivre' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Auteur du livre  :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='auteur' name='auteurdulivre' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Date de sortie du livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='sortie' name='datedesortie' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Disponibilité :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='dispo' name='disponibilite' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("</table>");
            
            
            out.println("<input type=submit value='Modifier'  />");
            out.println(" </form>");
            out.println("</th>");
            out.println("<th>");
            out.println("</th>");
            out.println("<th>");
            out.println("<br/>");
           out.println(" <form>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>");
            out.println("ID du Livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='id_livre' name='iddulivre' type='text'/>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Titre du livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='titre' name='titredulivre' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Auteur du livre  :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='auteur' name='auteurdulivre' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Date de sortie du livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='sortie' name='datedesortie' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Disponibilité :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='dispo' name='disponibilite' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("</table>");
            
            
            out.println("<input type=submit value='Supprimer'  />");
            out.println(" </form>");
                      
            
            out.println("</th>");
            
             out.println("<th>");
            out.println("<br/>");
           out.println(" <form>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>");
            out.println("ID du Livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='id_livre' name='iddulivre' type='text'/>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Titre du livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='titre' name='titredulivre' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Auteur du livre  :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='auteur' name='auteurdulivre' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Date de sortie du livre :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='sortie' name='datedesortie' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Disponibilité :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='dispo' name='disponibilite' type='text'/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("</table>");
            
            
            out.println("<input type=submit value='Création'  />");
            out.println(" </form>");
            out.println("</tr>");
            
            
            out.println("</th>");
            
            out.println("</tr>");

            out.println("</table>");
            
            
            
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
