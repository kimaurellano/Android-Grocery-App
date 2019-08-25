package com.cdtekk.product_scanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> mProductNames;
    private ArrayList<String> mProductPrices;
    private Context mContext;
    public RecyclerViewAdapter (Context context, ArrayList<String> productNames, ArrayList<String> productPrices){
        mContext = context;
        mProductNames = productNames;
        mProductPrices = productPrices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        // Set the information to the element
        viewHolder.productName.setText(mProductNames.get(i));
        viewHolder.productPrice.setText(mProductPrices.get(i));

        viewHolder.rowItemParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mProductNames.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // Determine the item count
        return mProductNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView productName;
        TextView productPrice;
        ConstraintLayout rowItemParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_text);
            productPrice = itemView.findViewById(R.id.price_text);
            rowItemParent = itemView.findViewById(R.id.row_item_parent);
        }
    }
}
