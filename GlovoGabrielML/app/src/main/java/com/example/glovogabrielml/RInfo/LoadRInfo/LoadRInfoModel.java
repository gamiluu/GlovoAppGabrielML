package com.example.glovogabrielml.RInfo.LoadRInfo;

import android.util.Log;

import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadRInfoModel implements LoadRInfoContract.Model{
    //ATRIBUTOS
    private LoadRInfoPresenter presenter;

    //CONSTRUCTORES
    public LoadRInfoModel(LoadRInfoPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void loadRInfoAPI(int restauranteId, loadRInfoListener loadRInfoListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(ApiService.class);

        Call<LoadRInfoData> call = apiService.getMyRInfo("RESTAURANTES.FIND_RESTAURANTE", restauranteId);
        call.enqueue(new Callback<LoadRInfoData>() {
            @Override
            public void onResponse(Call<LoadRInfoData> call, Response<LoadRInfoData> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es: " + response.body());
                    LoadRInfoData rInfoData = response.body();
                    System.out.println(response.body());
                    if (rInfoData.getNombre()==null){
                        loadRInfoListener.onFailure("No se pudo obtener la información del restaurante.");
                    }else{
                        loadRInfoListener.onFinished(rInfoData);

                    }
                } else {
                    System.out.println("Ha habido un error.");
                }
            }

            @Override
            public void onFailure(Call<LoadRInfoData> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
