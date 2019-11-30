/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author Matthieu PAPIER
 */


public class GestionCoockies {
    
    private static final String NOM = "nom";
    private static final String PRENOM = "prenom";
    private static final String MAIL = "mail";
    private static final String ID = "id";
        
    public static void createCookieUser(HttpServletResponse response, String id, String nom, String prenom, String mail, boolean estAdmin){
        Cookie cookie = new Cookie(ID, id);
        response.addCookie(cookie);
        cookie = new Cookie(NOM, nom);
        response.addCookie(cookie);
        cookie = new Cookie(PRENOM, prenom);
        response.addCookie(cookie);
        cookie = new Cookie(MAIL, mail);
        response.addCookie(cookie);
        cookie = new Cookie(NOM, nom);
        response.addCookie(cookie);
        
    }
     
    public static void supprimerCookies(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = null;
        cookies = request.getCookies();
        for(int i=0;i<cookies.length;i++){
            cookies[i].setMaxAge(0);
            response.addCookie(cookies[i]);
        }
    }
    
    public static void supprimerUnCookie(HttpServletRequest request,HttpServletResponse response,String nomCoockie) {
        Cookie[] cookies = null;
        cookies = request.getCookies();
        for(int i=0;i<cookies.length;i++){
            if(cookies[i].getName().equals(nomCoockie)){
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        }
    }
         
    public static Cookie[] getCoockieUser(HttpServletRequest request){
       Cookie[] cookies = null;
       cookies = request.getCookies();
       return cookies;
    }
    
    
}

