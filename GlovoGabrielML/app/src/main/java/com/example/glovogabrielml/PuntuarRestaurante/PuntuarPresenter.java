package com.example.glovogabrielml.PuntuarRestaurante;

import com.example.glovogabrielml.RAddItem.AddItemContract;
import com.example.glovogabrielml.RAddItem.AddItemModel;

public class PuntuarPresenter implements PuntuarContract.Presenter, PuntuarContract.Model.onInsertListener{
    //ATRIBUTOS
    private PuntuarContract.View view;
    private PuntuarContract.Model model;
    //CONSTRUCTORES
    public PuntuarPresenter(PuntuarContract.View view){
        this.view = view;
        model = new PuntuarModel(this);
    }

    //MÉTODOS
    @Override
    public void insert(int id_usuario, int id_restaurante, int nota) {
        model.insertAPI(id_usuario, id_restaurante, nota, this);
    }

    @Override
    public void onFinished(PuntuarData puntuarData) {
        view.successPuntuar(puntuarData);
    }

    @Override
    public void onFailure(String err) {
        view.failurePuntuar(err);
    }
}
