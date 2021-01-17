package fes.aragon.arbolavl;

/**
 * La clase arbol binario representa el tipo de dato abstracto de un arbol avl
 * 
 * @author Samuel González Hernández
 * @param <T>
 *            Recibe el parametro generico
 */
public class ArbolAVL<T> {
	private NodoAVL<T> raiz;

	/**
	 * Contructor
	 */
	public ArbolAVL() {
		raiz = null;
	}

	/**
	 * Inserta un nodo en el arbol
	 * 
	 * @param dato
	 *            recibe el dato a insertar
	 */
	public void insertar(T dato) {
		raiz = insert(dato, raiz);
		raiz = balanceo(raiz.getHijoDer(), raiz.getHijoIzq());
	}

	/**
	 * Obtiene la altura de un nodo
	 * 
	 * @param n
	 *            recibe el nodo
	 * @return la altura
	 */
	public int altura(NodoAVL<T> n) {
		if (n == null) {
			return -1;
		} else {
			return n.getAltura();
		}
	}

	/**
	 * Metodo que realiza la rotacion izquierda de un arbol desequilibrado
	 * 
	 * @param n
	 *            recibe el nodo del que se va a rotar
	 * @return el nodo rotado
	 */
	public NodoAVL<T> rotarIzq(NodoAVL<T> n) {
		NodoAVL<T> aux = n.getHijoIzq();
		n.setHijoIzq(aux.getHijoDer());
		aux.setHijoDer(n);
		n.setFe(Math.max(obtenerFE(n.getHijoIzq()), obtenerFE(n.getHijoDer())) + 1);
		aux.setFe(Math.max(obtenerFE(aux.getHijoIzq()),
				obtenerFE(aux.getHijoDer())) + 1);
		return aux;
	}

	/**
	 * Metodo que realiza la rotacion derecha de un arbol desequilibrado
	 * 
	 * @param n
	 *            recibe el nodo del que se va a rotar
	 * @return el nodo rotado
	 */
	public NodoAVL<T> rotarDer(NodoAVL<T> n) {
		NodoAVL<T> aux = n.getHijoDer();
		n.setHijoDer(aux.getHijoIzq());
		aux.setHijoIzq(n);
		n.setFe(Math.max(obtenerFE(n.getHijoIzq()), obtenerFE(n.getHijoDer())) + 1);
		aux.setFe(Math.max(obtenerFE(aux.getHijoIzq()),
				obtenerFE(aux.getHijoDer())) + 1);
		return aux;
	}

	/**
	 * Metodo que realiza la rotacion doble izquierda de un arbol desequilibrado
	 * 
	 * @param n
	 *            recibe el nodo del que se va a rotar
	 * @return el nodo rotado
	 */
	public NodoAVL<T> rotacionDobleIzq(NodoAVL<T> n) {
		NodoAVL<T> aux;
		n.setHijoIzq(rotarDer(n.getHijoIzq()));
		aux = rotarIzq(n);
		return aux;
	}

	/**
	 * Metodo que realiza la rotacion doble derecha de un arbol desequilibrado
	 * 
	 * @param n
	 *            recibe el nodo del que se va a rotar
	 * @return el nodo rotado
	 */
	public NodoAVL<T> rotacionDobleDer(NodoAVL<T> n) {
		NodoAVL<T> aux;
		n.setHijoDer(rotarIzq(n.getHijoDer()));
		aux = rotarDer(n);
		return aux;
	}

	/**
	 * Metodo que inserta un nodo al arbol y lo equilibra de ser necesario
	 * 
	 * @param dato
	 *            recibe el dato a insertar
	 * @param n
	 *            recibe el nodo a insertar
	 * @return el nodo a insertar
	 */
	public NodoAVL<T> insert(T dato, NodoAVL<T> n) {
		if (n == null) {
			n = new NodoAVL<>(dato);
		} else if (!n.comparaMenor(dato) && n.getDato() != dato) {
			n.setHijoIzq(insert(dato, n.getHijoIzq()));
			if (altura(n.getHijoIzq()) - altura(n.getHijoDer()) == 2) {
				if (n.getHijoIzq().comparaMenor(dato)) {
					n = rotarIzq(n);
				} else {
					n = rotacionDobleIzq(n);
				}
			}
		} else if (n.comparaMenor(dato) && n.getDato() != dato) {
			n.setHijoDer(insert(dato, n.getHijoDer()));
			if (altura(n.getHijoDer()) - altura(n.getHijoIzq()) == 2) {
				if (n.getHijoDer().comparaMenor(dato)) {
					n = rotarDer(n);
				} else {
					n = rotacionDobleDer(n);
				}
			}
		} else {
			System.out.println("Dato ya ingresado: " + dato);
		}
		n.setAltura(Math.max(altura(n.getHijoIzq()), altura(n.getHijoDer())) + 1);
		return n;
	}

	/**
	 * Metodo que obtiene la raiz del arbol
	 * 
	 * @return la raiz
	 */
	public NodoAVL<T> getRaiz() {
		return raiz;
	}

	/**
	 * Metodo que muestra todos los nodos del arbol por niveles
	 */
	public void recAmplitud() {
		NodoAVL<T> n = raiz;
		TDACola<NodoAVL<T>> cola = new TDACola<>();
		if (n != null) {
			cola.insertar(raiz);
			while (!cola.esVacio()) {
				n = cola.sacar();
				System.out.println(n.getDato());
				if (n.getHijoIzq() != null) {
					cola.insertar(n.getHijoIzq());
				}
				if (n.getHijoDer() != null) {
					cola.insertar(n.getHijoDer());
				}
			}
		}
	}

	/**
	 * Metodo que elimina un nodo y lo equilibra de ser necesario
	 * 
	 * @param dato
	 *            recibe el dato a eliminar
	 */
	public void eliminar(T dato) {
		NodoAVL<T> tmp, nodo, n = raiz, previo = null;
		while (n != null && n.getDato() != dato) {
			previo = n;
			if (n.comparaMenor(dato)) {
				n = n.getHijoDer();
			} else {
				n = n.getHijoIzq();
			}
		}
		nodo = n;
		if (n != null && n.getDato() == dato) {
			if (nodo.getHijoDer() == null) {
				nodo = nodo.getHijoIzq();
			} else if (nodo.getHijoIzq() == null) {
				nodo = nodo.getHijoDer();
			} else {
				tmp = nodo.getHijoIzq();
				while (tmp.getHijoDer() != null) {
					tmp = tmp.getHijoDer();
				}
				tmp.setHijoDer(nodo.getHijoDer());
				nodo = nodo.getHijoIzq();
			}
			if (n == raiz) {
				raiz = nodo;
			} else if (previo.getHijoIzq() == n) {
				previo.setHijoIzq(nodo);
			} else {
				previo.setHijoDer(nodo);
			}
		} else if (raiz != null) {
			System.out.println("No se encuentra dato " + dato);
		} else {
			System.out.println("Arbol vacio");
		}
		raiz = balanceo(raiz.getHijoDer(), raiz.getHijoIzq());
	}

	/**
	 * Metodo que checa las diferencias en las alturas de dos hijos y hace la
	 * rotacion adecuada
	 * 
	 * @param n
	 *            recibe el hijo izquierdo de la raiz
	 * @param n2
	 *            recibe el hijo derecho de la raiz
	 * @return la raiz del arbol rotado
	 */
	public NodoAVL<T> balanceo(NodoAVL<T> n, NodoAVL<T> n2) {
		NodoAVL<T> aux = raiz;
		if (n != null && n2 != null) {
			if (alturaE(n.getDato()) - alturaE(n2.getDato()) >= 2) {
				if (n2.getHijoIzq().getAltura() >= n2.getHijoDer().getAltura()) {
					aux = rotarDer(aux);
				} else {
					aux = rotacionDobleDer(aux);
				}
			} else if (alturaE(n2.getDato()) - alturaE(n.getDato()) >= 2) {
				if (n.getHijoDer().getAltura() >= n.getHijoIzq().getAltura()) {
					aux = rotarIzq(aux);
				} else {
					aux = rotacionDobleIzq(aux);
				}
			}
		}
		return aux;
	}

	/**
	 * Obtiene la altura de un nodo
	 * 
	 * @param dato
	 *            recibe el dato del nodo
	 * @return la altura
	 */
	public int alturaE(T dato) {
		NodoAVL<T> n = raiz;
		while (!(n.getDato().equals(dato))) {
			if (n.comparaMenor(dato)) {
				n = n.getHijoDer();

			} else if (!n.comparaMenor(dato)) {
				n = n.getHijoIzq();
			}
		}
		return alturaDos(n);
	}

	/**
	 * Trabaja en conjunto con altura
	 * 
	 * @param n
	 *            recibe el nodo deseado
	 * @return regresa la altura mayor
	 */
	public int alturaDos(NodoAVL<T> n) {
		int altIzq, altDer;
		if (n == null) {
			return -1;
		} else {
			altIzq = alturaDos(n.getHijoIzq());
			altDer = alturaDos(n.getHijoDer());
		}
		if (altIzq > altDer) {
			return altIzq + 1;
		} else {
			return altDer + 1;
		}
	}

	/**
	 * Metodo que muestra los nodos de un nivel del arbol
	 * 
	 * @param n
	 *            recibe el nodo raiz del arbol
	 * @param nivel
	 *            recibe el nivel deseado
	 */
	public void nivel(NodoAVL<T> n, int nivel) {
		if (n == null) {
			return;
		}
		if (nivel == 0) {
			System.out.println(n.getDato() + " ");
		} else {
			nivel(n.getHijoIzq(), nivel - 1);
			nivel(n.getHijoDer(), nivel - 1);
		}
	}

	/**
	 * Metodo que obtiene el factor de equilibrio
	 * 
	 * @param n
	 *            recibe el nodo del que se quiere saber su equilibrio
	 * @return el factor de equilibrio
	 */
	public int obtenerFE(NodoAVL<T> n) {
		if (n == null) {
			return -1;
		} else {
			return n.getFe();
		}
	}
}