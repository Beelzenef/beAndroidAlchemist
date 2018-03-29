package com.example.beandroidalchemist.pojo;

/**
 * Potion POJO
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
        this.olor = olor;
        this.sabor = sabor;
        this.etiqueta = etiqueta;
        this.efectoNegativo = efectoNegativo;
        this.efectoPositivo = efectoPositivo;
    }

    @Override
    public String toString() {
        return "Su olor: " + this.olor + "\nSu sabor " + this.sabor + "\nTiene una etiqueta: " + this.etiqueta +
                "\nSu efecto positivo es " + this.efectoPositivo + ".\nSu efecto negativo es " + this.efectoNegativo;
    }
}
