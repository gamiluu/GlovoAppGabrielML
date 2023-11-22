package com.example.glovogabrielml.UHome;



import java.util.ArrayList;

public interface LoadTopVContract {
    public interface View{
        public void successLoadTopV(ArrayList<LoadTopVData> lstTopV);
        public void failureLoadTopV(String err);
    }
    public interface Presenter{
        public void LoadTopV();

    }
    public interface Model{
        public void loadTopVAPI(LoadTopVContract.Model.loadTopVListener loadTopVListener);
        public interface loadTopVListener{
            public void onFinished(ArrayList<LoadTopVData> lstTopV);
            public void onFailure(String err);
        }

    }
}
