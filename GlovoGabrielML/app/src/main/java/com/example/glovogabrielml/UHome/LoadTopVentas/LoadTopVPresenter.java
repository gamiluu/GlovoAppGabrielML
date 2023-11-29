package com.example.glovogabrielml.UHome.LoadTopVentas;

import java.util.ArrayList;

public class LoadTopVPresenter implements LoadTopVContract.Presenter, LoadTopVContract.Model.loadTopVListener{
    //ATRIBUTOS
    LoadTopVContract.View view;
    LoadTopVContract.Model model;

    //CONSTRUCTORES
    public LoadTopVPresenter(LoadTopVContract.View view ){
        this.view = view;
        model = new LoadTopVModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadTopV() {
        model.loadTopVAPI(this);
    }

    @Override
    public void onFinished(ArrayList<LoadTopVData> lstTopV) {
        view.successLoadTopV(lstTopV);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadTopV(err);
    }
}
