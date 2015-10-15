/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.account.Address;

import model.admin.Item;
import service.ProductAdminService.ProductManager;

/**
 *
 * @author megha_000
 */
@WebServlet(name = "ConfirmPurchase", urlPatterns = {"/ConfirmPurchase"})
public class ConfirmPurchase extends HttpServlet {

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
        Address myAddress=new Address();
        myAddress.setAddressLine1(request.getParameter("InputAddress1"));
        myAddress.setAddressLine2(request.getParameter("InputAddress2"));
        myAddress.setCity(request.getParameter("city"));
        myAddress.setState(request.getParameter("state"));
        myAddress.setZip(Long.parseLong(request.getParameter("zip")));
            
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
        try{
            out.println( "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "    <head>\n"
                    + "        <meta charset=\"utf-8\">\n"
                    + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "        <link href=\"data:image/x-icon;base64,AAABAAEAEBAAAAEAIABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA5Pbt/3zUqv8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGrOnv9qzp7/uunT/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1vn9/5bu+v/A9fz/6/z+f7Dmzf9qzp7/as6e/2vQov/1+/V/4eK+f8jKiP/Fx4D/AAAAAAAAAAAAAAAAAAAAANP4/X9a5Pf/WuT3/13l+P/6/fx/as6e/2rOnv+S3b3/wsJ1/5GVEf+RlRH/qKtD/wAAAAAAAAAAAAAAAAAAAADs/P5/WuT3/1rk9/9a5Pf/4fr+f5fduf9qzp7//P79f52hK/+RlRH/kZUR/77Bc/8AAAAAAAAAAAAAAAAAAAAAAAAAAHvs+f9a5Pf/WuT3/6Xw+//7/vx/s+fP//n58X+RlRH/kZUR/5ebH//x8d//AAAAAAAAAAAAAAAAAAAAAFqW9v+bv/r//v//f9X6/X/H9v3/AAAAAAAAAADt7tl/ysyN//Pz5H//+e1//8xp///47f8AAAAA4u7+/yZ28/8mdvP/Jnbz/yh38/+1z/v/AAAAAAAAAAAAAAAAAAAAAP/893/+zGz//Lk2//y5Nv/8uTb//tuX/6/N+/8mdvP/Jnbz/yZ28/8mdvP/j7n5/wAAAAAAAAAAAAAAAAAAAAD/9d7//Lw8//y5Nv/8uTb//Lk2//3ASv8AAAAA9vr/fzSA9f9YmPb//P3/f/j3/n/Z0/h/AAAAAAAAAAD//v9/9977fwAAAAD/5Kj//b5A//7fov8AAAAAAAAAAAAAAAD9/P9/wbTz/3he5v9dQOH/mIXs//78/3/s0///+N35f8UC0f/IENT/2Fjl/wAAAAAAAAAAAAAAAAAAAAAAAAAA8u/9f11A4f9dQOH/XUDh/9bQ93/Lhf7/pTT9/wAAAADIENT/xQLR/8UC0f/heOf/AAAAAAAAAAAAAAAAAAAAAN3W+X9dQOH/XUDh/11A4f/+/f9/pTP8/6Uz/P/UoP7/2E7e/8UC0f/FAtH/1UXd/wAAAAAAAAAAAAAAAAAAAAC9sfP/a1Hk/4dx6f/AtvP/y4b+/6Uz/P+lM/z/pTT9//36///ZW+H/0DHa/9VI3v8AAAAAAAAAAAAAAAAAAAAA/v3/fwAAAAAAAAAAAAAAAPv1//+lM/z/pTP8/8Z//v8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1J7+/6c4/P8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/n8AAP4/AADEMwAA4gMAAOJDAADhQwAAzdkAAAPgAAADwAAAz/EAAOFHAADiQwAA4gMAAMADAAD8PwAA/n8AAA==\" rel=\"icon\" type=\"image/x-icon\" />\n"
                    + "        <title>Easy Buy!</title>\n"
                    + "        <!--<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">-->\n"
                    + "        <!--<link href=\"css/style.css\" rel=\"stylesheet\">-->\n"
                    + "        <link href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                    + "    </head>\n"
                    + "    <body >\n"
                    + "        <div id=\"wrap\">\n"
                    + "            <div class=\"container-\">\n"
                    + "                <div class=\"row-fluid\">\n"
                    + "                    <div class=\"col-md-12\">\n"
                    + "                        <nav class=\"navbar navbar-inverse\" role=\"navigation\" style=\"color: gold\">\n"
                    + "                            <div class=\"navbar-header\">\n"
                    + "\n"
                    + "                                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n"
                    + "                                    <span class=\"sr-only\">Toggle navigation</span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span>\n"
                    + "                                </button> <a style=\"color: chartreuse\"class=\"navbar-brand\" href=\"#\">EasyBuy!</a>\n"
                    + "                            </div>\n"
                    + "\n"
                    + "                            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n"
                    + "                                <ul class=\"nav navbar-nav\">\n"
                    + "                                    <li class=\"active\">\n"
                    + "                                        <a href=\"admin.jsp\">Sell in EasyBuy</a>\n"
                    + "                                    </li>\n"
                    + "                                    <li>\n"
                    + "                                        <a href=\"#\">Contact</a>\n"
                    + "                                    </li>\n"
                    + "                                    <li class=\"dropdown\">\n"
                    + "                                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Dropdown<strong class=\"caret\"></strong></a>\n"
                    + "                                        <ul class=\"dropdown-menu\">\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">Action</a>\n"
                    + "                                            </li>\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">Another action</a>\n"
                    + "                                            </li>\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">Something else here</a>\n"
                    + "                                            </li>\n"
                    + "                                            <li class=\"divider\">\n"
                    + "                                            </li>\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">Separated link</a>\n"
                    + "                                            </li>\n"
                    + "                                            <li class=\"divider\">\n"
                    + "                                            </li>\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">One more separated link</a>\n"
                    + "                                            </li>\n"
                    + "                                        </ul>\n"
                    + "                                    </li>\n"
                    + "                                </ul>\n"
                    + "\n"
                    + "                                <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "                                    <li>\n"
                    + "                                        <a href=\"#\">Login</a>\n"
                    + "                                    </li>\n"
                    + "                                    <li class=\"dropdown\">\n"
                    + "                                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Dropdown<strong class=\"caret\"></strong></a>\n"
                    + "                                        <ul class=\"dropdown-menu\">\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">My Orders</a>\n"
                    + "                                            </li>\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">Another action</a>\n"
                    + "                                            </li>\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">Something else here</a>\n"
                    + "                                            </li>\n"
                    + "                                            <li class=\"divider\">\n"
                    + "                                            </li>\n"
                    + "                                            <li>\n"
                    + "                                                <a href=\"#\">Separated link</a>\n"
                    + "                                            </li>\n"
                    + "                                        </ul>\n"
                    + "                                    </li>\n"
                    + "                                </ul>\n"
                    + "                            </div>\n"
                    + "\n"
                    + "                        </nav>\n"
                    + "                    </div>\n"
                    + "                </div>\n");
                    //String id=request.getParameter("itemid");
                    //Item myProduct = ProductManager.getProductByID(Integer.parseInt(id));
                    
                    out.println("addrss="+myAddress);
                    
                     out.println("        <div class=\"navbar  navbar-nav\" style=\"background-color: #333333;color: threedface \">\n"
                    + "            <div class=\"container\">\n"
                    + "                <div class=\"row\"  >\n"
                    + "                    <div class=\"col-md-12\">\n"
                    + "                        <h4>\n"
                    + "                            Sell an Item With EasyBuy\n"
                    + "                        </h4>\n"
                    + "                        <p>\n"
                    + "                            List your product on our website to get more orders to your shop from the various parts of the country.Make your products  reach the customers with Ease.\n"
                    + "\n"
                    + "                        </p>\n"
                    + "                        <p class=\"addthis_horizontal_follow_toolbox\"></p>\n"
                    + "                    </div>\n"
                    + "\n"
                    + "                    <div class=\"col-md-12\">\n"
                    + "                        <address style=\"color: greenyellow\">\n"
                    + "                            <strong>EasyBuy</strong><br> TC 13/874, Vadayakaddu <br> Vanchiyoor P.O <br> <abbr title=\"Phone\">P:</abbr> +91-8281619989\n"
                    + "                        </address>\n"
                    + "                    </div>\n"
                    + "                </div>                \n"
                    + "            </div>\n"
                    + "        </div>                   \n"
                    + "        <!-- Go to www.addthis.com/dashboard to customize your tools -->\n"
                    + "        <script type=\"text/javascript\" src=\"//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-55df0267066c5ea4\" async=\"async\"></script>\n"
                    + "\n"
                    + "        <!--    <script src=\"js/jquery.min.js\"></script>\n"
                    + "            <script src=\"js/bootstrap.min.js\"></script>\n"
                    + "            <script src=\"js/scripts.js\"></script>-->\n"
                    + "\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n"
                    + "        <!-- Include all compiled plugins (below), or include individual files as needed -->\n"
                    + "        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\n"
                    + "    </body>\n"
                    + "</html>");
          
        }
        finally{
            out.close();
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
