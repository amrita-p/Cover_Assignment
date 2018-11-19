package com.example.amrita.insurancebroker;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.location.places.AutocompletePrediction;

public class AdapterViewOnItemClickListener implements OnItemClickListener {
    private ArrayAdapter<?> adapter;
    static AutocompletePrediction item = null;
    static String item1 = null;
    private Context context;
    public AdapterViewOnItemClickListener(ArrayAdapter<?> adapter,Context context) {
    this.context = context;
    this.adapter = adapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            /*
             Retrieve the place ID of the selected item from the Adapter.
             The adapter stores each Place suggestion in a AutocompletePrediction from which we
             read the place ID and title.
              */

            if(Globals.gettype() == 0){
                item = (AutocompletePrediction)adapter.getItem(position);
                NextListener.setItem(item);
                CharSequence primaryText = item.getPrimaryText(null);

                Toast.makeText(context, "Clicked: " + primaryText,
                Toast.LENGTH_SHORT).show();
                item= null;
    }
    else{
                item1= (String)adapter.getItem(position);
                NextListener.setItem(item1);
                Toast.makeText(context, "Clicked: " + item1,
                        Toast.LENGTH_SHORT).show();
                item1=null;
            }
}

}
