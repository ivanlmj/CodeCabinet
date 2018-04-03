package com.redtjs.alarmmanager;

/**
 * Created by ivanleon on 23/11/16.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    //MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        //mp = MediaPlayer.create(context, R.raw.protoman  );
        //mp.start();
        Toast.makeText(context, "The Alarm has worked!", Toast.LENGTH_LONG).show();
    }
}
