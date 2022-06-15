package com.example.wartawanapp.activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wartawanapp.R;
import com.example.wartawanapp.activity.TampilanBerita;
import com.example.wartawanapp.model.tampilanberita.DataBerita;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<DataBerita> ListBerita;

//    public AdapterData(TampilanBerita tampilanBerita, List<DataBerita> listBerita) {
//        this.ctx = tampilanBerita;
//    }
    public AdapterData(Context context, List<DataBerita> listBerita){
        this.ctx = context;
        this.ListBerita = listBerita;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataBerita db = ListBerita.get(position);
        Glide.with(ctx).load(DataBerita.getPhoto()).into(holder.ivgambarberita);
        holder.idberita.setText(db.getIdBerita());
        holder.tvjudul.setText(db.getJudul());
        holder.tvtags.setText(db.getTags());
        holder.tvdeskripsi.setText(db.getDeskripsi());


    }

    @Override
    public int getItemCount() {
        return ListBerita.size();
    }

    public  class HolderData extends RecyclerView.ViewHolder {

        TextView idberita, tvjudul, tvtags, tvdeskripsi;
        ImageView ivgambarberita;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            idberita = itemView.findViewById(R.id.idberita);
            tvjudul = itemView.findViewById(R.id.tvjudul);
            tvtags = itemView.findViewById(R.id.tvtags);
            tvdeskripsi = itemView.findViewById(R.id.tvdeskripsi);
            ivgambarberita = itemView.findViewById(R.id.ivgambarberita);
        }
    }

}
