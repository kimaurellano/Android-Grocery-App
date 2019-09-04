package com.cdtekk.product_scanner.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cdtekk.product_scanner.Interface.DataChangeResponse;
import com.cdtekk.product_scanner.Model.Product;
import com.cdtekk.product_scanner.R;

import java.util.ArrayList;

public class RecyclerMultiViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Product> mProducts;
    private Context mContext;

    public DataChangeResponse delegate = null;

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

        View view;

        // Assign which fragment layout to use
        switch (viewType){
            case Product.CART_LIST_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_cart_item_list, viewGroup, false);
                return new CartListViewHolder(view);
            case Product.PRODUCT_LIST_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_product_list, viewGroup, false);
                return new ProductListViewHolder(view);
        }

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

    /*
     *  Multiple view types of a recyclerview items
     * */
    public static class ProductListViewHolder extends RecyclerView.ViewHolder{

        ImageButton imageButtonAddItemToCart;
        TextView textViewProductName;
        EditText editTextQuantity;
        TextView textViewProductPrice;

        public ProductListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButtonAddItemToCart = itemView.findViewById(R.id.buttonAddItemToCart);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewProductPrice = itemView.findViewById(R.id.textViewProductPrice);
            editTextQuantity = itemView.findViewById(R.id.editTextViewQuantity);
        }
    }

    public static class CartListViewHolder extends RecyclerView.ViewHolder{

        ImageButton imageButtonRemoveItem;
        TextView textViewProductName;
        TextView textViewQuantity;
        TextView textViewProductPrice;

        public CartListViewHolder(@NonNull View itemView){
            super(itemView);

            imageButtonRemoveItem = itemView.findViewById(R.id.buttonRemoveItem);
            textViewProductName = itemView.findViewById(R.id.textViewCartProductName);
            textViewQuantity = itemView.findViewById(R.id.textViewCartQuantity);
            textViewProductPrice = itemView.findViewById(R.id.textViewCartProductPrice);
        }
    }
}
