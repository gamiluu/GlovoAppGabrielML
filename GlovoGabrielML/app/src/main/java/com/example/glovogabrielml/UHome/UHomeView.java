package com.example.glovogabrielml.UHome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.glovogabrielml.Carrito.CarritoView;
import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RHome.LoadItemAdapter;
import com.example.glovogabrielml.RInfo.RInfoView;
import com.example.glovogabrielml.UHome.LoadCategorias.LoadCatAdapter;
import com.example.glovogabrielml.UHome.LoadCategorias.LoadCatContract;
import com.example.glovogabrielml.UHome.LoadCategorias.LoadCatData;
import com.example.glovogabrielml.UHome.LoadCategorias.LoadCatPresenter;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRAdapter;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRContract;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRData;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRPresenter;
import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVAdapter;
import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVContract;
import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVData;
import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVPresenter;
import com.example.glovogabrielml.UsuarioLogin.ULoginView;

import java.util.ArrayList;

public class UHomeView extends AppCompatActivity implements LoadTopVContract.View, LoadTopRContract.View, LoadCatContract.View {
    private static UHomeView mainActivity = null;
    //Datos restaurantes más vendidos.
    private LoadTopVPresenter loadTopVpresenter = new LoadTopVPresenter(this);
    public LoadTopVAdapter loadTopVAdapter;
    private ArrayList<LoadTopVData> lstTopV;
    //Datos de los restaurantes mejor puntuados.
    private LoadTopRPresenter loadTopRPresenter = new LoadTopRPresenter(this);
    public LoadTopRAdapter loadTopRAdapter;
    private ArrayList<LoadTopRData> lstTopR;
    //Datos de las categorías.
    private LoadCatPresenter loadCatPresenter = new LoadCatPresenter(this);
    public LoadCatAdapter loadCatAdapter;
    private ArrayList<LoadCatData> lstCategorias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uhome_view);
        initComponents();
    }

    private void initComponents() {
        //Ejecutamos las peticiónes a la API.
        loadTopVpresenter.LoadTopV();
        loadTopRPresenter.LoadTopR();
        loadCatPresenter.LoadCat();
        //Funcionalidad del botón de Log Out.
        ImageButton logoutBtn = findViewById(R.id.UHomeLogOut);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Eliminar la ID del usuario al cerrar sesión.
                SharedPreferences sharedPreferences = getSharedPreferences("DatosDeUsuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear(); //Eliminamos todos los datos del SharedPreferences.
                editor.apply();
                //Volvemos al inicio de sesión de usuarios.
                Intent intent = new Intent(UHomeView.this, ULoginView.class);
                startActivity(intent);
            }
        });
        //Funcionalidad del botón de acceso al carrito.
        ImageButton cartBtn = findViewById(R.id.UHomeCart);
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UHomeView.this, CarritoView.class);
                startActivity(intent);
            }
        });
    }

    //CARGAR TOP RESTAURANTES CON MÁS VENTAS
    @Override
    public void successLoadTopV(ArrayList<LoadTopVData> lstTopV) {
        this.lstTopV = lstTopV;
        RecyclerView recyclerView = findViewById(R.id.topRecycleView);
        //Hacemos que el RecyclerView sea horizontal.
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        loadTopVAdapter = new LoadTopVAdapter(this, lstTopV);
        recyclerView.setAdapter(loadTopVAdapter);
    }
    @Override
    public void failureLoadTopV(String err) {
        Toast.makeText(UHomeView.this, err, Toast.LENGTH_SHORT).show();
    }

    //CARGAR RESTAURANTES MEJOR PUNTUADOS
    @Override
    public void successLoadTopR(ArrayList<LoadTopRData> lstTopR) {
        this.lstTopR = lstTopR;
        RecyclerView recyclerView = findViewById(R.id.ratingRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadTopRAdapter = new LoadTopRAdapter(this, lstTopR);
        recyclerView.setAdapter(loadTopRAdapter);
    }
    @Override
    public void failureLoadTopR(String err) {
        Toast.makeText(UHomeView.this, err, Toast.LENGTH_SHORT).show();
    }

    //CARCAR CATEGORÍAS
    @Override
    public void successLoadCat(ArrayList<LoadCatData> lstCategorias) {
        this.lstCategorias = lstCategorias;
        RecyclerView recyclerView = findViewById(R.id.categoryRecycleView);
        //Hacemos que el RecyclerView sea horizontal.
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        loadCatAdapter = new LoadCatAdapter(this, lstCategorias);
        recyclerView.setAdapter(loadCatAdapter);
    }
    @Override
    public void failureLoadCat(String err) {
        Toast.makeText(UHomeView.this, err, Toast.LENGTH_SHORT).show();
    }



}