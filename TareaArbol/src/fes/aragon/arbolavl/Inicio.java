package fes.aragon.arbolavl;

public class Inicio {
	public static void main(String[] args) {
		ArbolAVL<Integer> avl = new ArbolAVL<>();
		//Arbol 1:
		avl.insertar(40);
		avl.insertar(13);
		avl.insertar(60);
		avl.insertar(5);
		avl.insertar(20);
		avl.insertar(77);
		avl.insertar(31);
		avl.insertar(66);
		int x = avl.alturaE(avl.getRaiz().getDato());
		System.out.print("Hoja del ultimo nivel: ");
		avl.nivel(avl.getRaiz(), x);
	}
}