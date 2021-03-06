/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import database.ConnectDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
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
public class EmpruntDeLivre extends HttpServlet {

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
            
            //GestionCoockies.DetectFakeConnection(request, response);
            
            
            String empruntant = request.getParameter("Utilisateur");
            String auteurLivre = request.getParameter("Livre").split(":")[0];
            String titreLivre = request.getParameter("Livre").split(":")[1];
            
            String date = request.getParameter("datedebut");
            String date2 = request.getParameter("datefin");

            
            
            ConnectDatabase cd = new ConnectDatabase();
            cd.addEmprunt(auteurLivre, titreLivre, date, date2, empruntant);
            
            
         
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>HTML Meta Tag</title>");
            out.println("<meta http-equiv = 'refresh' content = '0; url = /Slervothek/pageHomeAdmin' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Hello HTML5!</p>");
            out.println("<p>"+empruntant+" -- "+titreLivre+" -- "+auteurLivre+"---"+date+" -- "+date2+"</p>");
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
