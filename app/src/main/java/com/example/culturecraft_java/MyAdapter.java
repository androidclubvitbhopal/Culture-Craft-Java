package com.example.culturecraft_java;

import android.content.Context;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jgabrielfreitas.core.BlurImageView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<RecyclerItem> arrList;
    public MyAdapter(Context context, ArrayList<RecyclerItem> arrList){
        this.context=context;
        this.arrList=arrList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.blurImageView.setImageResource(arrList.get(position).drawable);
        holder.cultureTextV.setText(arrList.get(position).title);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            holder.blurImageView.setBlur(1);
            holder.blurImageView.setRenderEffect(RenderEffect.createBlurEffect(5, 5, Shader.TileMode.MIRROR));
        }else{
            holder.blurImageView.setBlur(2);
        }

    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        BlurImageView blurImageView;
        TextView cultureTextV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            blurImageView=itemView.findViewById(R.id.blurImageView);
            cultureTextV=itemView.findViewById(R.id.cultureTextV);

        }
    }
}
