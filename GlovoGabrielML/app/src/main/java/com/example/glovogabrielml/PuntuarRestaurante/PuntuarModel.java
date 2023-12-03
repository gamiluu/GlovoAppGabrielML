package com.example.glovogabrielml.PuntuarRestaurante;

import android.util.Log;

import com.example.glovogabrielml.RAddItem.AddItemContract;
import com.example.glovogabrielml.RAddItem.AddItemData;
import com.example.glovogabrielml.RAddItem.AddItemPresenter;
import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuntuarModel implements PuntuarContract.Model{
    //ATRIBUTOS
    private PuntuarPresenter presenter;

    //CONSTRUCTORES
    public PuntuarModel(PuntuarPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void insertAPI(int id_usuario, int id_restaurante, int nota, PuntuarContract.Model.onInsertListener onInsertListener) {
        //Generamos un API y realizamos la petición de inserción.
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/GlovoAPI/").create(ApiService.class);
        Call<PuntuarData> call = apiService.insertRating("PUNTUACIONES.PUNTUAR",
                id_usuario,
                id_restaurante,
                nota);
        call.enqueue(new Callback<PuntuarData>() {
            @Override
            public void onResponse(Call<PuntuarData> call, Response<PuntuarData> response) {
                if (response.isSuccessful()) {
                    System.out.println("Lineas afectadas: " + response.body());
                    PuntuarData puntuarData = response.body();

                    if (puntuarData.getLineas_afectadas() == 0) {
                        onInsertListener.onFailure("Error al intentar puntuar el restaurante.");

                    } else {
                        onInsertListener.onFinished(puntuarData);
                    }

                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<PuntuarData> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
