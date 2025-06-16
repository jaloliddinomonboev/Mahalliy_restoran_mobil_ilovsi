package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private Context context;
    private List<Food> foodList;

    public FoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }
    public void updateList(List<Food> newFoodList) {
        foodList = newFoodList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu_mahsulot, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodName.setText(food.getFoodName());
        holder.foodNarxi.setText(String.format("%d so'm", food.getFoodNarxi()));


        int imageResId = context.getResources().getIdentifier(food.getFoodRasmi(), "drawable", context.getPackageName());
        holder.foodImage.setImageResource(imageResId);


        holder.addToCartButton.setOnClickListener(v -> {
            CartManager.addToCart(food);
        });


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalActivity.class);
            intent.putExtra("foodName", food.getFoodName());
            intent.putExtra("foodNarxi", food.getFoodNarxi());
            intent.putExtra("foodHaqida", food.getFoodHaqida());
            intent.putExtra("foodRasmi", food.getFoodRasmi());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage,addToCartButton;
        TextView foodName, foodNarxi;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.foodImg);
            foodName = itemView.findViewById(R.id.textNameFood);
            foodNarxi = itemView.findViewById(R.id.txt_prize);
            addToCartButton = itemView.findViewById(R.id.addFood);
        }
    }

}
