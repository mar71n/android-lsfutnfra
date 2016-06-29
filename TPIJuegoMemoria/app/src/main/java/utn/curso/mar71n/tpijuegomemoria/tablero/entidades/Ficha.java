package utn.curso.mar71n.tpijuegomemoria.tablero.entidades;

public class Ficha {

	public static final boolean TAPADA = true;
	public static final boolean DESTAPADA = false;
	
	private boolean estado;
	private int imagen;
	private boolean clickable;
	
	public Ficha(boolean estado, int imagen)
	{
		setEstado(estado);
		setImagen(imagen);
		clickable = false;
	}
	
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getImagen() {
		return imagen;
	}
	public void setImagen(int imagen) {
		this.imagen = imagen;
	}
	public boolean isClickable() {
		return clickable;
	}
	public void setClickable(boolean clickable) {
		this.clickable = clickable;
	}
}
