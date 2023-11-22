package com.example.glovogabrielml.UsuarioLogin;

import android.util.Log;

import com.example.glovogabrielml.Beans.Usuario;
import com.example.glovogabrielml.RestauranteLogin.RLoginData;
import com.example.glovogabrielml.RestauranteLogin.RLoginPresenter;
import com.example.glovogabrielml.Utils.ApiService;
import com.example.glovogabrielml.Utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ULoginModel implements ULoginContract.Model{
    //////////////////////////////ATRIBUTOS//////////////////////////////
    private ULoginPresenter presenter;

    ////////////////////////////CONSTRUCTORES////////////////////////////
    public ULoginModel(ULoginPresenter presenter) {
        this.presenter = presenter;
    }

    ///////////////////////////////MÉTODOS///////////////////////////////
    @Override
    public void loginAPI(Usuario usuario, onULoginListener onULoginListener) {
        ApiService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/GlovoAPI/").create(ApiService.class);

        Call<ULoginData> call = apiService.getULogin("USUARIOS.LOGIN", usuario.getNombre(), usuario.getContrasena());
        call.enqueue(new Callback<ULoginData>() {
            @Override
            public void onResponse(Call<ULoginData> call, Response<ULoginData> response) {
                if (response.isSuccessful()) {

                    System.out.println("ID del usuario: " + response.body());
                    ULoginData uLoginData = response.body();

                    if (uLoginData.getId_usuario() == null) {
                        onULoginListener.onFailure("Error");

                    } else {
                        onULoginListener.onFinished(uLoginData);
                    }

                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ULoginData> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
