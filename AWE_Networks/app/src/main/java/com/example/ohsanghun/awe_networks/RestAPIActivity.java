package com.example.ohsanghun.awe_networks;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ohsanghun.awe_networks.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class RestAPIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_api);
    }

    public void getWeather(View view)
    {
        String id = "";
        switch (view.getId()){
            case R.id.londonButton :
                id = "London";
                break;
            case R.id.SeoulButton :
                id = "Seoul";
                break;
        }
        // 날씨를 읽어오는 API 호출
        OpenWeatherAPITask task= new OpenWeatherAPITask();
        try {
            String weather = task.execute(id).get();

            TextView temperatureText = (TextView)findViewById(R.id.resultTemperature);

            temperatureText.setText("TemperatureText :" + weather);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class OpenWeatherAPITask extends AsyncTask<String, Void, String> {
    @Override
    public String doInBackground(String... params) {
        OpenWeatherAPIClient client = new OpenWeatherAPIClient();

        String id = params[0];
        // API 호출
        String weather = client.getWeather(id);

        return weather;
    }
}

class OpenWeatherAPIClient {
    final static String openWeatherURL = "http://api.openweathermap.org/data/2.5/weather";
    public String getWeather(String id){
        String weather ;
        String urlString = openWeatherURL + "?q="+id+"&appid=73989af8356ce6d4600e10678529880e";

        try {
            // call API by using HTTPURLConnection
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            weather = getStringFromInputStream(in);
        }catch(MalformedURLException e){
            e.printStackTrace();
            return null;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }

        return weather;
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}