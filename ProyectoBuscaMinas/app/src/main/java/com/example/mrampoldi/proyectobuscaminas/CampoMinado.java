package com.example.mrampoldi.proyectobuscaminas;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by mrampoldi on 22/04/2016.
 */
public class CampoMinado {
    int x;
    int y;
    SectorMinado[][] campo;
    public CampoMinado(int  filas, int columnas){
        this.x = columnas;
        this.y = filas;
        //SectorMinado sm;
        for (int i=0 ; i<x ; i++){
            for (int j=0; j<y ; j++){
                campo[j][i] = new SectorMinado();
                SectorMinado sm = campo[j][i];
                sm.setBb(0);
                sm.setMostrar("");
            }
        }
    }

    public SectorMinado getSM(int f,int c){
        return campo[f][c];
    }
}
