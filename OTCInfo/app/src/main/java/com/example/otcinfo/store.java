package com.example.otcinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;


public class store extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        //lacation icon
        ImageView location= findViewById(R.id.imageView2);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+Uri.encode("السالمية"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        //phone icon
        ImageView call= findViewById(R.id.imageView3);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:66573159"));
                startActivity(callIntent);
            }
        });

        //a temporary product for completing the recycler view


        ArrayList<product> products_ArrayList= new ArrayList<>();

        //recycler view
        RecyclerView products_RecyclerView= findViewById(R.id.rv);
        products_RecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
        products_RecyclerView.setLayoutManager(lm);

        ProductsAdapter p= new ProductsAdapter(products_ArrayList, store.this);
        products_RecyclerView.setAdapter(p);


    }
}