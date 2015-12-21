package pracexamen1;

import paq1.Leer;

public class pracMain {

	public static void main(String[] args) {
	
		int res=1;
		System.out.println("Teclea el numero base: ");
		int base = Leer.datoInt();
		System.out.println("Teclea el numero de potencia: ");
		int potencia = Leer.datoInt();
		
		for(int x=1; x<=potencia; x++){
			res=res*base;
		}
		
		System.out.println("El valor de "+base+"^"+potencia+" es: "+res);

	}

}
