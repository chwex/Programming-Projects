package matrices;

import paq1.Formatea;
import paq1.Leer;

public class Ej2 {

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
		for(int i=0; i<n; i++)
		{
			System.out.print("v["+(i+1)+"]: ");
			v[i]=Leer.datoDouble();
		}
		System.out.println("Vector leido");
		for(int i=0; i<n; i++)
		{
			
			
			
			System.out.print(Formatea.alinder("####0.00",v[i]));
			if((i+1)%10==0){
				System.out.println();
			}
			
			
			
		}
		}
			
	

}
