package com.redtjs.simplelistdisplay;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayList extends Activity {

    // data source
    private String[] mobileArray = {"Albert Wesker","Chris Redfield","Jill Valentine"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_row_layout, mobileArray);
        ListView listView = (ListView) findViewById(R.id.display_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent displayRow = new Intent(DisplayList.this, DisplayRow.class);
                Object item = adapterView.getItemAtPosition(i);
                String value = item.toString();
                displayRow.putExtra("itemSelected", value);
                startActivity(displayRow);
            }

        });

    }

}

