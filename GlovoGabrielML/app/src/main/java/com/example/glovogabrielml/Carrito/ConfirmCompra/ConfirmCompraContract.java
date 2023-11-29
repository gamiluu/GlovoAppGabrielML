package com.example.glovogabrielml.Carrito.ConfirmCompra;

import com.example.glovogabrielml.Beans.Producto;
import com.example.glovogabrielml.RAddItem.AddItemContract;
import com.example.glovogabrielml.RAddItem.AddItemData;

public interface ConfirmCompraContract {
    public interface View {
        public void successConfirm(ConfirmCompraData confirmCompraData);
        public void failureConfirm(String err);
    }

    public interface Presenter {
        public void confirmCompra(int idUsuario);
    }

    public interface Model {
        public interface onConfirmListener {
            public void onFinished(ConfirmCompraData confirmCompraData);
            public void onFailure(String err);
        }
        public void confirmAPI(int idUsuario, ConfirmCompraContract.Model.onConfirmListener onConfirmListener);

    }
}
