/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author Matthieu PAPIER
 */


public class GestionCoockies {
    
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String MAIL = "mail";
    public static final String ROLE = "role";
        
    public static HttpServletResponse createCookieUser(HttpServletResponse response, String nom, String prenom, String mail, boolean estAdmin){
        Cookie cookie = new Cookie(NOM, nom);
        cookie.setMaxAge(1);
        response.addCookie(cookie);
        cookie = new Cookie(PRENOM, prenom);
        cookie.setMaxAge(1);
        response.addCookie(cookie);
        cookie = new Cookie(MAIL, mail);
        cookie.setMaxAge(1);
        response.addCookie(cookie);
        cookie = new Cookie(NOM, nom);
        cookie.setMaxAge(1);
        response.addCookie(cookie);
        cookie = new Cookie(ROLE, String.valueOf(estAdmin));
        cookie.setMaxAge(1);
        response.addCookie(cookie);
        
        return response;
    }
    
    public static void createSession(HttpServletRequest request, String nom, String prenom, String mail, boolean estAdmin){
        HttpSession session = request.getSession();
        session.setAttribute(NOM, nom);
        session.setAttribute(PRENOM, prenom);
        session.setAttribute(MAIL, mail);
        session.setAttribute(ROLE, estAdmin);
    }
    public static void eraseSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeValue(NOM);
        session.removeValue(PRENOM);
        session.removeValue(MAIL);
        session.removeValue(ROLE);
        session.invalidate();
    }
   
     
    public static HttpServletResponse supprimerCookies(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = null;
        cookies = request.getCookies();
        for(int i=0;i<cookies.length;i++){
            if(!cookies[i].getName().equals("JSESSIONID")){
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        }
        
        HttpSession session = request.getSession();
        session.invalidate();
        return response;
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
    
    public static Cookie getCoockie(Cookie[] cookies,String nomCoockie){
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals(nomCoockie))
                return cookies[i];
        }
        return null;
    }
    
    public static void DetectFakeConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String url = request.getHeader("referer");
        RequestDispatcher rd;
        rd=request.getRequestDispatcher("index.html");  
        
        if(url == null)
            rd.include(request,response);
    }
}

