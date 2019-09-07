package com.cdtekk.product_scanner.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cdtekk.product_scanner.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentContent extends Fragment {

    private int mFragment;

    public FragmentContent(){ }

    public FragmentContent(int fragment){
        this.mFragment = fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mFragment == R.id.fragment_cart_item_list){
            return inflater.inflate(R.layout.fragment_cart_item_list, container, false);
        } else if (mFragment == R.id.fragment_product_list){
            return inflater.inflate(R.layout.fragment_product_list, container, false);
        }

        return null;
    }
}
