package com.example.glovogabrielml.UHome.LoadCategorias;

import java.util.ArrayList;

public interface LoadCatContract {
    public interface View{
        public void successLoadCat(ArrayList<LoadCatData> lstCategorias);
        public void failureLoadCat(String err);
    }
    public interface Presenter{
        public void LoadCat();

    }
    public interface Model{
        public void loadCatAPI(LoadCatContract.Model.loadCatListener loadCatListener);
        public interface loadCatListener{
            public void onFinished(ArrayList<LoadCatData> lstCategorias);
            public void onFailure(String err);
        }
    }
}
