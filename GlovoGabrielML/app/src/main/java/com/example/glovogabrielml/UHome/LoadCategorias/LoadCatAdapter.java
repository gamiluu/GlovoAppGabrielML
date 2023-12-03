package com.example.glovogabrielml.UHome.LoadCategorias;

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

import com.example.glovogabrielml.CategoryList.CategoryListView;
import com.example.glovogabrielml.R;
import com.example.glovogabrielml.RInfo.RInfoView;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRAdapter;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoadCatAdapter extends RecyclerView.Adapter<LoadCatAdapter.ViewHolder> {
    //ATRIBUTOS
    private ArrayList<LoadCatData> lstCategorias;
    private LayoutInflater inflater;
    private Context context;

    //CONSTRUCTORES
    public LoadCatAdapter(Context context, ArrayList<LoadCatData> lstCategorias){
        this.lstCategorias = lstCategorias;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    //MÉTODOS
    @NonNull
    @Override
    public LoadCatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_uhome_categoria, parent, false);
        return new LoadCatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadCatAdapter.ViewHolder holder, int position) {
        LoadCatData item = lstCategorias.get(position);
        //Asignamos la función de acceder al restaurante con un evento para el "card".
        holder.itemCard.setOnClickListener(e->{
            Intent intent = new Intent(context, CategoryListView.class);
            intent.putExtra("id_categoria", lstCategorias.get(position).getId_categoria());
            intent.putExtra("categoria", lstCategorias.get(position).getCategoria());
            intent.putExtra("orden", "DESC");
            context.startActivity(intent);
        });
        // RELLENAR CON LOS DATOS
        holder.itemTitulo.setText(lstCategorias.get(position).getCategoria());
    }

    @Override
    public int getItemCount() {
        return lstCategorias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView itemCard;
        TextView itemTitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCard = itemView.findViewById(R.id.UHomeCategoriaCard);
            itemTitulo = itemView.findViewById(R.id.UHomeCategoriaNombre);
        }
    }
}
