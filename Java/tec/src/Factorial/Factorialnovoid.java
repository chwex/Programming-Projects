package Factorial;
import paq1.Leer;
public class Factorialnovoid {

	public static long Factorial(int n){
		long fact=1;
		for(int i=1; i<=n; i++)
			fact=fact*i;
		return fact;
	}
	
	public static void main(String[] args) {
	
		int n;
		do{
			System.out.println("Ingresa el valor de n: ");
			n=Leer.datoInt();
		}while(n<0);
		
		System.out.println(n+"!="+Factorial(n));
	
		
	}

}
