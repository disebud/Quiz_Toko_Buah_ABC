package com.disebud.quiztokobuahabc.Adapter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.disebud.quiztokobuahabc.Data.Data;
import com.disebud.quiztokobuahabc.R;

import java.util.List;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private Data[] listdata;

    // RecyclerView recyclerView;
    public MyListAdapter(Data[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("Range")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Data myListData = listdata[position];

        holder.name.setText(listdata[position].getName());
        holder.jenis.setText(listdata[position].getJenis());
        holder.harga.setText(listdata[position].getHarga());

        if (listdata[position].getName() == "FRT-0001-Anggur California"){
            holder.name.setTextColor(Color.MAGENTA);
            holder.jenis.setTextColor(Color.MAGENTA);
            holder.harga.setTextColor(Color.MAGENTA);
        } else if (listdata[position].getName() == "FRT-0002-Durian Montong"){
            holder.name.setTextColor(Color.parseColor("#FF8C00"));
            holder.jenis.setTextColor(Color.parseColor("#FF8C00"));
            holder.harga.setTextColor(Color.parseColor("#FF8C00"));
        } else if (listdata[position].getName() == "FRT-0003-Mangga Harum Manis"){
            holder.name.setTextColor(Color.GREEN);
            holder.jenis.setTextColor(Color.GREEN);
            holder.harga.setTextColor(Color.GREEN);
        } else if (listdata[position].getName() == "FRT-0004-Nanas Spongebo"){
            holder.name.setTextColor(Color.parseColor("#FF8C00"));
            holder.jenis.setTextColor(Color.parseColor("#FF8C00"));
            holder.harga.setTextColor(Color.parseColor("#FF8C00"));
        } else if (listdata[position].getName() == "FRT-0006-Naga Chines"){
            holder.name.setTextColor(Color.parseColor("#FF1493"));
            holder.jenis.setTextColor(Color.parseColor("#FF1493"));
            holder.harga.setTextColor(Color.parseColor("#FF1493"));
        }
        else if (listdata[position].getName() == "FRT-0008-Pepaya California"){
            holder.name.setTextColor(Color.parseColor("#FFA500"));
            holder.jenis.setTextColor(Color.parseColor("#FFA500"));
            holder.harga.setTextColor(Color.parseColor("#FFA500"));
        }else {
            holder.name.setTextColor(Color.parseColor("#FF7F50"));
            holder.jenis.setTextColor(Color.parseColor("#FF7F50"));
            holder.harga.setTextColor(Color.parseColor("#FF7F50"));
        }

//        holder.jenis.setTextColor(Color.parseColor(String.format("#%s",warna)));
//        holder.harga.setTextColor(Color.parseColor(listdata[position].getWarna()));
        holder.imageViewProduct.setImageResource(listdata[position].getImageId());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Buah : "+myListData.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewProduct;
        public TextView name,jenis,harga;
        public ConstraintLayout constraintLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageViewProduct = (ImageView) itemView.findViewById(R.id.iv_produk);
            this.name = (TextView) itemView.findViewById(R.id.nameProduct);
            this.jenis = (TextView) itemView.findViewById(R.id.jenis);
            this.harga = (TextView) itemView.findViewById(R.id.harga);
            constraintLayout = (ConstraintLayout)itemView.findViewById(R.id.cr_item);
        }
    }
}