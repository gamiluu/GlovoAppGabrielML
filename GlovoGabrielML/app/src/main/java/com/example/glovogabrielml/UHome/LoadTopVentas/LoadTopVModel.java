package com.example.glovogabrielml.UHome.LoadTopVentas;

import android.util.Log;

import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadTopVModel implements LoadTopVContract.Model{
    //ATRIBUTOS
    private LoadTopVPresenter presenter;

    //CONSTRUCTORES
    public LoadTopVModel(LoadTopVPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadTopVAPI(loadTopVListener loadTopVListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<ArrayList<LoadTopVData>> call = apiService.getTopVentas("RESTAURANTES.FIND_TOP_VENTAS");
        call.enqueue(new Callback<ArrayList<LoadTopVData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoadTopVData>> call, Response<ArrayList<LoadTopVData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es esto: " + response.body());
                    ArrayList<LoadTopVData> lstTopV = response.body();
                    System.out.println(response.body());
                    for (LoadTopVData item: lstTopV) {
                        System.out.println(item.toString());
                    }
                    if (lstTopV.isEmpty()){
                        loadTopVListener.onFailure("No tienes productos a la venta.");
                    }else{
                        loadTopVListener.onFinished(lstTopV);

                    }
                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoadTopVData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }

}
