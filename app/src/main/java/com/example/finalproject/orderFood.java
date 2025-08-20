package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class orderFood extends AppCompatActivity {
    TextView tvPrice, tvQuantity;
    ImageButton btnPlus, btnMinus;
    Button bt_buy;

    final int BASE_PRICE = 100;
    final int MIN_QUANTITY = 1, MAX_QUANTITY = 99;
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_food);

        // اربط كل العناصر بعد setContentView
        bt_buy     = findViewById(R.id.bt_buy);
        btnPlus    = findViewById(R.id.btnPlus);
        btnMinus   = findViewById(R.id.btnMinus);
        tvQuantity = findViewById(R.id.tvQuantity);
        tvPrice    = findViewById(R.id.tv_price_box);

        bt_buy.setOnClickListener(v -> {
            // Intent intent = new Intent(orderFood.this, payment.class);
            // startActivity(intent);
        });

        updateQuantityText();

        btnPlus.setOnClickListener(v -> {
            if (quantity < MAX_QUANTITY) { quantity++; updateQuantityText(); }
        });

        btnMinus.setOnClickListener(v -> {
            if (quantity > MIN_QUANTITY) { quantity--; updateQuantityText(); }
        });
    }

    private void updateQuantityText() {
        tvQuantity.setText(String.format("%02d", quantity));
        tvPrice.setText((quantity * BASE_PRICE) + "$");
    }
}
