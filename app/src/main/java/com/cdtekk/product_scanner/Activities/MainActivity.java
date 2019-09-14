package com.cdtekk.product_scanner.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.TransitionManager;

import com.cdtekk.product_scanner.Interface.OnFragmentContentCloseListener;
import com.cdtekk.product_scanner.Interface.OnFragmentInteractionListener;
import com.cdtekk.product_scanner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.transitionseverywhere.extra.Scale;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private ImageButton imageButtonBack;

    public static final String TAG = "GROCERYAPP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentLanding fragmentLanding = new FragmentLanding();
        fragmentLanding.setFragmentInteractionListener(this);

        fragmentLanding.setFragmentContentCloseListener(new OnFragmentContentCloseListener() {
            @Override
            public void onFragmentClose() {
                ViewGroup rootViewContainer = findViewById(R.id.fragment_root_view);
                TransitionManager.beginDelayedTransition(rootViewContainer, new Scale());
                FloatingActionButton floatingActionButton = findViewById(R.id.fabChangeContent);
                floatingActionButton.setVisibility(View.GONE);
            }
        });

        // Load landing page to root view
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_root_view, fragmentLanding)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String data) {

    }

    @Override
    public void onFragmentOptionClick(int id) {
        ViewGroup rootViewContainer = findViewById(R.id.fragment_root_view);
        TransitionManager.beginDelayedTransition(rootViewContainer, new Scale());
        FloatingActionButton floatingActionButton = findViewById(R.id.fabChangeContent);
        floatingActionButton.setVisibility(View.VISIBLE);
    }
}