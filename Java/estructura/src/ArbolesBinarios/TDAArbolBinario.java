package ArbolesBinarios;

import java.util.Iterator;
public interface TDAArbolBinario <T>
{
	public void removeLeftsubtee();
	public void removeRightsubtree();
	public void removeAllelements();
	public boolean isEmpty();
	public int size();
	public boolean contains(T e);
	public String toString();
	public Iterator<T> iteratorPreorden();
	public Iterator<T> iteratorInorden();
	public Iterator<T> iteratorPostorden();
}
