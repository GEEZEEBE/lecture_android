package com.example.ohsanghun.awe_networks_tmp;

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
            Weather weather = task.execute(id,id).get();

            TextView temperatureText = (TextView)findViewById(R.id.resultTemperature);
            String temperature = String.valueOf(weather.getTemprature());

            temperatureText.setText("TemperatureText :" + temperature);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Weather {
    int lat;
    int ion;
    int temprature;
    int cloudy;
    String city;

    public void setLat(int lat){ this.lat = lat;}
    public void setIon(int ion){ this.ion = ion;}
    public void setTemperature(int t){ this.temprature = t;}
    public void setCloudy(int cloudy){ this.cloudy = cloudy;}
    public void setCity(String city){ this.city = city;}

    public int getLat(){ return lat;}
    public int getIon() { return ion;}
    public int getTemprature() { return temprature;}
    public int getCloudy() { return cloudy; }
    public String getCity() { return city; }
}

class OpenWeatherAPITask extends AsyncTask<String, Void, Weather> {
    @Override
    public Weather doInBackground(String... params) {
        OpenWeatherAPIClient client = new OpenWeatherAPIClient();

        String id = params[0];
        // API 호출
        Weather weather = client.getWeather(id);

        return weather;
    }
}

class OpenWeatherAPIClient {
    final static String openWeatherURL = "http://api.openweathermap.org/data/2.5/weather";
    public Weather getWeather(String id){
        Weather weather = new Weather();
        String urlString = openWeatherURL + "?q="+id+"&appid=73989af8356ce6d4600e10678529880e";

        try {
            // call API by using HTTPURLConnection
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JSONObject json = new JSONObject(getStringFromInputStream(in));

            // parse JSON
            weather = parseJSON(json);


        }catch(MalformedURLException e){
            e.printStackTrace();
            return null;

        }catch(JSONException e) {
            e.printStackTrace();
            return null;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }

        // set Weather Object

        return weather;
    }

    private Weather parseJSON(JSONObject json) throws JSONException {
        Weather weather = new Weather();
        weather.setTemperature(json.getJSONObject("main").getInt("temp"));
        weather.setCity(json.getString("name"));
        //weather.setCloudy();

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