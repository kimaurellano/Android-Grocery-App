package com.cdtekk.groceryapp.View


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.cdtekk.groceryapp.Interface.IBackPress
import com.cdtekk.groceryapp.R
import kotlinx.android.synthetic.main.fragment_productlist.*
import java.lang.ClassCastException

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ProductListFragment : Fragment() {

    var listener : OnFragmentChangeListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("GROCERYAPP", "created")
        listener?.onFragmentChanged(R.id.productlistFragment)

        btnCart.setOnClickListener{view ->
            run {
                view.findNavController().navigate(R.id.base_to_cartFragment)
                Log.d("GROCERYAPP", fragmentManager?.backStackEntryCount.toString())

                listener?.onFragmentChanged(R.id.cartFragment)
            }
        }

        cartSummary.setOnClickListener{view ->
            run {
                view.findNavController().navigate(R.id.base_to_cartFragment)

                listener?.onFragmentChanged(R.id.cartFragment)
            }
        }

        btnProfile.setOnClickListener{view ->
            run {
                view.findNavController().navigate(R.id.base_to_profileFragment)
                Log.d("GROCERYAPP", fragmentManager?.backStackEntryCount.toString())

                listener?.onFragmentChanged(R.id.profileFragment)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as? OnFragmentChangeListener
        if(listener == null){
            throw ClassCastException("$context must implement OnArticleSelectedListener")
        }
    }

    interface OnFragmentChangeListener{
        fun onFragmentChanged(fragmentId : Int)
    }
}
