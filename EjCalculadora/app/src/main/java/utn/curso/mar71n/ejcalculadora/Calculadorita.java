package utn.curso.mar71n.ejcalculadora;

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
        Float fa = (Float) Float.parseFloat(a);
        Float fb = (Float) Float.parseFloat(b);
        Float fr = (Float) Float.parseFloat(r);
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
        this.r = String.format("%f",fr);
        return this;
    }
}
