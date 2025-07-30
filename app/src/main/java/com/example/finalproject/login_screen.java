package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tv_sign = findViewById(R.id.tv_sign);
        Button bt_login = findViewById(R.id.bt_login);




        tv_sign.setOnClickListener(v -> {
            Intent intent = new Intent(login_screen.this, sign_up_screen.class);
            startActivity(intent);
        });

        bt_login.setOnClickListener(v -> {
            Intent intent = new Intent(login_screen.this, Home_screen.class);
            startActivity(intent);
        });

    }
}