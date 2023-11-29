package com.example.glovogabrielml.RInfo.LoadRProducts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RHome.LoadItemAdapter;
import com.example.glovogabrielml.RHome.LoadItemData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoadRProductsAdapter extends RecyclerView.Adapter<LoadRProductsAdapter.ViewHolder> {
    //ATRIBUTOS
    private ArrayList<LoadRProductsData> lstProducts;
    private LayoutInflater inflater;

    //CONSTRUCTORES
    public LoadRProductsAdapter(Context context, ArrayList<LoadRProductsData> lstProducts){
        this.lstProducts = lstProducts;
        this.inflater = LayoutInflater.from(context);
    }

    //MÉTODOS
    @NonNull
    @Override
    public LoadRProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_rinfo_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadRProductsAdapter.ViewHolder holder, int position) {
        LoadRProductsData item = lstProducts.get(position);
        // RELLENAR CON LOS DATOS
        holder.itemTitulo.setText(lstProducts.get(position).getNombre());
        //Si
        String imgUrl = lstProducts.get(position).getImagen();
        if(!imgUrl.equals("")){
            Picasso.get().load(imgUrl).into(holder.itemImagen);
        }
        holder.itemDescripcion.setText(lstProducts.get(position).getDescripcion());
        holder.itemPrecio.setText(String.valueOf(lstProducts.get(position).getPrecio())+"€");
    }

    @Override
    public int getItemCount() {
        return lstProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImagen;
        TextView itemTitulo;
        TextView itemDescripcion;
        TextView itemPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitulo = itemView.findViewById(R.id.RInfoItemTitle);
            itemImagen = itemView.findViewById(R.id.RInfoItemImg);
            itemDescripcion = itemView.findViewById(R.id.RInfoItemDesc);
            itemPrecio = itemView.findViewById(R.id.RInfoItemPrice);
        }
    }
}
