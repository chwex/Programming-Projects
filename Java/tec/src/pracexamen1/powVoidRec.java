package pracexamen1;

import paq1.Leer;

public class powVoidRec 
{

	static int banp=1, bann=0;
	static double x;
	public static void potencia(double n, int pot)
	{
		
			if (pot==1)
				x=n;
			else
			{
				if(pot==0)
					x=1;
				if(pot>0)
				{
					banp++;
					potencia(n, pot-1);
					x = n*x;
				}
				if(pot<0)
				{
					bann--;
					potencia(n, pot+1);
					x = n*x;
				}
			}
			if(banp==pot || bann==pot){
				if (pot<0)
					x=1/x;
				System.out.println("El numero "+n+" elevado a "+pot+" = "+x);
			}		
		}
	
	public static void main(String[] args) 
	{
		double n;
		int pot;
		System.out.print("Que valor quieres elevar a una potencia? ");
		n = Leer.datoDouble();
		System.out.print("A que potencia quieres elevar el numero "+n+" ? ");
		pot = Leer.datoInt();
		
		potencia(n, pot);
	}

}
