package com.example.beandroidalchemist;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beandroidalchemist.pojo.Pocion;
import com.example.beandroidalchemist.pojo.TiposPociones;
import com.example.beandroidalchemist.utils.GetDaJSON;
import com.example.beandroidalchemist.utils.RestClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private GetDaJSON JSONGetter;

    private TiposPociones tiposPociones;

    private Random randomGenerator;

    private TextView txtV_Resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONGetter = new GetDaJSON(MainActivity.this);

        tiposPociones = new TiposPociones();
        descarga("https://api.myjson.com/bins/167a4n");

        randomGenerator = new Random();

        txtV_Resultados = (TextView) findViewById(R.id.txtv_Results);
    }

    public void onClick_genNewPotion (View v)
    {
        switch (v.getId())
        {
            case R.id.btn_genPotion:
                genNewPotion();
                break;
        }
    }

    private void genNewPotion()
    {
        Pocion pocion = new Pocion(
                tiposPociones.getoYs().get(randomGenerator.nextInt(tiposPociones.getoYs().size())),
                tiposPociones.getoYs().get(randomGenerator.nextInt(tiposPociones.getoYs().size())),
                tiposPociones.getEtiquetas().get(randomGenerator.nextInt(tiposPociones.getEtiquetas().size())),
                tiposPociones.getEfectosN().get(randomGenerator.nextInt(tiposPociones.getEfectosN().size())),
                tiposPociones.getEfectosP().get(randomGenerator.nextInt(tiposPociones.getEfectosP().size()))
        );

        txtV_Resultados.setText(pocion.toString());
    }

    private void descarga(String web) {
        final ProgressDialog progreso = new ProgressDialog(this);
        RestClient.get(web, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progreso.setMessage("Conectando...");
                progreso.setCancelable(true);
                progreso.show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    progreso.dismiss();
                    tiposPociones = JSONGetter.getParamsPociones(response);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "¡Error al obtener parámetros! :(",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                progreso.dismiss();
                Toast.makeText(MainActivity.this, "¡Ha fallado la descarga! :(",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
