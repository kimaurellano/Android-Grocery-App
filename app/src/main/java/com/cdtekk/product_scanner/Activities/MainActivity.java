package com.cdtekk.product_scanner.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.cdtekk.product_scanner.Interface.DataChangeResponse;
import com.cdtekk.product_scanner.Interface.OnFragmentInteractionListener;
import com.cdtekk.product_scanner.R;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity implements DataChangeResponse, OnFragmentInteractionListener {

    private String TAG = "GROCERYAPP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Load fragments to root view
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_root_view, new FragmentContainer(true))
                .commit();
    }

    @Override
    public void onDataChange(float amountUpdate){
    }

    @Override
    public void onFragmentInteraction(String data) {
    }

    @Override
    public void onFragmentChange(int direction) {

    }
}
