package com.example.glovogabrielml.RHome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RAddItem.RAddItemView;
import com.example.glovogabrielml.RestauranteLogin.RLoginView;

import java.util.ArrayList;

public class RHomeView extends AppCompatActivity implements RHomeContract.View{
    //ATRIBUTOS
    private ImageButton backBtn;
    private ImageButton addBtn;
    private static RHomeView mainActivity = null;
    private LoadItemPresenter presenter = new LoadItemPresenter(this);
    public LoadItemAdapter loadItemAdapter;
    private ArrayList<LoadItemData> lstItems;

    //MÉTODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhome_view);
        initComponents();
    }

    private void initComponents() {
        Bundle extras = getIntent().getExtras();
        System.out.println("El id de tu restaurante es: " + extras.getInt("id_restaurante"));
        //Ejecutamos la petición a la API.
        presenter.LoadItem(extras.getInt("id_restaurante"));
        addBtn = findViewById(R.id.RHomeAddBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RHomeView.this, RAddItemView.class);
                intent.putExtra("id_restaurante", extras.getInt("id_restaurante"));
                startActivity(intent);
            }
        });
        backBtn = findViewById(R.id.RHomeBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RHomeView.this, RLoginView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void successLoadItem(ArrayList<LoadItemData> lstItems) {
        this.lstItems = lstItems;
        RecyclerView recyclerView = findViewById(R.id.RHomeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadItemAdapter = new LoadItemAdapter(this, lstItems);
        recyclerView.setAdapter(loadItemAdapter);
    }

    @Override
    public void failureLoadItem(String err) {
        Toast.makeText(RHomeView.this, err, Toast.LENGTH_SHORT).show();
    }
}