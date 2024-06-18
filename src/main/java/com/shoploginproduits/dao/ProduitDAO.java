package com.shoploginproduits.dao;

import com.shoploginproduits.HibernateUtil;
import com.shoploginproduits.model.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProduitDAO {

    public ProduitDAO() {
        // Default constructor
    }

    public void addOrUpdateProduit(Produit produit) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(produit);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logError(e);
        }
    }

    public Produit getProduitById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Produit.class, id);
        } catch (Exception e) {
            logError(e);
            return null;
        }
    }

/*    public List getProduits() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Produit> query =   session.createQuery("from Produit", Produit.class);
        List<Produit> produits = query.getResultList();
        return (produits);
    }*/

    public List<Produit> getAllProduits() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Produit", Produit.class).list();
        } catch (Exception e) {
            logError(e);
            return null;
        }
    }

    public void deleteProduit(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Produit produit = session.get(Produit.class, id);
            if (produit != null) {
                session.delete(produit);
                transaction.commit();
            } else {
                System.out.println("Produit not found with ID: " + id);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logError(e);
        }
    }

    private void logError(Exception e) {
        // Use a logging framework in production code. Here, we're using System.err for simplicity.
        System.err.println("An error occurred: " + e.getMessage());
        e.printStackTrace(System.err);
    }
}
