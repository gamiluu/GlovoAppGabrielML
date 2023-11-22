package com.example.glovogabrielml.UsuarioLogin;

import com.example.glovogabrielml.Beans.Restaurante;
import com.example.glovogabrielml.Beans.Usuario;
import com.example.glovogabrielml.RestauranteLogin.RLoginContract;
import com.example.glovogabrielml.RestauranteLogin.RLoginData;

public interface ULoginContract {
    public interface View {
        public void successLogin(ULoginData uLoginData);
        public void failureLogin(String err);
    }

    public interface Presenter {
        public void login(Usuario usuario);
    }

    public interface Model {
        public interface onULoginListener {
            public void onFinished(ULoginData uLoginData);
            public void onFailure(String err);
        }
        public void loginAPI(Usuario usuario, ULoginContract.Model.onULoginListener onULoginListener);
    }
}
