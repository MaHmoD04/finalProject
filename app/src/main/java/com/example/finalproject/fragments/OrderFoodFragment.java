package com.example.finalproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.R;

public class OrderFoodFragment extends Fragment {

    private TextView tvPrice, tvQuantity;
    private ImageButton btnPlus, btnMinus;
    private Button btBuy;

    private final int BASE_PRICE = 100;
    private final int MIN_QUANTITY = 1;
    private final int MAX_QUANTITY = 99;
    private int quantity = 1;

    public OrderFoodFragment() { /* Required empty constructor */ }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // اربط الـViews من الـview المعاد من onCreateView
        btBuy      = view.findViewById(R.id.bt_buy);
        btnPlus    = view.findViewById(R.id.btnPlus);
        btnMinus   = view.findViewById(R.id.btnMinus);
        tvQuantity = view.findViewById(R.id.tvQuantity);
        tvPrice    = view.findViewById(R.id.tv_price_box);

        updateQuantityText();

        btnPlus.setOnClickListener(v -> {
            if (quantity < MAX_QUANTITY) {
                quantity++;
                updateQuantityText();
            }
        });

        btnMinus.setOnClickListener(v -> {
            if (quantity > MIN_QUANTITY) {
                quantity--;
                updateQuantityText();
            }
        });


    }

    private void updateQuantityText() {
        tvQuantity.setText(String.format("%02d", quantity));
        int totalPrice = quantity * BASE_PRICE;
        tvPrice.setText(totalPrice + "$");
    }
}
