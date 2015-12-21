package ArbolesBinarios;

public class NodoArbol <T>
{
	private T elemento;
	private NodoArbol<T> izquierdo;
	private NodoArbol<T> derecho;
	
	//constructures
	public NodoArbol(T e)
	{
		elemento=e;
		izquierdo=null;
		derecho=null;
	}
	
	//Elementos set
	public void setElemento(T e)
	{
		elemento=e;
	}
	
	public void setIzquierdo(NodoArbol<T> i)
	{
		izquierdo=i;
	}
	
	public void setDerecho(NodoArbol<T> d)
	{
		derecho=d;
	}
	
	//Metodos get
	public  T getElemento()
	{
		return elemento;
	}
	
	public NodoArbol<T> getIzquierdo()
	{
		return izquierdo;
	}
	
	public NodoArbol<T> getDerecho()
	{
		return derecho;
	}
	
	//Metodos especiales
	public int numeroDeHijos()
	{
		//podemos observar los metodos recursivos
		int hijos=0;
		if(getIzquierdo()!=null)
			hijos=hijos+1+getIzquierdo().numeroDeHijos();
		if(getDerecho()!=null)
			hijos=hijos+1+getDerecho().numeroDeHijos();
		
		return hijos;
	}	
}//Fina de la clase
