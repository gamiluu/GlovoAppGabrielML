package com.example.glovogabrielml.CategoryList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovogabrielml.R;
import com.example.glovogabrielml.UHome.UHomeView;

import java.util.ArrayList;

public class CategoryListView extends AppCompatActivity implements LoadByCatContract.View{
    //ATRIBUTOS
    private LoadByCatPresenter loadByCatPresenter = new LoadByCatPresenter(this);
    public LoadByCatAdapter loadByCatAdapter;
    private ArrayList<LoadByCatData> lstRestaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list_view);
        initComponents();
    }

    private void initComponents() {
        //Sustituimos el titulo de la vista por la categoria.
        Bundle extras = getIntent().getExtras();
        TextView titulo = findViewById(R.id.CategoryTitle);
        titulo.setText(extras.getString("categoria")+":");
        //Cargamos los restaurantes usando el ID de categoria.
        loadByCatPresenter.LoadByCat(extras.getInt("id_categoria"));
        //Botón para volver al UHomeView.
        ImageButton backBtn = findViewById(R.id.CarritoBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListView.this, UHomeView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void successLoadByCat(ArrayList<LoadByCatData> lstRestaurantes) {
        this.lstRestaurantes = lstRestaurantes;
        RecyclerView recyclerView = findViewById(R.id.ListaPorCategoriaRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadByCatAdapter = new LoadByCatAdapter(this, lstRestaurantes);
        recyclerView.setAdapter(loadByCatAdapter);
    }

    @Override
    public void failureLoadByCat(String err) {
        Toast.makeText(CategoryListView.this, err, Toast.LENGTH_SHORT).show();
    }
}