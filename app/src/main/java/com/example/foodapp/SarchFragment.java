package com.example.foodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class SarchFragment extends Fragment {
    private RecyclerView recyclerView;
    private FoodAdapter adapter;
    private List<Food> foodList;
    private List<Food> filteredList;
    private EditText editTextSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sarch, container, false);


        recyclerView = view.findViewById(R.id.recyclerViewSearch);
        editTextSearch = view.findViewById(R.id.editTextSearch);


        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));


        loadFoodData();


        adapter = new FoodAdapter(getContext(), foodList);
        recyclerView.setAdapter(adapter);


        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                updateRecyclerView(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

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
        foodList.add(new Food("mastava", "Mastava", 22000,
                "Mastava — guruch, sabzavot va go‘sht bilan tayyorlangan an’anaviy o‘zbek sho‘rvasi."));
        foodList.add(new Food("kabob", "Kabob", 35000,
                "Kabob — mayin, ziravorlangan go‘sht bo‘laklari ochiq olovda pishiriladi."));
        foodList.add(new Food("manti", "Manti", 27000,
                "Manti — bug‘da pishirilgan go‘shtli xamir taomi."));
        foodList.add(new Food("chak-chak", "Chak-chak", 15000,
                "Chak_chak — asal va shakar bilan aralashtirilgan shirinlik taomi."));
        foodList.add(new Food("non", "Non", 5000,
                "Non o‘zbek milliy taomi, tandirda pishiriladi."));
        foodList.add(new Food("halva", "Halva", 12000,
                "Halva — shirinlik bo‘lib, yong‘oq va asal bilan tayyorlanadi."));
        foodList.add(new Food("norin", "Norin", 30000,
                "Norin — no‘qol go‘shti va noodl bilan tayyorlangan an’anaviy taom."));
        foodList.add(new Food("somsa_pishiriq", "Pishiriq Somsa", 13000,
                "Pishiriq somsa qovurilgan xamir va go‘sht bilan tayyorlanadi."));
        foodList.add(new Food("quymoq", "Quymoq", 10000,
                "Quymoq — sut va tuxumdan tayyorlangan an’anaviy o‘zbek pishiriqi."));
    }




    private void updateRecyclerView(String query) {
        filteredList = new ArrayList<>();


        for (Food food : foodList) {
            if (food.getFoodName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(food);
            }
        }


        adapter.updateList(filteredList);
    }
}