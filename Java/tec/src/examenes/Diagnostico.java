package examenes;
import java.util.*;
public class Diagnostico 
{
	public static void genmat(double a[][])
	{
		int n=0;
		for (int i=0;i<a.length;i++)
			for (int j=0;j<a[0].length; j++)
			{
				n++;
				a[i][j]=n;
			}
	}
	
	public static void main(String[] args)
	{
	   int m,n;
	   double a[][];
	   Scanner leer=new Scanner(System.in);
	   do 
	   {
		   System.out.print("Teclea numero de renglones: ");
		   m=leer.nextInt();
	   }while(m<=0);
	   
	   do 
	   {
		   System.out.print("Teclea numero de columnas: ");
		   n=leer.nextInt();
	   }while(m<=0);
	   
	   a = new double [m][n];
	   
	   for (int i=0;i<a.length;i++)
	   {
			for (int j=0;j<a[0].length; j++)
			{
				System.out.print("a["+(i+1)+"]["+(j+1)+"] ");
				a[i][j]=leer.nextDouble();
			}
			
	   }
	   genmat(a);
	   
	   System.out.println("\nMatriz generada: \n");
	   for (int i=0;i<a.length;i++)
	   {
			for (int j=0;j<a[0].length; j++)
				System.out.print(a[i][j]+"  ");
			System.out.println();
			
	   }
	   
	}

}
