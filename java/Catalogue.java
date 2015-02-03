/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Not-A
 */
@WebServlet("/welcome")
public class Catalogue extends HttpServlet {

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
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("username")) userName = cookie.getValue();
            }
            }
            if(userName == null) response.sendRedirect("Index");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Layout layout = new Layout(request);
            /* TODO output your page here. You may use following sample code. */
            out.println(layout.header("Index"));
            out.println(layout.navBar());
            out.println(layout.containerOpen());
            out.println("<br /><br />"+
                    "  <h3 id=\"list-group-custom-content\">Catalogue</h3>\n" +
"  <p>Welcome to SolutionBlender Shopping! Please select a category or browse all of our items.</p>\n" +
"  <div class=\"bs-example\">\n" +
"    <div class=\"list-group\">\n" +
"      <a href=\"./Items\" class=\"list-group-item\">\n" +
"        <h4 class=\"list-group-item-heading\">CPUs and Processors</h4>\n" +
               " <div class=\"container\"><img src=\"./css/processor.jpg\" "
                    + "alt=\"computer\" style=\"width:100px;height:100px\"></div>"   +   

"      <a href=\"./Items\" class=\"list-group-item\">\n" +
"        <h4 class=\"list-group-item-heading\">Computer Accessories</h4>\n" +
                    " <div class=\"container\"><img src=\"./css/parts.jpg\" "
                    + "alt=\"computer\" style=\"width:100px;height:100px\"></div>"   + 

"      <a href=\"./Items\" class=\"list-group-item\">\n" +
"        <h4 class=\"list-group-item-heading\">Printers, Scanners, and Supplies</h4>\n" +
                  
                    " <div class=\"container\"><img src=\"./css/printers.jpg\" "
                    + "alt=\"computer\" style=\"width:100px;height:100px\"></div>");
            
            
            //out.println(layout.containerClose());
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
