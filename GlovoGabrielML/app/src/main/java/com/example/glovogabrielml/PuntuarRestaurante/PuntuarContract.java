package com.example.glovogabrielml.PuntuarRestaurante;

import com.example.glovogabrielml.Beans.Producto;
import com.example.glovogabrielml.RAddItem.AddItemContract;
import com.example.glovogabrielml.RAddItem.AddItemData;

public interface PuntuarContract {
    public interface View {
        public void successPuntuar(PuntuarData puntuarData);
        public void failurePuntuar(String err);
    }

    public interface Presenter {
        public void insert(int id_restaurante, int id_usuario, int nota);
    }

    public interface Model {
        public interface onInsertListener {
            public void onFinished(PuntuarData puntuarData);
            public void onFailure(String err);
        }
        public void insertAPI(int id_restaurante, int id_usuario, int nota, PuntuarContract.Model.onInsertListener onInsertListener);

    }
}
