package com.example.otcinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class opening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        Button library = findViewById(R.id.button);
        Button store = findViewById(R.id.button2);

        //click store button to go to the store
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStore= new Intent(opening.this, store.class);
                startActivity(toStore);
            }
        });

        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLibrary= new Intent(opening.this, library.class);
                startActivity(toLibrary);
            }
        });
    }
}