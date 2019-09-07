package com.cdtekk.product_scanner.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdtekk.product_scanner.Interface.OnFragmentInteractionListener;
import com.cdtekk.product_scanner.R;
import com.transitionseverywhere.ChangeText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

@SuppressLint("SetTextI18n")
public class FragmentContainer extends Fragment {
    
    private OnFragmentInteractionListener mListener;
    private int currentStack;
    private boolean mFirstRun;

    public FragmentContainer(boolean firstRun){
        this.mFirstRun = firstRun;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentFragment = inflater.inflate(R.layout.fragment_parent, container, false);

        final ViewGroup transitionContainer = parentFragment.findViewById(R.id.transitions_container);
        final TextView windowTypeText = transitionContainer.findViewById(R.id.textViewWindowType);
        final TextView windowContentSummaryText = transitionContainer.findViewById(R.id.textViewWindowContentSummary);

        if(mFirstRun){
            changeFragmentContent(R.id.fragment_cart_item_list, 0);
        }

        mFirstRun = !mFirstRun;

        parentFragment.findViewById(R.id.buttonNavRight).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RtlHardcoded")
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(
                        transitionContainer,
                        new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_IN));
                windowTypeText.setText("Product list");
                windowContentSummaryText.setText("0 Items");

                changeFragmentContent(R.id.fragment_product_list, 1);
            }
        });

        parentFragment.findViewById(R.id.buttonNavLeft).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RtlHardcoded")
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(
                        transitionContainer,
                        new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_IN));
                windowTypeText.setText("Your cart");
                windowContentSummaryText.setText("₱ 0.00");

                changeFragmentContent(R.id.fragment_cart_item_list, 0);
            }
        });

        // TODO: populate recycler view

        return parentFragment;
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

    @SuppressLint("RtlHardcoded")
    private void changeFragmentContent(int id, int stackIndex) {
        // Avoid recreating the content
        if(currentStack == stackIndex && !mFirstRun){
            return;
        }

        currentStack = stackIndex;

        // Load fragments to root view
        if(stackIndex == 1){
            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_from_left, R.anim.slide_to_right,
                            R.anim.slide_from_left, R.anim.slide_to_right
                    )
                    .replace(R.id.fragment_container_content, new FragmentContent(id))
                    .commit();
        } else if (stackIndex == 0){
            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_from_right, R.anim.slide_to_left,
                            R.anim.slide_from_right, R.anim.slide_to_left
                    )
                    .replace(R.id.fragment_container_content, new FragmentContent(id))
                    .commit();
        }
    }
}
