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
public class Checkout extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private final ArrayList<Product> Cart = new ArrayList<Product>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("username")) userName = cookie.getValue();
            }
            }
              ArrayList<Product> prods = Index.Products;
            if(userName == null) response.sendRedirect("Index");
            
              if(request.getParameter("remove") != null){
                   for(Product product: prods){
                         if(request.getParameter("remove").contains(product.id+"")){
                         Cart.remove(product);
                         }
                     }
              }
            if(request.getParameter("add") != null){
                 
                     for(Product product: prods){
                         if(request.getParameter("add").contains(product.id+"")){
                         Cart.add(product);
                         }
                     }
              Cookie loginCookie = new Cookie("cart",request.getParameter("add") + ",");
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
          
            }
            float total = 0;
                for(Product product: Cart){
                    total = total + product.price;
                }
            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         Layout layout = new Layout(request);
            /* TODO output your page here. You may use following sample code. */
            out.println(layout.header("Index"));
            out.println(layout.navBar());
            out.println(layout.containerOpen());
            out.println("<div style='margin-top:80px;' class=\"panel panel-default\">\n" +
"  <div class=\"panel-body\">\n");
            if(!Cart.isEmpty()){
                 out.println("<table class=\"table table-striped\">\n");
            for(Product prod : Cart){
            out.println("<tr><td> "+ prod.id +" </td><td> "+ prod.name +" </td><td> "+ prod.category.toString() +" </td><td> "+ prod.price +" </td><td><a class='btn btn-primary' href='./Checkout?remove="+ prod.id +"'>Remove from cart</a></td></tr>");
            }
            out.println("</table>");
            }
out.println("  </div>\n" +
"</div><br /><br />" +  request.getParameter("add"));

            if(total != 0){
             out.println("<h1> Your Total Comes To: " + total);
             out.println("<h2>Please <a class='btn btn-lg btn-success' href='yay'>Click here</a> to enter your credit card and comfirm purchase");
            }
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
