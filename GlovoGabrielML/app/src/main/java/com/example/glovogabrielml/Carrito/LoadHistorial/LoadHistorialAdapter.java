package com.example.glovogabrielml.Carrito.LoadHistorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovogabrielml.R;

import java.sql.Date;
import java.util.ArrayList;

public class LoadHistorialAdapter extends RecyclerView.Adapter<LoadHistorialAdapter.ViewHolder> {
    //ATRIBUTOS
    private ArrayList<LoadHistorialData> lstHistorial;
    private LayoutInflater inflater;

    //CONSTRUCTORES
    public LoadHistorialAdapter(Context context, ArrayList<LoadHistorialData> lstSales){
        this.lstHistorial = lstSales;
        this.inflater = LayoutInflater.from(context);
    }

    //MÉTODOS
    @NonNull
    @Override
    public LoadHistorialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_carrito_historial, parent, false);
        return new LoadHistorialAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadHistorialAdapter.ViewHolder holder, int position) {
        LoadHistorialData item = lstHistorial.get(position);
        // RELLENAR CON LOS DATOS
        holder.itemId.setText(String.valueOf(lstHistorial.get(position).getId_compra()));
        holder.itemFecha.setText(lstHistorial.get(position).getFecha());
        holder.itemPrecio.setText(String.valueOf(lstHistorial.get(position).getPrecio())+"€");
    }

    @Override
    public int getItemCount() {
        return lstHistorial.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemId;
        TextView itemFecha;
        TextView itemPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemId = itemView.findViewById(R.id.CarritoHistorialId);
            itemFecha = itemView.findViewById(R.id.CarritoHistorialFecha);
            itemPrecio = itemView.findViewById(R.id.CarritoHistorialPrecio);
        }
    }
}
