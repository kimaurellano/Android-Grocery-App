package com.cdtekk.product_scanner;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.Dictionary;

public class CustomAddItemDialog extends Dialog implements View.OnClickListener {

    public Activity activity;
    public Dialog dialog;
    public Button ok, cancel;

    private SearchView searchViewItemList;
    private EditText editTextQuantity;
    private TextView textViewAmount;
    private Dictionary<String, String[]> product;

    public Dictionary<String, String[]> GetInputData(){
        return product;
    }

    public CustomAddItemDialog(Activity activity){
        super(activity);

        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_add_item_dialog);
        ok = findViewById(R.id.buttonOk);
        cancel = findViewById(R.id.buttonCancel);
        searchViewItemList = findViewById(R.id.searchViewItemList);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        textViewAmount = findViewById(R.id.textViewAmount);

        editTextQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonOk:
                product.put(
                        searchViewItemList.getQuery().toString(),
                        new String[]{
                                editTextQuantity.getText().toString(),
                                textViewAmount.getText().toString()
                        });

                activity.finish();
                break;
            case R.id.buttonCancel:
                dismiss();
                break;
            default:
        }
    }
}
