package com.example.glovogabrielml.CategoryList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RInfo.RInfoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoadByCatAdapter extends RecyclerView.Adapter<LoadByCatAdapter.ViewHolder>{
    //ATRIBUTOS
    private ArrayList<LoadByCatData> lstRestaurantes;
    private LayoutInflater inflater;
    private Context context;

    //CONSTRUCTORES
    public LoadByCatAdapter(Context context, ArrayList<LoadByCatData> lstSales){
        this.lstRestaurantes = lstSales;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    //MÉTODOS
    @NonNull
    @Override
    public LoadByCatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_uhome_rated, parent, false);
        return new LoadByCatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadByCatAdapter.ViewHolder holder, int position) {
        LoadByCatData item = lstRestaurantes.get(position);
        //Asignamos la función de acceder al restaurante con un evento para el "card".
        holder.itemCard.setOnClickListener(e->{
            Intent intent = new Intent(context, RInfoView.class);
            intent.putExtra("id_restaurante", lstRestaurantes.get(position).getId_restaurante());
            context.startActivity(intent);
        });
        // RELLENAR CON LOS DATOS
        holder.itemTitulo.setText(lstRestaurantes.get(position).getNombre());
        String imgUrl = lstRestaurantes.get(position).getImagen();
        if(!imgUrl.equals("")){
            Picasso.get().load(imgUrl).into(holder.itemImagen);
        }
        holder.itemNota.setText(String.valueOf(lstRestaurantes.get(position).getNota_media()));
    }

    @Override
    public int getItemCount() {
        return lstRestaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView itemCard;
        TextView itemTitulo;
        ImageView itemImagen;
        TextView itemNota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCard = itemView.findViewById(R.id.UHomeRatedCard);
            itemImagen = itemView.findViewById(R.id.UHomeRatedImage);
            itemTitulo = itemView.findViewById(R.id.UHomeRatedTitle);
            itemNota = itemView.findViewById(R.id.UHomeRatedNota);
        }
    }
}
