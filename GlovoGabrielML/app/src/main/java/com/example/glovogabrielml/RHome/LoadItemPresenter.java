package com.example.glovogabrielml.RHome;

import java.util.ArrayList;

public class LoadItemPresenter implements RHomeContract.Presenter, RHomeContract.Model.loadItemListener{
    //ATRIBUTOS
    RHomeContract.View view;
    RHomeContract.Model model;

    //CONSTRUCTORES
    public LoadItemPresenter(RHomeContract.View view ){
        this.view = view;
        model = new LoadItemModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadItem(int restauranteId) {
        model.loadItemAPI(restauranteId, this);
    }
    @Override
    public void onFinished(ArrayList<LoadItemData> lstItems) {
        view.successLoadItem(lstItems);
    }
    @Override
    public void onFailure(String err) {
        view.failureLoadItem(err);
    }
}
