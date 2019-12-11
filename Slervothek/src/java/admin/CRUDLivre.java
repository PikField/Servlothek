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
import utils.Livre;

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
        
        //GestionCoockies.DetectFakeConnection(request, response);
        
        
        List<Livre> livres = new ArrayList<Livre>();
        if(request.getAttribute("livres")!=null)
            livres = (List<Livre>) request.getAttribute("livres");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String type = request.getParameter("type");
            String value = request.getParameter("value");

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

            out.println("<center><h1>Création, Lecture, Modification, Suppression de livre</h1></center>");
            out.println("  <br/>");

            out.println(" <h3>Information : </h3>");

            out.println("<table align='center'>");
            out.println("<tr>");
            out.println(" <td>");

            out.println("  <br/>");
            out.println("  <form action='/Slervothek/ServletTempoCreationLivre' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='creation'>");
            out.println("  <table>");
            out.println("  <tr>");
            out.println("  <td width='50%'>");
            out.println("  Titre du livre :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='titre' name='titredulivre' type='text' required/>");
            out.println("  </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>");
            out.println(" Auteur du livre  :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='auteur' name='auteurdulivre' type='text' required/>");
            out.println("  </td>");
            out.println("  </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("  Date de sortie du livre :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='sortie' type='date' name='datedesortie' type='text' required/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("  Disponibilité :");
            out.println(" </td>");
            out.println(" <td>");
            out.println(" <input id='dispo' name='disponibilite' type='checkbox'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" </table> ");

            out.println("<input type=submit style='float:right' value='Création du livre'  />");
            out.println("  </form>");

            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("	<td>");
            out.println("  <br/>");

            out.println(" <form action='/Slervothek/ServletTempoSupressionLivre' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='suppression'>");
            out.println(" <table width='100%'>");

            out.println(" <tr>");
            out.println(" <td width='50%'>");
            out.println(" Titre du livre :");
            out.println(" </td>");
            out.println("   <td>");
            out.println("  <input id='titre' name='titredulivre' type='text' required/>");
            out.println("  </td>");
            out.println("  </tr>");
            out.println(" <tr>");
            out.println(" <td>");
            out.println(" Auteur du livre  :");
            out.println(" </td>");
            out.println(" <td>");
            out.println(" <input id='auteur' name='auteurdulivre' type='text' required/>");
            out.println("  </td>");
            out.println("  </tr>");

            out.println("  </table>");

            out.println("  <input type=submit style='float:right' value='Supprimer'  />");
            out.println("  </form>");

            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("<td>");

            out.println(" <br/>");
            out.println(" <form action='/Slervothek/ServletTempoRechercheLivre' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='recherche'>");
            out.println(" <table>");
            out.println("<tr>");
            out.println("<td  width='50%'>");
            out.println(" Titre du livre :");
            out.println(" </td>");
            out.println(" <td>");
            out.println(" <input id='titre' name='titredulivre' type='text'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>");
            out.println(" Auteur du livre  :");
            out.println(" </td>");
            out.println("  <td>");
            out.println(" <input id='auteur' name='auteurdulivre' type='text'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("<td>");
            out.println("Date de sortie du livre :");
            out.println("  </td>");
            out.println(" <td>");
            out.println("<input id='sortie' type='date'  name='datedesortie' type='text'/>");
            out.println("  </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("  Disponibilité :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='dispo' name='disponibilite' type='checkbox'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println("  </table>");

            out.println("  <input type=submit style='float:right' value='Recherche'  />");
            out.println("   </form>");
            out.println("  </td>");
            out.println("   </tr>");

            out.println("<tr>");
            out.println(" <td>");
/*
            out.println("  <br/>");
            out.println("  <form action='/Slervothek/ServletTempoModificationLivre' method='POST'>");
            out.println(" <input type='hidden' id='type' name='type' value='modification'>");
            out.println("  <table>");
            out.println("  <tr>");
            out.println("  <td width='50%'>");
            out.println("  Titre du livre :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='titre' name='titredulivre' type='text' required/>");
            out.println("  </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>");
            out.println(" Auteur du livre  :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='auteur' name='auteurdulivre' type='text' required/>");
            out.println("  </td>");
            out.println("  </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("  Date de sortie du livre :");
            out.println("  </td>");
            out.println("  <td>");
            out.println("  <input id='sortie' type='date'  name='datedesortie' type='text' required/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println("  <td>");
            out.println("  Disponibilité :");
            out.println(" </td>");
            out.println(" <td>");
            out.println(" <input id='dispo' name='disponibilite' type='checkbox'/>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" </table> ");

            out.println("<input type=submit style='float:right' value='Modification du livre'  />");
            out.println("  </form>");
*/
            out.println(" </td>");
            out.println(" </tr>");
            
            out.println(" </table>");

            
            out.println("<h3>Résultat :"+"</h3>");
            
            for(int i = 0;i<livres.size();i++){
                out.println(livres.get(i).getTitre()+ " "+livres.get(i).getAuteur());
                if(livres.get(i).isDisponible())
                    out.println(" disponible ");
                else
                    out.println(" indisponible ");
                  out.println("<br/>");
            
            }
            
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
