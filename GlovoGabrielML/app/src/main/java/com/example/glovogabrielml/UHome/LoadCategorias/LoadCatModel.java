package com.example.glovogabrielml.UHome.LoadCategorias;

import android.util.Log;

import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRData;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRPresenter;
import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadCatModel implements LoadCatContract.Model{
    //ATRIBUTOS
    private LoadCatPresenter presenter;
    //CONSTRUCTORES
    public LoadCatModel(LoadCatPresenter presenter) {
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadCatAPI(loadCatListener loadCatListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<ArrayList<LoadCatData>> call = apiService.getCategorias("CATEGORIAS.FIND_ALL");
        call.enqueue(new Callback<ArrayList<LoadCatData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoadCatData>> call, Response<ArrayList<LoadCatData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es esto: " + response.body());
                    ArrayList<LoadCatData> lstCategorias = response.body();
                    System.out.println(response.body());
                    for (LoadCatData item: lstCategorias) {
                        System.out.println(item.toString());
                    }
                    if (lstCategorias.isEmpty()){
                        loadCatListener.onFailure("No se encontraron categorias.");
                    }else{
                        loadCatListener.onFinished(lstCategorias);

                    }
                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoadCatData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
