package com.cdtekk.product_scanner.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import com.cdtekk.product_scanner.Interface.OnFragmentContentCloseListener;
import com.cdtekk.product_scanner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.transitionseverywhere.extra.Scale;

import static com.cdtekk.product_scanner.Activities.MainActivity.TAG;

public class FragmentContent extends Fragment {

    private int mFragment;
    private OnFragmentContentCloseListener mCloseListener;

    public FragmentContent(){ }

    public FragmentContent(int fragment){
        this.mFragment = fragment;
    }

    public void setOnFragmentContentCloseListener(OnFragmentContentCloseListener listener){
        mCloseListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Load with either your cart/products fragment
        View view = inflater.inflate(mFragment, container, false);

        Log.d(TAG, container.toString());

        if(mFragment == R.layout.fragment_my_cart){
            // TODO
        } else if (mFragment == R.layout.fragment_products){
            // TODO
        }

        final FragmentLanding fragmentLanding = new FragmentLanding();
        fragmentLanding.setFragmentContentCloseListener(new OnFragmentContentCloseListener() {
            @Override
            public void onFragmentClose() {
                TransitionManager.beginDelayedTransition(container, new Scale());
                FloatingActionButton floatingActionButton = container.findViewById(R.id.fabChangeContent);
                floatingActionButton.setVisibility(View.GONE);
            }
        });

        view.findViewById(R.id.imageButtonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_root_view, fragmentLanding)
                        .commit();
            }
        });

        return view;
    }
}
