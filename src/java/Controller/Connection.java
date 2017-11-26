package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Modele.modele_membre;
import Modele.model_media;
import dao.daomedia ;
import dao.beans.membre;
import dao.daocategorie;
import dao.daomembre ;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public class Connection extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private daocategorie categorie=new daocategorie();
     private daomembre md=new daomembre();
     private daomedia media = new daomedia() ;
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          String f = request.getParameter("logme"); 
            HttpSession session = request.getSession();
           if (request.getParameter("back")!=null)
           {
             RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
              
             rd.forward(request, response);
           }
          if (f.equals("d")){
             
              String login = request.getParameter("l1") ;
              String password = request.getParameter("p1") ;
              
             
             /*session*/
             membre m=new membre(login,password,0," "," "," "," ");

       
           
           //
                
                membre rep=md.verif(m);
           
             
            if (rep!=null) {
                    
                     List<Map<String, String>> lst = new ArrayList<Map<String, String>>(); 
                     lst = media.afficherFilm();
                     List<Map<String, String>> lstcat = new ArrayList<Map<String, String>>();
                     lstcat=categorie.ListerCategorie();
                     request.setAttribute("listcategorie", lst);
                     request.setAttribute("listmedia", lst);
                     session.setAttribute("model", rep);
                     if (rep.getType().equals("utilisateur")){
                     RequestDispatcher rd = request.getRequestDispatcher("page_principale.jsp");
                     rd.forward(request, response);}
                    else 
                    if (rep.getType().equals("admin"))
                    { RequestDispatcher rda = request.getRequestDispatcher("Admin_page.jsp");
                     rda.forward(request, response);
                    }
            }
            else {
                     RequestDispatcher rd = request.getRequestDispatcher("ilegal_password.jsp");
                     rd.forward(request, response); 
            }
          }
          
          
          if (f.equals("insc")){
              
               String Email = request.getParameter("mail") ; 
               String user = request.getParameter("name") ; 
               String Password = request.getParameter("pwd") ; 
               String nom = request.getParameter("nom") ;
               String cin = request.getParameter("cin")  ;
               String prenom = request.getParameter("prenom");
               
             
              if (Email.equals("") || user.equals("") || Password.equals("") || nom.equals("") || cin.equals("") || prenom.equals(""))
              {  
                RequestDispatcher rd = request.getRequestDispatcher("Error_Connection.jsp");
              
              rd.forward(request, response);
                }
              
              else
          { 
                   membre m = new membre(user,Password,Integer.parseInt(cin),nom,prenom,Email,"GUEST") ;
                  md.ajouter_membre(m);
                 
           session.setAttribute("model", m);
              RequestDispatcher rd = request.getRequestDispatcher("page_principale.jsp");
              
              rd.forward(request, response);
          }
          }
          
          if (request.getParameter("return").equals("ret"))
          {
               RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
              
             rd.forward(request, response);
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
