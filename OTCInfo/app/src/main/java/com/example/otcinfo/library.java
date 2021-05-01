package com.example.otcinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class library extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Button myList= findViewById(R.id.button3);
        Button surf= findViewById(R.id.button4);
        FrameLayout screen= findViewById(R.id.fl);






        myList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm= getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                MyList_Fragment fragment= new MyList_Fragment();
                //Bundle b= getIntent().getExtras();
                //if(b!=null) {
                   // drug d = (drug) b.getSerializable("toLib");
                    //Bundle bundle = new Bundle();
                    //bundle.putSerializable("toMine", d);
                    //fragment.setArguments(bundle);
                //}
                ft.replace(R.id.fl,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        surf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm= getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                Surf_Fragment fragment= new Surf_Fragment();
                ft.replace(R.id.fl,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


    }
}