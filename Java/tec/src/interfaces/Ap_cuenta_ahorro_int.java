package interfaces;

import paq1.Formatea;
import paq1.Leer;

public class Ap_cuenta_ahorro_int 
{
	public static void main(String [] args)
	  {
		String cuenta;
        String nombre;
        double saldo;
        double tasa;
        double cuota;
        do
        {
        	System.out.print("Teclea el numero de cuenta: ");
        	cuenta=Leer.dato();
        }while (Long.parseLong(cuenta)<1);
        
        System.out.print("Teclea el nombre: ");
        nombre=Leer.dato();
        
        do
        {
        	System.out.print("Teclea el saldo inicial: ");
        	saldo=Leer.datoDouble();
        }while (saldo<0);
        
        do
        {
        	System.out.print("Teclea la tasa de interes anual: ");
        	tasa=Leer.datoDouble();
        }while (tasa<0);

        do
        {
        	System.out.print("Teclea cuota de mantenimiento: ");
        	cuota=Leer.datoDouble();
        }while (cuota<0);

		
		  
		  Cuenta_Ahorro_int cliente01=new Cuenta_Ahorro_int(cuota,cuenta,nombre,saldo, tasa);
		  
		  cliente01.deposito(1000000);
	      System.out.println("\t\tEstado de cuenta del cliente: ");
	      System.out.println();
	      
	      System.out.println("\tNombre: "+ cliente01.getNombre());
	      System.out.println("\tCuenta: "+ cliente01.getCuenta());
	      System.out.println("\tSaldo Inicial........: "+ Formatea.alinder("##,###,###,##0.00",cliente01.saldo()));
	     // System.out.println("\tC.Mto.........: "+ Formatea.alinder("##,###,###,##0.00",cliente01.obtenerCuotaMant()));
	      System.out.println("\tComisiones...........: "+ Formatea.alinder("##,###,###,##0.00",cliente01.comisiones()));
	      System.out.println("\tSaldo con comisiones.: "+ Formatea.alinder("##,###,###,##0.00",cliente01.saldo()));
	      System.out.println("\tIntereses............: "+ Formatea.alinder("##,###,###,##0.00",cliente01.intereses()));
	      System.out.println("\tSaldo Actual.........: "+ Formatea.alinder("##,###,###,##0.00",cliente01.saldo()));
	      		
	  }

}
