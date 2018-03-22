package com.example.franciscoemanuelcardenasramos.consumoweb2;

/**
 * Created by franciscoemanuelcardenasramos on 21/03/18.
 */


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



public class GetJson extends AsyncTask<Void,Void,Void> {

    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/timezone/json?location=21.7638775,-105.2294039&timestamp=1458000000&key=AIzaSyCOwrLW4ArRmDSzIeFlwfK7VS4B9PF02H4");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();


            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }


            JSONObject JA = new JSONObject(data);

            singleParsed = "la diferencia horaria para el horario de verano  :   " + "\n"+ JA.get("dstOffset")+" S" + "\n"+  "\n"+
                    " la diferencia horaria respecto de UTC  : " + "\n"+ JA.get("rawOffset") +"S"+ "\n"+ "\n"+
                    "zona horaria : " + "\n"+JA.get("timeZoneId") + "\n"+ "\n"+
                    "nombre en formato largo de la zona horaria : " + "\n"+ JA.get("timeZoneName") + "\n"+ "\n"+
                    "estado de la respuesta : "+ "\n"+JA.get("status") + "\n";
            dataParsed = dataParsed + singleParsed +"\n" ;

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
