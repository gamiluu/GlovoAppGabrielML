package com.example.glovogabrielml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.glovogabrielml.Carrito.CarritoView;
import com.example.glovogabrielml.RestauranteLogin.RLoginView;
import com.example.glovogabrielml.UsuarioLogin.ULoginView;

public class GlovoMainView extends AppCompatActivity {
    private Button restauranteBtn;
    private Button usuarioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        restauranteBtn = findViewById(R.id.restauranteBtn);
        usuarioBtn = findViewById(R.id.usuarioBtn);
        restauranteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GlovoMainView.this, RLoginView.class);
                startActivity(intent);
            }
        });
        usuarioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GlovoMainView.this, ULoginView.class);
                startActivity(intent);
            }
        });
    }
}