package com.redtjs.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startAlert();
            }
        });

    }

    public void startAlert() {

        int numberSeconds;
        Intent intent;
        EditText text;
        PendingIntent pIntent;

        intent        = new Intent(this, MyBroadcastReceiver.class);
        text          = (EditText) findViewById(R.id.time);
        numberSeconds = Integer.parseInt(text.getText().toString());
        pIntent       = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (numberSeconds * 1000), pIntent);

        Toast.makeText(this, "Alarm set in " + numberSeconds + " seconds",Toast.LENGTH_LONG).show();

    }

}
