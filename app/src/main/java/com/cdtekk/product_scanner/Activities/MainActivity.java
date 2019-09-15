package com.cdtekk.product_scanner.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;

import com.cdtekk.product_scanner.Interface.OnFragmentInteractionListener;
import com.cdtekk.product_scanner.R;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener, FragmentContent.OnFabInteractionListener {

    public static final String TAG = "GROCERYAPP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentLanding fragmentLanding = new FragmentLanding();
        fragmentLanding.setFragmentInteractionListener(this);

        // Load landing page to root view
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_root_view, fragmentLanding)
                .commit();

        FragmentContent.setOnHappeningsListener(this);
    }

    @Override
    public void onFragmentOptionClick(int id) {
        final ViewGroup rootViewContainer = findViewById(R.id.fragment_root_view);

        // Scaling effect on the content layout
        TransitionManager.beginDelayedTransition(rootViewContainer, new Fade(Fade.IN));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_root_view, new FragmentContent(id))
                .commit();
    }

    @Override
    public void onFabInteract(int fragmentLayout) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.fade_in, R.anim.fade_out,
                        R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.fragment_root_view, new FragmentContent(fragmentLayout))
                .commit();
    }
}