package com.example.glovogabrielml.RHome;

import java.util.ArrayList;

public interface RHomeContract {
    public interface View{
        public void successLoadItem(ArrayList<LoadItemData> lstItems);
        public void failureLoadItem(String err);
    }
    public interface Presenter{
        public void LoadItem(int restauranteId);

    }
    public interface Model{
        public void loadItemAPI(int restauranteId, loadItemListener loadItemListener);
        public interface loadItemListener{
            public void onFinished(ArrayList<LoadItemData> lstItems);
            public void onFailure(String err);
        }

    }
}
