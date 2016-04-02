package utn.curso.mar71n.censotransito;

/**
 * Created by Usuario on 2/4/2016.
 */
public class Contador {
    private Integer total;
    private Integer paso;
    public Contador(){
        total = 0;
        paso = 1;
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
