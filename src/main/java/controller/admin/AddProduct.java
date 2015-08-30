/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import static com.google.apphosting.api.ApiProxy.log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.rmi.server.LogStream.log;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        try {
            Item myProduct = new Item();
             //response.setContentType("text/plain");
            
            response.setContentType("image/jpg");
            // myProduct.setProductName(request.getParameter("itemname"));
            //myProduct.setProductDetails(request.getParameter("itemdetails"));
            //myProduct.setProductQuantity(Integer.parseInt(request.getParameter("itemquantity")));
            //myProduct.setPrice(Double.parseDouble(request.getParameter("itemprice")));

            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator iterator = upload.getItemIterator(request);
            //byte[] buffer = new byte[8192];
            byte[] buffer=null;
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
                    //Logger.getLogger("Got a form field: " + item.getFieldName());
                    Logger.getLogger(AddProduct.class.getName()).log(Level.WARNING, "Got a form field: {0}", item.getFieldName());
                } else {
                    Logger.getLogger(AddProduct.class.getName()).log(Level.WARNING, "Got an uploaded file: {0}, name = {1}", new Object[]{item.getFieldName(), item.getName()});
                    /**/              //Logger.getLogger("Got an uploaded file: " + item.getFieldName() +
                    //              ", name = " + item.getName());

                    // You now have the filename (item.getName() and the
                    // contents (which you can read from stream). Here we just
                    // print them back out to the servlet output stream, but you
                    // will probably want to do something more interesting (for
                    // example, wrap them in a Blob and commit them to the
                    // datastore).
                    int len;
                    int size = 1024;
                    byte[] buf;
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    buf = new byte[size];
                    while ((len = stream.read(buf, 0, size)) != -1){
                      bos.write(buf, 0, len);
                    }
                    // byte[] buffer = new byte[8192];
                     buffer = bos.toByteArray();
                     
                    // stream.read(buffer);
                   // while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
                        //response.getOutputStream().write(buffer, 0, len);
                   // }
                    
                    
                    
                    
                }
            }
            Logger.getLogger(AddProduct.class.getName()).log(Level.WARNING, "Lenght of byte array =: {0}", buffer.length);
           // response.setContentType("image/jpg");
            //response.getOutputStream().write(buffer, 0, buffer.length);
           // response.getOutputStream().flush();
            
            
            myProduct.setProductImage(buffer);

                // InputStream inputStream = null;
                /* Part filePart = request.getPart("itempic");
                
             if (filePart != null) {
             // prints out some information for debugging
             System.out.println(filePart.getName());
             System.out.println(filePart.getSize());
             System.out.println(filePart.getContentType());
                
             // obtains input stream of the upload file
             inputStream = filePart.getInputStream();
             byte[] targetArray = new byte[inputStream.available()];
             inputStream.read(targetArray);
             myProduct.setProductImage(targetArray);
                
             }      */
                //File file = new File(request.getPart("itempic"));
            //Part filePart = request.getPart("itempic");
            //byte[] bFile = new byte[(int) file.length()];
            //FileInputStream fileInputStream = new FileInputStream(file);
            
            
            
            
            ProductManager.addProduct(myProduct);
            
            
            
            
           /* response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet AddProduct</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Product Added  " + myProduct + "</h1>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
*/
        } catch (FileUploadException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
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
