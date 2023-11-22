package com.example.glovogabrielml.RHome;

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

public class LoadItemAdapter extends RecyclerView.Adapter<LoadItemAdapter.ViewHolder> {
    //ATRIBUTOS
    private ArrayList<LoadItemData> lstItems;
    private LayoutInflater inflater;

    //CONSTRUCTORES
    public LoadItemAdapter(Context context, ArrayList<LoadItemData> lstSales){
        this.lstItems = lstSales;
        this.inflater = LayoutInflater.from(context);
    }

    //MÉTODOS
    @NonNull
    @Override
    public LoadItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_rhome_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadItemAdapter.ViewHolder holder, int position) {
        LoadItemData item = lstItems.get(position);
        // RELLENAR CON LOS DATOS
        holder.itemTitulo.setText(lstItems.get(position).getNombre());
        //Si
        String imgUrl = lstItems.get(position).getImagen();
        if(!imgUrl.equals("")){
            Picasso.get().load(imgUrl).into(holder.itemImagen);
        }
        holder.itemDescripcion.setText(lstItems.get(position).getDescripcion());
        holder.itemPrecio.setText(String.valueOf(lstItems.get(position).getPrecio())+"€");

    }

    @Override
    public int getItemCount() {
        return lstItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImagen;
        TextView itemTitulo;
        TextView itemDescripcion;
        TextView itemPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitulo = itemView.findViewById(R.id.RHomeItemTitle);
            itemImagen = itemView.findViewById(R.id.RHomeItemImg);
            itemDescripcion = itemView.findViewById(R.id.RHomeItemDesc);
            itemPrecio = itemView.findViewById(R.id.RHomeItemPrice);
        }
    }
}
