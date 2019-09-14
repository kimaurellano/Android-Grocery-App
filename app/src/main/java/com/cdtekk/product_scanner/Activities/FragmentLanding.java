package com.cdtekk.product_scanner.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdtekk.product_scanner.Interface.OnFragmentContentCloseListener;
import com.cdtekk.product_scanner.Interface.OnFragmentInteractionListener;
import com.cdtekk.product_scanner.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

@SuppressLint("SetTextI18n")
public class FragmentLanding extends Fragment {
    
    private OnFragmentInteractionListener mInteractionListener;
    private OnFragmentContentCloseListener mCloseListener;

    public void setFragmentInteractionListener(OnFragmentInteractionListener listener){
        this.mInteractionListener = listener;
    }

    public void setFragmentContentCloseListener(OnFragmentContentCloseListener listener){
        this.mCloseListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Load landing page on start
        final View view = inflater.inflate(R.layout.fragment_landing, container, false);

        View fabButton = container.getRootView().findViewById(R.id.fabChangeContent);

        if(fabButton != null){
            fabButton.setVisibility(View.GONE);
            mCloseListener.onFragmentClose();
        }

        // Options to be click on landing page
        view.findViewById(R.id.frameLayoutBtnMyCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentContent fragmentContent = new FragmentContent(R.layout.fragment_my_cart);
                // This will replace fragment landing on the root view
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_root_view, fragmentContent)
                        .commit();
                mInteractionListener.onFragmentOptionClick(R.layout.fragment_my_cart);
            }
        });

        view.findViewById(R.id.frameLayoutBtnProducts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentContent fragmentContent = new FragmentContent(R.layout.fragment_products);
                // This will replace fragment landing on the root view
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_root_view, fragmentContent)
                        .commit();
                mInteractionListener.onFragmentOptionClick(R.layout.fragment_products);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void sendBack(String sendBackText) {
        if (mInteractionListener != null) {
            mInteractionListener.onFragmentInteraction(sendBackText);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mInteractionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mInteractionListener = null;
    }
}
