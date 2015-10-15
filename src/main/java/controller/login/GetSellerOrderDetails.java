/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import controller.admin.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.account.Account;
import model.account.Address;
import model.account.Orders;
import model.admin.Item;
import service.AddressService.AddressManager;
import service.OrderService.OrderManager;
import service.ProductAdminService.ProductManager;

/**
 *
 * @author megha_000
 */
@WebServlet(name = "GetSellerOrderDetails", urlPatterns = {"/GetSellerOrderDetails"})
public class GetSellerOrderDetails extends HttpServlet {

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
         PrintWriter out = response.getWriter(); {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetProductDeatils</title>");
            out.println("</head>");
            out.println("<body> <%@include file=\"/Header.jsp\" %>");
            out.println("<h1>Get Product Details  </h1>");
            out.println("<form action=\"GetProductDetails\" method=\"post\">");
            out.println("<p>Item id : <input type=\"text\" name=\"itemid\"</p>");
            out.println("<p><input type=\"submit\" value=\"get Item\"</p>");
            out.println("</form>");
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
        HttpSession session = request.getSession(false);
        if (session != null) {
            Account myUser = (Account) session.getAttribute("myUser");
            if(myUser == null)
            {
                 request.getRequestDispatcher("login.html").forward(request, response);
            }
            request.getRequestDispatcher("getRecivedOrders.jsp").forward(request, response);
            List<Orders> myOrders = OrderManager.getAllMyRecivedOrders(myUser.getAccount_id());

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>ProductDeatils</title>");
                out.println("<link href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("</head>");
                out.println("<body>");

                // Make a centered table
                out.println("<CENTER>");
                out.println("<TABLE BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=70%>");

                // First row
                out.println("<TR>");

                out.println("<TD><CENTER><B>");
                out.println("<FONT SIZE=+2>Item Name</FONT>");
                out.println("</B></CENTER></TD>");

                out.println("<TD><CENTER><B>");
                out.println("<FONT SIZE=+2>Delivery Address </FONT>");
                out.println("</B></CENTER></TD>");

                out.println("</TR>");
                for (Orders each : myOrders) {
                    out.println("<TR>");
                    out.println("<TD>&nbsp;<FONT SIZE=+1>");
                    out.println(ProductManager.getProductByID(each.getItemID()).getProductName());
                    out.println("</FONT></TD>");
                    out.println("<TD>&nbsp;<FONT SIZE=+1>");
                    Address myAddress = AddressManager.getAddressByID(each.getDeliveryAddressID());
                    out.println(myAddress.getAddressLine1());
                    out.println(myAddress.getAddressLine2());
                    out.println(myAddress.getCity());
                    out.println(myAddress.getState());
                    out.println(myAddress.getZip());
                    out.println("</FONT></TD>");
                    out.println("</TR>");
                }

                // Close the still-open tags
                out.println("</TABLE>");
                out.println("</CENTER>");

                out.println("<form action=\"index.jsp\" method=\"get\">");
                out.println("<input type=\"submit\" class=\"btn btn-success\" value=\"Go Back\"");
                out.println("</body>");
                out.println("</html>");
            }
        }
        else
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
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
        // processRequest(request, response);

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
