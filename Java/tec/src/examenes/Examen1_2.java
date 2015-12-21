package examenes;

import paq1.Leer;

public class Examen1_2 
{
	static double promedio=0;
	static double suma=0;
	
	public static double prom(int n)
	{
		if(n==1)
		{
			suma=n;
			return 1;
		}
		
		else
			prom(n-1);
		suma=suma+n;
		promedio=suma/n;
		return promedio;
	}
	public static void main(String[] args) 
	{
		int n;
		do
		{
			System.out.println("Teclea un numero positivo mayor a cero");
			n=Leer.datoInt();
		}while(n<=0);
		System.out.println("El promedio es: "+prom(n));
	}

}
