package com.example.otcinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class MyList_Fragment extends Fragment {
    //private drug d;

    public MyList_Fragment() {
        // Required empty public constructor
    }

    //@Override
    //public void onCreate(@Nullable Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //Bundle b= getArguments();
        //if(b!=null){
            //d= (drug) b.getSerializable("toMine");
        //}
    //}
    FirebaseDatabase database= FirebaseDatabase.getInstance("https://otc-info-db-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef= database.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_my_list_, container, false);
        Toast.makeText(getActivity(),"This is My OTC LIST",Toast.LENGTH_SHORT).show();
        ArrayList<drug> myList_ArrayList= new ArrayList<>();

        //if(!myList_ArrayList.contains(d))
            //myList_ArrayList.add(d);

        RecyclerView myList_RecyclerView= v.findViewById(R.id.rv3);
        myList_RecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(v.getContext());
        myList_RecyclerView.setLayoutManager(lm);

        MyListAdapter mla= new MyListAdapter(myList_ArrayList,v.getContext());
        myList_RecyclerView.setAdapter(mla);

        Query allMyList= dbRef.child("myDrugsList");
        allMyList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //positive case
                for(DataSnapshot md: snapshot.getChildren()){
                    drug dd= md.getValue(drug.class);//coverts from json to drug
                    myList_ArrayList.add(dd);
                }
                mla.notifyDataSetChanged();
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