package com.example.amrita.insurancebroker;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.maps.model.LatLngBounds;



public class AutocompleteAdapterHelper {
 private static ArrayAdapter<?> adapter;
    public static ArrayAdapter getAdapter(int type, Context context){
        if(type == 0){
            LatLngBounds bounds = null;
            adapter = new PlaceAutocompleteAdapter(context, bounds,null);
        }
        else if(type == 1){
            adapter = new InsurerAutocompleteAdapter(context, android.R.layout.simple_dropdown_item_1line,Globals.getCarrierList());
        }

        return adapter;
    }
}
