package com.example.glovogabrielml.Carrito.LoadCarrito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovogabrielml.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoadCarritoAdapter extends RecyclerView.Adapter<LoadCarritoAdapter.ViewHolder> {
    //ATRIBUTOS
    private ArrayList<LoadCarritoData> lstCarrito;
    private LayoutInflater inflater;

    //CONSTRUCTORES
    public LoadCarritoAdapter(Context context, ArrayList<LoadCarritoData> lstSales){
        this.lstCarrito = lstSales;
        this.inflater = LayoutInflater.from(context);
    }

    //MÉTODOS
    @NonNull
    @Override
    public LoadCarritoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_carrito_item, parent, false);
        return new LoadCarritoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadCarritoAdapter.ViewHolder holder, int position) {
        LoadCarritoData item = lstCarrito.get(position);
        // RELLENAR CON LOS DATOS
        holder.itemTitulo.setText(lstCarrito.get(position).getNombre());
        //Si
        String imgUrl = lstCarrito.get(position).getImagen();
        if(!imgUrl.equals("")){
            Picasso.get().load(imgUrl).into(holder.itemImagen);
        }
        holder.itemPrecio.setText(String.valueOf(lstCarrito.get(position).getPrecio())+"€");
        holder.itemCantidad.setText("x"+String.valueOf(lstCarrito.get(position).getCantidad()));
    }

    @Override
    public int getItemCount() {
        return lstCarrito.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImagen;
        TextView itemTitulo;
        TextView itemPrecio;
        TextView itemCantidad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitulo = itemView.findViewById(R.id.CartItemTitle);
            itemImagen = itemView.findViewById(R.id.CartItemImg);
            itemPrecio = itemView.findViewById(R.id.CartItemPrice);
            itemCantidad = itemView.findViewById(R.id.CartItemCantidad);
        }
    }
}
