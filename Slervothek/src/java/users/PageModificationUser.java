/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adminGRIT
 */
public class PageModificationUser extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modification utilisateur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Page de Modification utilisateur</h1></center>");
            out.println("<br/>");
            out.println("<br/>");
                       
            out.println("<form action='/Slervothek/ServletTemporaireUser' method='POST'>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Votre nom :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='Nom' name='name' type='text' required/>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Votre prénom :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='Prénom' name='surname' type='text' required/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Votre email de contact :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='Mail' name='email' type='email' required/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Votre mot de passe :");
            out.println("</th>");
            out.println("<th>");
            out.println("<input id='MotDePasse' name='password' type='password' required/>");
            out.println("</th>");
            out.println("</tr>");
            out.println("</table>");
            
            //Faire une vérification
            out.println("<br/>");out.println("<br/>");
            out.println("<input type=submit value='Enregistrer les modifications'/>");
            out.println("</form>");
            

            
            //out.println("Les informations rentrés sont les suivantes : "+nom+","+prenom+","+mail+","+mdp);
            
            //out.println("<input type=button onclick=window.location.href='/Slervothek/PageHomeUser'; value='Enregistrer les modifications' />");
            
            out.println("</body>");
            out.println("</html>");
            
            out.println("<br/>");
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
