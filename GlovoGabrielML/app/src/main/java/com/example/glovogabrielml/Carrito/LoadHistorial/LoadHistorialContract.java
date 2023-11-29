package com.example.glovogabrielml.Carrito.LoadHistorial;

import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoContract;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoData;

import java.util.ArrayList;

public interface LoadHistorialContract {
    public interface View{
        public void successLoadHistorial(ArrayList<LoadHistorialData> lstHistorial);
        public void failureLoadHistorial(String err);
    }
    public interface Presenter{
        public void LoadHistorial(int idUsuario);

    }
    public interface Model{
        public void loadHistorialAPI(int idUsuario, LoadHistorialContract.Model.loadHistorialListener loadHistorialListener);
        public interface loadHistorialListener{
            public void onFinished(ArrayList<LoadHistorialData> lstHistorial);
            public void onFailure(String err);
        }

    }
}
