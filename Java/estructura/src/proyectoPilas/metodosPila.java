package proyectoPilas;
import java.util.*;
public class metodosPila<T> implements TDAPila<T> 
{
	int contador=0;
	private static int CAPACIDAD = 10;
	private T[] elementos;
	
	public metodosPila()
	{
		this(CAPACIDAD);
	}

	public metodosPila(int tam) 
	{
		if(tam<=0)
			tam=CAPACIDAD;
		elementos=(T[]) new Object[tam]; 
		contador=0;
	}
	
	public void push(T elemento)
	{
		if(CAPACIDAD==elementos.length)
			//CAPACIDAD = CAPACIDAD + 10;
			Expandercapacidad();
		elementos[contador]=elemento;
		contador++;
	}

	public T pop() throws PilaVaciaException
	{
		if(isEmpty())
			throw new PilaVaciaException();
		T ultimo = elementos[contador-1];
		elementos[contador-1] = null;
		contador--;
		return ultimo;
	}
	
	public T peek() throws PilaVaciaException
	{
		if(isEmpty())
			throw new PilaVaciaException();
		return elementos[contador-1];
	}
	
	public boolean isEmpty()
	{
		return size()==0;
	}
	
	public int size()
	{
		return elementos.length;
	}
	
	public String toString()
	{
		String pila = "";
		for (int i=(contador-1); i>=0; i--)
			pila=pila+elementos[i]+"\n";
		return pila;	
	}
	
	public void Expandercapacidad()
	{
		T[]auxiliar=(T[])new Object [size()*2];
		for(int i=0; i <size();i++)
			auxiliar[i]=elementos[i];
		elementos=auxiliar;
	}
}