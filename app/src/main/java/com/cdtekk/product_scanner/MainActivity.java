package com.cdtekk.product_scanner;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataChangeResponse {

    private ArrayList<Pair<String, String>> products = new ArrayList<>();
    private float tAmount = 0;
    private DataChangeResponse dataChangeResponse;
    private TextView textViewTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonAddItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddProduct(new Pair<>("Ligo Sardines", "₱16.00"));

                // Get the price
                String lastInput = products.get(products.size() - 1).second;

                // Sum the prices
                tAmount += Float.parseFloat(lastInput.substring(1));

                textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
                textViewTotalAmount.setText("₱ " + tAmount);
            }
        });
    }

    private void AddProduct(Pair<String, String> item){
        products.add(item);

        UpdateRecyclerView();
    }

    private void UpdateRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, products);
        recyclerViewAdapter.delegate = this;
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onDataChange(float amountUpdate){
        Toast.makeText(this, Float.toString(amountUpdate), Toast.LENGTH_SHORT).show();
        textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
        textViewTotalAmount.setText("₱ " + amountUpdate);
    }
}
