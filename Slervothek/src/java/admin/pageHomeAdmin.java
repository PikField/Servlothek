/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
£££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££
TO DO QUENTIN GLACHANT : 

- Fonction :    
Une fonction de récupération des livres suivants les infos (titre, auteur, date, dispo) si toute vide renvois tout, si un élèment prend juste en compte cet element
Une fonction de suppression de Livre qui renvoi un code d'erreur, 1 si la supression a été faite avec succées, 2 si celui-ci n'existe pas, 3 si l'un des champs n'est pas remplis
Un fonction de création de Livre qui renvoi le livre 






 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matthieu PAPIER
 */
public class pageHomeAdmin extends HttpServlet {

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

            List<String> listNom = new ArrayList<String>();
            listNom.add("Martin Michou");
            listNom.add("Jean Richelieu");

            int nombreUtilisateur = listNom.size();

            List<String> livreDisponible = new ArrayList<String>();
            livreDisponible.add("Rouge et noir");
            livreDisponible.add("oui-oui et le haricot magique");
            livreDisponible.add("khjk");
            livreDisponible.add("iuihiu");
            livreDisponible.add("mlzpkozi");

            int nombreLivredispo = livreDisponible.size();

            List<String> livreEmprunte = new ArrayList<String>();
            livreEmprunte.add("64645");
            livreEmprunte.add("ljtlkezt");
            livreEmprunte.add("pm   z");
            livreEmprunte.add("mù");
            livreEmprunte.add("^yria");

            int nombreLivreEmprunte = livreEmprunte.size();

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Page utilisateur</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<input type=submit value='Déconnexion' />");

            out.println("<center><h1>Page de gestion administrateur</h1></center>");

            out.println("<input type=button onclick=window.location.href='/Slervothek/CRUDLivre'; value='CRUD Livre' />");
            out.println("<input type=button onclick=window.location.href='/Slervothek/CRUDUtilisateur'; value='CRUD Utilisateur' />");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<h3>Effectuer un prêt :</h3>");

            out.println("<FORM action='/Slervothek/EmpruntDeLivre' method='POST'>");
            out.println("<SELECT name='Utilisateur' size='1'>");

            for (int i = 0; i < nombreUtilisateur; i++) {
                out.println("<OPTION>" + listNom.get(i));
            }

            //out.println("<OPTION>Matthieu Papier");
            //out.println("<OPTION>Quentin Glachant");
            //out.println("<OPTION>Antoine Besnard");
            //out.println("<OPTION>Casse Couille");
            out.println("</SELECT>");

            out.println("<SELECT name='Livre' size='1'>");
            for (int i = 0; i < nombreLivredispo; i++) {
                out.println("<OPTION>" + livreDisponible.get(i));
            }
            //out.println("<OPTION>Le rouge et le noir");
            //out.println("<OPTION>Antigone");
            //out.println("<OPTION>Le malade imaginaire");
            //out.println("<OPTION>Oui-oui et les amis imaginaires");
            out.println("</SELECT>");

            out.println("<input type=submit value='Déclarer un emprunt' />");

            out.println("</FORM>");

            out.println("<h3>Indiquer un retour :</h3>");

            out.println("<FORM action='/Slervothek/RetourDeLivre' method='POST'>");
            out.println("<SELECT name='LivreEmprunté' size='1'>");
            
            for (int i = 0; i < nombreLivreEmprunte; i++) {
                out.println("<OPTION>" + livreEmprunte.get(i));
            }
            //out.println("<OPTION>Le rouge et le noir");
            //out.println("<OPTION>Antigone");
            //out.println("<OPTION>Le malade imaginaire");
            //out.println("<OPTION>Oui-oui et les amis imaginaires");
            out.println("</SELECT>");

            out.println("<input type=submit value='Déclarer un Retour' />");
            out.println("</FORM>");

            out.println("<br/>");
            out.println("<br/>");

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
