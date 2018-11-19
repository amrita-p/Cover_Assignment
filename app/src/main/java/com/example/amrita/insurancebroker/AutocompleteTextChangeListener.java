package com.example.amrita.insurancebroker;


import android.text.Editable;
import android.text.TextWatcher;

public class AutocompleteTextChangeListener implements TextWatcher {
    public AutocompleteTextChangeListener(){}
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        NextListener.setItem(null);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
