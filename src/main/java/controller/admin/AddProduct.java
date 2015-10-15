/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.admin.Item;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import service.ProductAdminService.ProductManager;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.account.Account;
import org.apache.tomcat.util.http.fileupload.util.Streams;

/**
 *
 * @author megha_000
 */
public class AddProduct extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        Account myUser = null;
        if (session != null) {
            myUser = (Account) session.getAttribute("myUser");
            if (myUser == null) {

                String error = "Please login add an Item!!";
                request.setAttribute("message", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }

            try {
                Item myProduct = new Item();

                ServletFileUpload upload = new ServletFileUpload();
                FileItemIterator iterator = upload.getItemIterator(request);
                //byte[] buffer = new byte[8192];
                byte[] buffer = null;
                while (iterator.hasNext()) {
                    FileItemStream item = iterator.next();
                    InputStream stream = item.openStream();

                    if (item.isFormField()) {
                        if ("itemname".equals(item.getFieldName())) {
                            myProduct.setProductName(Streams.asString(stream));
                        }
                        if ("itemdetails".equals(item.getFieldName())) {
                            myProduct.setProductDetails(Streams.asString(stream));
                        }
                        if ("itemquantity".equals(item.getFieldName())) {
                            myProduct.setProductQuantity(Integer.parseInt(Streams.asString(stream)));
                        }
                        if ("itemprice".equals(item.getFieldName())) {
                            myProduct.setPrice(Double.parseDouble(Streams.asString(stream)));
                        }

                        Logger.getLogger(AddProduct.class.getName()).log(Level.WARNING, "Got a form field: {0}", item.getFieldName());
                    } else {
                        Logger.getLogger(AddProduct.class.getName()).log(Level.WARNING, "Got an uploaded file: {0}, name = {1}", new Object[]{item.getFieldName(), item.getName()});
                        int len;
                        int size = 1024;
                        byte[] buf;
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        buf = new byte[size];
                        while ((len = stream.read(buf, 0, size)) != -1) {
                            bos.write(buf, 0, len);
                        }

                        buffer = bos.toByteArray();

                    }
                }
                Logger.getLogger(AddProduct.class.getName()).log(Level.WARNING, "Lenght of byte array =: {0}", buffer.length);

                myProduct.setSellerID(myUser.getAccount_id());
                myProduct.setProductImage(buffer);

                ProductManager.addProduct(myProduct);

                String message = "Item  added  Succesfully !! ";
                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (FileUploadException ex) {
                Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
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
        HttpSession session = request.getSession(false);
        if (session != null) {
            Account myUser = (Account) session.getAttribute("myUser");
            if (myUser == null) {

                String error = "Please login add an Item!!";
                request.setAttribute("message", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("login.html").forward(request, response);
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
