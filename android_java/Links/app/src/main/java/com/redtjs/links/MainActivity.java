package com.redtjs.links;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String lFacebook = "Go to https://www.facebook.com/";
        String lTwitter  = "Go to https://twitter.com/";
        String lLinkedin = "Go to https://www.linkedin.com/";

        TextView tvFacebook = (TextView) findViewById(R.id.link_facebook);
        TextView tvTwitter  = (TextView) findViewById(R.id.link_twitter);
        TextView tvLinkedin = (TextView) findViewById(R.id.link_linkedin);

        tvFacebook.setText(lFacebook);
        tvTwitter.setText(lTwitter);
        tvLinkedin.setText(lLinkedin);

        Linkify.addLinks(tvFacebook, Linkify.WEB_URLS);
        Linkify.addLinks(tvTwitter, Linkify.WEB_URLS);
        Linkify.addLinks(tvLinkedin, Linkify.WEB_URLS);
    }
}
