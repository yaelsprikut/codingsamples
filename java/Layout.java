
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Not-A
 */
public class Layout {
    
    public Layout(HttpServletRequest request){
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
    for(Cookie cookie : cookies){
        if(cookie.getName().contains("user")) userName = cookie.getValue();
    }
    }
    if(userName != null)
        CurrentUser = userName;
    }
    
    
    public String CurrentUser;
    public String header(String title){
    return "<!DOCTYPE html>"+"<html>"+"<head>"+"<link rel='stylesheet' type='text/css' href='./css/bootstrap.css'><script type=\"text/javascript\" src=\"//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script><script src=\"./js/bootstrap.js\"></script>"+
            "<title>" + title + "</title>"        
            +"</head><body>";
    }
    
    public String footer(){
        return "<nav class=\"navbar navbar-default navbar-fixed-bottom\" role=\"navigation\">\n" +
"  <div class=\"container\">\n" +
"    SolutionBlender Shopping (C) 2014\n" +
"  </div>\n" +
"</nav></body></html>";
    }
    public String containerOpen(){
    return "<div class='container' style='margin-top:30px;'>";
    }
    
    public String containerClose(){
    return "</div>";
    }
    
    public String navBar(){
        if(CurrentUser != null){
         return "<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n" +
"  <div class=\"container\">\n" +
"      <!-- Brand and toggle get grouped for better mobile display -->\n" +
"    <div class=\"navbar-header\">\n" +
"      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n" +
"        <span class=\"sr-only\">Toggle navigation</span>\n" +
"        <span class=\"icon-bar\"></span>\n" +
"        <span class=\"icon-bar\"></span>\n" +
"        <span class=\"icon-bar\"></span>\n" +
"      </button>\n" +
"      <a class=\"navbar-brand\" href=\"./Index\"><b>SolutionBlender Shopping</b></a>\n" +
"    </div>\n" +
"\n" +
"    <!-- Collect the nav links, forms, and other content for toggling -->\n" +
"    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
"      <ul class=\"nav navbar-nav\">\n" +
"           <li class=\"active\"><a href=\"./Catalogue\">Catalogue</a></li>\n" +


"      </ul>\n" +
"      <ul class=\"nav navbar-nav navbar-right\">\n" +
"        <li><a href=\"./Logout\">Logout</a></li>\n" +
"        \n" +
"      </ul>"+
"    </div>"+
"  </div>\n" +
"</nav>";   
        }else{
        return "<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n" +
"  <div class=\"container\">\n" +
"      <!-- Brand and toggle get grouped for better mobile display -->\n" +
"    <div class=\"navbar-header\">\n" +
"      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n" +
"        <span class=\"sr-only\">Toggle navigation</span>\n" +
"        <span class=\"icon-bar\"></span>\n" +
"        <span class=\"icon-bar\"></span>\n" +
"        <span class=\"icon-bar\"></span>\n" +
"      </button>\n" +
"      <a class=\"navbar-brand\" href=\"./Index\"><b>SolutionBlender Shopping</b></a>\n" +
"    </div>\n" +
"\n" +
"    <!-- Collect the nav links, forms, and other content for toggling -->\n" +
"    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
"      <ul class=\"nav navbar-nav\">\n" +
"           <li class=\"active\"><a href=\"./Catalogue\">Catalogue</a></li>\n" +


"      </ul>\n" +
"      <ul class=\"nav navbar-nav navbar-right\">\n" +
"        <li><a href=\"./Login\">Login</a></li>\n" +
"        <li><a href=\"./Registration\">Register</a></li>\n" +
"        \n" +
"      </ul>"+
"    </div>"+
"  </div>\n" +
"</nav>";   
        }   
    }
}
