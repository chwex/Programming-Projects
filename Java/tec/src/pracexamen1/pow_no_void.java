package pracexamen1;

import paq1.Leer;

public class pow_no_void {
	public static int pow(int base, int potencia)
	{
		int res = 1;
		for(int x=1; x<=potencia; x++)
		{
			res=res*base;
		}
		
		return res;
	}
	public static void main(String[] args)
	{
		System.out.println("Teclea el numero base: ");
		int base = Leer.datoInt();
		System.out.println("Teclea el numero de potencia: ");
		int potencia = Leer.datoInt();
		
		System.out.println("El valor de "+base+"^"+potencia+" es: "+pow(base,potencia));

	}

}
