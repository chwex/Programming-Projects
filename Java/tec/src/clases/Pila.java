package clases;
import paq1.*;
class pila
{
	private double [] datos;
	private int tope;
	private int nelem;
	
	// constructor
	public pila(int ne)
	{
		datos=new double[ne];
		tope=0;
		nelem=ne;
	}
	
	// metodos
	public void metepila(double dato)
	{
		datos[tope]=dato;
		tope++;
	}
	
	public double sacapila()
	{
		tope--;
		return datos[tope];
	}
	
	public void desppila()
	{
		for (int i=(tope-1); i>=0; i--)
			System.out.println("pila[" + (i+1) + "]="+ Formatea.alinder("###,##0.00", datos[i]));
	}
	
	public boolean pilavacia()
	{
		if (tope==0)
			return true;
		else
			return false;
	}
	
	public boolean pilallena()
	{
		if (tope==nelem)
			return true;
		else
			return false;
	}

}

