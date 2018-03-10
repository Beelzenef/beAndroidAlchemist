package com.example.beandroidalchemist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.beandroidalchemist.pojo.Pocion;
import com.example.beandroidalchemist.utils.GetDaJSON;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GetDaJSON JSONGetter;

    private ArrayList<String> listaOyS;
    private ArrayList<String> listaEtiquetas;
    private ArrayList<String> listaEfectosN;
    private ArrayList<String> listaEfectosP;

    private Random randomGenerator;

    private TextView txtV_Resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONGetter = new GetDaJSON(MainActivity.this);

        listaEfectosN = JSONGetter.getEfectosN();
        listaEtiquetas = JSONGetter.getEtiqueta();
        listaOyS = JSONGetter.getOyS();
        listaEfectosP = JSONGetter.getEfectosP();

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
                listaOyS.get(randomGenerator.nextInt(listaOyS.size())),
                listaOyS.get(randomGenerator.nextInt(listaOyS.size())),
                listaEtiquetas.get(randomGenerator.nextInt(listaEtiquetas.size())),
                listaEfectosN.get(randomGenerator.nextInt(listaEfectosN.size())),
                listaEfectosP.get(randomGenerator.nextInt(listaEfectosP.size()))
        );

        txtV_Resultados.setText(pocion.toString());
    }
}
