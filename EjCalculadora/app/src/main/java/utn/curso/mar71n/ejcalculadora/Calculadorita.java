package utn.curso.mar71n.ejcalculadora;

import java.util.Objects;

/**
 * Created by Usuario on 10/4/2016.
 */
public class Calculadorita {
    String r;
    String a;
    String b;
    String o;
    String espero;
    public Calculadorita(){
        r = "0";
        espero = "a";
        a="";
        b="";
        o="";
    }
    public Calculadorita ingresar(String algo){
        switch (espero){
            case "a" : {
                a =  algo;
                espero = "o";
                break;
            }
            case "b" : {
                b =  algo;
                this.calcular();
                a = r;
                espero = "o";
                break;
            }
            case "o" : {
                o =  algo;
                espero = "b";
                break;
            }
        }
        return this;
    }
    public Calculadorita calcular(){
        Float fa = (Float) Float.parseFloat(a.replace(',','.'));
        Float fb = (Float) Float.parseFloat(b.replace(',','.'));
        Float fr = (Float) Float.parseFloat(r.replace(',','.'));
        switch (this.o){
            case "+" : fr = fa + fb;
                break;
            case "-" : fr = fa - fb;
                break;
            case "*" : fr = fa * fb;
                break;
            case "/" : fr = fa / fb;
                break;
        }
        this.a = String.format("%f",fr);
        this.b = "";
        this.r = String.format("%f",fr);
        return this;
    }

    @Override
    public String toString() {
        String st = this.a + " " + this.o;
        return st;
    }
}
