package com.example.amrita.insurancebroker;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.gms.location.places.AutocompletePrediction;

public class TaskPreparingScreens {

    private static TaskPreparingScreens instance;
Context context;
    public static TaskPreparingScreens getInstance(Context context) {
        if (instance == null)
            instance = new TaskPreparingScreens(context);
        return instance;
    }

    private TaskPreparingScreens(Context context){
        this.context = context;
    }

    public void Prepare_address_screen(TextView question, ArrayAdapter<AutocompletePrediction> adapter, AutoCompleteTextView autocomplete,AdapterViewOnItemClickListener listener){
        Globals.settype(0);
        prepareAddressScreen address_screen = prepareAddressScreen.getInstance(adapter,context,listener);
        address_screen.prepare(question,autocomplete);
    }
    public void Prepare_insurance_screen(TextView question, ArrayAdapter<String> adapter, AutoCompleteTextView autocomplete,AdapterViewOnItemClickListener listener){
        Globals.settype(1);
        Globals.setCarrierList(JSONParser.getInstance(context).getList());
        prepareInsuranceScreen insurance_screen = prepareInsuranceScreen.getInstance(adapter,context,listener);
        insurance_screen.prepare(question,autocomplete);
    }
}
