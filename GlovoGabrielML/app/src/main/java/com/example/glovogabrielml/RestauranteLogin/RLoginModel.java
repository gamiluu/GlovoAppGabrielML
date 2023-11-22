package com.example.glovogabrielml.RestauranteLogin;

import android.util.Log;
import com.example.glovogabrielml.Beans.Restaurante;
import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RLoginModel implements RLoginContract.Model{
    //////////////////////////////ATRIBUTOS//////////////////////////////
    private RLoginPresenter presenter;

    ////////////////////////////CONSTRUCTORES////////////////////////////
    public RLoginModel(RLoginPresenter presenter) {
        this.presenter = presenter;
    }

    ///////////////////////////////MÉTODOS///////////////////////////////
    @Override
    public void loginAPI(Restaurante restaurante, onRLoginListener onRLoginListener) {

        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/GlovoAPI/").create(ApiService.class);

        Call<RLoginData> call = apiService.getRLogin("RESTAURANTES.LOGIN", restaurante.getNombre(), restaurante.getClave());
        call.enqueue(new Callback<RLoginData>() {
            @Override
            public void onResponse(Call<RLoginData> call, Response<RLoginData> response) {
                if (response.isSuccessful()) {

                    System.out.println("ID del restaurante: " + response.body());
                    RLoginData rLoginData = response.body();

                    if (rLoginData.getId() == null) {
                        onRLoginListener.onFailure("Error");

                    } else {
                        onRLoginListener.onFinished(rLoginData);
                    }

                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<RLoginData> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }


}
