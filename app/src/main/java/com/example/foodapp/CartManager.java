package com.example.foodapp;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static final List<Food> cartList = new ArrayList<>();

    public static void addToCart(Food food) {
        cartList.add(food);
    }

    public static List<Food> getCartList() {
        return cartList;
    }
}
