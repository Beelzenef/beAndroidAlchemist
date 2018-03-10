package com.example.beandroidalchemist.pojo;

/**
 * Created by Beelzenef on 10/03/2018.
 */

public class Pocion {

    String olor;
    String sabor;
    String etiqueta;
    String efectoNegativo;
    String efectoPositivo;

    String resultado;

    public String getOlor() {
        return olor;
    }

    public void setOlor(String olor) {
        this.olor = olor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEfectoNegativo() {
        return efectoNegativo;
    }

    public void setEfectoNegativo(String efectoNegativo) {
        this.efectoNegativo = efectoNegativo;
    }

    public String getEfectoPositivo() {
        return efectoPositivo;
    }

    public void setEfectoPositivo(String efectoPositivo) {
        this.efectoPositivo = efectoPositivo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Pocion(String olor, String sabor, String etiqueta, String efectoNegativo, String efectoPositivo) {
        this.olor = this.olor;
        this.sabor = this.sabor;
        this.etiqueta = etiqueta;
        this.efectoNegativo = efectoNegativo;
        this.efectoPositivo = efectoPositivo;
    }

    @Override
    public String toString() {
        return "Huele a " + this.olor + " y sabe a " + this.sabor + ". Tiene una etiqueta: " + this.etiqueta +
                ". Su efecto positivo es " + this.efectoPositivo + " y el negativo es " + this.efectoNegativo;
    }
}
