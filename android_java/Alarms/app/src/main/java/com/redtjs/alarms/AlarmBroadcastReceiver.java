package com.redtjs.alarms;

import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.media.MediaPlayer;

import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import android.util.Log;

import android.widget.Toast;

import org.json.JSONObject;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by ivanleon on 23/11/16.
 */
public class AlarmBroadcastReceiver extends BroadcastReceiver {

    public final String CLASS = this.getClass().getSimpleName() + ": ";
    public final String TAG   = "ALARMS";

    Context      alarmContext;
    MediaPlayer  mp;
    MainActivity ma = new MainActivity();

    @Override
    public void onReceive(final Context context, Intent intent) {
        alarmContext = context;
        mp = MediaPlayer.create(context,R.raw.protoman);
        mp.start();
        Toast.makeText(context, "The Alarm is working!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, CLASS + "the Alarm is working! Next check in: " + (ma.interval / 1000) / 60 + " minutes.");
        VolleySingleton volley = new VolleySingleton(context);
        volley.getMessage(new VolleySingleton.VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                if(result.equals("disabled")) {
                    Toast.makeText(context,"Usuario fue desabilitado.",Toast.LENGTH_SHORT).show();
                } else if (result.equals("new_password")) {
                    Toast.makeText(context,"Usuario fue desabilitado.",Toast.LENGTH_SHORT).show();
                } else
                    try {
                        JSONObject  jo   = new JSONObject(result);
                        Iterator<?> keys = jo.keys();
                        while(keys.hasNext()) {
                            String key = (String) keys.next();
                            Log.d(TAG, CLASS + "Key: " + key);
                            JSONObject value = jo.getJSONObject(key);
                            Log.d(TAG, CLASS + "Value: " + value);
                            Iterator<?> nKeys = value.keys();
                            while(nKeys.hasNext()) {
                                String levelKey = (String) nKeys.next();
                                String levelValue = (String) value.get(levelKey);
                                Log.d(TAG, CLASS + "Level       : " + levelKey);
                                Log.d(TAG, CLASS + "Level Value : " + levelValue);
                                if (levelValue.equals("si")) {
                                    Log.d(TAG, CLASS + "Level + Value: " + levelKey + "@" + levelValue);
                                    String levelString;
                                    switch (levelKey) {
                                        case "HijosKinder":
                                            levelString = "Kindergarten";
                                            Log.d(TAG, CLASS + "Adding notification to: " + levelString);
                                            addNotification(levelString, 0);
                                            break;
                                        case "HijosPrimaria":
                                            levelString = "Primary Level";
                                            Log.d(TAG, CLASS + "Adding notification to: " + levelString);
                                            addNotification(levelString, 1);
                                            break;
                                        case "HijosSecundaria":
                                            levelString = "Jr. High School";
                                            Log.d(TAG, CLASS + "Adding notification to: " + levelString);
                                            addNotification(levelString, 2);
                                            break;

                                    }

                                } else {

                                }
                            }
                        }
                    } catch (Exception e) {
                        Log.d(TAG, CLASS + "an Exception has ocurred -> " + e.toString());
                        e.printStackTrace();
                    }

            }
        });

    }

    public void addNotification(String level, int id) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(alarmContext);
        builder.setSmallIcon(R.drawable.alarm_white);
        builder.setContentTitle("Aviso TJS");
        builder.setContentText(level);
        builder.setTicker("Aviso TJS - " + level);
        builder.setOngoing(true);
        builder.setAutoCancel(true);

        Intent  notificationIntent = new Intent(alarmContext, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("level",level);
        notificationIntent.putExtras(bundle);
        PendingIntent contentIntent = PendingIntent.getActivity(alarmContext, id, notificationIntent,
                                      PendingIntent.FLAG_UPDATE_CURRENT |
                                      PendingIntent.FLAG_ONE_SHOT |
                                      PendingIntent.FLAG_CANCEL_CURRENT);

        builder.setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) alarmContext.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(id, builder.build());
    }

}