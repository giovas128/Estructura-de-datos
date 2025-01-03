package Arbol;

public class Nodo{
	int valor;
	Nodo izq;
	Nodo der;

	public Nodo(int valor){
		this.valor = valor;
		this.izq = null;
		this.der = null;
	}
}