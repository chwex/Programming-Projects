package ListaConjuntos;
public interface TDAListaDesordenada<T> extends TDALista<T> 
{
	public void addToFront(T e);
	public void addToRear(T e);
	public void addAfter(T e, T anterior);
}

