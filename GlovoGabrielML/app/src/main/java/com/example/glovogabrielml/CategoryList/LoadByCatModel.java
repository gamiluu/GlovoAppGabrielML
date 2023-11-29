package com.example.glovogabrielml.CategoryList;

import android.util.Log;

import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadByCatModel implements LoadByCatContract.Model{
    //ATRIBUTOS
    private LoadByCatPresenter presenter;

    //CONSTRUCTORES
    public LoadByCatModel(LoadByCatPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadByCatAPI(int id_categoria, loadByCatListener loadByCatListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<ArrayList<LoadByCatData>> call = apiService.getByCategoria("RESTAURANTES.FIND_BY_CATEGORIA", id_categoria);
        call.enqueue(new Callback<ArrayList<LoadByCatData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoadByCatData>> call, Response<ArrayList<LoadByCatData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es: " + response.body());
                    ArrayList<LoadByCatData> lstRestaurantes = response.body();
                    System.out.println(response.body());
                    for (LoadByCatData item: lstRestaurantes) {
                        System.out.println(item.toString());
                    }
                    if (lstRestaurantes.isEmpty()){
                        loadByCatListener.onFailure("No hay restaurantes con esta categoría.");
                    }else{
                        loadByCatListener.onFinished(lstRestaurantes);

                    }
                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoadByCatData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
