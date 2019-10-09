package com.cdtekk.groceryapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.cdtekk.groceryapp.Model.Product
import com.cdtekk.groceryapp.R
import java.lang.IllegalArgumentException

class MultiViewAdapter (val items : ArrayList<Product>, val context: Context)
    : RecyclerView.Adapter<ViewHolder>() {

    var viewType : Int? = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        @Suppress("DUPLICATE_LABEL_IN_WHEN")
        (return when(viewType){
            Product.CART_TYPE -> ProductItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview_cartlist, parent, false))
            Product.PRODUCT_TYPE -> ProductItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview_productlist, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        })
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Product = items[position]
        when(viewType){

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ProductItemViewHolder(itemView : View) : ViewHolder(itemView) {

        private var productImage : ImageView? = null
        private var productName : TextView? = null
        private var productPrice : TextView? = null
        private var addProduct : ImageButton? = null

        init {
            productImage = itemView.findViewById(R.id.productImage)
            productName = itemView.findViewById(R.id.productNameText)
            productPrice = itemView.findViewById(R.id.productPriceText)
            addProduct = itemView.findViewById(R.id.btnAddItem)
        }
    }

    class CartItemViewHolder(itemView : View) : ViewHolder(itemView) {
        init {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}