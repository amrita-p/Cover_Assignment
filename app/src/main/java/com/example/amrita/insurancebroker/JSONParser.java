package com.example.amrita.insurancebroker;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {
    private Context context;
    private List<String> carrier;
    private static JSONParser instance=null;
    public static JSONParser getInstance(Context context){
        if(instance==null) {
            instance = new JSONParser(context);

        }
            return instance;
    }
   private JSONParser(Context context){
       this.context = context;
       this.carrier = new ArrayList<>();
   }

   public void getParserDone(){
       String response = loadJSONFromAsset();
       get_insurer_list(response);
          }

   public List<String> getList(){
        return carrier;

   }

    protected void get_insurer_list(String result) {
        try {
            JSONObject jObj = new JSONObject(result);
            JSONArray json_array = jObj.getJSONArray("insurance_carriers");
            for (int i = 0; i < json_array.length(); i++) {
                String str = json_array.getString(i);
                carrier.add(str);

            }

        } catch (JSONException ex) {
            ex.printStackTrace();

        }
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = context.getAssets().open(Globals.getFilename());
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
