package com.example.glovogabrielml.Carrito.LoadHistorial;

import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoContract;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoData;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoModel;

import java.util.ArrayList;

public class LoadHistorialPresenter implements LoadHistorialContract.Presenter, LoadHistorialContract.Model.loadHistorialListener{
    //ATRIBUTOS
    LoadHistorialContract.View view;
    LoadHistorialContract.Model model;

    //CONSTRUCTORES
    public LoadHistorialPresenter(LoadHistorialContract.View view ){
        this.view = view;
        model = new LoadHistorialModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadHistorial(int idUsuario) {
        model.loadHistorialAPI(idUsuario,this);
    }

    @Override
    public void onFinished(ArrayList<LoadHistorialData> lstHistorial) {
        view.successLoadHistorial(lstHistorial);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadHistorial(err);
    }
}
