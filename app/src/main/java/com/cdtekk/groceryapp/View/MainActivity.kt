package com.cdtekk.groceryapp.View

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.cdtekk.groceryapp.Interface.IBackPress
import com.cdtekk.groceryapp.R
import kotlinx.android.synthetic.main.dialogbox_exit.view.*
import kotlinx.android.synthetic.main.dialogbox_test.*
import kotlin.math.log

class MainActivity : AppCompatActivity(), ProductListFragment.OnFragmentChangeListener {

    var currentLoadedFrag : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onFragmentChanged(fragmentId : Int) {
        Log.d("GROCERYAPP", fragmentId.toString())

        currentLoadedFrag = fragmentId
    }

    override fun onBackPressed() {
        if(currentLoadedFrag == R.id.productlistFragment){
            showDialog()
        } else {
            super.onBackPressed()
        }

    }

    private fun showDialog(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialogbox_exit, null)

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)

        val mAlertDialog = mBuilder.show()

        mDialogView.btnNo.setOnClickListener{
            mAlertDialog.dismiss()
        }

        mDialogView.btnYes.setOnClickListener{
            super.onBackPressed()
        }
    }
}
