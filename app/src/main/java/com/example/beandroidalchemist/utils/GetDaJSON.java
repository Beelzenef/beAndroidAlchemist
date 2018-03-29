package com.example.beandroidalchemist.utils;

import android.content.Context;

import com.example.beandroidalchemist.pojo.TiposPociones;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * JSON getter
 */

public class GetDaJSON {

    private Context c;

    public GetDaJSON(Context c) {
        this.c = c;
    }

    public TiposPociones getParamsPociones(JSONObject contenido) throws JSONException {

        TiposPociones params = new TiposPociones();

        ArrayList<String> listaOyS = new ArrayList<>();
        ArrayList<String> listaEtiquetas = new ArrayList<>();
        ArrayList<String> listaEfectosN = new ArrayList<>();
        ArrayList<String> listaEfectosP = new ArrayList<>();

        JSONArray oys = new JSONArray(contenido.getString("olorsabor"));
        JSONArray efectosn = new JSONArray(contenido.getString("efectosn"));
        JSONArray efectosp = new JSONArray(contenido.getString("efectosp"));
        JSONArray etiquetas = new JSONArray(contenido.getString("etiqueta"));

        for (int i = 0; i < oys.length(); i++) {
            listaOyS.add(oys.getString(i));
        }
        params.setoYs(listaOyS);

        for (int i = 0; i < efectosn.length(); i++) {
            listaEfectosN.add(efectosn.getString(i));
        }
        params.setEfectosN(listaEfectosN);

        for (int i = 0; i < efectosp.length(); i++) {
            listaEfectosP.add(efectosp.getString(i));
        }
        params.setEfectosP(listaEfectosP);

        for (int i = 0; i < etiquetas.length(); i++) {
            listaEtiquetas.add(etiquetas.getString(i));
        }
        params.setEtiquetas(listaEtiquetas);

        return params;
    }

}
