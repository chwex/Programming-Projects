package matrices;

import paq1.Leer;

public class matrizVolteada {

	public static void main(String[] args) {

		int n = 0, m=0;
		int med1,med2=0;
		double mat[][];
		do
		{
			System.out.println("Numero de renglones de la matriz: ");
			m = Leer.datoInt();
		}while(m<=0);
		
		do
		{
			System.out.println("Numero de columnas de la matriz: ");
			n = Leer.datoInt();
		}while(n<=0);

		mat=new double[m][n];
		
		System.out.println("\nTeclea los valores de la matriz: \n");
		Cmatriz.leeMat(mat);
		
		System.out.println("Matriz Leida");
		Cmatriz.despMat(mat);
		
		System.out.println("Matriz Volteada");
		Cmatriz.matvol(mat); 
		
	//	System.out.println(mat.length+" "+mat[0].length);
	}

}
