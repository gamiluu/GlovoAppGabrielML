package com.example.glovogabrielml.Carrito.LoadCarrito;

import java.util.ArrayList;

public interface LoadCarritoContract {
    public interface View{
        public void successLoadCarrito(ArrayList<LoadCarritoData> lstCarrito);
        public void failureLoadCarrito(String err);
    }
    public interface Presenter{
        public void LoadCarrito(int idUsuario);

    }
    public interface Model{
        public void loadCarritoAPI(int idUsuario, LoadCarritoContract.Model.loadCarritoListener loadCarritoListener);
        public interface loadCarritoListener{
            public void onFinished(ArrayList<LoadCarritoData> lstCarrito);
            public void onFailure(String err);
        }

    }
}
