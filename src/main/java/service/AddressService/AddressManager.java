/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.AddressService;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.account.Address;


/**
 *
 * @author megha_000
 */
public class AddressManager {
    
     public static int  AddAddress(Address newAddress)
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
        em.persist(newAddress);
        em.getTransaction().commit();
        em.close();
        return newAddress.getAddressID();
        
    }
     
      public static Address getAddressByID (int addressId)
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
        Address myAddress = null;

        String queryString = "SELECT I from Address  I where I.addressID = :addressId";
        javax.persistence.Query query = em.createQuery(queryString);
        query.setParameter("addressId", addressId);
        myAddress = (Address) query.getSingleResult();
        em.getTransaction().commit();
        em.close();  
        return myAddress;
        
    }
    
}
