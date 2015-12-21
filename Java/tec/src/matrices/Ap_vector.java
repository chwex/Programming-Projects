package matrices;

import paq1.Formatea;
import paq1.Leer;

public class Ap_vector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		double v[];
		do
		{
			System.out.println("Teclea el numero de elementos del vector: ");
			n=Leer.datoInt();
		}while(n<=0);
		
		v=new double[n];
		
		Cvectr.leeVec(v);
		System.out.println("\nVecor leido: \n");
		Cvectr.despVec(v);
		System.out.println("Suma de los elementos del vector=     "+Formatea.alinder("##,##0.00", Cvectr.sumVec(v)));
		System.out.println("Promedio de los elementos del vector= "+Formatea.alinder("##,##0.00", Cvectr.promVec(v)));
		System.out.println("El mayor de los elementos del vector= "+Formatea.alinder("##,##0.00", Cvectr.mayVec(v)));
		
		Cvectr.ordVec(v);
		System.out.println("\nVecor Ordenado: \n");
		Cvectr.despVec(v);
	}

}
