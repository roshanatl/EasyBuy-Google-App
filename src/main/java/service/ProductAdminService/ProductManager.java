/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.ProductAdminService;


import com.google.appengine.demos.Greeting;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.admin.Item;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.*;


/**
 *
 * @author megha_000
 */
public class ProductManager {
    
    public static void addProduct(Item newProduct)
    {
        Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(newProduct);
        em.getTransaction().commit();
        em.close();
      
        
    }
    
     public static void removeAllProducts ()
    {
        //List<Item> items = new LinkedList<Item>();
        Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
         String queryString = "Update Item  I set I.productQuantity =0";        
        Query query = em.createQuery(queryString);        
         query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        
        
    }
    
    public static Item getProductByID (int productId)
    {
        Map<String, String> properties = new HashMap();
        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Item myProduct = null;    
        String queryString = "SELECT I from Item  I where I.productId = :productId";        
        Query query = em.createQuery(queryString);
        query.setParameter("productId", productId);
        myProduct = (Item) query.getSingleResult();
        return myProduct;
        
    }
    
    
    
    
    
    public static List<Item> getAllProducts ()
    {
        List<Item> items = new LinkedList<Item>();
        Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        items = em
                .createQuery("SELECT g FROM Item g")
                .getResultList();

        em.getTransaction().commit();
        em.close();
        return items;
        
    }
    
    
    
}
