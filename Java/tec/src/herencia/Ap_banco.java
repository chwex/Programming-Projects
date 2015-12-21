package herencia;

import paq1.Leer;

public class Ap_banco 
{
	public static Ccuenta leerDatos(int op)
	{
		Ccuenta obj = null;
		String nom, cuenta;
		double saldo, tasai, mant;
		System.out.print("Nombre..........: ");
		nom = Leer.dato();
		System.out.print("Cuenta..........: ");
		cuenta = Leer.dato();
		System.out.print("Saldo...........: ");
		saldo = Leer.datoDouble();
		System.out.print("Tasa de interes.: ");
		tasai = Leer.datoDouble();
		if(op == 1)
		{
			System.out.print("Mantenimiento.......: ");
			mant = Leer.datoDouble();
			obj = new Cuenta_ahorro( mant, cuenta ,nom,  saldo, tasai );
		}
		else
		{
			int transex;
			double imptrans;
			System.out.print("Importe por trnasaccion: ");
			imptrans = Leer.datoDouble();
			System.out.print("Transacciones exentas: ");
			transex = Leer.datoInt();
			
			if(op ==2)
				obj = new Cuenta_cheques(imptrans, transex,cuenta,nom, saldo ,tasai);
			else
				obj = new Cuenta_cheques_esp(imptrans, transex,cuenta,nom, saldo ,tasai);
		}
		return obj;
	}
	public static int menu()
	{
		System.out.print("\n\n");
		System.out.println("\t1. Buscar");
		System.out.println("\t2. Buscar Siguiente");
		System.out.println("\t3. Deposito");
		System.out.println("\t4. Retiro");
		System.out.println("\t5. Añadir");
		System.out.println("\t6. Eliminar");
		System.out.println("\t7. Actualizar Cuentas");
		System.out.println("\t8. Salir");
		System.out.println();
		System.out.print("\tOpcion:    ");
		int op;
		do
		{	
			op = Leer.datoInt();
		}while ( op < 1 || op > 8);
		return op;
	}
	public static void main(String args[])
	{
		// PrintStream flujoS = System.out;
		Banco banco = new Banco();
		
		int opcion = 0, pos = -1;
		String sigue;
		String cadenabuscar = null;
		String nombre, cuenta;
		double cantidad;
		boolean eliminado = false;
		
		do
		{
			opcion = menu();
			if (opcion==8)
			{
				System.out.println("Hasta la vista...");
				banco = null;
				break;
			}
			
			switch (opcion)
			{
			case 1:
				// System.out.println(banco.clienteEn(0).obtenerNombre());
				// System.out.println(banco.clienteEn(0).obtenerCuenta());
				// System.out.println(banco.clienteEn(0).estado());

				
				System.out.print("Nombre o cuenta, total o parcial ");
				cadenabuscar = Leer.dato();
				pos = banco.buscar(cadenabuscar, 0);
				if(pos == -1)
					if(banco.longitud() != 0)
						System.out.println("No se encontro");
					else
						System.out.println("No hay clientes");
				else
				{
					// System.out.println("pos= "+pos);
					
					System.out.println(banco.obtenerClienteEn(pos).getNombre());
					System.out.println(banco.obtenerClienteEn(pos).getCuenta());
					System.out.println(banco.obtenerClienteEn(pos).saldo());
				}
				
				
    	        System.out.println("Oprima un Enter para continuar...");
		        sigue=Leer.dato();
    		    break;

			case 2:
				pos = banco.buscar(cadenabuscar, pos + 1);
				if(pos == -1)
					if(banco.longitud() != 0)
						System.out.println("No se encontro");
					else
						System.out.println("No hay clientes");
				else
				{
					System.out.println(banco.obtenerClienteEn(pos).getNombre());
					System.out.println(banco.obtenerClienteEn(pos).getCuenta());
					System.out.println(banco.obtenerClienteEn(pos).saldo());
				}
				
    	        System.out.println("Oprima un Enter para continuar...");
		        sigue=Leer.dato();
				break;
			
			case 3:
			case 4:
				System.out.print("Cuenta: ");
				cuenta = Leer.dato();
				pos = banco.buscar(cuenta, 0);
				if(pos == -1)
					if(banco.longitud() != 0)
						System.out.println("No se encuentra");
					else
						System.out.println("No hay clientes");
				else
				{
					System.out.println("Saldo Anterior: "+ banco.obtenerClienteEn(pos).saldo());
					System.out.print("Cantidad: ");
					cantidad = Leer.datoDouble();
					if( opcion == 3)
						banco.obtenerClienteEn(pos).deposito(cantidad);
					else
						banco.obtenerClienteEn(pos).retiro(cantidad);
					System.out.println("Saldo Actual: "+ banco.obtenerClienteEn(pos).saldo());
				}
    	        System.out.println("Oprima un Enter para continuar...");
		        sigue=Leer.dato();
				break;

			case 5:
				System.out.print("Tipo de cuenta: 1-(CA), 2-(CC), 3-CCE  ");
				do
				{
					opcion = Leer.datoInt();
				}while( opcion < 1 || opcion > 3);
				banco.añadir(leerDatos(opcion));
				break;
			
			case 6:
				System.out.print("Cuenta: ");
				cuenta = Leer.dato();
				eliminado = banco.eliminar(cuenta);
				if(eliminado)
					System.out.println("Registro Eliminado");
				else
					if(banco.longitud() != 0)
						System.out.println("Cuenta no encontrada");
					else
						System.out.println("No hay clientes");
				break;
			
			case 7:
				for (pos = 0; pos < banco.longitud(); pos++)
				{
					System.out.println(banco.obtenerClienteEn(pos).getNombre());
					System.out.println(banco.obtenerClienteEn(pos).getCuenta());
					System.out.println("Saldo Anterior: "+banco.obtenerClienteEn(pos).saldo());
					System.out.println("Comisiones  : "+banco.obtenerClienteEn(pos).comisiones());
					System.out.println("Intereses   : "+banco.obtenerClienteEn(pos).intereses());
					System.out.println("Saldo Actual: "+banco.obtenerClienteEn(pos).saldo());
	    	        System.out.println("Oprima un Enter para ver siguiente...");
			        sigue=Leer.dato();
				}
				break;
			}
		}while(opcion != 8);
	}

}
