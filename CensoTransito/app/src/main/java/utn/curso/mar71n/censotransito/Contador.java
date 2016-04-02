package utn.curso.mar71n.censotransito;

/**
 * Created by Usuario on 2/4/2016.
 */
public class Contador {
    private static Contador instancia = null;
    private Integer total;
    private Integer paso;
    private  Contador(){
        total = 0;
        paso = 1;
    }
    public static synchronized Contador getContador(){
        if (instancia == null){
            instancia = new Contador();
        }
        return instancia;
    }
    public void incTot(){
        total += paso;
    }
    public int getTot(){
        return total;
    }
    public void delTot(){
        total = 0;
    }
}
