package com.example.glovogabrielml.Carrito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.glovogabrielml.Carrito.ConfirmCompra.ConfirmCompraContract;
import com.example.glovogabrielml.Carrito.ConfirmCompra.ConfirmCompraData;
import com.example.glovogabrielml.Carrito.ConfirmCompra.ConfirmCompraPresenter;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoAdapter;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoContract;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoData;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoPresenter;
import com.example.glovogabrielml.Carrito.LoadHistorial.LoadHistorialAdapter;
import com.example.glovogabrielml.Carrito.LoadHistorial.LoadHistorialContract;
import com.example.glovogabrielml.Carrito.LoadHistorial.LoadHistorialData;
import com.example.glovogabrielml.Carrito.LoadHistorial.LoadHistorialPresenter;
import com.example.glovogabrielml.GlovoMainView;
import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RestauranteLogin.RLoginView;
import com.example.glovogabrielml.UHome.UHomeView;

import java.util.ArrayList;

public class CarritoView extends AppCompatActivity implements LoadCarritoContract.View, ConfirmCompraContract.View, LoadHistorialContract.View {
    private static CarritoView mainActivity = null;
    private LoadCarritoPresenter loadCarritoPresenter = new LoadCarritoPresenter(this);
    private LoadCarritoAdapter loadCarritoAdapter;
    private ArrayList<LoadCarritoData> lstCarrito;
    private ConfirmCompraPresenter confirmCompraPresenter = new ConfirmCompraPresenter(this);
    private LoadHistorialPresenter loadHistorialPresenter = new LoadHistorialPresenter(this);
    private LoadHistorialAdapter loadHistorialAdapter;
    private ArrayList<LoadHistorialData> lstHistorial;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_view);
        initComponents();
    }

    private void initComponents() {
        //Obtenemos la ID del usuario que ha iniciado sesión.
        SharedPreferences sharedPreferences = getSharedPreferences("DatosDeUsuario", Context.MODE_PRIVATE);
        int idUsuario = sharedPreferences.getInt("idUsuario", 0);
        //Cargamos el carrito actual.
        loadCarritoPresenter.LoadCarrito(idUsuario);
        //Cargamos el historial de compras.
        loadHistorialPresenter.LoadHistorial(idUsuario);
        //Volver al UserHome.
        ImageButton backBtn = findViewById(R.id.CarritoBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarritoView.this, UHomeView.class);
                startActivity(intent);
            }
        });
        //Confirmación de la compra.
        Button confirmBtn = findViewById(R.id.CarritoConfirmarBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmCompraPresenter.confirmCompra(idUsuario);

            }
        });
    }

    //CARGAR CARRITO
    @Override
    public void successLoadCarrito(ArrayList<LoadCarritoData> lstCarrito) {
        this.lstCarrito = lstCarrito;
        RecyclerView recyclerView = findViewById(R.id.CarritoRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadCarritoAdapter = new LoadCarritoAdapter(this, lstCarrito);
        recyclerView.setAdapter(loadCarritoAdapter);
    }

    @Override
    public void failureLoadCarrito(String err) {
        Toast.makeText(CarritoView.this, err, Toast.LENGTH_SHORT).show();
    }

    //CONFIRMAR COMPRA
    @Override
    public void successConfirm(ConfirmCompraData confirmCompraData) {
        Intent intent = new Intent(CarritoView.this, CarritoView.class);
        startActivity(intent);
    }

    @Override
    public void failureConfirm(String err) {
        Toast.makeText(CarritoView.this, err, Toast.LENGTH_SHORT).show();
    }

    //CARGAR HISTORIAL COMPRAS
    @Override
    public void successLoadHistorial(ArrayList<LoadHistorialData> lstHistorial) {
        this.lstHistorial = lstHistorial;
        RecyclerView recyclerView = findViewById(R.id.CarritoHisrotialRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadHistorialAdapter = new LoadHistorialAdapter(this, lstHistorial);
        recyclerView.setAdapter(loadHistorialAdapter);
    }

    @Override
    public void failureLoadHistorial(String err) {
        Toast.makeText(CarritoView.this, err, Toast.LENGTH_SHORT).show();
    }

    //FUNCIONES SOBRE LAS NOTIFICACIONES



}