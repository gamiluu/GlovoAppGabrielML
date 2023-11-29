package com.example.glovogabrielml.RInfo.LoadRProducts;

import com.example.glovogabrielml.RHome.LoadItemModel;
import com.example.glovogabrielml.RHome.RHomeContract;

import java.util.ArrayList;

public class LoadRProductsPresenter implements LoadRProductsContract.Presenter, LoadRProductsContract.Model.loadRProductsListener{
    //ATRIBUTOS
    LoadRProductsContract.View view;
    LoadRProductsContract.Model model;

    //CONSTRUCTORES
    public LoadRProductsPresenter(LoadRProductsContract.View view ){
        this.view = view;
        model = new LoadRProductsModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadRProducts(int restauranteId) {
        model.loadRProductsAPI(restauranteId, this);
    }

    @Override
    public void onFinished(ArrayList<LoadRProductsData> lstProducts) {
        view.successRLoadProducts(lstProducts);
    }

    @Override
    public void onFailure(String err) {
        view.failureRLoadProducts(err);
    }
}
