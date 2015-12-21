package ListaConjuntos;

public class ListaOrdenada<T> extends ListaEnlazada<T> implements TDAListaOrdenada<T>
{
	public void add(T e)
	{
		Nodo<T> nuevo = new Nodo<T>(e);
		if(inicio == null)
		{
			inicio = nuevo;
			contador ++;
			return;
		}
		Nodo<T> actual = inicio;
		Nodo<T> previo = null;
		while(actual != null)
		{
			Comparable<T> temporal = (Comparable<T>) e;
			if(temporal.compareTo(actual.getElemento())<0)
				break;
			previo = actual;
			actual.getNext();
		}
		
		if(previo == null)
		{
			//insertar inicio
			nuevo.setNext(inicio);
			inicio = nuevo;
		}
		
		else
		{
			//insertar al medio o al final
			nuevo.setNext(actual);
			previo.setNext(nuevo);
			contador++;
		}
			
	}
}
