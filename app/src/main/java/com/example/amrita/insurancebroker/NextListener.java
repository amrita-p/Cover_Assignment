package com.example.amrita.insurancebroker;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;



public class NextListener implements View.OnClickListener {

    private Context context;
    private static Object item;
    private ProgressDialog progressbar;
    private ProgressBarAsyncTask progressbarasync;
    private View view;

    public NextListener(ProgressDialog progressbar, Context context) {
        this.context = context;
        this.progressbar = progressbar;
    }

    public static void setItem(Object item) {
        NextListener.item = item;
    }

    @Override
    public void onClick(View v) {

        /** ProgressBar starts its execution */
        this.view = v;
        if(item==null){
              OpenDialog dialog = new OpenDialog(context);
              dialog.showDialog();

          }
          else{

            progressbar.show();
            progressbarasync = new ProgressBarAsyncTask(context);

            /** ProgressBar starts its execution */
            progressbarasync.execute();

          }

    }

    private class ProgressBarAsyncTask extends AsyncTask<Void, Integer, Void> {
        int progressStatus ;
        private AsyncTaskListener listener;

        ProgressBarAsyncTask(Context context){
            this.listener=(AsyncTaskListener)context;
        }
        /** This callback method is invoked, before starting the background process */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //reset progress bar status
            progressStatus = 0;
        }

        /** This callback method is invoked on calling execute() method
         * on an instance of this class */
        @Override
        protected Void doInBackground(Void...params) {
            while(progressStatus<100){
                try{

                    progressStatus++;

                    if(Globals.gettype()==0 && Globals.getTime()==0) {
                        JSONParser parser = JSONParser.getInstance(context);
                        parser.getParserDone();
                        Globals.setTime();
                    }


                    /** Invokes the callback method onProgressUpdate */
                    publishProgress(progressStatus);

                    /** Sleeps this thread for 100ms */
                    Thread.sleep(100);

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        /** This callback method is invoked when publishProgress()
         * method is called */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressbar.setProgress(progressStatus);
            progressbar.setProgressNumberFormat(null) ;

        }

        /** This callback method is invoked when the background function
         * doInBackground() is executed completely */
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if(Globals.gettype()==1){
                popupDisplay popup = popupDisplay.getInstance(context, view);
                popup.showPopup();
            }
            else {
                listener.OnTaskComplete();
            }
                progressbar.dismiss();

        }
    }






}
