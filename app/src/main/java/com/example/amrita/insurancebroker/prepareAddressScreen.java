package com.example.amrita.insurancebroker;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.gms.location.places.AutocompletePrediction;

public class prepareAddressScreen {
    private static prepareAddressScreen instance;
    ArrayAdapter<AutocompletePrediction> adapter;
    AdapterViewOnItemClickListener listener;
    Context context;

    public static prepareAddressScreen getInstance(ArrayAdapter<AutocompletePrediction> adapter,Context context,AdapterViewOnItemClickListener listener ){
        if(instance == null)
            instance = new prepareAddressScreen(adapter,context,listener);
        return instance;
    }

    private prepareAddressScreen(ArrayAdapter<AutocompletePrediction> adapter, Context context,AdapterViewOnItemClickListener listener){
        if(adapter==null)
            adapter = AutocompleteAdapterHelper.getAdapter(Globals.gettype(), context);
        this.adapter = adapter;
        if(listener == null)
            listener = new AdapterViewOnItemClickListener(adapter,context);
        this.listener = listener;
        this.context=context;
    }

    public void prepare(TextView question, AutoCompleteTextView autocomplete){

        question.setText(R.string.question_address);
        autocomplete.setHint(R.string.hint_address);
        autocomplete.setOnItemClickListener(this.listener);
        autocomplete.setText("");
        autocomplete.setAdapter(adapter);
        NextListener.setItem(null);
    }

}
