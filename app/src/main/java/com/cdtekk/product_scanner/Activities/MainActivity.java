package com.cdtekk.product_scanner.Activities;

import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cdtekk.product_scanner.Interface.DataChangeResponse;
import com.cdtekk.product_scanner.Interface.OnFragmentInteractionListener;
import com.cdtekk.product_scanner.Model.Product;
import com.cdtekk.product_scanner.R;

import org.w3c.dom.Text;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity implements DataChangeResponse, OnFragmentInteractionListener {

    private String TAG = "GROCERYAPP";

    //
    private DataChangeResponse dataChangeResponse;
    private OnFragmentInteractionListener fragmentInteractionListener;
    private int windowIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textViewWindowType = findViewById(R.id.textViewWindowType);
        final TextView textViewWindowContentSummary = findViewById(R.id.textViewWindowContentSummary);

        // Opened by default
        openFragment(Product.CART_LIST_TYPE);

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Log.d(TAG, "entries:" + getSupportFragmentManager().getBackStackEntryCount());

                textViewWindowType.setText(windowIdx == 1 ? "Product list" : "Your cart");
                textViewWindowContentSummary.setText(windowIdx == 1 ? "0 items" : "₱ 0.00");
            }
        });

        findViewById(R.id.buttonNavRight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowIdx++;

                if(windowIdx > 1){
                    windowIdx = 1;
                    return;
                }

                openFragment(Product.PRODUCT_LIST_TYPE);
            }
        });

        findViewById(R.id.buttonNavLeft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowIdx--;

                if(windowIdx < 0){
                    windowIdx = 0;
                    return;
                }

                getSupportFragmentManager().popBackStack();
            }
        });
    }

    private void openFragment(final int type){
        // Open a fragment base on which type
        Fragment fragment = new FragmentContent(type);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_enter_from_bottom, R.anim.anim_exit_to_bottom, R.anim.anim_enter_from_bottom, R.anim.anim_exit_to_bottom);
        transaction.addToBackStack(null);
        transaction.add(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    public void onDataChange(float amountUpdate){
    }

    @Override
    public void onFragmentInteraction(String data) {
    }

    @Override
    public void onFragmentChange(int direction) {
        windowIdx += direction;

        if(direction < 0){
            getSupportFragmentManager().popBackStack();
        } else if(direction > 0){
            openFragment(Product.PRODUCT_LIST_TYPE);
        }
    }
}
