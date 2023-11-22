package com.example.glovogabrielml.RestauranteLogin;

import com.example.glovogabrielml.Beans.Restaurante;

public interface RLoginContract {
    public interface View {
        public void successLogin(RLoginData rLoginData);
        public void failureLogin(String err);
    }

    public interface Presenter {
        public void login(Restaurante restaurante);
    }

    public interface Model {
        public interface onRLoginListener {
            public void onFinished(RLoginData rLoginData);
            public void onFailure(String err);
        }
        public void loginAPI(Restaurante restaurante, onRLoginListener onRLoginListener);
    }
}
