package com.example.glovogabrielml.Carrito.LoadHistorial;

import android.util.Log;

import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoData;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoPresenter;
import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadHistorialModel implements LoadHistorialContract.Model{
    //ATRIBUTOS
    private LoadHistorialPresenter presenter;

    //CONSTRUCTORES
    public LoadHistorialModel(LoadHistorialPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadHistorialAPI(int idUsuario, loadHistorialListener loadHistorialListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<ArrayList<LoadHistorialData>> call = apiService.getMyHistorial("COMPRAS.FIND_HISTORIAL", idUsuario);
        call.enqueue(new Callback<ArrayList<LoadHistorialData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoadHistorialData>> call, Response<ArrayList<LoadHistorialData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es: " + response.body());
                    ArrayList<LoadHistorialData> lstHistorial = response.body();
                    System.out.println(response.body());
                    for (LoadHistorialData item: lstHistorial) {
                        System.out.println(item.toString());
                    }
                    if (lstHistorial.isEmpty()){
                        loadHistorialListener.onFailure("Se han realizado compras todavía.");
                    }else{
                        loadHistorialListener.onFinished(lstHistorial);

                    }
                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoadHistorialData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
