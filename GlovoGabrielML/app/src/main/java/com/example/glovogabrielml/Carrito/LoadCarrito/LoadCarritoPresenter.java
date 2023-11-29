package com.example.glovogabrielml.Carrito.LoadCarrito;

import java.util.ArrayList;

public class LoadCarritoPresenter implements LoadCarritoContract.Presenter, LoadCarritoContract.Model.loadCarritoListener{
    //ATRIBUTOS
    LoadCarritoContract.View view;
    LoadCarritoContract.Model model;

    //CONSTRUCTORES
    public LoadCarritoPresenter(LoadCarritoContract.View view ){
        this.view = view;
        model = new LoadCarritoModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadCarrito(int idUsuario) {
        model.loadCarritoAPI(idUsuario, this);
    }

    @Override
    public void onFinished(ArrayList<LoadCarritoData> lstCarrito) {
        view.successLoadCarrito(lstCarrito);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadCarrito(err);
    }
}
