package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;
    private List<Food> cartList;
    private OnTotalPriceChangeListener onTotalPriceChangeListener;

    public CartAdapter(Context context, List<Food> cartList, OnTotalPriceChangeListener onTotalPriceChangeListener) {
        this.context = context;
        this.cartList = cartList;
        this.onTotalPriceChangeListener = onTotalPriceChangeListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sotib_olish, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Food food = cartList.get(position);

        holder.foodName.setText(food.getFoodName());
        holder.foodNarxi.setText(String.format("%d so'm", food.getFoodNarxi() * food.getQuantity()));
        holder.tvQuantity.setText(String.valueOf(food.getQuantity()));

        int imageResId = context.getResources().getIdentifier(food.getFoodRasmi(), "drawable", context.getPackageName());
        holder.foodImage.setImageResource(imageResId);

        holder.btnIncrement.setOnClickListener(v -> {
            food.setQuantity(food.getQuantity() + 1);
            holder.tvQuantity.setText(String.valueOf(food.getQuantity()));
            holder.foodNarxi.setText(String.format("%d so'm", food.getFoodNarxi() * food.getQuantity()));
            notifyItemChanged(position);


            onTotalPriceChangeListener.onTotalPriceChanged(cartList);
        });

        holder.btnDecrement.setOnClickListener(v -> {
            if (food.getQuantity() > 1) {
                food.setQuantity(food.getQuantity() - 1);
                holder.tvQuantity.setText(String.valueOf(food.getQuantity()));
                holder.foodNarxi.setText(String.format("%d so'm", food.getFoodNarxi() * food.getQuantity()));
                notifyItemChanged(position);


                onTotalPriceChangeListener.onTotalPriceChanged(cartList);
            }
        });

        holder.btnRemoveItem.setOnClickListener(v -> {
            cartList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartList.size());


            onTotalPriceChangeListener.onTotalPriceChanged(cartList);
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName, foodNarxi, tvQuantity;
        ImageView btnIncrement, btnDecrement, btnRemoveItem;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.imgFost);
            foodName = itemView.findViewById(R.id.textView5);
            foodNarxi = itemView.findViewById(R.id.textView7);
            tvQuantity = itemView.findViewById(R.id.tvText);
            btnIncrement = itemView.findViewById(R.id.piluss);
            btnDecrement = itemView.findViewById(R.id.minuss);
            btnRemoveItem = itemView.findViewById(R.id.tozalash);
        }
    }

    public interface OnTotalPriceChangeListener {
        void onTotalPriceChanged(List<Food> cartList);
    }
}
