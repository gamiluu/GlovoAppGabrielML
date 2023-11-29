package com.example.glovogabrielml.RInfo.LoadRProducts;

import com.example.glovogabrielml.RInfo.LoadRInfo.LoadRInfoContract;
import com.example.glovogabrielml.RInfo.LoadRInfo.LoadRInfoData;

import java.util.ArrayList;

public interface LoadRProductsContract {
    public interface View{
        public void successRLoadProducts(ArrayList<LoadRProductsData> lstProducts);
        public void failureRLoadProducts(String err);
    }
    public interface Presenter{
        public void LoadRProducts(int restauranteId);

    }
    public interface Model{
        public void loadRProductsAPI(int restauranteId, LoadRProductsContract.Model.loadRProductsListener loadRProductsListener);
        public interface loadRProductsListener{
            public void onFinished(ArrayList<LoadRProductsData> lstProducts);
            public void onFailure(String err);
        }

    }
}
