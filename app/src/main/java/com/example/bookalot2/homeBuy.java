package com.example.bookalot2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class homeBuy extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OderAdapter oderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_buy);

        //creating arraylist
        modelList = new ArrayList<>();
        modelList.add(new Model("Python",getString(R.string.python), R.drawable.python));
        modelList.add(new Model("PAYTON",getString(R.string.python2in1), R.drawable.python2in1));
        modelList.add(new Model("basicC",getString(R.string.basiccomp), R.drawable.basiccomp));
        modelList.add(new Model("c1",getString(R.string.c1), R.drawable.c1));
        modelList.add(new Model("java",getString(R.string.java), R.drawable.java));
        modelList.add(new Model("php",getString(R.string.php), R.drawable.php));
        modelList.add(new Model("plus",getString(R.string.cplus), R.drawable.cplus));
        modelList.add(new Model("core",getString(R.string.core), R.drawable.core));
        modelList.add(new Model("python's",getString(R.string.pythononpro), R.drawable.pythonpro));
//
//        //recyclerview
        recyclerView = findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
//        //adapter
        oderAdapter = new OderAdapter(this,modelList);

        recyclerView.setAdapter(oderAdapter);

//
    }
}