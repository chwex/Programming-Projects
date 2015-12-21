package ListaConjuntos;

public class Nodo<T> 
{
	private T elemento;
	Nodo<T> next;
	
	// constructor
	public Nodo()
	{
		elemento = null;
		next = null;
	}
	
	public Nodo(T e)
	{
		elemento = e;
		next = null;
	}
	
	//Metodos Set
	public void setElemento(T e)
	{
		elemento = e;
	}
	public void setNext(Nodo<T> n)
	{
		next = n;
	}
	
	// metodos get
	public T getElemento()
	{
		return elemento;
	}
	public Nodo<T> getNext()
	{
		return next;
	}
}
