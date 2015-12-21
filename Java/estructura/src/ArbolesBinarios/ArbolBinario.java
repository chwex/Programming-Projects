package ArbolesBinarios;

import java.util.Iterator;

import ListaConjuntos.ListaDesordenada;
import ListaConjuntos.ListaEnlazada;

public class ArbolBinario<T> implements TDAArbolBinario<T>
{

	protected NodoArbol<T> raiz;
	protected int contador;
	
	//constructores
	public ArbolBinario()
	{
		raiz=null;
		contador=0;
	}
	public ArbolBinario(T e)
	{
		//Raiz sera igual una variable de tipoNodoArbol genirca T 
		//La cual le manda como argumento e para inicializar el
		//constructor de nodoArbol
		raiz= new NodoArbol<T> (e);
		contador=1;
	}
	
	public ArbolBinario(T e, ArbolBinario<T> i, ArbolBinario<T> d)
	{
		raiz= new NodoArbol<T>(e);
		contador=1;
		if(i!=null)
		{
			raiz.setIzquierdo(i.getRaiz());
			contador=contador+i.size();
		}
		if(d!=null)
		{
			raiz.setDerecho(d.getRaiz());
			contador=contador+d.size();
		}
	}
	
	//Metodos Especiales predifinidos
	public NodoArbol<T> getRaiz()
	{
			return raiz;
	}
	
	public void removeLeftsubtee()
	{
		if(getRaiz().getIzquierdo()!=null)
		{
			contador=contador-1-getRaiz().getIzquierdo().numeroDeHijos();
			getRaiz().setIzquierdo(null);
		}
	}
	
	
	public void removeRightsubtree()
	{
		if(getRaiz().getDerecho()!=null)
		{
			contador=contador-1-getRaiz().getDerecho().numeroDeHijos();
			getRaiz().setDerecho(null);
		}
	}
	
	public void removeAllelements()
	{
		raiz=null;
		contador=0;
	}
	
	public boolean isEmpty()
	{
		return size()==0;
	}
	
	public int size()
	{
		return contador;
	}
	
	public boolean contains (T e)
	{
		if (isEmpty())
		return false;
			
		boolean encontrado = false;
		Iterator<T> iterator=iteratorInorden();
		while(iterator.hasNext())
		{
			T temporal = iterator.next();// Aqui puede producirse un error ya que es 
										// con hasNext segun el apunte	
			if(temporal.equals(e))
			{
				encontrado=true;
				break;
			}
		}
		return encontrado;
		
	}
	
	public String ToString()
	{
		String resultado=" ";
		Iterator<T> iterator=iteratorInorden();
		while(iterator.hasNext())
			resultado=resultado+iterator.next().toString()+"\n";
		return resultado;
	}
	
	//Iteradores
	//PreOrden
	public Iterator<T> iteratorPreorden()
	{
		ListaDesordenada<T> lista = new ListaDesordenada<T>();
		preOrden(getRaiz(), lista);
		return lista.iterator();
	}
	
	public void preOrden(NodoArbol<T> r, ListaDesordenada<T> l)
	{
		if (r!=null)
		{
			l.addToRear(r.getElemento());
			preOrden(r.getIzquierdo(),l);
			preOrden(r.getDerecho(),l);
		}
		
	}
	//InORden
	public Iterator<T> iteratorInorden()
	{
		ListaDesordenada<T> lista = new ListaDesordenada<T>();
		inOrden(getRaiz(), lista);
		return lista.iterator();
	}
	
	public void inOrden(NodoArbol<T> r, ListaDesordenada<T> l)
	{
		if (r!=null)
		{
		
			inOrden(r.getIzquierdo(),l);
			inOrden(r.getDerecho(),l);
			l.addToRear(r.getElemento());
		}
		
	}
	
	//Postorden
	public Iterator<T> iteratorPostorden()
	{
		ListaDesordenada<T> lista = new ListaDesordenada<T>();
		postOrden(getRaiz(), lista);
		return lista.iterator();
	}
	
	public void postOrden(NodoArbol<T> r, ListaDesordenada<T> l)
	{
		if (r!=null)
		{
		
			postOrden(r.getIzquierdo(),l);
			l.addToRear(r.getElemento());
			postOrden(r.getDerecho(),l);
		
		}
		
	}	
}
