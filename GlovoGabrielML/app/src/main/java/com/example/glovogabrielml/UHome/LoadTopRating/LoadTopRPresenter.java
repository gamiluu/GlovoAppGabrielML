package com.example.glovogabrielml.UHome.LoadTopRating;

import java.util.ArrayList;

public class LoadTopRPresenter implements LoadTopRContract.Presenter, LoadTopRContract.Model.loadTopRListener{
    //ATRIBUTOS
    LoadTopRContract.View view;
    LoadTopRContract.Model model;

    //CONSTRUCTOR
    public LoadTopRPresenter(LoadTopRContract.View view) {
        this.view = view;
        this.model = new LoadTopRModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadTopR() {
        model.loadTopRAPI(this);
    }

    @Override
    public void onFinished(ArrayList<LoadTopRData> lstTopR) {
        view.successLoadTopR(lstTopR);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadTopR(err);
    }
}
