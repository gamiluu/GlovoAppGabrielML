package com.example.glovogabrielml.UHome.LoadCategorias;

import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRContract;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRModel;

import java.util.ArrayList;

public class LoadCatPresenter implements LoadCatContract.Presenter, LoadCatContract.Model.loadCatListener{
    //ATRIBUTOS
    LoadCatContract.View view;
    LoadCatContract.Model model;

    //CONSTRUCTOR
    public LoadCatPresenter(LoadCatContract.View view) {
        this.view = view;
        this.model = new LoadCatModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadCat() {
        model.loadCatAPI(this);
    }

    @Override
    public void onFinished(ArrayList<LoadCatData> lstCategorias) {
        view.successLoadCat(lstCategorias);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadCat(err);
    }
}
