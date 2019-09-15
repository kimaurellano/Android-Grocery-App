package com.cdtekk.product_scanner.Adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cdtekk.product_scanner.Model.Product;

import java.util.ArrayList;

public class RecyclerMultiViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Product> mProducts;
    private Context mContext;

    /**
     * @param context the context
     * @param products data set of products
     */
    public RecyclerMultiViewAdapter(Context context, ArrayList<Product> products){
        mContext = context;
        mProducts = products;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // TODO: Initialization specific like Listeners
        // ...

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int listPosition) {
        Product object = mProducts.get(listPosition);
        if(object != null){
            switch (object.type){
                case Product.CART_LIST_TYPE:
                    // TODO
                    break;
                case Product.PRODUCT_LIST_TYPE:
                    // TODO
                    break;
                default:
                    break;
            }
        }
    }

    /*
     *  Provide data size
     * */
    @Override
    public int getItemCount() {
        // Determine the item count
        return mProducts.size();
    }

    /*
     *  This viewType variable is internal to the Adapter class.
     *  It’s used in the onCreateViewHolder() and onBindViewHolder
     *  to inflate and populate the mapped layouts.
     * */
    @Override
    public int getItemViewType(int position){
        switch (mProducts.get(position).type){
            case 0:
                return Product.CART_LIST_TYPE;
            case 1:
                return Product.PRODUCT_LIST_TYPE;
            default:
                return -1;
        }
    }
}
