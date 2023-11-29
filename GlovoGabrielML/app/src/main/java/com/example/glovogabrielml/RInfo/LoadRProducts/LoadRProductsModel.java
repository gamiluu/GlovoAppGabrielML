package com.example.glovogabrielml.RInfo.LoadRProducts;

import android.util.Log;

import com.example.glovogabrielml.RHome.LoadItemData;
import com.example.glovogabrielml.RHome.LoadItemPresenter;
import com.example.glovogabrielml.RInfo.LoadRInfo.LoadRInfoContract;
import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadRProductsModel implements LoadRProductsContract.Model{
    //ATRIBUTOS
    private LoadRProductsPresenter presenter;

    //CONSTRUCTORES
    public LoadRProductsModel(LoadRProductsPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadRProductsAPI(int restauranteId, LoadRProductsContract.Model.loadRProductsListener loadRProductsListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<ArrayList<LoadRProductsData>> call = apiService.getRProducts("PRODUCTOS.FIND_BY_ID", restauranteId);
        call.enqueue(new Callback<ArrayList<LoadRProductsData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoadRProductsData>> call, Response<ArrayList<LoadRProductsData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es: " + response.body());
                    ArrayList<LoadRProductsData> lstProducts = response.body();
                    System.out.println(response.body());
                    for (LoadRProductsData item: lstProducts) {
                        System.out.println(item.toString());
                    }
                    if (lstProducts.isEmpty()){
                        loadRProductsListener.onFailure("Este restaurante no ha publicado ningún producto.");
                    }else{
                        loadRProductsListener.onFinished(lstProducts);

                    }
                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoadRProductsData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
