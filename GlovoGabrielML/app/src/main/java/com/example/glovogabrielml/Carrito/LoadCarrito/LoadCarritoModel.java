package com.example.glovogabrielml.Carrito.LoadCarrito;

import android.util.Log;

import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadCarritoModel implements LoadCarritoContract.Model{
    //ATRIBUTOS
    private LoadCarritoPresenter presenter;

    //CONSTRUCTORES
    public LoadCarritoModel(LoadCarritoPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadCarritoAPI(int idUsuario, loadCarritoListener loadCarritoListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<ArrayList<LoadCarritoData>> call = apiService.getMyCarrito("PRODUCTOS.FIND_CURRENT_CART", idUsuario);
        call.enqueue(new Callback<ArrayList<LoadCarritoData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoadCarritoData>> call, Response<ArrayList<LoadCarritoData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es: " + response.body());
                    ArrayList<LoadCarritoData> lstCarrito = response.body();
                    System.out.println(response.body());
                    for (LoadCarritoData item: lstCarrito) {
                        System.out.println(item.toString());
                    }
                    if (lstCarrito.isEmpty()){
                        loadCarritoListener.onFailure("No has añadido ningún producto.");
                    }else{
                        loadCarritoListener.onFinished(lstCarrito);

                    }
                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoadCarritoData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
