package com.example.finalproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.FoodItem;
import com.example.finalproject.R;
import com.example.finalproject.adapters.FoodGridAdapter;
import com.example.finalproject.orderFood;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private GridView gridView;
    private List<FoodItem> items;

    public HomeFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle s) {
        super.onViewCreated(view, s);

        gridView = view.findViewById(R.id.gridView);

        items = new ArrayList<>();
        items.add(new FoodItem(R.drawable.card_food, "15 mins", "4.5"));
        items.add(new FoodItem(R.drawable.card_food, "20 mins", "4.7"));
        items.add(new FoodItem(R.drawable.card_food, "10 mins", "4.3"));
        items.add(new FoodItem(R.drawable.card_food, "25 mins", "4.8"));

        FoodGridAdapter adapter = new FoodGridAdapter(requireContext(), items);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, itemView, position, id) -> {
            FoodItem clickedItem = items.get(position);
            Intent intent = new Intent(requireContext(), orderFood.class);
            intent.putExtra("image", clickedItem.imageRes);
            intent.putExtra("time", clickedItem.time);
            intent.putExtra("rating", clickedItem.rating);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        gridView = null;
    }
}
