/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MGU
 */
public class form extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>form_main {\n" +
"    width: 100%;\n" +
"}\n" +
".form_main h4 {\n" +
"    font-family: roboto;\n" +
"    font-size: 20px;\n" +
"    font-weight: 300;\n" +
"    margin-bottom: 15px;\n" +
"    margin-top: 20px;\n" +
"    text-transform: uppercase;\n" +
"}\n" +
".heading {\n" +
"    border-bottom: 1px solid #fcab0e;\n" +
"    padding-bottom: 9px;\n" +
"    position: relative;\n" +
"}\n" +
".heading span {\n" +
"    background: #9e6600 none repeat scroll 0 0;\n" +
"    bottom: -2px;\n" +
"    height: 3px;\n" +
"    left: 0;\n" +
"    position: absolute;\n" +
"    width: 75px;\n" +
"}   \n" +
".form {\n" +
"    border-radius: 7px;\n" +
"    padding: 6px;\n" +
"}\n" +
".txt[type=\"text\"] {\n" +
"    border: 1px solid #ccc;\n" +
"    margin: 10px 0;\n" +
"    padding: 10px 0 10px 5px;\n" +
"    width: 100%;\n" +
"}\n" +
".txt_3[type=\"text\"] {\n" +
"    margin: 10px 0 0;\n" +
"    padding: 10px 0 10px 5px;\n" +
"    width: 100%;\n" +
"}\n" +
".txt2[type=\"submit\"] {\n" +
"    background: #242424 none repeat scroll 0 0;\n" +
"    border: 1px solid #4f5c04;\n" +
"    border-radius: 25px;\n" +
"    color: #fff;\n" +
"    font-size: 16px;\n" +
"    font-style: normal;\n" +
"    line-height: 35px;\n" +
"    margin: 10px 0;\n" +
"    padding: 0;\n" +
"    text-transform: uppercase;\n" +
"    width: 30%;\n" +
"}\n" +
".txt2:hover {\n" +
"    background: rgba(0, 0, 0, 0) none repeat scroll 0 0;\n" +
"    color: #5793ef;\n" +
"    transition: all 0.5s ease 0s;\n" +
"}  </style>");
            out.println("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n" +
"<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n" +
"<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>");
            out.println("<title>Servlet form</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">\n" +
"	<div class=\"row\">\n" +
"    <div class=\"col-md-4\">\n" +
"		<div class=\"form_main\">\n" +
"                <h4 class=\"heading\"> Contact <span></span></h4>\n" +
"                <div class=\"form\">\n" +
"                <form action=\"contact_send_mail.php\" method=\"post\" id=\"contactFrm\" name=\"contactFrm\">\n" +
"                    <input type=\"text\" required=\"\" placeholder=\"Please input your Name\" value=\"\" name=\"name\" class=\"txt\">\n" +
"                    <input type=\"text\" required=\"\" placeholder=\"Please input your FirstName\" value=\"\" name=\"firstName\" class=\"txt\">\n" +
"                    <input type=\"text\" required=\"\" placeholder=\"Please input your date of birth\" value=\"\" name=\"date\" class=\"txt\">\n" +
"                    \n" +
"                	 <textarea placeholder=\"Your Message\" name=\"mess\" type=\"text\" class=\"txt_3\"></textarea>\n" +
"                     <input type=\"submit\" value=\"submit\" name=\"submit\" class=\"txt2\">\n" +
"                </form>\n" +
"            </div>\n" +
"            </div>\n" +
"            </div\n" +
"	</div>\n" +
"</div>");
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
