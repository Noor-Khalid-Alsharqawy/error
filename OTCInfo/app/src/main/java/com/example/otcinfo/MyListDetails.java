package com.example.otcinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MyListDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_details);

        Bundle b= getIntent().getExtras();
        drug item= (drug) b.getSerializable("myListItem");

        TextView name= findViewById(R.id.tv46); name.setText(item.getTradeName());
        TextView activeText= findViewById(R.id.tv48); activeText.setText(item.getActiveIngredients());
        TextView ageText= findViewById(R.id.tv50); ageText.setText(item.getAge());
        TextView sideText= findViewById(R.id.tv52); sideText.setText(item.getSideEffects());
        TextView interText= findViewById(R.id.tv54); interText.setText(item.getInteractions());
        TextView contText= findViewById(R.id.tv56);  contText.setText(item.getContraindications());
        TextView appText= findViewById(R.id.tv58); appText.setText(item.getApplication());
        TextView noteText= findViewById(R.id.tv60); noteText.setText(item.getNotes());
        TextView pregText= findViewById(R.id.tv62); pregText.setText(item.getPregnancySafety()+"");
    }
}