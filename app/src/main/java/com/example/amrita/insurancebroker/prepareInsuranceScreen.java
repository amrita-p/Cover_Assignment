package com.example.amrita.insurancebroker;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;


public class prepareInsuranceScreen {

    private static prepareInsuranceScreen instance;
    ArrayAdapter<String> adapter;
    AdapterViewOnItemClickListener listener;
    Context context;

        public static prepareInsuranceScreen getInstance(ArrayAdapter<String> adapter, Context context,AdapterViewOnItemClickListener listener ){
            if(instance == null)
                instance = new prepareInsuranceScreen(adapter,context,listener);
            return instance;
        }

        private prepareInsuranceScreen(ArrayAdapter<String> adapter, Context context,AdapterViewOnItemClickListener listener){
            if(adapter==null)
                this.adapter = AutocompleteAdapterHelper.getAdapter(Globals.gettype(), context);
            else
                this.adapter = adapter;
            if(listener ==null)
                this.listener = new AdapterViewOnItemClickListener(this.adapter,context);
            else
                this.listener = listener;
            this.context = context;
        }

        public void prepare(TextView question, AutoCompleteTextView autocomplete){

            question.setText(R.string.question_insurance);
            autocomplete.setText("");
            autocomplete.setHint(R.string.hint_insurance);
            autocomplete.setOnItemClickListener(listener);
            autocomplete.setAdapter(adapter);
            NextListener.setItem(null);
        }

    }


