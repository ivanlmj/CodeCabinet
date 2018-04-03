package com.redtjs.alarms;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by ivanleon on 23/11/16.
 */
public class BootBroadcastReceiver extends BroadcastReceiver {

    public final String CLASS = this.getClass().getSimpleName();
    public final String TAG   = "ALARMS";

    @Override
    public void onReceive(Context context, Intent intent) {

        /*        Log.d(TAG, CLASS + " running onReceive()");
        if (intent.getAction().equals(BOOT_COMPLETED)) {
            Log.d(TAG, CLASS + " creating Toast");
            Toast.makeText(context, "It's a Boot Completed.", Toast.LENGTH_SHORT).show();
            // how to call the alarm ?.....
        }
        */

    }

}
