package matrices;

import paq1.Leer;

public class Ap_identidad {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m=0;
		double mat[][];
		do
		{
			System.out.println("Numero de renglones y/o columnas de la matriz: ");
			m = Leer.datoInt();
		}while(m<=0);

		mat=new double[m][m];
		
		Cmatriz.mIdentidad(mat);
		System.out.println("\nMatriz Identidad generada: \n");
		Cmatriz.despMat(mat);
		
	}

}
