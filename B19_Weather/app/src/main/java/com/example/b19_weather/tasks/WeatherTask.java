package com.example.b19_weather.tasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chethan on 11/19/2015.
 */
public class WeatherTask extends AsyncTask<String, Void, Void>{

    private final String TAG = "WeatherTask";

    @Override
    protected Void doInBackground(String... params) {
        //Network related code here

        String link = params[0];

        Log.i(TAG, "link = " + link);


        try {
            URL url = new URL(link);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(15000);

            conn.setRequestMethod("GET");
            conn.connect();

            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String rawJson = "", data = "";

            while( (data = reader.readLine()) != null){
                rawJson = rawJson + data + "\n";
            }


            Log.i(TAG,"rawJson = "+rawJson);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
