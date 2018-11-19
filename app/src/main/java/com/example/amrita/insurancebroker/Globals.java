package com.example.amrita.insurancebroker;


import java.util.ArrayList;
import java.util.List;

public class Globals {
    private static int type = 0;
    private static List<String> list = null;
    private static int time = 0;
    private static int screens = 2;
    private static String filename = "carriers.json";
    public static String getFilename(){
        return filename;
    }
    public static List<String> getCarrierList() {
        return list;
    }

    public static void setCarrierList(List<String> l) {
        if(list==null)
        list = new ArrayList<>(l);
    }
    public static int gettype() {
        return type;
    }

    public static void settype(int d) {
        type = d;
    }
    public static void setTime() {
        time = time+1;
    }
    public static int getTime() {return time; }
    public static int getScreens(){ return screens;}
}
