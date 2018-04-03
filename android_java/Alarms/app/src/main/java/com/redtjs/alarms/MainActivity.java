package com.redtjs.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public final String CLASS = this.getClass().getSimpleName() + ": ";
    public final String TAG   = "ALARMS";

    long startsIn  = SystemClock.elapsedRealtime() + 60 * 1000;
    long interval  = 60000;

    Intent          intent;
    PendingIntent   pendingIntent;
    AlarmManager    alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent        = new Intent(this, AlarmBroadcastReceiver.class);
        String level  = getIntent().getStringExtra("level");
        TextView tv   = (TextView) findViewById(R.id.textReturn);
        tv.setText(level);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager  = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

    }

    public void alarmControl(View view) {

        Button button     = (Button)view;
        String buttonText = button.getText().toString();
        Log.d(TAG, CLASS + "button " + buttonText + " has been clicked");
        switch (button.getId()) {
            case R.id.buttonStart:
                Log.d(TAG, CLASS + "calling -> setAlarm()");
                setAlarm();
                Toast.makeText(getApplicationContext(), "Alarm has been STARTED !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonStop:
                Log.d(TAG, CLASS + "calling -> stopAlarm()");
                stopAlarm();
                Toast.makeText(getApplicationContext(), "Alarm has been STOPPED !", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void setAlarm() {
        try {
            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, startsIn, interval, pendingIntent);
            Log.d(TAG, CLASS + "Alarm STARTED!");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, CLASS + "can't START the alarm...");
        }
    }

    public void stopAlarm() {
        try {
            alarmManager.cancel(pendingIntent);
            Log.d(TAG, CLASS + "Alarm STOPPED!");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, CLASS + "can't STOP the alarm...");
        }
    }


    public void makeRequest(View view) {

        VolleySingleton volley = new VolleySingleton(this);
        volley.makeRequest(new VolleySingleton.RequestCallback() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(getApplicationContext(),"Message: " + result,Toast.LENGTH_SHORT).show();

                try {
                    JSONArray ja = new JSONArray(result);
                    for (int i=0; i < ja.length(); i++) {
                        if (ja.getString(i).equals("kinder")) {
                            Log.d(TAG, CLASS + "Array element is Kinder! - " + ja.getString(i));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
