package com.example.amrita.insurancebroker;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class popupDisplay {
    private static popupDisplay popup;
    private AsyncTaskListener listener;
    Context context;
    View view;
    public static popupDisplay getInstance(Context context,View view){
        if(popup == null)
            popup = new popupDisplay(context,view);
            return popup;

    }
    private popupDisplay(Context context, View view){
        this.context = context;
        this.view = view;
        this.listener=(AsyncTaskListener)context;

    }
    public void showPopup() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_up_end, null);
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
        listener.OnTaskComplete();
    }
}
