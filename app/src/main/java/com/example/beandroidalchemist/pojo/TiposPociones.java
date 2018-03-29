package com.example.beandroidalchemist.pojo;

import java.util.ArrayList;

public class TiposPociones {

    private ArrayList<String> etiquetas;
    private ArrayList<String> efectosN;
    private ArrayList<String> efectosP;
    private ArrayList<String> oYs;

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public ArrayList<String> getEfectosN() {
        return efectosN;
    }

    public void setEfectosN(ArrayList<String> efectosN) {
        this.efectosN = efectosN;
    }

    public ArrayList<String> getEfectosP() {
        return efectosP;
    }

    public void setEfectosP(ArrayList<String> efectosP) {
        this.efectosP = efectosP;
    }

    public ArrayList<String> getoYs() {
        return oYs;
    }

    public void setoYs(ArrayList<String> oYs) {
        this.oYs = oYs;
    }

    public TiposPociones() {
        efectosN = new ArrayList<>();
        efectosP = new ArrayList<>();
        etiquetas = new ArrayList<>();
        oYs = new ArrayList<>();
    }
}
