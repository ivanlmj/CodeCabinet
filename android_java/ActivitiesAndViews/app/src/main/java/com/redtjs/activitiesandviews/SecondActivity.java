package com.redtjs.activitiesandviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ivanleon on 28/06/16.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);

        Intent intent = getIntent();
        String message = intent.getExtras().getString("activityMessage");

        setContentView(R.layout.activity_second);

        TextView textView = (TextView)findViewById(R.id.secondTextView);
        textView.setText("Welcome to the Second Activity");

        TextView activityMessage = (TextView)findViewById(R.id.activityMessage);
        activityMessage.setText(message);


    }
}
