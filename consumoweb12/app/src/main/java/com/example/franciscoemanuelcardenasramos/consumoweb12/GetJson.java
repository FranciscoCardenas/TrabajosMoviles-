package com.example.franciscoemanuelcardenasramos.consumoweb12;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by franciscoemanuelcardenasramos on 21/03/18.
 */




public class GetJson extends AsyncTask<Void,Void,Void> {

    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Tepic,mx&APPID=0906362826d2cfea265ed029381a7e31");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();


            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }


            JSONObject jsonObject = new JSONObject(data);
            JSONArray weather = new JSONArray(jsonObject.getString("weather"));
            JSONObject weather2;
            String description="";
            for(int i=0;i<weather.length();i++){
                weather2 = (JSONObject)weather.get(i);
                description= weather2.getString("description");
            }
            JSONObject main = new JSONObject(jsonObject.getString("main"));
            JSONObject sys = new JSONObject(jsonObject.getString("sys"));
            singleParsed = "City: " + jsonObject.get("name") + "\n"
                    + "Country: "+ sys.getString("country") +"\n"
                    + "Description: "+ description+"\n"

                    + "Temperatura Minima : "+main.getString("temp_min") +"\n"
                    + "Temperatura Maxima : "+main.getString("temp_max") +"\n"
                    + "Presion  : "+main.getString("pressure") +"\n"
                    + "Humedad : " + main.getString("humidity")+"\n";

            dataParsed = dataParsed + singleParsed + "\n";

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.dataParsed);
    }


}

