package matrices;
import paq1.Formatea;
import paq1.Leer;
public class Ap_Matricial {
	
		public static void main(String[] args) {
			int n = 0, m=0, l=0;
			double mat1[][];
			double mat2[][];
			double mat3[][];
			do
			{
				System.out.println("Numero de renglones de la primera: ");
				m = Leer.datoInt();
			}while(m<=0);
			
			do
			{
				System.out.println("Numero de columnas de la segunda: ");
				n = Leer.datoInt();
			}while(n<=0);
			
			do
			{
				System.out.println("Numero de columnas de la primera o renglones de la segunda: ");
				l = Leer.datoInt();
			}while(l<=0);

			mat1=new double[m][l];
			mat2=new double[l][n];
			mat3=new double[m][n];
			
			
			System.out.println("\nTeclea los valores de la primera matriz: \n");
			Cmatriz.leeMat(mat1);
			
			System.out.println("\nTeclea los valores de la segunda matriz: \n");
			Cmatriz.leeMat(mat2);
			
			//Cmatriz.sumaMatricial(mat1, mat2, mat3);
			Cmatriz.multMatricial(mat1, mat2, mat3);
			
			System.out.println("\nPrimera Matriz Leida: \n");
			Cmatriz.despMat(mat1);
			
			System.out.println("\nSegunda Matriz Leida: \n");
			Cmatriz.despMat(mat2);
			
			System.out.println("\nMatriz Producto: \n");
			Cmatriz.despMat(mat3);
			

		}
}