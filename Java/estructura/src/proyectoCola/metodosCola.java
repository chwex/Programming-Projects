package proyectoCola;

import java.util.Iterator;

import ListaConjuntos.Nodo;

public class metodosCola<T> implements TDACola<T> {
		protected Nodo<T> inicio;
		protected int contador;
		
		
		
	public metodosCola()
		{
			inicio=null;
			contador=0;
		}
		
	public T first() throws ListaVaciaException
	{
		if(isEmpty())
			throw new ListaVaciaException();
		return inicio.getElemento();		
	}
	
	
	public T dequeue() throws ListaVaciaException{
		if(isEmpty())
			throw new ListaVaciaException();
		Nodo <T> temporal=inicio;
		inicio=inicio.getNext();
		contador--;
		return temporal.getElemento();
	}

	public void enqueue(T e){
		Nodo<T> nuevo=new Nodo<T>(e);
		
		if(isEmpty())
			addToFront(e);
		
		
		else{
		Nodo<T> actual= inicio;
		while (actual.getNext()!=null)
			actual=actual.getNext();
		actual.setNext(nuevo);
		contador++;
		}
	}
	public boolean isEmpty()
	{
		return contador==0;
	}
	
	public int size()
	{
		return contador;
	}
	
	public void addToFront(T e)
	{
		Nodo<T> nuevo = new Nodo<T>(e);
		nuevo.setNext(inicio);
		inicio=nuevo;
		contador++;
	}
	
	public String toString()
	{
		String resultado="";
		Nodo<T> actual=inicio;
		while(actual!=null)
		{
			resultado=resultado+actual.getElemento().toString();
			actual=actual.getNext();
		}
		
		return resultado;
	}
	
	public String toStringClave()
	{
		String resultado="";
		Nodo<T> actual=inicio;
		while(actual!=null)
		{
			resultado=resultado+actual.getElemento().toString()+" ";
			actual=actual.getNext();
		}
		
		return resultado;
	}
	
	public Iterator<T> iterator()
	{
		return new IteratorLista<T>(inicio,contador);
	}
	
}
