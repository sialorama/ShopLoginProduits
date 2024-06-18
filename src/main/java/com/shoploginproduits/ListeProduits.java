package com.shoploginproduits;

import com.shoploginproduits.model.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listeProduits", value = "/listeProduits")
public class ListeProduits extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produit> produits = new ArrayList<>();

        // Utiliser le constructeur avec paramètres
        produits.add(new Produit(1, "Produit 1", "Description 1", "/images/produit1.jpg", 10.0));
        produits.add(new Produit(2, "Produit 2", "Description 2", "/images/produit2.jpg", 20.0));
        produits.add(new Produit(3, "Produit 3", "Description 3", "/images/produit3.jpg", 30.0));
        produits.add(new Produit(4, "Produit 4", "Description 4", "/images/produit4.jpg", 40.0));

        // Ajouter la liste des produits à la requête
        request.setAttribute("produits", produits);

        // Rediriger vers la JSP pour afficher les produits
        request.getRequestDispatcher("/listeProduit.jsp").forward(request, response);
    }
}
