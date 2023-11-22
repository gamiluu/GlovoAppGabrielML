package com.example.glovogabrielml.UHome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RAddItem.RAddItemView;
import com.example.glovogabrielml.RHome.LoadItemAdapter;
import com.example.glovogabrielml.RHome.LoadItemData;
import com.example.glovogabrielml.RHome.LoadItemPresenter;
import com.example.glovogabrielml.RHome.RHomeView;

import java.util.ArrayList;

public class UHomeView extends AppCompatActivity implements LoadTopVContract.View{
    private static UHomeView mainActivity = null;
    private LoadTopVPresenter presenter = new LoadTopVPresenter(this);
    public LoadTopVAdapter loadTopVAdapter;
    private ArrayList<LoadTopVData> lstTopV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uhome_view);
        //Hacemos que el recycler del Top Ventas sea horizontal.

        initComponents();
    }

    private void initComponents() {
        //Ejecutamos la petición a la API.
        presenter.LoadTopV();
    }

    @Override
    public void successLoadTopV(ArrayList<LoadTopVData> lstTopV) {
        this.lstTopV = lstTopV;
        RecyclerView recyclerView = findViewById(R.id.topRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        loadTopVAdapter = new LoadTopVAdapter(this, lstTopV);
        recyclerView.setAdapter(loadTopVAdapter);
    }

    @Override
    public void failureLoadTopV(String err) {
        Toast.makeText(UHomeView.this, err, Toast.LENGTH_SHORT).show();
    }
}