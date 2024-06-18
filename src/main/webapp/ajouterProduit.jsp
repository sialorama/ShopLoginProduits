<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Produit</title>
    <!-- Ajoutez votre CSS ici -->
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .submit-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            text-align: center;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Ajouter un Produit</h1>
    <form action="ajouterProduit" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Nom du Produit:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4" required></textarea>
        </div>
        <div class="form-group">
            <label for="photo">Photo URL:</label>
            <input type="text" id="photo" name="photo" required>
        </div>
        <div class="form-group">
            <label for="price">Prix:</label>
            <input type="number" step="0.01" id="price" name="price" required>
        </div>
        <button type="submit" class="submit-btn">Ajouter</button>
    </form>
</div>
</body>
</html>
