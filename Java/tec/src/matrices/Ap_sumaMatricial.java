package matrices;

import paq1.Formatea;
import paq1.Leer;

public class Ap_sumaMatricial {

	public static void main(String[] args) {
		int n = 0, m=0;
		double mat1[][];
		double mat2[][];
		double mat3[][];
		do
		{
			System.out.println("Numero de renglones de las dos matrices: ");
			m = Leer.datoInt();
		}while(m<=0);
		
		do
		{
			System.out.println("Numero de columnas de las dos matrices: ");
			n = Leer.datoInt();
		}while(n<=0);

		mat1=new double[m][n];
		mat2=new double[m][n];
		mat3=new double[m][n];
		
		
		System.out.println("\nTeclea los valores de la primera matriz: \n");
		Cmatriz.leeMat(mat1);
		
		System.out.println("\nTeclea los valores de la segunda matriz: \n");
		Cmatriz.leeMat(mat2);
		
		//Cmatriz.sumaMatricial(mat1, mat2, mat3);
		mat3=Cmatriz.sumaMatricial(mat1, mat2);
		
		System.out.println("\nPrimera Matriz Leida: \n");
		Cmatriz.despMat(mat1);
		
		System.out.println("\nSegunda Matriz Leida: \n");
		Cmatriz.despMat(mat2);
		
		System.out.println("\nMatriz Suma: \n");
		Cmatriz.despMat(mat3);
		

	}

}
