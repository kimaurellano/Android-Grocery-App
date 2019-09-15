package com.cdtekk.product_scanner.Activities;

import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cdtekk.product_scanner.R;

public class FragmentContent extends Fragment {

    private int mFragment;
    private static OnFabInteractionListener onFabInteractListener;

    public static void setOnHappeningsListener(OnFabInteractionListener listener){
        onFabInteractListener = listener;
    }

    public FragmentContent(){ }

    public FragmentContent(int fragmentLayout){
        this.mFragment = fragmentLayout;
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

        if(mFragment == R.layout.fragment_my_cart){
            view.findViewById(R.id.fabProductList).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onFabInteractListener.onFabInteract(R.layout.fragment_products);
                }
            });
        } else if (mFragment == R.layout.fragment_products){
            view.findViewById(R.id.fabCart).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onFabInteractListener.onFabInteract(R.layout.fragment_my_cart);
                }
            });
        }

        view.findViewById(R.id.imageButtonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
                        .replace(R.id.fragment_root_view, new FragmentLanding())
                        .commit();
            }
        });

        return view;
    }

    public interface OnFabInteractionListener {
        void onFabInteract(int fragmentLayout);
    }
}
