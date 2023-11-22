package com.example.glovogabrielml.RAddItem;

import android.util.Log;

import com.example.glovogabrielml.Beans.Producto;
import com.example.glovogabrielml.RestauranteLogin.RLoginData;
import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddItemModel implements AddItemContract.Model{
    //ATRIBUTOS
    private AddItemPresenter presenter;

    //CONSTRUCTORES
    public AddItemModel(AddItemPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void insertAPI(Producto producto, onInsertListener onInsertListener) {
        //Generamos un API y realizamos la petición de inserción.
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/GlovoAPI/").create(ApiService.class);
        Call<AddItemData> call = apiService.insertItem("PRODUCTOS.ADD_PRODUCTO",
                producto.getId_restaurante(),
                producto.getNombre(),
                producto.getImagen(),
                producto.getDescripcion(),
                producto.getPrecio());
        call.enqueue(new Callback<AddItemData>() {
            @Override
            public void onResponse(Call<AddItemData> call, Response<AddItemData> response) {
                if (response.isSuccessful()) {
                    System.out.println("Lineas afectadas: " + response.body());
                    AddItemData addItemData = response.body();

                    if (addItemData.getLineas_afectadas() == 0) {
                        onInsertListener.onFailure("Error en la inserción");

                    } else {
                        onInsertListener.onFinished(addItemData);
                    }

                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<AddItemData> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
