package herencia;

public class Conversion_implicita
{
	
	// Esto funciona porque obtiene_cuenta() y saldo() son metodos heredados en Cuenta_cheques  de Ccuenta y
	// porque los metodos que pueden ejecutarse son los de la variable cliente del tipo Ccuenta
	// no de la referencia al objeto Cuenta_cheques.
	
	/*
	public static void main(String[] args)
	{
		String nom;
		Ccuenta cliente;
		Cuenta_cheques cliente01=new Cuenta_cheques(10,1,"1234567890","Cliente01",10000,12);
		cliente=cliente01;
		String cuenta=cliente.getCuenta();
	
		double saldo=cliente.saldo();
		nom=cliente.getNombre();
		
		System.out.println("Cuenta= "+cuenta+"\n"+"Saldo.: "+saldo);
		System.out.println("Nombre= "+nom);
	}
	
	*/
	
	// Esto funciona porque obtiene_nombre() es metodo de Ccuenta y
	// porque los metodos que pueden ejecutarse son los de la variable cliente del tipo Ccuenta
	// no de la referencia al objeto Cuenta_cheques y Cuenta_ahorro
	
	/*
	public static void main(String[] args)
	{	
		Ccuenta cliente;
		
		Cuenta_cheques cliente01=new Cuenta_cheques(10,1,"1234567891","Cliente01",10000,12);
		Cuenta_ahorro cliente02=new Cuenta_ahorro(50.00,"1234567892","Cliente02",20000,12);
		
		cliente=cliente01;
		String nombre1=cliente.getNombre();
		System.out.println("Nombre= "+nombre1);

		cliente=cliente02;
		String nombre2=cliente.getNombre();
		System.out.println("Nombre= "+nombre2);

	}
	*/
	
	
	// Esto no funciona por lo indicado abajo
	
	/*
	public static void main(String[] args)
	{
		Ccuenta cliente;
		
		Cuenta_cheques cliente01=new Cuenta_cheques(10,1,"1234567891","Cliente01",10000,12);
		Cuenta_ahorro cliente02=new Cuenta_ahorro(50.00,"1234567892","Cliente02",20000,12);
		
		cliente=cliente01;
		double impTransaccion=cliente.asignar_importexTransaccion(10); // Error: asignarimportePorTrans(1.0) 
																   //        no es metodo de cuenta
		cliente=cliente02;
		double transExentas=cliente.asignar_cuotaMantenimiento(50); 	   // Error: asignartransExentas(6)
																   //        no es metodo de cuenta
	}
	*/
	
	
	public static void main(String[] args)
	{
		// Esto funciona porque intereses() esta definido en la superclase y redefinido en las subclases

		Ccuenta cliente;
		
		Cuenta_cheques cliente01=new Cuenta_cheques(10,0,"Cliente01","1234567891",10000,12);
		Cuenta_ahorro cliente02=new Cuenta_ahorro(50.00,"Cliente02","1234567892",10000,12);
		
		double intereses;
		cliente=cliente01;
		intereses=cliente.intereses();					// Se ejecuta Cuenta_cheques.intereses() 
		System.out.println("Intereses= "+intereses);

		cliente=cliente02;
		intereses=cliente.intereses(); 
		System.out.println("Intereses= "+intereses);    // Se ejecuta Cuenta_ahorro.intereses()
	
	}
	
	
}
