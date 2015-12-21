package herencia;

import paq1.*;
import clases.*;
public class Ap_cuenta_cheques
{
	public static void main(String[] args)
	{
        String cuenta;
        String nombre;
        double saldo;
        double tasa;
        double impxTransaccion;
        int tranExentas;
        
        
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
        	System.out.print("Teclea el importe por transaccion: ");
        	impxTransaccion=Leer.datoDouble();
        }while (impxTransaccion<0);
        
        do
        {
        	System.out.print("Teclea transacciones exentas: ");
        	tranExentas=Leer.datoInt();
        }while (tranExentas<0);
        

        
        Cuenta_cheques cte1=new Cuenta_cheques(impxTransaccion,tranExentas,cuenta,nombre,saldo,tasa);
		
		cte1.deposito(100);
		Fecha fecha=new Fecha();
		System.out.println("\nEstado de Cuenta al :"+ fecha.obtenerF()+"\n");
		System.out.println("Cuenta..............: "+cte1.getCuenta());
		System.out.println("Nombre..............:       "+cte1.getNombre());
		System.out.println("Saldo anterior......: "+Formatea.alinder("##,###,##0.00",cte1.saldo()));
		System.out.println("Imp. x Transac......: "+Formatea.alinder("##,###,##0.00",cte1.getImportexTransaccion()));
		System.out.println("Trans. Exentas......: "+Formatea.alinder("##,###,##0.00",cte1.getTransaccionesExentas()));
		System.out.println("Tasa de Interes.....: "+Formatea.alinder("##,###,##0.00",cte1.getTasadeinteres()));
		System.out.println("Saldo sin comisiones: "+Formatea.alinder("##,###,##0.00",cte1.saldo()));
		System.out.println("Comisiones..........: "+Formatea.alinder("##,###,##0.00",cte1.comisiones()));
		System.out.println("Saldo con comisiones: "+Formatea.alinder("##,###,##0.00",cte1.saldo()));
		System.out.println("Interes:............: "+Formatea.alinder("##,###,##0.00",cte1.intereses()));
		System.out.println("Saldo...............: "+Formatea.alinder("##,###,##0.00",cte1.saldo()));
		
		
	}

}
