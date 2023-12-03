package com.example.glovogabrielml.RAddItem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.glovogabrielml.Beans.Producto;
import com.example.glovogabrielml.Beans.Restaurante;
import com.example.glovogabrielml.Carrito.CarritoView;
import com.example.glovogabrielml.GlovoMainView;
import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RHome.RHomeView;
import com.example.glovogabrielml.RestauranteLogin.RLoginView;

public class RAddItemView extends AppCompatActivity implements AddItemContract.View{
    private Button guardarBtn;
    private ImageButton backBtn;
    private AddItemPresenter addItemPresenter = new AddItemPresenter(this);
    private static RAddItemView rAddItemView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radd_item);
        intitComponents();
    }

    private void intitComponents() {
        Bundle extras = getIntent().getExtras();
        System.out.println("El id de tu restaurante es: " + extras.getInt("id_restaurante"));
        //
        Button guardarItemBtn = findViewById(R.id.RAddItemBtn);
        guardarItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_restaurante = extras.getInt("id_restaurante");
                EditText nombreField = findViewById(R.id.RAddItemNombre);
                String nombre = nombreField.getText().toString();
                EditText imagenField = findViewById(R.id.RAddItemImagen);
                String imagen = imagenField.getText().toString();
                EditText descripcionField = findViewById(R.id.RAddItemDesc);
                String descripcion = descripcionField.getText().toString();
                EditText precioField = findViewById(R.id.RAddItemPrecio);
                String precioString = precioField.getText().toString();
                int precioInt = Integer.parseInt(precioString);

                Producto producto = new Producto(id_restaurante, nombre, imagen, descripcion, precioInt);
                addItemPresenter.insert(producto);
            }
        });
        //Comandos con los que volvemos a la vista anterior, nada relacionado con el login en sí.
        backBtn = findViewById(R.id.RAddBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RAddItemView.this, RHomeView.class);
                intent.putExtra("id_restaurante", extras.getInt("id_restaurante"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void successInsert(AddItemData addItemData) {
        Bundle extras = getIntent().getExtras();
        Intent intent = new Intent(RAddItemView.this, RHomeView.class);
        intent.putExtra("id_restaurante", extras.getInt("id_restaurante"));
        startActivity(intent);
    }

    @Override
    public void failureInsert(String err) {
        Toast.makeText(RAddItemView.this, err, Toast.LENGTH_SHORT).show();
    }
}