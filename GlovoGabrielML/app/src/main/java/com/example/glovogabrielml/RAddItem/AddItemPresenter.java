package com.example.glovogabrielml.RAddItem;

import com.example.glovogabrielml.Beans.Producto;

public class AddItemPresenter implements AddItemContract.Presenter, AddItemContract.Model.onInsertListener{
    //ATRIBUTOS
    private AddItemContract.View view;
    private AddItemContract.Model model;
    //CONSTRUCTORES
    public AddItemPresenter(AddItemContract.View view){
        this.view = view;
        model = new AddItemModel(this);
    }

    //MÉTODOS
    @Override
    public void insert(Producto producto) {
        model.insertAPI(producto, this);
    }

    @Override
    public void onFinished(AddItemData adItemData) {
        view.successInsert(adItemData);
    }

    @Override
    public void onFailure(String err) {
        view.failureInsert(err);
    }
}
