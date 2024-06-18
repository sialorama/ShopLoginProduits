<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.shoploginproduits.model.Produit" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Produits</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="my-4">Liste des Produits</h1>
    <ul class="listeProduits">
        <%
            // Récupérer la liste des produits depuis l'objet de requête
            List<Produit> produits = (List<Produit>) request.getAttribute("produits");
            if (produits != null && !produits.isEmpty()) {
                for (Produit produit : produits) {
        %>
        <li class="list-group-item">
            <div class="row">
                <div class="col-md-2">
                    <img src="<%= produit.getPhoto() %>" alt="<%= produit.getName() %>" class="img-thumbnail" style="width:100px;height:100px;">
                </div>
                <div class="col-md-10">
                    <h2>Nom: <%= produit.getName() %></h2>
                    <p>Description: <%= produit.getDescription() %></p>
                    <p>Photo: <%= produit.getPhoto() %></p>
                    <p>Prix: <%= produit.getPrice() %> €</p>

                </div>
            </div>
        </li>
        <%
            }
        } else {
        %>
        <li class="list-group-item">Aucun produit disponible.</li>
        <%
            }
        %>
    </ul>
    <%
        // Vérifier si l'utilisateur est un admin
        if (session.getAttribute("user") != null) {
            com.shoploginproduits.model.User user = (com.shoploginproduits.model.User) session.getAttribute("user");
            if ("admin".equals(user.getRole())) {
    %>
    <a href="ajouterProduit.jsp" class="btn btn-primary mt-4">Ajouter un Produit</a>
    <%
            }
        }
    %>
</div>
</body>
</html>
