package Recursividad;

import paq1.Leer;

public class Factorial_rec_void {
	static long fact;
	static int contador=0;
	public static void factorial(int x)
	{
		if((x==0)||(x==1))
		{
			
			fact=1;
			if(x==0)
			{
				contador=0;
			}
			else
			{
				contador++;
			}
		}
		else
		{
			contador++;
			factorial(x-1);
			fact=fact*x;
		}
		if(contador==x){
			contador=0;
			System.out.print("Factorial de "+x+" = "+fact);
		}
		
		
		
	}
	public static void main(String[] args) {
		
		int x;
		do
		{
			System.out.println("Teclea el numero: ");
			x=Leer.datoInt();
		}while(x<0);
		factorial(x);

	}

}
