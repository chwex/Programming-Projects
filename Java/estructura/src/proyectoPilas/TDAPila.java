package proyectoPilas;

public interface TDAPila<T>
{
	public void push(T elemento);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public int size();
	public String toString();
}
