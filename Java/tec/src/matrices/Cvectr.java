package matrices;
import paq1.Formatea;
import paq1.Leer;

public class Cvectr
{
	public static void leeVec(double v[])
	{
		for(int i=0; i<v.length; i++)
		{
			System.out.print("v["+(i+1)+"]: ");
			v[i]=Leer.datoDouble();
		}
	}
	
	public static void despVec(double v[])
	{
		for(int i=0; i<v.length; i++)
		{		
			System.out.print(Formatea.alinder("####0.00",v[i]));
			if((i+1)%10==0){
				System.out.println();
		}
			
		}
		System.out.println();
	}
	
	public static double[] LeeVec(double v[])
	{
		double v1[]=new double[v.length];
		for(int i=0; i<v.length; i++)
		{
			System.out.print("v["+(i+1)+"]: ");
			v1[i]=Leer.datoDouble();
		}
		return v1;
	}
	
	public static double sumVec(double v[])
	{
		double suma=0;
		for(int i=0; i<v.length; i++)		
			suma=suma+v[i];
		
		return suma;
	}
	
	public static double promVec(double v[])
	{	
		return sumVec(v)/v.length;
	}
	
	public static double mayVec(double v[])
	{
		double mayor=v[0];
		for(int i=0; i<v.length; i++)		
			if(v[i]>mayor)
			mayor=v[i];
		
		return mayor;
	}
	
	public static void ordVec(double v[])
	{
		double temp=0;
		for(int i=0; i<v.length-1; i++)
			for(int j=i+1; j<v.length-1; j++)
				if(v[i]>v[j])
				{
					temp=v[i];
					v[i]=v[j];
					v[j]=v[i];
					v[j]=temp;
					
				}
		
		}

	
public static boolean busqueda_binaria(double m[],double eb)
{
	int p=0;
	int u=m.length-1;
	int j;
	
	while(p<=u)
	{
		j=(int)((p+u)/2);
		if(eb<m[j])
			u=j-1;
		else
			if(eb>m[j])
				p=j+1;
			else
				return true;
	}
	return false;
}
}
