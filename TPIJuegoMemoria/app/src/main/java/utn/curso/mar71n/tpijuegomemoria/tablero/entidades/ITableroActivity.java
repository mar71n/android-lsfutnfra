package utn.curso.mar71n.tpijuegomemoria.tablero.entidades;

import android.widget.ImageView;

/**
 * Created by mrampoldi on 29/06/2016.
 */
public interface ITableroActivity {
    public ImageView getImagen(int ni);
    public void redibujar(int position);
    public void redibujar();
    public void lanzarToast(CharSequence mensage, int duracion);
    public void clickableFAB(boolean clickable);
    public void lanzarDialogoPedirNombre();
    public void setTxtTiempo(String tiempo);
}
