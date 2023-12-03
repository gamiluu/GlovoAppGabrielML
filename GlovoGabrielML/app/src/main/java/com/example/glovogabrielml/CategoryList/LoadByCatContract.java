package com.example.glovogabrielml.CategoryList;


import java.util.ArrayList;

public interface LoadByCatContract {
    public interface View{
        public void successLoadByCat(ArrayList<LoadByCatData> lstRestaurantes);
        public void failureLoadByCat(String err);
    }
    public interface Presenter{
        public void LoadByCat(int id_categoria, String orden);

    }
    public interface Model{
        public void loadByCatAPI(int id_categoria, String orden, LoadByCatContract.Model.loadByCatListener loadByCatListener);
        public interface loadByCatListener{
            public void onFinished(ArrayList<LoadByCatData> lstRestaurantes);
            public void onFailure(String err);
        }

    }
}
