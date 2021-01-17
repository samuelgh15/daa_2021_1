package fes.aragon.arbolavl;

/**
 * Representa el tipo de dato abstracto de una Lista Simple
 * 
 * @author Samuel González Hernández
 * @version 21/08/2019/2.2
 * @param <T>
 *            Recibe el parametro generico
 */
public class TDAListaSimpleGenerica<T> {
	private NodoGenerico<T> cabeza;
	private NodoGenerico<T> cola;
	private int longitud;

	/**
	 * Asigna un dato null a la cabeza y cola
	 */
	public TDAListaSimpleGenerica() {
		cabeza = cola = null;
	}

	/**
	 * Crea un nodo como cabeza al inicio de la lista enlazada y le asigna un
	 * dato
	 * 
	 * @param dato
	 *            recibe el parametro generico del nodo
	 */
	public void insertarCabeza(T dato) {
		if (cabeza == null) {
			cabeza = new NodoGenerico<T>(dato);
			cola = cabeza;
		} else {
			NodoGenerico<T> tmp = new NodoGenerico<T>(dato);
			tmp.setSiguiente(cabeza);
			cabeza = tmp;
		}
		longitud++;
	}

	/**
	 * Crea un nodo como cola al final de la lista enlazada y le asigna un dato
	 * 
	 * @param dato
	 *            recibe el parametro generico del nodo
	 */
	public void insertarCola(T dato) {
		if (cabeza == null) {
			cabeza = new NodoGenerico<T>(dato);
			cola = cabeza;
		} else {
			NodoGenerico<T> tmp = new NodoGenerico<T>(dato);
			cola.setSiguiente(tmp);
			cola = tmp;
		}
		longitud++;
	}

	/**
	 * Metodo que elimina el primer nodo de la lista enlazada
	 * 
	 * @return El dato generico del nodo eliminado
	 */
	public T eliminarCabeza() {
		NodoGenerico<T> dato = null;
		if (cabeza == cola) {
			dato = cabeza;
			cabeza = cola = null;
		} else {
			dato = cabeza;
			NodoGenerico<T> tmp = cabeza.getSiguiente();
			cabeza = tmp;
		}
		longitud--;
		return dato.getDato();
	}

	/**
	 * Metodo que elimina el ultimo nodo de la lista enlazada
	 * 
	 * @return El dato generico del nodo eliminado
	 */
	public T eliminarCola() {
		NodoGenerico<T> dato = null;
		if (cabeza == cola) {
			dato = cabeza;
			cabeza = cola = null;
		} else {
			int i = 0;
			NodoGenerico<T> tmp = cabeza.getSiguiente();
			NodoGenerico<T> previo = cabeza;
			for (; i != longitud - 2; previo = tmp, tmp = tmp.getSiguiente(), i++)
				;
			cola = previo;
			dato = tmp;
			cola.setSiguiente(null);
		}
		longitud--;
		return dato.getDato();
	}

	/**
	 * Metodo que elimina el nodo con el indice recibido de la lista enlazada
	 * 
	 * @param indice
	 *            recibe el indice que se desea eliminar
	 * @return un boolean con true si es eliminado o false en el caso contrario
	 */
	public boolean eliminarIndice(int indice) {
		boolean eliminado = false;
		boolean error = this.errorIndice(indice);
		if (!error) {
			if (indice == longitud - 1) {
				eliminarCola();
				eliminado = true;
			} else if (indice == 0) {
				eliminarCabeza();
				eliminado = true;
			} else {
				int i = 0;
				NodoGenerico<T> tmp = cabeza.getSiguiente();
				NodoGenerico<T> previo = cabeza;
				for (; i != indice - 1; previo = tmp, tmp = tmp.getSiguiente(), i++)
					;
				previo.setSiguiente(tmp.getSiguiente());
				tmp.setSiguiente(null);
				longitud--;
				eliminado = true;
			}
		}
		return eliminado;
	}

	/**
	 * Metodo que elimina el nodo con el dato recibido de la lista enlazada
	 * 
	 * @param dato
	 *            recibe el dato generico que se desea eliminar
	 * @return un boolean con true si es eliminado o false en el caso contrario
	 */
	public boolean eliminarDato(T dato) {
		boolean eliminado = false;
		eliminado = this.eliminarIndice(this.obtenerIndice(dato));
		return eliminado;
	}

	/**
	 * Metodo que obtiene el indice del nodo
	 * 
	 * @param dato
	 *            recibe el dato generico que se desea obtener
	 * @return un entero que es el indice del nodo
	 */
	public int obtenerIndice(T dato) {
		int indice = -1;
		if (this.cabeza != null) {
			if ((dato.equals(this.cabeza.getDato()))) {
				indice = 0;
			} else {
				NodoGenerico<T> tmp = cabeza.getSiguiente();
				int i = 1;
				for (; tmp != null && !(tmp.getDato().equals(dato)); tmp = tmp
						.getSiguiente(), i++)
					;
				if (tmp != null) {
					indice = i;
				}
			}
		}
		return indice;
	}

	/**
	 * Metodo que obtiene el dato del nodo
	 * 
	 * @param indice
	 *            recibe el indice que se desea obtener
	 * @return el dato generico buscado
	 */
	public T obtenerDato(int indice) {
		boolean error = this.errorIndice(indice);
		NodoGenerico<T> tmp = null;
		if (!error) {
			int i = 0;
			for (tmp = cabeza; i != indice; tmp = tmp.getSiguiente(), i++)
				;
		}
		if (tmp != null) {
			return tmp.getDato();
		} else {
			return null;
		}
	}

	/**
	 * Metodo que evalua si la lista enlazada esta vacia
	 * 
	 * @return un boolean true en caso de ser vacia o false en caso contrario
	 */
	public boolean esVacia() {
		return cabeza == null;
	}

	/**
	 * Metodo que muestra todos los datos de la lista enlazada
	 */
	public void mostrarDatos() {
		for (NodoGenerico<T> tmp = cabeza; tmp != null; tmp = tmp
				.getSiguiente()) {
			System.out.println(tmp.toString());
		}
	}

	/**
	 * Metodo que obtiene la longitud de la lista enlazada
	 * 
	 * @return un entero con la longitud
	 */
	public int getLongitud() {
		return longitud;
	}

	/**
	 * Metodo que evalua el indice introducido para verificar que exista
	 * 
	 * @param indice
	 *            entero del indice deseado
	 * @return un boolean true en caso de que exista o false en caso contrario
	 */
	public boolean errorIndice(int indice) {
		boolean error = false;
		if (indice < 0 || indice >= longitud) {
			error = true;
		}
		return error;
	}

	/**
	 * Metodo que obtiene el nodo deseado
	 * 
	 * @param indice
	 *            recibe el indice del nodo
	 * @return el nodo en la posicion desdeada
	 */
	public NodoGenerico<T> obtenerNodo(int indice) {
		boolean error = this.errorIndice(indice);
		NodoGenerico<T> tmp = null;
		if (!error) {
			int i = 0;
			for (tmp = cabeza; i != indice; tmp = tmp.getSiguiente(), i++)
				;
		}
		if (tmp != null) {
			return tmp;
		} else {
			return null;
		}
	}
}