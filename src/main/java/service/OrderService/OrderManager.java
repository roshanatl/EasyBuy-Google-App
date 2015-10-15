/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.OrderService;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.account.Orders;


/**
 *
 * @author megha_000
 */
public class OrderManager {
    
    public static int createOrder(Orders newOrder)
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
        em.persist(newOrder);
        em.getTransaction().commit();
        em.close();
        return newOrder.getOrderID();
    }
    
    public static List<Orders> getAllMyOrders ( long userID)
    {
        List<Orders> myOrders=new LinkedList<Orders>();
       Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Orders myOrder = null;
        String queryString = "SELECT I from Orders  I where I.userID = :userID ";
        Query query = em.createQuery(queryString);
        query.setParameter("userID", userID);
        List queryResult = query.getResultList();
        for (Iterator it = queryResult.iterator(); it.hasNext();) {
            Object each = it.next();
            myOrder = (Orders) each;
            myOrders.add(myOrder);
        }
        em.getTransaction().commit();
        em.close();
       
        return myOrders;
        
    }

    public static List<Orders> getAllMyRecivedOrders(long sellerID) {
         List<Orders> myOrders=new LinkedList<Orders>();
       Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Orders myOrder = null;
        String queryString = "SELECT I from Orders  I where I.sellerID = :sellerID ";
        Query query = em.createQuery(queryString);
        query.setParameter("sellerID", sellerID);
        List queryResult = query.getResultList();
        for (Iterator it = queryResult.iterator(); it.hasNext();) {
            Object each = it.next();
            myOrder = (Orders) each;
            myOrders.add(myOrder);
        }
        em.getTransaction().commit();
        em.close();
       
        return myOrders;
        
    }
    
    public static void deliverOrder( int orderID)
    {
        
        
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(Orders.class);              
//        
//        config.configure("hibernate.cfg.xml");        
//        SessionFactory factory = config.buildSessionFactory();
//        Session session = factory.openSession();        
//        Orders myOrder=(Orders)session.get(Orders.class, orderID);        
//        session.beginTransaction();
//        myOrder.setOrderState(1);
//        session.update(myOrder);
//        session.getTransaction().commit();
//        session.close();
        
    }
    
}
