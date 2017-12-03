package edu.gmu.cs477.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by sergiogutierrez on 12/2/17.
 */

public class CurrentActivity extends Activity{

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_currency);
        lv=(ListView) findViewById(R.id.listView);
//        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

    }
}
