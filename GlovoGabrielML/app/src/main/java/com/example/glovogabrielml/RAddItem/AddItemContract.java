package com.example.glovogabrielml.RAddItem;

import com.example.glovogabrielml.Beans.Producto;

public interface AddItemContract {
    public interface View {
        public void successInsert(AddItemData adItemData);
        public void failureInsert(String err);
    }

    public interface Presenter {
        public void insert(Producto producto);
    }

    public interface Model {
        public interface onInsertListener {
            public void onFinished(AddItemData adItemData);
            public void onFailure(String err);
        }
        public void insertAPI(Producto producto, AddItemContract.Model.onInsertListener onInsertListener);

    }
}
