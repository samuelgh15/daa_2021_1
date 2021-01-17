package fes.aragon.arbolavl;

/**
 * Clase que representa los nodos de un arbol avl
 * 
 * @author Samuel González Hernández
 * @param <T>
 *            recibe el parametro generico del nodo
 */
public class NodoAVL<T> {
	private T dato;
	private NodoAVL<T> hijoIzq;
	private NodoAVL<T> hijoDer;
	private int altura;
	private int fe;

	/**
	 * Constructor del nodo
	 * 
	 * @param dato
	 *            recibe el dato
	 */
	public NodoAVL(T dato) {
		super();
		this.fe = 0;
		this.dato = dato;
		this.hijoIzq = null;
		this.hijoDer = null;
	}

	/**
	 * Metodo que obtiene la altura
	 * 
	 * @return la altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * Metodo que modifica la altura
	 * 
	 * @param altura
	 *            recibe la altura a modificar
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * Metodo que obtiene el factor de equilibrio del arbol
	 * 
	 * @return el factor de equilibrio
	 */
	public int getFe() {
		return fe;
	}

	/**
	 * Metodo que modifica el factor de equilibrio del arbol
	 * 
	 * @param fe
	 *            el factor de equilibrio a modificar
	 */
	public void setFe(int fe) {
		this.fe = fe;
	}

	/**
	 * Metodo que obtiene el dato
	 * 
	 * @return el dato
	 */
	public T getDato() {
		return dato;
	}

	/**
	 * Metodo que modifica el dato
	 * 
	 * @param dato
	 *            recibe el dato a modificar
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Metodo que obtiene el hijo izquierdo
	 * 
	 * @return el hijo izquierdo
	 */
	public NodoAVL<T> getHijoIzq() {
		return hijoIzq;
	}

	/**
	 * Metodo que modifica el hijo izquierdo
	 * 
	 * @param hijoIzq
	 *            recibe el hijo izquierdo a modificar
	 */
	public void setHijoIzq(NodoAVL<T> hijoIzq) {
		this.hijoIzq = hijoIzq;
	}

	/**
	 * Metodo que obtiene el hijo derecho
	 * 
	 * @return el hijo derecho
	 */
	public NodoAVL<T> getHijoDer() {
		return hijoDer;
	}

	/**
	 * Metodo que modifica el hijo derecho
	 * 
	 * @param hijoDer
	 *            recibe el hijo derecho a modificar
	 */
	public void setHijoDer(NodoAVL<T> hijoDer) {
		this.hijoDer = hijoDer;
	}

	/**
	 * Metodo que obtiene el menor de dos datos
	 * 
	 * @param obj
	 *            recibe el objeto principal a comparar
	 * @return cual es el menor
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
}