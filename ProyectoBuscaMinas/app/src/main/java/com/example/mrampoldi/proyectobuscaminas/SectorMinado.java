package com.example.mrampoldi.proyectobuscaminas;

/**
 * Created by mrampoldi on 22/04/2016.
 */
public class SectorMinado {
    private String mostrar;
    private int cuantos;
    private int bb;

    public SectorMinado(){
        this.cuantos = 0;
        this.mostrar = "";
        this.bb = 0;
    }

    public void incCuantos(){
        this.cuantos++;
    }

    public int getCuantos() {
        return cuantos;
    }

    public void setCuantos(int cuantos) {
        this.cuantos = cuantos;
    }

    public String getMostrar() {
        return mostrar;
    }

    public void setMostrar(String mostrar) {
        this.mostrar = mostrar;
    }

    public void setBb(int b){
        this.bb = b;
    }

    public int getBb(){
        return bb;
    }
}
