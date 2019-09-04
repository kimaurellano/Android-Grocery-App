package com.cdtekk.product_scanner.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cdtekk.product_scanner.Interface.OnFragmentInteractionListener;
import com.cdtekk.product_scanner.Model.Product;
import com.cdtekk.product_scanner.R;

public class FragmentContent extends Fragment {
    //
    private OnFragmentInteractionListener mListener;

    private int mType;

    public FragmentContent(int type){
        this.mType = type;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getContext(), "Created!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if(mType == Product.CART_LIST_TYPE){
            View view = inflater.inflate(R.layout.fragment_cart_item_list, container, false);
            view.findViewById(R.id.floatingActionButtonAddItem).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentChange(1);
                }
            });

            return view;
        } else if(mType == Product.PRODUCT_LIST_TYPE){
            View view = inflater.inflate(R.layout.fragment_product_list, container, false);
            view.findViewById(R.id.floatingActionButtonToCartView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentChange(-1);
                }
            });

            return view;
        }

        // TODO: populate recycler view

        return null;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void sendBack(String sendBackText) {
        if (mListener != null) {
            mListener.onFragmentInteraction(sendBackText);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // Populates recyclerview
    private void UpdateRecyclerView(){
        // TODO
    }
}
