package com.ivanleoncz.SplashActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Bye!", Toast.LENGTH_SHORT).show();
        moveTaskToBack(true);
    }

    public void sharingContent(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String content = "https://github.com/ivanlmj/Android-SplashActivity";
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"Splash Activity for Android!");
        sharingIntent.putExtra(Intent.EXTRA_TEXT,content);
        startActivity(Intent.createChooser(sharingIntent, "Share via:"));
    }

    public void openBrowser(View view) {
        String uri = (String)view.getTag();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

}
