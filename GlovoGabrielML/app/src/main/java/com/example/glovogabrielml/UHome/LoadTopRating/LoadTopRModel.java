package com.example.glovogabrielml.UHome.LoadTopRating;

import android.util.Log;

import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadTopRModel implements LoadTopRContract.Model{
    //ATRIBUTOS
    private LoadTopRPresenter presenter;
    //CONSTRUCTORES
    public LoadTopRModel(LoadTopRPresenter presenter) {
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadTopRAPI(loadTopRListener loadTopRListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<ArrayList<LoadTopRData>> call = apiService.getTopRating("RESTAURANTES.FIND_TOP_RATING");
        call.enqueue(new Callback<ArrayList<LoadTopRData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoadTopRData>> call, Response<ArrayList<LoadTopRData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es esto: " + response.body());
                    ArrayList<LoadTopRData> lstTopR = response.body();
                    System.out.println(response.body());
                    for (LoadTopRData item: lstTopR) {
                        System.out.println(item.toString());
                    }
                    if (lstTopR.isEmpty()){
                        loadTopRListener.onFailure("No se encontraron establecimientos.");
                    }else{
                        loadTopRListener.onFinished(lstTopR);

                    }
                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoadTopRData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
