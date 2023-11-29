package com.example.glovogabrielml.UHome.LoadTopRating;

import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVContract;
import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVData;

import java.util.ArrayList;

public interface LoadTopRContract {
    public interface View{
        public void successLoadTopR(ArrayList<LoadTopRData> lstTopR);
        public void failureLoadTopR(String err);
    }
    public interface Presenter{
        public void LoadTopR();

    }
    public interface Model{
        public void loadTopRAPI(LoadTopRContract.Model.loadTopRListener loadTopRListener);
        public interface loadTopRListener{
            public void onFinished(ArrayList<LoadTopRData> lstTopR);
            public void onFailure(String err);
        }
    }
}
