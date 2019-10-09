package com.cdtekk.groceryapp.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.cdtekk.groceryapp.R
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnProfile.setOnClickListener{ view ->
            run{
                view.findNavController().navigate(R.id.cartFragment_to_profileFragment)
                Log.d("GROCERYAPP", fragmentManager?.backStackEntryCount.toString())
            }
        }

        btnProduct.setOnClickListener{ view ->
            run{
                view.findNavController().navigate(R.id.cartFragment_to_productFragment)
                Log.d("GROCERYAPP", fragmentManager?.backStackEntryCount.toString())
            }
        }
    }
}