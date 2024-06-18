package com.demo;

import com.demo.model.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet(name = "ajouterProduit", value = "/ajouterProduit")
public class AjouterProduitServlet extends HttpServlet {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String photo = request.getParameter("photo");
        String priceStr = request.getParameter("price");

        if (name == null || description == null || photo == null || priceStr == null ||
                name.isEmpty() || description.isEmpty() || photo.isEmpty() || priceStr.isEmpty()) {
            response.sendRedirect("err.jsp"); // Redirect to error page
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("err.jsp"); // Redirect to error page
            return;
        }

        // Create new produit
        Produit produit = new Produit();
        produit.setName(name);
        produit.setDescription(description);
        produit.setPhoto(photo);
        produit.setPrice(price);

        // Save produit using Hibernate
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(produit);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("err.jsp"); // Redirect to error page
            return;
        }

        // Redirect to success or list page
        response.sendRedirect("listProduit.jsp"); // Assuming you have a page to list products
    }
}
