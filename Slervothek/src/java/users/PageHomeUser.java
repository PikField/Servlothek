/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.GestionCoockies;

/**
 *
 * @author Matthieu PAPIER
 */
public class PageHomeUser extends HttpServlet {

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
        
        try ( PrintWriter out = response.getWriter()) {
            
            //REquest donné cookie.
            
            //Cookie ck[]=request.getCookies();  
            //String id = ck[0].toString();
            
            
            //String prenom = "lol";//GestionCoockies.getCoockie(GestionCoockies.getCoockieUser(request),GestionCoockies.PRENOM).getValue();  
            //String nom = "lol";//GestionCoockies.getCoockie(GestionCoockies.getCoockieUser(request),GestionCoockies.NOM).getValue();           
            
            
            
            HttpSession session = request.getSession();
            String prenom = session.getAttribute("prenom").toString() ;
            String nom = session.getAttribute("nom").toString();
            
            
            if(session.getAttribute(GestionCoockies.ROLE).equals("true"))
                response.sendRedirect("index.html");
            
            int i=7;
            //cookie + récupérations des données BDD
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Page utilisateur</title>");            
            out.println("</head>");
            
            
            
            
            
            out.println("<body>");
            out.println("<form action='/Slervothek/ServletDeconnexion'>");
            out.println("<input type=submit value='Déconnexion' />");
            out.println("</form>");
            out.println("<center><h1>Page de gestion utilisateur</h1></center>");
            out.println("<div align='right'>");
            out.println("<input type=button onclick=window.location.href='/Slervothek/PageModificationUser'; value='Modification du profil' />");
            out.println("</div>");
            out.println("<br/>");
            out.println("<br/>");
                        
            out.println("<h3>"+prenom+" -- "+nom+"----"+session.getAttribute("role").toString() +"</h3>");

            out.println("<p>Bonjour "+ prenom+" "+nom+",");
            out.println("<br/>");
            out.println("<br/>");
            out.println("Vous avez à ce jour emprunté les livres suivants : ");
            out.println("<br/>");
            out.println("<br/>");
            
            while(i!=0){
               out.println("-Titre : <u>"+prenom+"</u>,de l'auteur : <u>"+prenom+"</u>, emprunté le : <u>"+prenom+"</u> et à rendre avant le : <u>"+prenom+"</u>");
               out.println("<br/>");
               i--;
            }
               

            
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
