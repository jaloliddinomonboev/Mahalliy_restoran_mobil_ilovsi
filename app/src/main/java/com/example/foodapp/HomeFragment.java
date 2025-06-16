package com.example.foodapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private FoodAdapter adapter;
    private List<Food> foodList;
    private LinearLayout linerHammasi,linerBurger,Pizza,Disert;
    private TextView allllTxt,txtDisert,txtBrger,txtPiza;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        linerHammasi = view.findViewById(R.id.HmmasiF);
        linerBurger = view.findViewById(R.id.Burger);
        Pizza = view.findViewById(R.id.Pizza);
        Disert = view.findViewById(R.id.Disert);
        allllTxt = view.findViewById(R.id.allll);
        txtDisert = view.findViewById(R.id.txtDisert);
        txtBrger = view.findViewById(R.id.txtBrger);
        txtPiza = view.findViewById(R.id.txtPiza);


        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        linerBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerBurger.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.menu_card));
                linerHammasi.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                Pizza.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                Disert.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                allllTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtDisert.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtBrger.setTextColor(ContextCompat.getColor(getContext(),R.color.color));
                txtPiza.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));


            }
        });
        linerHammasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerBurger.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                linerHammasi.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.menu_card));
                Pizza.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                Disert.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                allllTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.color));
                txtDisert.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtBrger.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtPiza.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));


            }
        });
        Pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerBurger.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                linerHammasi.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                Pizza.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.menu_card));
                Disert.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                allllTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtDisert.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtBrger.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtPiza.setTextColor(ContextCompat.getColor(getContext(),R.color.color));


            }
        });
        Disert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerBurger.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                linerHammasi.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                Pizza.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.card_back));
                Disert.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.menu_card));
                allllTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtDisert.setTextColor(ContextCompat.getColor(getContext(),R.color.color));
                txtBrger.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));
                txtPiza.setTextColor(ContextCompat.getColor(getContext(),R.color.color2));


            }
        });



        loadFoodData();


        adapter = new FoodAdapter(getContext(), foodList);
        recyclerView.setAdapter(adapter);

        return view;
    }


    private void loadFoodData() {
        foodList = new ArrayList<>();
        foodList.add(new Food("shorva", "Shorva", 15000,
                "Shorva iliq va to‘yimli taom bo‘lib, go‘sht, sabzavotlar va turli ziravorlar qo‘shilib tayyorlanadi."));
        foodList.add(new Food("tovuq", "Tovuq", 25000,
                "Tovuq yumshoq va mazali go‘shtli taom bo‘lib, sog‘lom ovqatlanish uchun a’lo tanlov hisoblanadi."));
        foodList.add(new Food("somsa", "Somsa", 10000,
                "Somsa an’anaviy o‘zbek taomlaridan biri bo‘lib, xamir ichiga go‘sht, piyoz yoki boshqa mahsulotlar solib tandirda yoki duxovkada pishiriladi."));
        foodList.add(new Food("shashlik", "Shashlik", 14000,
                "Shashlik ochiq olovda yoki grilda pishiriladigan go‘shtli taom bo‘lib, u mayin, shirador va tutunli ta’mi bilan ajralib turadi."));
        foodList.add(new Food("pizza", "Pizza", 18000,
                "Pizza italyan oshxonasining mashhur taomi bo‘lib, yupqa yoki qalin xamir ustiga turli mahsulotlar solinib pishiriladi."));
        foodList.add(new Food("osh", "Osh", 33000,
                "Osh o‘zbek milliy taomlarining eng mashhurlaridan biri bo‘lib, guruch, go‘sht, sabzi va turli ziravorlar bilan tayyorlanadi."));
        foodList.add(new Food("gril", "Gril", 56000,
                "Gril ochiq olov yoki maxsus qurilmalarda pishiriladigan go‘sht, tovuq yoki sabzavot taomidir."));
        foodList.add(new Food("burger", "Burger", 80000,
                "Burger ikki dona non orasida go‘sht kotleti, pishloq va sabzavotlar bilan tayyorlanadi."));
        foodList.add(new Food("lagman", "Lagman", 28000,
                "Lagman — qo‘lda tayyorlangan noodl bilan tayyorlangan mazali sho‘rva taomi."));
    }

}
