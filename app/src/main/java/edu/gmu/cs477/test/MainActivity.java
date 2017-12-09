package edu.gmu.cs477.test;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

import android.widget.ListView;

public class MainActivity extends Activity {

    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int[] prgmImages = {R.drawable.images, R.drawable.images1, R.drawable.images2, R.drawable.images3, R.drawable.images4, R.drawable.images5, R.drawable.images6, R.drawable.images7, R.drawable.images8};
    public static String[] prgmNameList = {"Bitcoin", "Etherium", "Ripple", "Litecoin", "Cardone ", "Monero", "iota", "Qtum", "Zcash"};
    public static double[] price = {11035.3, 461.699, 0.252478, 99.6847, 0.130139, 204.947, 1.43962, 12.8437, 327.16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        context = this;
//        Crypto myC = new Crypto();
//        for(int i=0 ; i<5; i++){
//            prgmNameList[i] = myC.getCrypto(i).get(0);
//        }
        update_arrays();
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages, price));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main, menu);

        return true;
    }

    public static void update_arrays() {
        Random random = new Random();
        for (int i = 0; i < prgmImages.length; i++) {


        }
    }


}