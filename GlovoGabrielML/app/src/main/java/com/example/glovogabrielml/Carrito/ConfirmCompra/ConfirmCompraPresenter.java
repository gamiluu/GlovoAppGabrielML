package com.example.glovogabrielml.Carrito.ConfirmCompra;

import com.example.glovogabrielml.RAddItem.AddItemContract;
import com.example.glovogabrielml.RAddItem.AddItemModel;

public class ConfirmCompraPresenter implements ConfirmCompraContract.Presenter, ConfirmCompraContract.Model.onConfirmListener{
    //ATRIBUTOS
    private ConfirmCompraContract.View view;
    private ConfirmCompraContract.Model model;
    //CONSTRUCTORES
    public ConfirmCompraPresenter(ConfirmCompraContract.View view){
        this.view = view;
        model = new ConfirmCompraModel(this);
    }

    //MÉTODOS
    @Override
    public void confirmCompra(int idUsuario) {
        model.confirmAPI(idUsuario, this);
    }

    @Override
    public void onFinished(ConfirmCompraData confirmCompraData) {
        view.successConfirm(confirmCompraData);
    }

    @Override
    public void onFailure(String err) {
        view.failureConfirm(err);
    }
}
