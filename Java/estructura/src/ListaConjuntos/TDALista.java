package ListaConjuntos;
import java.util.Iterator;

public interface TDALista<T>
{
	public T removeFirst();
	public T removeLast();
	public T remove(T elemento);
	public T first();
	public T last();
	public boolean contains(T elemento);
	public boolean isEmpty();
	public int size();
	public Iterator<T> iterator();
	public String toString();
}



