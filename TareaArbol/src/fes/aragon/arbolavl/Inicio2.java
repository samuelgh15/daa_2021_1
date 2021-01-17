package fes.aragon.arbolavl;

public class Inicio2 {
	public static void main(String[] args) {
		ArbolAVL<Integer> avl = new ArbolAVL<>();
		//Arbol 2
		avl.insertar(17);
		avl.insertar(5);
		avl.insertar(30);
		avl.insertar(2);
		avl.insertar(13);
		avl.insertar(21);
		avl.insertar(1);
		avl.insertar(40);
		int x = avl.alturaE(avl.getRaiz().getDato());
		System.out.print("Hoja del ultimo nivel: ");
		avl.nivel(avl.getRaiz(), x);
	}
}