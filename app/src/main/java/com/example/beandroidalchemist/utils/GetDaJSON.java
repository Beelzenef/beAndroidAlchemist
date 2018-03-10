package com.example.beandroidalchemist.utils;

import android.content.Context;
import android.util.Log;

import com.example.beandroidalchemist.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Beelzenef on 10/03/2018.
 */

public class GetDaJSON {

    private Context c;

    public GetDaJSON(Context c) {
        this.c = c;
    }

    public ArrayList<String> getOyS() {

        ArrayList<String> listaOyS = new ArrayList<>();

        InputStream is = c.getResources().openRawResource(R.raw.olorsabor);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int controlEOF;
        try {
            controlEOF = is.read();
            while (controlEOF != -1) {
                baos.write(controlEOF);
                controlEOF = is.read();
            }
            is.close();

            JSONObject jObject = new JSONObject(baos.toString());
            JSONArray listaJSON = jObject.getJSONArray("olorsabor");

            for (int i = 0; i < listaJSON.length(); i++) {
                listaOyS.add(listaJSON.getString(i));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return listaOyS;
    }

    public ArrayList<String> getEfectosN() {

        ArrayList<String> listaEfectosN = new ArrayList<>();

        InputStream is = c.getResources().openRawResource(R.raw.efectosn);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int controlEOF;
        try {
            controlEOF = is.read();
            while (controlEOF != -1) {
                baos.write(controlEOF);
                controlEOF = is.read();
            }
            is.close();

            JSONObject jObject = new JSONObject(baos.toString());
            JSONArray listaJSON = jObject.getJSONArray("efectosn");

            for (int i = 0; i < listaJSON.length(); i++) {
                listaEfectosN.add(listaJSON.getString(i));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return listaEfectosN;
    }

    public ArrayList<String> getEfectosP() {

        ArrayList<String> listaEfectosP = new ArrayList<>();

        InputStream is = c.getResources().openRawResource(R.raw.efectosp);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int controlEOF;
        try {
            controlEOF = is.read();
            while (controlEOF != -1) {
                baos.write(controlEOF);
                controlEOF = is.read();
            }
            is.close();

            JSONObject jObject = new JSONObject(baos.toString());
            JSONArray listaJSON = jObject.getJSONArray("efectosp");

            for (int i = 0; i < listaJSON.length(); i++) {
                listaEfectosP.add(listaJSON.getString(i));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return listaEfectosP;
    }

    public ArrayList<String> getEtiqueta() {

        ArrayList<String> listaEtiquetas = new ArrayList<>();

        InputStream is = c.getResources().openRawResource(R.raw.etiquetas);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int controlEOF;
        try {
            controlEOF = is.read();
            while (controlEOF != -1) {
                baos.write(controlEOF);
                controlEOF = is.read();
            }
            is.close();

            JSONObject jObject = new JSONObject(baos.toString());
            JSONArray listaJSON = jObject.getJSONArray("etiquetas");

            for (int i = 0; i < listaJSON.length(); i++) {
                listaEtiquetas.add(listaJSON.getString(i));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return listaEtiquetas;
    }

}
