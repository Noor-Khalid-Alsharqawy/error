package com.example.otcinfo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter {

    private ArrayList<product> pArray= new ArrayList<>();
    private Context context;

    public ProductsAdapter(ArrayList<product> pArray, Context context) {
        this.pArray = pArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).tradeName.setText(pArray.get(position).getD().getTradeName());
        if(pArray.get(position).getImage().equals("empty")){
            Picasso.with(context).load("https://superbodegacr.com/wp-content/uploads/" +
                    "2020/04/no-image.jpg").into(((ViewHolder) holder).image);
        }
        else{
            Picasso.with(context).load(pArray.get(position).getImage()).into(((ViewHolder) holder).image);
        }
        Picasso.with(context).load(pArray.get(position).getImage()).into(((ViewHolder) holder).image);
        ((ViewHolder) holder).price.setText(pArray.get(position).getPrice()+"");
        ((ViewHolder) holder).totalMGrams.setText(pArray.get(position).getTotalWeigh()+"");
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context,productDetails.class);
                i.putExtra("productItem",pArray.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() { return pArray.size(); }

    //////NOTE:: if it doesn't work delete 'private'
    private static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView tradeName;
        public TextView price;
        public TextView totalMGrams;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view= itemView;
            image= itemView.findViewById(R.id.imageView5);
            tradeName= itemView.findViewById(R.id.textView);
            price= itemView.findViewById(R.id.textView3);
            totalMGrams= itemView.findViewById(R.id.textView5);
        }
    }
}
