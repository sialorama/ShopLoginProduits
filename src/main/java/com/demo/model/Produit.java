package com.demo.model;

public class Produit {
    private int id;
    private String name;
    private String description;
    private String photo;
    private double price;

    public Produit() {}

    // Constructeur avec tous les champs
    public Produit(int id, String name, String description, String photo, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
    }

    // Constructeur avec tous les champs
    public Produit(String name, String description, String photo, double price) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                '}';
    }
}
