package com.example.beandroidalchemist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    }
}
