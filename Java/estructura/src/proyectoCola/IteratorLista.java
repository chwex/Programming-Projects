package proyectoCola;

import java.util.*;

//import TDAListasDoblesEnlazadas.UnsupportedOperationException;
public class IteratorLista<T> implements Iterator<T>
{
	private ListaConjuntos.Nodo<T> actual;
	private int contador;
	
	public IteratorLista(ListaConjuntos.Nodo<T> inicio, int c)
	{
		actual= inicio;
		contador=c;
	}
	
	public boolean hasNext()
	{
		return actual!=null;
	}
	
	public T next() throws ElementoNoEncontradoException
	{
		if(!hasNext())
			throw new ElementoNoEncontradoException();
		T resultado= actual.getElemento();
		actual=actual.getNext();
		return resultado;
	}
	
	public void remove () throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	
}//Fin de la clase
