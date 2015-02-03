/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yael
 */
public class RegistrationPreview extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        public static ArrayList<User> Users = new Users();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Layout layout = new Layout(request);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
              boolean dontadd = false;
              for(User user: Users){
              dontadd = false;
              if(user.username.contains(request.getParameter("username"))){
              dontadd = true;
              }
              }
              if(!dontadd){
                User test = new User(request.getParameter("username"), request.getParameter("password"));
              Users.add(test);
              }
            out.println(layout.header("Login"));
            out.println(layout.navBar());
            out.println(layout.containerOpen());
            
            out.println("<br /><br />"+
                    "<div class=\"panel panel-primary\"><h4>&nbsp; "
                    + "Congratulations " + request.getParameter("name")
                    + "! You've registered with SolutionBlender!"
                    + " Please browse our items.</h4></div><br/>"+
                    
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("lname") + "\n" +
                "<li><b>Username:</b>: " 
                + request.getParameter("username") + "\n" +
                    "<li><b>Password:</b>: " 
                + request.getParameter("password") +
               
                    
                "</ul>\n" );
            
            //out.println("<h1>Servlet RegistrationPreview at " + request.getContextPath() + "</h1>");
           
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
