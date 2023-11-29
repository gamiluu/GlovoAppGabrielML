package com.example.glovogabrielml.UsuarioLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.glovogabrielml.Beans.Usuario;
import com.example.glovogabrielml.GlovoMainView;
import com.example.glovogabrielml.R;
import com.example.glovogabrielml.UHome.UHomeView;

public class ULoginView extends AppCompatActivity implements ULoginContract.View{
    private Button loginBtn;
    private ImageButton backBtn;
    private ULoginPresenter uLoginPresenter = new ULoginPresenter(this);
    private static ULoginView rLoginView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulogin_view);
        initComponents();
    }

    private void initComponents() {
        loginBtn = findViewById(R.id.uLoginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombreField = findViewById(R.id.usuarioField);
                String nombre = nombreField.getText().toString();
                EditText claveField = findViewById(R.id.contrasenaField);
                String contrasena = claveField.getText().toString();
                Usuario usuario = new Usuario(nombre, contrasena);
                uLoginPresenter.login(usuario);
            }
        });
        //Comandos con los que volvemos a la vista anterior, nada relacionado con el login en sí.
        backBtn = findViewById(R.id.ULoginBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ULoginView.this, GlovoMainView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void successLogin(ULoginData uLoginData) {
        //Guardamos el la ID del usuario como "inicio de sesión" en local.
        SharedPreferences datosSesion = getSharedPreferences("DatosDeUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = datosSesion.edit();
        editor.putInt("idUsuario", uLoginData.getId_usuario());
        editor.apply();
        //Accedemos a la siguiente ventana.
        Intent intent = new Intent(ULoginView.this, UHomeView.class);
        startActivity(intent);
    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(ULoginView.this, "Nombre o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
    }
}