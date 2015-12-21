package Recursividad;
import paq1.Leer;
public class Factorial_rec_novoid {
	static long fact=1;
	public static long Factorial(int x)
	{
		if((x==0)||(x==1))
	    	return 1;
		fact=Factorial(x-1);
		fact=fact*x;
		return fact;
		
		
	}
	
	public static void main(String[] args) {
		int x;
		do
		{
			System.out.println("Teclea el numero: ");
			x=Leer.datoInt();
		}while(x<0);
	
		System.out.print("Factorial de "+x+" = "+Factorial(x));
	}
}
