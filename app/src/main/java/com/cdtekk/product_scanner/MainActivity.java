package com.cdtekk.product_scanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pair<String, String>> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetProductInfos();
        InitRecyclerView();

        findViewById(R.id.buttonAddItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void SetProductInfos(){
        products.add(new Pair<>("Century", "₱25.00"));
        products.add(new Pair<>("Ligo Sardines", "₱16.00"));
        products.add(new Pair<>("Tide bar", "8.00"));
        products.add(new Pair<>("Corn Beef", "₱25.00"));
        products.add(new Pair<>("Safeguard", "₱20.00"));
    }

    private void InitRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, products);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
