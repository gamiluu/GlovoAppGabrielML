package com.example.glovogabrielml.RHome;

import android.util.Log;

import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadItemModel implements RHomeContract.Model{
    //ATRIBUTOS
    private LoadItemPresenter presenter;

    //CONSTRUCTORES
    public LoadItemModel(LoadItemPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadItemAPI(int restauranteId, loadItemListener loadItemListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<ArrayList<LoadItemData>> call = apiService.getMyProducts("PRODUCTOS.FIND_BY_ID", restauranteId);
        call.enqueue(new Callback<ArrayList<LoadItemData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoadItemData>> call, Response<ArrayList<LoadItemData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es: " + response.body());
                    ArrayList<LoadItemData> lstItems = response.body();
                    System.out.println(response.body());
                    for (LoadItemData item: lstItems) {
                        System.out.println(item.toString());
                    }
                    if (lstItems.isEmpty()){
                        loadItemListener.onFailure("No tienes productos a la venta.");
                    }else{
                        loadItemListener.onFinished(lstItems);

                    }
                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoadItemData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }

}
