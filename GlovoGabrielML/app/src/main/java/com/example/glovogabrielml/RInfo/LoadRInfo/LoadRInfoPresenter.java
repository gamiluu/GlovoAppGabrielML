package com.example.glovogabrielml.RInfo.LoadRInfo;

public class LoadRInfoPresenter implements LoadRInfoContract.Presenter, LoadRInfoContract.Model.loadRInfoListener{
    //ATRIBUTOS
    LoadRInfoContract.View view;
    LoadRInfoContract.Model model;

    //CONSTRUCTORES
    public LoadRInfoPresenter(LoadRInfoContract.View view ){
        this.view = view;
        model = new LoadRInfoModel(this);
    }

    //MÉTODOS
    @Override
    public void LoadRInfo(int restauranteId) {
        model.loadRInfoAPI(restauranteId, this);
    }

    @Override
    public void onFinished(LoadRInfoData rInfoData) {
        view.successRLoadInfo(rInfoData);
    }

    @Override
    public void onFailure(String err) {
        view.failureRLoadInfo(err);
    }
}
