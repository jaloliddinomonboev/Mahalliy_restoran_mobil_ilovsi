package com.example.foodapp;

public class Food {
    private String foodRasmi;
    private String foodName;
    private int foodNarxi;
    private String foodHaqida;
    private int quantity;

    public Food(String foodRasmi, String foodName, int foodNarxi, String foodHaqida) {
        this.foodRasmi = foodRasmi;
        this.foodName = foodName;
        this.foodNarxi = foodNarxi;
        this.foodHaqida = foodHaqida;
        this.quantity = 1;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getFoodRasmi() {
        return foodRasmi;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodNarxi() {
        return foodNarxi;
    }

    public String getFoodHaqida() {
        return foodHaqida;
    }
}
