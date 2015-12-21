package examenes;

import paq1.Leer;

public class Exa1_2
{

    static double promedio=0;
    static double suma=1;
    //static double prom=0;
    static int c=0, p=0;
    public static double promedio(int x)
    {
    	/*
    	if (n>1)
    		prom(n-1);	
    	
    	suma=suma+n;
    	promedio=suma/n;
    	return promedio;
    	*/
    	if (x==1)
    		return p/c;
    	else
    	{
	    	p=p+x;
	    	c++;
	    	promedio(x-1);
    	}
	    return p/c;
    	
    	
    }
	
	public static void main(String[] args)
	{
		int n;
		do
		{
			System.out.print("Teclea un numero positivo mayor que cero: ");
			n=Leer.datoInt();
		}while(n<=0);
		System.out.println("El promedio es : "+promedio(n));
	}	
	
	

}
