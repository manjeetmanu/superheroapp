package com.example.superheroapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class dashboard extends AppCompatActivity {

    public static EditText et;
    private RecyclerView buttons;
    public static TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        et=findViewById(R.id.edittext);
        tv=findViewById(R.id.tv);

        buttons=findViewById(R.id.recycle);
        //buttons.setLayoutManager(new LinearLayoutManager(this));
        buttons.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        String[] str={"powerstats","biography","appearance","work","connections","image"};
        buttons.setAdapter(new buttonAdapter(str));

        //tv.setText("manjeet");
    }

}
