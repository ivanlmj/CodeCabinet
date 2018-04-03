package com.redtjs.customlistview;

import android.app.ListActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ListActivity {

    String names[] = {"Ivan","Alan","Joao"};
    String ages[]  = {"28","35","21"};

    static final ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity_main);
        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.row, String[] names, );
    }

}
