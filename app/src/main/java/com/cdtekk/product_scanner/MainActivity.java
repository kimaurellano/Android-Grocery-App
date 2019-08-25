package com.cdtekk.product_scanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> productNames = new ArrayList<>();
    private ArrayList<String> productPrices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetProductInfos();

        InitRecyclerView();
    }

    private void SetProductInfos(){
        productNames.add("Product 1");
        productPrices.add("PHP100.00");

        productNames.add("Product 1");
        productPrices.add("PHP100.00");

        productNames.add("Product 1");
        productPrices.add("PHP100.00");

        productNames.add("Product 1");
        productPrices.add("PHP100.00");

        productNames.add("Product 1");
        productPrices.add("PHP100.00");
    }

    private void InitRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, productNames, productPrices);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
