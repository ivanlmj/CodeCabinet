package com.redtjs.simplelistdisplay;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayRow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String messageIntent = intent.getExtras().getString("itemSelected");


        switch (messageIntent) {
            case "Albert Wesker":
                setContentView(R.layout.activity_display_row_wesker);
                break;
            case "Chris Redfield":
                setContentView(R.layout.activity_display_row_chris);
                break;
            case "Jill Valentine":
                setContentView(R.layout.activity_display_row_jill);
                break;
        }

        TextView displayRow = (TextView) findViewById(R.id.display_item);
        displayRow.setText(messageIntent);

    }

}
