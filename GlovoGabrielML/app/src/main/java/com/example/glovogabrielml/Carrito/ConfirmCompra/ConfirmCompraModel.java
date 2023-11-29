package com.example.glovogabrielml.Carrito.ConfirmCompra;

import android.util.Log;

import com.example.glovogabrielml.RAddItem.AddItemData;
import com.example.glovogabrielml.RAddItem.AddItemPresenter;
import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmCompraModel implements ConfirmCompraContract.Model{
    //ATRIBUTOS
    private ConfirmCompraPresenter presenter;

    //CONSTRUCTORES
    public ConfirmCompraModel(ConfirmCompraPresenter presenter){
        this.presenter = presenter;
    }

    //MÉTODOS
    @Override
    public void confirmAPI(int idUsuario, onConfirmListener onConfirmListener) {
        //Generamos un API y realizamos la petición de inserción.
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/GlovoAPI/").create(ApiService.class);
        Call<ConfirmCompraData> call = apiService.confirmCompra("COMPRAS.CONFIRM_COMPRA", idUsuario);
        call.enqueue(new Callback<ConfirmCompraData>() {
            @Override
            public void onResponse(Call<ConfirmCompraData> call, Response<ConfirmCompraData> response) {
                if (response.isSuccessful()) {
                    System.out.println("Lineas afectadas: " + response.body());
                    ConfirmCompraData confirmCompraData = response.body();

                    if (confirmCompraData.getLineas_afectadas() == 0) {
                        onConfirmListener.onFailure("Error en la inserción");

                    } else {
                        onConfirmListener.onFinished(confirmCompraData);
                    }

                } else {
                    System.out.println("Ha habido un error en el proceso de confirmación.");
                }
            }

            @Override
            public void onFailure(Call<ConfirmCompraData> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
