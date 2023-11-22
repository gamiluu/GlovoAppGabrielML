package com.example.glovogabrielml.RestauranteLogin;

import com.example.glovogabrielml.Beans.Restaurante;

public class RLoginPresenter implements RLoginContract.Presenter, RLoginContract.Model.onRLoginListener{
    //////////////////////////////ATRIBUTOS//////////////////////////////
    private RLoginContract.View view;
    private RLoginContract.Model model;

    ////////////////////////////CONSTRUCTORES////////////////////////////
    public RLoginPresenter(RLoginContract.View view){
        this.view = view;
        model = new RLoginModel(this);
    }

    ///////////////////////////////MÉTODOS///////////////////////////////
    @Override
    public void login(Restaurante restaurante) {
        model.loginAPI(restaurante, this);
    }
    @Override
    public void onFinished(RLoginData rLoginData) {
        view.successLogin(rLoginData);
    }
    @Override
    public void onFailure(String err) {
        view.failureLogin(err);
    }
}
