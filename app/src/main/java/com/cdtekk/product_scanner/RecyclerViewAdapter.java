package com.cdtekk.product_scanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<Pair<String, String>> mProducts;
    private Context mContext;

    public RecyclerViewAdapter (Context context, ArrayList<Pair<String, String>> products){
        mContext = context;
        mProducts = products;
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
        viewHolder.productName.setText(mProducts.get(i).first);
        viewHolder.productPrice.setText(mProducts.get(i).second);

        viewHolder.buttonRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Item removed", Toast.LENGTH_SHORT).show();
                mProducts.remove(i);

                notifyItemRemoved(i);
                notifyItemRangeChanged(i, mProducts.size());
            }
        });

        viewHolder.rowItemParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mProducts.get(i).second, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // Determine the item count
        return mProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageButton buttonRemoveItem;
        private TextView productName;
        private TextView productPrice;
        private ConstraintLayout rowItemParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_text);
            productPrice = itemView.findViewById(R.id.price_text);
            rowItemParent = itemView.findViewById(R.id.row_item_parent);
            buttonRemoveItem = itemView.findViewById(R.id.buttonRemoveItem);
        }
    }
}
