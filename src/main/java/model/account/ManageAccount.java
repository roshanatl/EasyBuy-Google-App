/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author megha_000
 */
public class ManageAccount {

    public static void createAccount(Account user) {
        Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();

    }

    public static Account getAccountByEmail(String email) {
        Map<String, String> properties = new HashMap();
        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account user = null;

        String queryString = "SELECT I from Account  I where I.email = :email";
        Query query = em.createQuery(queryString);
        query.setParameter("email", email);
        user = (Account) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return user;
        
    }

    public static Account getAccountByID(Long accountID) {

        Map<String, String> properties = new HashMap();
        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account user = null;

        String queryString = "SELECT I from Account  I where I.account_id = :accountID";
        Query query = em.createQuery(queryString);
        query.setParameter("accountID", accountID);
        user = (Account) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return user;

    }

}
