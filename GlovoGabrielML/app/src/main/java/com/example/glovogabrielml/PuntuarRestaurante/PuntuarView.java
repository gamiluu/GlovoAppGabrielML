package com.example.glovogabrielml.PuntuarRestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.glovogabrielml.Carrito.CarritoView;
import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RAddItem.AddItemPresenter;
import com.example.glovogabrielml.RAddItem.RAddItemView;
import com.example.glovogabrielml.RHome.RHomeView;
import com.example.glovogabrielml.RInfo.RInfoView;

public class PuntuarView extends AppCompatActivity implements PuntuarContract.View{
    private PuntuarPresenter puntuarPresenter = new PuntuarPresenter(this);
    private static PuntuarView puntuarView = null;
    private int valorRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuar_view);
        initComponents();
    }

    private void initComponents() {
        //Obtenemos el restaurante a puntuar.
        Bundle extras = getIntent().getExtras();
        int id_restaurante = extras.getInt("id_restaurante");
        //Obtenemos la ID del usuario que ha iniciado sesión.
        SharedPreferences sharedPreferences = getSharedPreferences("DatosDeUsuario", Context.MODE_PRIVATE);
        int idUsuario = sharedPreferences.getInt("idUsuario", 0);
        //Obtenemos la nota que desea insertar.
        RatingBar ratingBar = findViewById(R.id.RatingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // El valor de la RatingBar ha cambiado
                valorRating = (int) rating;
            }
        });
        //Botón de puntuar.
        Button puntuarBtn = findViewById(R.id.RatingButton);
        puntuarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntuarPresenter.insert(idUsuario, id_restaurante, valorRating);
            }
        });
        //Boton de volver al restaurante.
        ImageButton backBtn = findViewById(R.id.RatingBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                Intent intent = new Intent(PuntuarView.this, RInfoView.class);
                intent.putExtra("id_restaurante", extras.getInt("id_restaurante"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void successPuntuar(PuntuarData puntuarData) {
        Bundle extras = getIntent().getExtras();
        Intent intent = new Intent(PuntuarView.this, RInfoView.class);
        intent.putExtra("id_restaurante", extras.getInt("id_restaurante"));
        startActivity(intent);
    }

    @Override
    public void failurePuntuar(String err) {
        Toast.makeText(PuntuarView.this, err, Toast.LENGTH_SHORT).show();
    }
}