/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import database.ConnectDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.GestionCoockies;
import utils.Utilisateur;

/**
 *
 * @author Matthieu PAPIER
 */
public class ServletConnexion extends HttpServlet {

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
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        
        
        RequestDispatcher rd;
        Utilisateur user = cd.connnectUtilisateur(login,password);
        
        if(!(user instanceof Utilisateur)){
            rd=request.getRequestDispatcher("index.html");  
            rd.include(request,response);
        }else{ 
            response = GestionCoockies.createCookieUser(response, user.getNom(),user.getPrenom(),user.getMail(),user.isRole());
            GestionCoockies.createSession(request, user.getNom(), user.getPrenom(), user.getMail(), user.isRole());
            if(user.isRole()){
                //rd=request.getRequestDispatcher("pageHomeAdmin");  
                //rd.forward(request,response);
                response.sendRedirect("pageHomeAdmin");
            }else{
                rd=request.getRequestDispatcher("PageHomeUser");  
                rd.forward(request,response);
            }
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
