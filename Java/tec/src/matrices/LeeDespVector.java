package matrices;

import paq1.Leer;

public class LeeDespVector 
{
	public static void main(String[] args) 
	{
		int n=0;
		double v[];
		do
		{
			System.out.println("Numero de elemenos del vector: ");
			n = Leer.datoInt();
		}while(n<=0);

		v=new double[n];
		System.out.println("\nTeclea los valores del vector: \n");
		System.out.println("\nMetodo no void: \n");
		//Cvectr.leeVec(v); metodo tipo void
		
		v=Cvectr.LeeVec(v);
		System.out.println("\nVector Leido: \n");
		Cvectr.despVec(v);

	}

}
