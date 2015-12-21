package pracexamen1;
import paq1.Leer;
public class pracvoid {

	public static void main(String[] args) {
		System.out.println("Teclea el numero base: ");
		int base = Leer.datoInt();
		System.out.println("Teclea el numero de potencia: ");
		int potencia = Leer.datoInt();
		
		int res = (base^potencia);
		System.out.println("El valor de "+base+"^"+potencia+" es: "+res);

	}

}
