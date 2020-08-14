package com.example.taiwanweatherapp;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;

public class MyService extends Service {
    final String TAG = "MyService";
    final String key = "CWB-9A3F0E3E-CC4F-4284-84D3-F57EBDAB6A08";
    final String url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-9A3F0E3E-CC4F-4284-84D3-F57EBDAB6A08&format=JSON&locationName=%E8%87%BA%E5%8C%97%E5%B8%82&elementName=PoP";
    String Response = null;
    RequestQueue queue;
    Fragment_Weather fragmentWeather;

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        new DoBackgroundTask().execute();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void callCWBServer() {


        queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Log.d(TAG, "onResponse: " + response);
                        Response = response;

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: ");
                Response = "error";
            }
        });


        queue.add(stringRequest);


    }

    private class DoBackgroundTask extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG, "doInBackground: ");

            try {
                callCWBServer();
            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d(TAG, "onPostExecute: ");
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(this, 5000);
                    Log.d(TAG, "run: repeat");
                    try {
                        callCWBServer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "run: Response:" + Response);

                }
            }, 3000);
            super.onPostExecute(result);
        }
    }

}

