package pracexamen1;

import paq1.Leer;

public class metodoNorm
{
	static int res=1;
	public static void pow(int base, int potencia)
	{
		for(int x=1; x<=potencia; x++)
		{
			res=res*base;
		}
		
		System.out.println("El valor de "+base+"^"+potencia+" es: "+res);
	}
	public static void main(String[] args) 
	{
		System.out.println("Teclea el numero base: ");
		int base = Leer.datoInt();
		System.out.println("Teclea el numero de potencia: ");
		int potencia = Leer.datoInt();
		pow(base,potencia);
		

	}

}
