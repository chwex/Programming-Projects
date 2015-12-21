package proyectoCola;


public class Nodo <T>
{
	private T elemento; 
	private Nodo <T> next;
	
	//Constructures
	public Nodo()
	{
		elemento=null;
		next=null;
	}
	
	public Nodo (T e)
	{
		elemento=e;
		next=null;
	}
	
	//Metodos set
	public void setElemento(T e)
	{
		elemento=e;
	}
	public void setNext(Nodo<T> n)
	{
		next=n;
	}
	
	//Metodos get
	public T getElemento()
	{
		return elemento;
	}
	public Nodo<T> getNext()
	{
		return next;
	}
	
}