package com.example.otcinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Surf_Fragment extends Fragment {

    public Surf_Fragment() {
        // Required empty public constructor
    }

    FirebaseDatabase database= FirebaseDatabase.getInstance("https://otc-info-db-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef= database.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_surf_, container, false);
        Toast.makeText(getActivity(),"This is SURF OTC section",Toast.LENGTH_SHORT).show();

        //a temporary product for completing the recycler view

        ArrayList<drug> surf_ArrayList= new ArrayList<>();

        RecyclerView surf_RecyclerView= v.findViewById(R.id.rv2);
        surf_RecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(v.getContext());
        surf_RecyclerView.setLayoutManager(lm);

        SurfAdapter sf= new SurfAdapter(surf_ArrayList,v.getContext());
        surf_RecyclerView.setAdapter(sf);


        Query allSurf= dbRef.child("drug");
        allSurf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //positive case
                for(DataSnapshot md: snapshot.getChildren()){
                    //String id = md.getKey();
                    HashMap<String,String> dd= (HashMap<String, String>) md.getValue();//coverts from json to drug
                    String trade= dd.get("tradaName"); String active= dd.get("activeIngredients");
                    String use= dd.get("uses"); String age= dd.get("age"); String app= dd.get("application");
                    String inter= dd.get("interactions");  String cont= dd.get("contraindications");
                    char preg= dd.get("pregnancySafety").charAt(0); String side= dd.get("sideEffects");
                    String notes= dd.get("notes");
                    //drug dd= md.child(id).getValue(drug.class)
                    drug ddd= new drug(trade,active,use,age,side,inter,cont,preg,app,notes);
                    surf_ArrayList.add(ddd);
                    sf.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //negative case
                Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}