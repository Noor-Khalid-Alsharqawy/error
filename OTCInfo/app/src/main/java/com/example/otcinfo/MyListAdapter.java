package com.example.otcinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter {

    private ArrayList<drug> mlArray;
    private Context context;

    public MyListAdapter(ArrayList<drug> mlArray, Context context) {
        this.mlArray = mlArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_card, parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).tradeName.setText(mlArray.get(position).getTradeName());
        ((ViewHolder) holder).activeIngredient.setText(mlArray.get(position).getActiveIngredients());
        ((ViewHolder) holder).remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlArray.remove(position);
                notifyDataSetChanged();/////////
            }
        });
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context,MyListDetails.class);
                i.putExtra("myListItem",mlArray.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() { return mlArray.size(); }

    private static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tradeName;
        public TextView activeIngredient;
        public Button remove;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view= itemView;
            tradeName= itemView.findViewById(R.id.textView7);
            activeIngredient= itemView.findViewById(R.id.textView8);
            remove= itemView.findViewById(R.id.button5);
        }
    }
}
