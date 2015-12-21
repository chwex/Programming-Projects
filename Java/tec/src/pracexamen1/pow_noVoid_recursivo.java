package pracexamen1;

import paq1.Leer;

public class pow_noVoid_recursivo 
{

	public static int pow(int base, int potencia)
	{
		int res=1;
		
		if(potencia==0)
		{
			res=1;
		}
		else
		{
			res=base*pow(base,potencia-1);
		}
		
		return res;
	}
	
	public static void main(String[] args) 
	{
	System.out.println("Teclea la base: ");
	int base = Leer.datoInt();
	System.out.println("Teclea la potencia: ");
	int potencia = Leer.datoInt();
	
	System.out.println("El valor de "+base+"^"+potencia+" es: "+pow(base,potencia));
	}

}
