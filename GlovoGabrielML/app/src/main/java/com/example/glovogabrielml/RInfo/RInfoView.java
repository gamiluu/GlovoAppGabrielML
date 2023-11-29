package com.example.glovogabrielml.RInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RHome.LoadItemAdapter;
import com.example.glovogabrielml.RHome.RHomeView;
import com.example.glovogabrielml.RInfo.LoadRInfo.LoadRInfoContract;
import com.example.glovogabrielml.RInfo.LoadRInfo.LoadRInfoData;
import com.example.glovogabrielml.RInfo.LoadRInfo.LoadRInfoPresenter;
import com.example.glovogabrielml.RInfo.LoadRProducts.LoadRProductsAdapter;
import com.example.glovogabrielml.RInfo.LoadRProducts.LoadRProductsContract;
import com.example.glovogabrielml.RInfo.LoadRProducts.LoadRProductsData;
import com.example.glovogabrielml.RInfo.LoadRProducts.LoadRProductsPresenter;
import com.example.glovogabrielml.UHome.UHomeView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RInfoView extends AppCompatActivity implements LoadRInfoContract.View, LoadRProductsContract.View {
    private static RInfoView mainActivity = null;
    //Atributos para cargar la información del restaurante.
    private LoadRInfoPresenter rInfoPresenter = new LoadRInfoPresenter(this);
    private LoadRInfoData lstInfo;
    //Atributos para cargar los productos del restaurante.
    public LoadRProductsAdapter rProductsAdapter;
    private LoadRProductsPresenter rProductosPresenter = new LoadRProductsPresenter(this);
    private ArrayList<LoadRProductsData> lstProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rinfo_view);
        initComponents();
    }

    private void initComponents() {
        Bundle extras = getIntent().getExtras();
        rInfoPresenter.LoadRInfo(extras.getInt("id_restaurante"));
        rProductosPresenter.LoadRProducts(extras.getInt("id_restaurante"));
    }

    @Override
    public void successRLoadInfo(LoadRInfoData rInfoData) {
        setInfo(rInfoData);
        ImageButton backBtn = findViewById(R.id.RInfoBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RInfoView.this, UHomeView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void failureRLoadInfo(String err) {
        Toast.makeText(RInfoView.this, err, Toast.LENGTH_SHORT).show();
    }

    public void setInfo(LoadRInfoData rInfoData){
        TextView infoTitulo = findViewById(R.id.RInfoTitulo);
        infoTitulo.setText(rInfoData.getNombre());
        TextView infoUbi = findViewById(R.id.RInfoUbi);
        infoUbi.setText(rInfoData.getUbicacion());
        TextView infoDesc = findViewById(R.id.RInfoDesc);
        infoDesc.setText(rInfoData.getDescripcion());
        ImageView infoFondo = findViewById(R.id.RInfoFondo);
        String fondoUrl = rInfoData.getImagen();
        if (fondoUrl!=""){
            Picasso.get().load(fondoUrl).into(infoFondo);
        }
    }


    @Override
    public void successRLoadProducts(ArrayList<LoadRProductsData> lstProducts) {
        this.lstProducts = lstProducts;
        RecyclerView recyclerView = findViewById(R.id.RInfoRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rProductsAdapter = new LoadRProductsAdapter(this, lstProducts);
        recyclerView.setAdapter(rProductsAdapter);
    }

    @Override
    public void failureRLoadProducts(String err) {
        Toast.makeText(RInfoView.this, err, Toast.LENGTH_SHORT).show();
    }
}