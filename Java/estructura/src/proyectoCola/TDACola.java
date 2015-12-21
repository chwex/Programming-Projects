package proyectoCola;

public interface TDACola<T> 
{
	public void enqueue(T elemento);
	public T dequeue();
	public T first();
	public boolean isEmpty();
	public int size();
	public String toString();
}
