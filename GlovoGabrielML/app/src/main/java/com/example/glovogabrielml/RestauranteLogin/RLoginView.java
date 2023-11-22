package com.example.glovogabrielml.RestauranteLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.glovogabrielml.Beans.Restaurante;
import com.example.glovogabrielml.GlovoMainView;
import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RHome.RHomeView;

public class RLoginView extends AppCompatActivity implements RLoginContract.View{
    // ATRIBUTOS
    private ImageButton backBtn;
    private RLoginPresenter presenterLogin = new RLoginPresenter(this);
    private static RLoginView rLoginView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlogin_view);
        initComponents();
    }

    private void initComponents() {
        Button restauranteAccesoBtn = findViewById(R.id.restauranteAccesoBtn);
        restauranteAccesoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombreField = findViewById(R.id.restauranteField);
                String nombre = nombreField.getText().toString();
                EditText claveField = findViewById(R.id.claveField);
                String clave = claveField.getText().toString();
                Restaurante restaurante = new Restaurante(nombre, clave);
                presenterLogin.login(restaurante);
            }
        });
        //Comandos con los que volvemos a la vista anterior, nada relacionado con el login en sí.
        backBtn = findViewById(R.id.RLoginBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RLoginView.this, GlovoMainView.class);
                startActivity(intent);
            }
        });
    }

    //En caso de que el login sea correcto.
    @Override
    public void successLogin(RLoginData rLoginData) {
        Intent intent = new Intent(RLoginView.this, RHomeView.class);
        intent.putExtra("id_restaurante", rLoginData.getId());
        startActivity(intent);
    }

    //En caso de que falle el login.
    @Override
    public void failureLogin(String err) {
        Toast.makeText(RLoginView.this, err, Toast.LENGTH_SHORT).show();
    }
}