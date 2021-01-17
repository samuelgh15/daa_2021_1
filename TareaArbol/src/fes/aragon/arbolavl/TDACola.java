package fes.aragon.arbolavl;

/**
 * Representa el tipo de dato abstracto de una cola
 * 
 * @author Samuel González Hernández
 * @version 28/08/2019 1.0
 * @param <T>
 *            Recibe el parametro generico
 */
public class TDACola<T> {
	TDAListaSimpleGenerica<T> cola = new TDAListaSimpleGenerica<>();

	/**
	 * Es el contructor de la clase
	 */
	public TDACola() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que borra toda la pila
	 */
	public void borrar() {
		cola = new TDAListaSimpleGenerica<>();
	}

	/**
	 * Crea un nodo al final y le asigna un dato
	 * 
	 * @param dato
	 *            recibe el parametro generico del nodo
	 */
	public void insertar(T dato) {
		this.cola.insertarCola(dato);
	}

	/**
	 * Elimina el ultimo nodo y lo muestra
	 * 
	 * @return El dato generico del ultimo nodo
	 */
	public T sacar() {
		return this.cola.eliminarCabeza();
	}

	/**
	 * Metodo que evalua si la cola enlazada esta vacia
	 * 
	 * @return un boolean true en caso de ser vacia o false en caso contrario
	 */
	public boolean esVacio() {
		return this.cola.esVacia();
	}

	/**
	 * Metodo que muestra lo que tiene el ultimo nodo
	 * 
	 * @return El dato generico del primer nodo
	 */
	public T verAbajo() {
		T dato = this.cola.eliminarCabeza();
		cola.insertarCabeza(dato);
		return dato;
	}
}