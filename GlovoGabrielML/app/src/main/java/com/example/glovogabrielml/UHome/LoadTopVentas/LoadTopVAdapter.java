package com.example.glovogabrielml.UHome.LoadTopVentas;

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

public class LoadTopVAdapter extends RecyclerView.Adapter<LoadTopVAdapter.ViewHolder> {
    //ATRIBUTOS
    private ArrayList<LoadTopVData> lstTopV;
    private LayoutInflater inflater;
    private Context context;

    //CONSTRUCTORES
    public LoadTopVAdapter(Context context, ArrayList<LoadTopVData> lstTopV){
        this.lstTopV = lstTopV;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    //MÉTODOS
    @NonNull
    @Override
    public LoadTopVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_uhome_top, parent, false);
        return new LoadTopVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadTopVAdapter.ViewHolder holder, int position) {
        LoadTopVData item = lstTopV.get(position);
        //Asignamos la función de acceder al restaurante con un evento para el "card".
        holder.itemCard.setOnClickListener(e->{
            Intent intent = new Intent(context, RInfoView.class);
            intent.putExtra("id_restaurante", lstTopV.get(position).getId_restaurante());
            context.startActivity(intent);
        });
        // RELLENAR CON LOS DATOS
        holder.itemTitulo.setText(lstTopV.get(position).getNombre());
        String imgUrl = lstTopV.get(position).getImagen();
        if(!imgUrl.equals("")){
            Picasso.get().load(imgUrl).into(holder.itemImagen);
        }
    }

    @Override
    public int getItemCount() {
        return lstTopV.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView itemCard;
        TextView itemTitulo;
        ImageView itemImagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCard = itemView.findViewById(R.id.UHomeTopCard);
            itemTitulo = itemView.findViewById(R.id.UHomeTopTitle);
            itemImagen = itemView.findViewById(R.id.UHomeTopImage);
        }
    }
}
