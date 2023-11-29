package com.example.glovogabrielml.RInfo.LoadRInfo;

public interface LoadRInfoContract {
    public interface View{
        public void successRLoadInfo(LoadRInfoData rInfoData);
        public void failureRLoadInfo(String err);
    }
    public interface Presenter{
        public void LoadRInfo(int restauranteId);

    }
    public interface Model{
        public void loadRInfoAPI(int restauranteId, LoadRInfoContract.Model.loadRInfoListener loadRInfoListener);
        public interface loadRInfoListener{
            public void onFinished(LoadRInfoData rInfoData);
            public void onFailure(String err);
        }

    }
}
