package com.redtjs.alarms;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by ivanleon on 09/11/16.
 */
public class VolleySingleton {

    String         TAG   = "ALARMS";
    String         CLASS = this.getClass().getSimpleName() + ": ";
    String         url;
    String         server;

    Context        context;
    RequestQueue   requestQueue;
    ProgressDialog pd;

    // class constructor
    public VolleySingleton(Context ctx) {
        server       = "192.168.1.73";
        context      = ctx;
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    // interfaces: they fucking saved my life <3!
    public interface VolleyCallback {
        void onSuccess(String result);
    }

    public interface RequestCallback {
        void onSuccess(String result);
    }


    // class method
    public void getMessage(final VolleyCallback volleyCallback) {

        url = "http://" + server + "/message";
        Log.d(TAG, CLASS + "requesting data from - " + url);
        StringRequest getData = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, CLASS + "request for /message was SUCCESSFUL! ");
                        Toast.makeText(context,"Request SUCCESSFUL!",Toast.LENGTH_LONG).show();
                        volleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, CLASS + "request for /message FAILED... " + error);
                        Toast.makeText(context,"request failed...",Toast.LENGTH_LONG).show();
                    }
                });
        try {
            requestQueue.add(getData);
        } catch (Exception e){
            Log.d(TAG, CLASS + "failed to add request to the queue (StackTrace) below. ");
            e.printStackTrace();
        }
    }

    public void makeRequest(final RequestCallback requestCallback) {

        url = "http://" + server + "/message";
        Log.d(TAG, CLASS + "requesting data from - " + url);
        StringRequest getData = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, CLASS + "request for /message was SUCCESSFUL! ");
                        pd.dismiss();
               //         spinner.setVisibility(View.GONE);
                        Toast.makeText(context,"Request SUCCESSFUL!",Toast.LENGTH_LONG).show();
                        requestCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, CLASS + "request for /message FAILED... " + error);
                        pd.dismiss();
               //         spinner.setVisibility(View.GONE);
                        Toast.makeText(context,"request failed...",Toast.LENGTH_LONG).show();
                    }
                });
        try {
            requestQueue.add(getData);
            // spinner = (ProgressBar) ((Activity)context).findViewById(R.id.progressBar1);
            // spinner.setVisibility(View.VISIBLE);
            pd = new ProgressDialog(context,R.style.CustomDialog);
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setIndeterminate(true);
            pd.setMessage("Jr. High School");
            pd.show();
        } catch (Exception e){
            Log.d(TAG, CLASS + "failed to add request to the queue (StackTrace) below. ");
            e.printStackTrace();
        }

    }

}
