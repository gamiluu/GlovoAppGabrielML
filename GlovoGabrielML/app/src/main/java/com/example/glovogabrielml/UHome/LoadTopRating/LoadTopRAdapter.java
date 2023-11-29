package com.example.glovogabrielml.UHome.LoadTopRating;

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
import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVAdapter;
import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoadTopRAdapter extends RecyclerView.Adapter<LoadTopRAdapter.ViewHolder> {
    //ATRIBUTOS
    private ArrayList<LoadTopRData> lstTopR;
    private LayoutInflater inflater;
    private Context context;

    //CONSTRUCTORES
    public LoadTopRAdapter(Context context, ArrayList<LoadTopRData> lstTopR){
        this.lstTopR = lstTopR;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    //MÉTODOS
    @NonNull
    @Override
    public LoadTopRAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_uhome_rated, parent, false);
        return new LoadTopRAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadTopRAdapter.ViewHolder holder, int position) {
        LoadTopRData item = lstTopR.get(position);
        //Asignamos la función de acceder al restaurante con un evento para el "card".
        holder.itemCard.setOnClickListener(e->{
            Intent intent = new Intent(context, RInfoView.class);
            intent.putExtra("id_restaurante", lstTopR.get(position).getId_restaurante());
            context.startActivity(intent);
        });
        // RELLENAR CON LOS DATOS
        holder.itemTitulo.setText(lstTopR.get(position).getNombre());
        String imgUrl = lstTopR.get(position).getImagen();
        if(!imgUrl.equals("")){
            Picasso.get().load(imgUrl).into(holder.itemImagen);
        }
        holder.itemNota.setText(String.valueOf(lstTopR.get(position).getNota_media()));
    }

    @Override
    public int getItemCount() {
        return lstTopR.size();
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
