package com.example.glovogabrielml.CategoryList;

import java.util.ArrayList;

public class LoadByCatPresenter implements LoadByCatContract.Presenter, LoadByCatContract.Model.loadByCatListener{
    //ATRIBUTOS
    LoadByCatContract.View view;
    LoadByCatContract.Model model;

    //CONSTRUCTORES
    public LoadByCatPresenter(LoadByCatContract.View view ){
        this.view = view;
        model = new LoadByCatModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadByCat(int id_categoria, String orden) {
        model.loadByCatAPI(id_categoria, orden, this);
    }

    @Override
    public void onFinished(ArrayList<LoadByCatData> lstRestaurantes) {
        view.successLoadByCat(lstRestaurantes);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadByCat(err);
    }
}
