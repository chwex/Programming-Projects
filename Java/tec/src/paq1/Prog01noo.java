package paq1;
import java.util.*;
public class Prog01noo 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long cuenta;
		String nombre;
		double beca;
		
		Scanner leer = new Scanner(System.in);
		
		do
		{
			System.out.print("Teclea el numero de cuenta: ");
			cuenta=leer.nextLong();
		}while (cuenta<=0);
		
		System.out.print("Teclea el numero nombre: ");
		nombre=leer.next();
		
		do
		{
			System.out.print("Teclea el importe de la beca: ");
			beca=leer.nextDouble();
		}while (beca<0);
		
		System.out.println("\n\tDatos del Alumno\n");
		System.out.println("Cuenta: "+cuenta);
		System.out.println("Nombre: "+nombre);
		System.out.println("Beca..: "+beca);
		
	}

}
