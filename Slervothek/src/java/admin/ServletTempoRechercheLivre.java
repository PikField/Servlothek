/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import database.ConnectDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Livre;

/**
 *
 * @author adminGRIT
 */
public class ServletTempoRechercheLivre extends HttpServlet {

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
            
            
            String titre = request.getParameter("titredulivre");
            String auteur = request.getParameter("auteurdulivre");
            String date = request.getParameter("datedesortie");
            String custId = request.getParameter("type");
            
            ConnectDatabase cd = new ConnectDatabase();
            
            
            Boolean dispo = true;
            if(request.getParameter("disponibilite") == null)
                dispo = false;
            
            
            List<Livre> livres = cd.getLivres(titre, auteur, dispo);
            
            
            HttpServletRequest req = request;
            
            req.setAttribute("livres",livres);
            
            
            RequestDispatcher rd=request.getRequestDispatcher("CRUDLivre");  
            rd.include(req,response);
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>temp</title>");
            

            //out.println("<meta http-equiv = 'refresh' content = '2; url = /Slervothek/CRUDLivre'/>");
            
            
            out.println("</head>");
            out.println("<body>");
            
            out.println("  <form action='/Slervothek/CRUDLivre' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='Recherche'>");
            out.println(" <input type='hidden' id='type' name='livres' value='"+livres+"'>");
            //out.println(" <input type='hidden' id='value' name='value' value="+creation+">");
            
            out.println("<button type='submit' text='retour' >");

            out.println("  </form>");
            
            out.println("test :");
            out.println(custId+" -- "+request.getParameter("disponibilite")+" --- "+livres.size());
            for(int i=0;i<livres.size();i++)
                out.println(livres.get(i).getTitre()+" - "+livres.get(i).getAuteur()+" </BR>");
            
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
