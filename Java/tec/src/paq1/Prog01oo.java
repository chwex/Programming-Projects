package paq1;


public class Prog01oo 
{
	public static void main(String[] args)
	{
		long cuenta;
		String nombre;
		double beca;
		
	
		do
		{
			System.out.print("Teclea el numero de cuenta: ");
			cuenta=Leer.datoLong();
		}while (cuenta<=0);
		
		
		
		System.out.print("Teclea el numero nombre: ");
		nombre=Leer.dato();
		
		do
		{
			System.out.print("Teclea el importe de la beca: ");
			beca=Leer.datoDouble();
		}while (beca<0);
		
		
		Alumno al1=new Alumno();
		
		al1.setCuenta(cuenta);
		al1.setNombre(nombre);
		al1.setBeca(beca);
		
		System.out.println("\n\tDatos del Alumno\n");
		System.out.println("Cuenta: "+al1.getCuenta());
		System.out.println("Nombre: "+al1.getNombre());
		System.out.println("Beca..: "+Formatea.alinder("#,##0.000",al1.getBeca()));
		
	}

}
