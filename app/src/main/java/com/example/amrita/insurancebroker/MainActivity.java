package com.example.amrita.insurancebroker;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.location.places.AutocompletePrediction;



public class MainActivity extends FragmentActivity implements AsyncTaskListener {
    protected AutoCompleteTextView autocompleteView;
    protected TextView question;
    protected NextListener next_click_Listener ;
    int type=Globals.gettype();
    private ProgressDialog progressBar;
    private ArrayAdapter<String> adapter1=null;
    private ArrayAdapter<AutocompletePrediction>adapter2=null;
    protected AdapterViewOnItemClickListener autocompleteClickListener1=null,autocompleteClickListener2=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autocompleteView = findViewById(R.id.autocomplete_places);
        question = findViewById(R.id.question);
        question.setText(R.string.question_address);
        Button next = findViewById(R.id.button_next);
        adapter2= AutocompleteAdapterHelper.getAdapter(type,this);
        autocompleteView.setAdapter(adapter2);
        autocompleteView.setHint(R.string.hint_address);
        autocompleteClickListener2 = new AdapterViewOnItemClickListener(adapter2,this);
        autocompleteView.setOnItemClickListener(autocompleteClickListener2);
        AutocompleteTextChangeListener textChangeListener = new AutocompleteTextChangeListener();
        autocompleteView.addTextChangedListener(textChangeListener);
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Loading ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        next_click_Listener= new NextListener(progressBar,this);
        next.setOnClickListener(next_click_Listener);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public AutoCompleteTextView getView(){
        return autocompleteView;
    }

    @Override
    public void OnTaskComplete() {
        // TODO Auto-generated method stub
        if(Globals.gettype()==0) {
            TaskPreparingScreens.getInstance(this).Prepare_insurance_screen(question,adapter1,autocompleteView,autocompleteClickListener1);
        }
        else{
            TaskPreparingScreens.getInstance(this).Prepare_address_screen(question,adapter2,autocompleteView,autocompleteClickListener2);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}

