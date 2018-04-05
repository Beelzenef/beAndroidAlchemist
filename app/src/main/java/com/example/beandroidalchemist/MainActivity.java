package com.example.beandroidalchemist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beandroidalchemist.pojo.Pocion;
import com.example.beandroidalchemist.pojo.TiposPociones;
import com.example.beandroidalchemist.utils.GetDaJSON;
import com.example.beandroidalchemist.utils.RestClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.Random;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GetDaJSON JSONGetter;

    private TiposPociones tiposPociones;

    private Random randomGenerator;

    private TextView txtV_Resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        JSONGetter = new GetDaJSON(MainActivity.this);

        tiposPociones = new TiposPociones();
        descarga("https://api.myjson.com/bins/167a4n");

        randomGenerator = new Random();

        txtV_Resultados = (TextView) findViewById(R.id.txtv_Results);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {

        }
        else if (id == R.id.nav_feedback) {

        }
        else if (id == R.id.nav_aboutus) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
