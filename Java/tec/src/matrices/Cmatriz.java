package matrices;
import paq1.Formatea;
import paq1.Leer;
public class Cmatriz
{
	public static void leeMat(double m[][])
	{
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[i].length; j++)
		{
			System.out.print("M["+(i+1)+"]["+(j+1)+"]: ");
			m[i][j]=Leer.datoDouble();
		}
	}
	
	public static void despMat(double m[][])
	{
		for(int i=0; i<m.length; i++)
		{
			for(int j=0;j<m[i].length;j++)		
				System.out.print(Formatea.alinder("####0.00",m[i][j]));	
			System.out.println();
		
		}
		System.out.println();
	}
	
	public static double sumMat(double m[][])
	{
			
		double suma=0;
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[i].length; j++)
				suma=suma+m[i][j];
		return suma;
	}
	
	public static double proMat(double m[][])
	{
		return sumMat(m)/(m.length*m[0].length);
		
	}

	public static void mIdentidad(double m[][])
	{
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m.length; j++)
				if(i==j)
					m[i][j]=1;
	}
	
	public static double mayMat(double m[][])
	{
		double mayor;
		mayor = m[0][0];
		
		for (int i=0; i<m.length; i++)
			for (int j=0; j<m[i].length;j++)
				if (mayor < m[i][j])
					mayor=m[i][j];
		return mayor;
	}
		
	/*public static double[] LeeVec(double m[][])
	{
		double v1[]=new double[v.length];
		for(int i=0; i<v.length; i++)
		{
			System.out.print("v["+(i+1)+"]: ");
			v1[i]=Leer.datoDouble();
		}
		return v1;
	}*/
	
	public static void sumaMatricial(double a[][],double b[][],double suma[][])
	{
		for(int i=0; i<a.length; i++)
			for(int j=0; j<a[i].length; j++)
				suma[i][j]=a[i][j]+b[i][j];					
	}
	
	public static double [][] sumaMatricial(double a[][],double b[][])
	{
		double suma[][] = new double[a.length][a[0].length];
		for(int i=0; i<a.length; i++)
			for(int j=0; j<a[i].length; j++)
				suma[i][j]=a[i][j]+b[i][j];
		return suma;
	}
	
	public static void multMatricial(double a[][],double b[][],double pro[][])
	{
		for(int i=0; i<a.length; i++)
			for(int j=0; j<b[0].length; j++)
				for(int k=0; k<a[0].length; k++)
					pro[i][j]= pro[i][j]+a[i][k]*b[k][j];
	
}
	public static void matvol(double a[][])
	{
	   double matvolt[][] = new double [a.length][a[0].length];
	   for(int i=0; i<a.length; i++)
			for(int j=0; j<a[0].length; j++)
				matvolt[i][j]=a[(a.length-1)-i][(a[0].length-1)-j];
			
		despMat(matvolt);
	}
}