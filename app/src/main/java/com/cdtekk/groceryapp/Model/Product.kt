package com.cdtekk.groceryapp.Model

import android.widget.ImageView

data class Product(var productName : String, var productPrice : Double, var productImage : ImageView){
    companion object {
        val PRODUCT_TYPE = 0
        val CART_TYPE = 0
    }
}