/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.MoneyService;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.account.Account;
import model.account.ManageAccount;
import model.account.Money;
import model.admin.Item;

/**
 *
 * @author megha_000
 */
public class MoneyManager {

    private static void addMoney(Money myMoney) {
        Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(myMoney);
        em.getTransaction().commit();
        em.close();

    }

    public static void updateMoneyAmount(long sellerID, Double amount) {
        Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();

        Money myMoney = getMoneyofUser(sellerID);

        em.getTransaction().begin();
        if (myMoney == null) {
            Money myNewMoney = new Money();
            myNewMoney.setBalance(amount);
            myNewMoney.setUserID(sellerID);
            addMoney(myNewMoney);
        } else {
            myMoney.setBalance(myMoney.getBalance() + amount);
            em.merge(myMoney);
        }
        em.getTransaction().commit();
        em.close();

    }

    public static Money getMoneyofUser(long userID) {
        
        Map<String, String> properties = new HashMap();

        properties.put("javax.persistence.jdbc.driver",
                "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
                System.getProperty("cloudsql.url"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "Demo", properties);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Money myMoney = null;
        try{
        String queryString = "SELECT I from Money  I where I.userID = :userID";
        Query query = em.createQuery(queryString);
        query.setParameter("userID", userID);
        myMoney = (Money) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        }
        catch (NoResultException ex)
        {
             //returns a null Money
        }
           

        return myMoney;

    }
}
