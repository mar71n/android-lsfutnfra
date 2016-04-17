package utn.curso.mar71n.ejcalculadora;

/**
 * Created by Usuario on 16/4/2016.
 */
public class Calculadorita2 {
    String sR;
    String sA;
    String sO;
    String sB;
    private String sOO;
    public Calculadorita2()
    {
        sR = "0";
        sA = "0";
        sO = "";
        sB = "0";
        sOO = "";
    }
    public Calculadorita2 ingresar(String numero, String operador)
    {
        if(operador == "=")
        {
            sA = sR;  sB = numero; sOO = sO;
            sR = calcular();
            sO = "";
        }else if (sO == "" )
        {
            sA = numero; sO = operador; sR = numero;
        }else
        {
            sA = sR;  sB = numero;
            sR = calcular();
            sOO = sO;
            sO = operador;
        }
        return this;
    }
    public String calcular()
    {
        Float fa = (Float) Float.parseFloat(sA.replace(',', '.'));
        Float fb = (Float) Float.parseFloat(sB.replace(',', '.'));
        Float fr = (Float) Float.parseFloat(sR.replace(',', '.'));
        switch (this.sO){
            case "+" : fr = fa + fb;
                break;
            case "-" : fr = fa - fb;
                break;
            case "*" : fr = fa * fb;
                break;
            case "/" : fr = fa / fb;
                break;
        }
        // return String.format("%012.2f",fr);
        return String.format("%04.2f",fr);
    }
    public void limpiar()
    {
        sR = "0";
        sA = "0";
        sO = "";
        sB = "0";
        sOO = "";
    }
    @Override
    public String toString()
    {
        return this.sA + " " + this.sOO + " " + this.sB + " = " + this.sR + " " + this.sO;
    }
}
