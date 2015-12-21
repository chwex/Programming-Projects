package ArbolesBinarios;

public class ArbolBinarioDeBusqueda<T> extends ArbolBinario<T> 
					implements TDAArbolBinarioDeBusqueda<T>
{
	//constructores
	public ArbolBinarioDeBusqueda()
	{
		super();
	}
	
	public ArbolBinarioDeBusqueda(T raiz)
	{
		super(raiz);
	}
	
	/* agrega el elemento especificado segun su valor menor
	 *  en el hijo izquierdo mayor o igual en el hijo derecho*/
	
	public void addElement(T e)
	{
		NodoArbol<T> temporal = new NodoArbol<T>(e);
		
		//preguntar si el arbol esta vacio
		if(isEmpty())
		{
			raiz = temporal;
			contador++;
			return;
		}
		
		Comparable<T> elementoComparable = (Comparable<T>) e;
		NodoArbol<T> actual = getRaiz();
		boolean agregado = false;
		while(!agregado)
		{
			if(elementoComparable.compareTo(actual.getElemento())<0)
			{
				if(actual.getIzquierdo() == null)
				{
					actual.setIzquierdo(temporal);
					agregado=true;
				}
				else
					actual = actual.getIzquierdo();
			}
			else
			{
				if(actual.getDerecho() == null)
				{
					actual.setDerecho(temporal);
					agregado = true;
				}
				else
					actual = actual .getDerecho();
			}
		}
		contador++;
	}// fin de addElement
	
	/* elimina el elemento especificado. Lanza una exepvion si el elemento noexiste.  
	 * El elemento eliminado es sustituido por el nodo devielto por el metodo promover.
	 */
	
	public T removeElement(T e) throws ElementoNoEncontradoException
	{
		if(isEmpty())
			throw new ElementoNoEncontradoException();
		
		T resultado = null;
		Comparable<T> elementoComparable = (Comparable<T>) e;
		
		//preguntar por la raiz
		if(elementoComparable.equals(getRaiz().getElemento()))
		{
			resultado = getRaiz().getElemento();
			raiz = promover(getRaiz());
			contador--;
			return resultado;
		}
		
		//cualquier otro nodo
		NodoArbol<T> padre = getRaiz();
		NodoArbol<T> actual;
		boolean encontrado = false;
		
		if(elementoComparable.compareTo(getRaiz().getElemento())<0)
			actual = getRaiz().getIzquierdo();
		else
			actual = getRaiz().getDerecho();
		
		while(actual != null && !encontrado)
		{
			if(elementoComparable.equals(actual.getElemento()))
			{
				encontrado = true;
				resultado = actual.getElemento();
				contador--;
				if(actual == padre.getIzquierdo())
					padre.setIzquierdo(promover(actual));
				else
					padre.setDerecho(promover(actual));
			}
			else
			{
				padre=actual;
				if(elementoComparable.compareTo(actual.getElemento())<0)
					actual = actual.getIzquierdo();
				else
					actual = actual.getDerecho();
			}
		}
		if(!encontrado)
			throw new ElementoNoEncontradoException();
		return resultado;				
	}//fin de removeElement
	
	/* devuelve el nodo que sustituye al eliminado cuando hay 
	 * 2 hijos regresa el que sigue en el recorrido inorden*/
	
	private NodoArbol<T> promover(NodoArbol<T> nodo)
	{
		NodoArbol<T> resultado = null;
		if(nodo.getIzquierdo()== null && nodo.getDerecho()==null)
			resultado = null;
		
		else if(nodo.getDerecho()==null)
			resultado = nodo.getIzquierdo();
		
		else if(nodo.getIzquierdo() == null)
			resultado = nodo.getDerecho();
		
		else
		{
			//tengo 2 hijos
			NodoArbol<T> actual = nodo.getDerecho();
			NodoArbol<T> padre = nodo;
			
			while(actual.getIzquierdo() != null)
			{
				padre = actual;
				actual = actual.getIzquierdo();
			}
			
			if(nodo.getDerecho() == actual)
				actual.setIzquierdo(nodo.getIzquierdo());
			else
			{
				padre.setIzquierdo(actual.getDerecho());
				actual.setDerecho(nodo.getDerecho());
				actual.setIzquierdo(nodo.getIzquierdo());
			}
			resultado = actual;
		}
		return resultado;
	}//fin promover
}// fin de clase
