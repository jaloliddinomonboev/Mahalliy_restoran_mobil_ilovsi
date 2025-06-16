package com.example.foodapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SavatFragment extends Fragment {

    private RecyclerView recyclerView;
    private CartAdapter adapter;
    private TextView tvTotalPrice;
    private AppCompatButton qabulQilish;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_savat, container, false);

        qabulQilish = view.findViewById(R.id.qabulQilish);
        recyclerView = view.findViewById(R.id.recyclerViewSavat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tvTotalPrice = view.findViewById(R.id.jamiNarx);
        qabulQilish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Buyurtma qabul qilindi", Toast.LENGTH_SHORT).show();
            }
        });



        List<Food> cartList = CartManager.getCartList();


        updateTotalPrice(cartList);


        adapter = new CartAdapter(getContext(), cartList, this::updateTotalPrice);
        recyclerView.setAdapter(adapter);

        return view;
    }


    private void updateTotalPrice(List<Food> cartList) {
        int totalPrice = 0;
        for (Food food : cartList) {
            totalPrice += food.getFoodNarxi() * food.getQuantity();
        }
        tvTotalPrice.setText(String.format("Jami narx: %d so'm", totalPrice));
    }
}
