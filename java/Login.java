/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Not-A
 */
public class Login extends HttpServlet {
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    
    private ArrayList<User> Users = RegistrationPreview.Users;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");  
      
        for(User user: Users){
           if(request.getParameter("password")!=null&&request.getParameter("username")!= null&&user.username.equalsIgnoreCase(request.getParameter("username")) && user.password.equalsIgnoreCase(request.getParameter("password"))){
            Cookie loginCookie = new Cookie("username",user.username);
            loginCookie.setMaxAge(120*60);
            response.addCookie(loginCookie);
            response.sendRedirect("welcome");
           }
          }
        try (PrintWriter out = response.getWriter()) {
       Layout layout = new Layout(request);
            /* TODO output your page here. You may use following sample code. */
            out.println(layout.header("Login"));
            out.println(layout.navBar());
            out.println(layout.containerOpen());
          
                   out.println("<br /><div class=\"container-fluid\"> <h4>Welcome to SolutionBlender Shopping.\n"
                    + "Please enter your e-mail and password to "
                    + "login. <br /> If you do not have an account with us, please register <a href=\"./Registration\">here</a>.</h4></div>"+ "<div class=\"col-md-4\"><form method=\"post\" action=\"Login\" role=\"form\">\n" +
                    "  <div class=\"form-group\">\n" + 
                    "    <label for=\"username\">Username</label>\n" +
                    "    <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" placeholder=\"Enter Username\">\n" +
                    "  </div>\n" +
                    "  <div class=\"form-group\">\n" +
                    "    <label for=\"password\">Password</label>\n" +
                    "    <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Password\">\n" +
                    "  </div>\n" +
                    "  <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
                    "</form></div>");
                            
            out.println(layout.containerClose());
            out.println(layout.footer());
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
