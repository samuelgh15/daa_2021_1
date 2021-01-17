package fes.aragon.arbolavl;

/**
 * La clase nodo representa los que tiene una lista elazada simple
 * 
 * @author Samuel González Hernández
 * @version 21/08/2019/1.0
 * @param <T>
 *            recibe el parametro generico del nodo
 */
public class NodoGenerico<T> {
	private T dato;
	private NodoGenerico<T> siguiente;

	/**
	 * Contructor que crea un nodo
	 * 
	 * @param dato
	 *            recibe el parametro generico del nodo
	 */
	public NodoGenerico(T dato) {
		super();
		this.dato = dato;
		this.siguiente = null;
	}

	/**
	 * Metodo que sive para obtener el tipo de dato generico
	 * 
	 * @return el tipo de dato generico del nodo
	 */
	public T getDato() {
		return dato;
	}

	/**
	 * Metodo que cambia el dato generico del nodo
	 * 
	 * @param dato
	 *            recibe el parametro generico del nodo
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Metodo que obtiene la direccion de memoria del nodo siguiente
	 * 
	 * @return el dato del nodo siguiente
	 */
	public NodoGenerico<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * Metodo que modifica el valor generico del siguiente
	 * 
	 * @param siguiente
	 *            recibe el parametro generico del nodo
	 */
	public void setSiguiente(NodoGenerico<T> siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Metodo que devuelve el dato en tipo cadena
	 */
	public String toString() {
		return this.dato + "";
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public boolean comparaMenor(Object obj) {
		boolean resultado = false;
		if (dato instanceof Integer) {
			Integer dat1 = (Integer) dato;
			Integer dat2 = (Integer) obj;
			resultado = dat1 < dat2;
		} else if (dato instanceof Float) {
			Float dat1 = (Float) dato;
			Float dat2 = (Float) obj;
			resultado = dat1 < dat2;
		} else if (dato instanceof Double) {
			Double dat1 = (Double) dato;
			Double dat2 = (Double) obj;
			resultado = dat1 < dat2;
		}
		return resultado;
	}

	public boolean comparaMayorIgual(Object obj) {
		boolean resultado = false;
		if (dato instanceof Integer) {
			Integer dat1 = (Integer) dato;
			Integer dat2 = (Integer) obj;
			resultado = dat1 >= dat2;
		} else if (dato instanceof Float) {
			Float dat1 = (Float) dato;
			Float dat2 = (Float) obj;
			resultado = dat1 >= dat2;
		} else if (dato instanceof Double) {
			Double dat1 = (Double) dato;
			Double dat2 = (Double) obj;
			resultado = dat1 >= dat2;
		}
		return resultado;
	}
}