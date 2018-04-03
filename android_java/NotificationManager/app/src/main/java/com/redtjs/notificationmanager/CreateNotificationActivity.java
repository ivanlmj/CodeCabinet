package com.redtjs.notificationmanager;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class CreateNotificationActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void createNotification(View view) {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        // Build notification
        // Actions are just fake
        if (Build.VERSION.SDK_INT < 16) {
            Notification noti = new Notification.Builder(this)
                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject").setSmallIcon(R.drawable.icon)
                    .setContentIntent(pIntent)
                    .addAction(R.drawable.icon, "Call", pIntent)
                    .addAction(R.drawable.icon, "More", pIntent)
                    .addAction(R.drawable.icon, "And more", pIntent).getNotification();
        } else {
            Notification noti = new Notification.Builder(this)
                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject").setSmallIcon(R.drawable.icon)
                    .setContentIntent(pIntent)
                    .addAction(R.drawable.icon, "Call", pIntent)
                    .addAction(R.drawable.icon, "More", pIntent)
                    .addAction(R.drawable.icon, "And more", pIntent).build();
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }
}
