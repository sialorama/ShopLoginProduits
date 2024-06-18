package com.demo;


import com.demo.dao.ProduitDAO;
import com.demo.model.Produit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;


@WebServlet("/produits")
public class ProduitServlet extends HttpServlet {
    private ProduitDAO produitDAO = new ProduitDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produit> produits = produitDAO.getAllProduits();
        request.setAttribute("produits", produits);
        RequestDispatcher dispatcher = request.getRequestDispatcher("produits.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String photo = request.getParameter("photo");
        double price = Double.parseDouble(request.getParameter("price"));

        Produit produit = new Produit();
        produit.setName(name);
        produit.setDescription(description);
        produit.setPhoto(photo);
        produit.setPrice(price);

        produitDAO.saveProduit(produit);
        response.sendRedirect("produits");
    }
}
