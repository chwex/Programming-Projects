package herencia;
import paq1.*;
public class Ap_cuenta_ahorro 
{
	public static void main(String[] args)
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
        }while (saldo<=0);
        
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
        
       
        Cuenta_ahorro cte1=new Cuenta_ahorro(cuota,cuenta,nombre,saldo,tasa);
        
        cte1.deposito(100000);
		System.out.println("\nEstado de Cuenta:\n");
		System.out.println("Cuenta............: "+cte1.getCuenta());
		System.out.println("Nombre............:       "+cte1.getNombre());
		System.out.println("Saldo Inicial.....: "+Formatea.alinder("##,###,##0.00",cte1.saldo()));
		System.out.println("Cuota.............: "+Formatea.alinder("##,###,##0.00",cte1.getCuotaMantenimiento()));
		System.out.println("Tasa de Interes...: "+Formatea.alinder("##,###,##0.00",cte1.getTasadeinteres())+"%");
		System.out.println("Comisiones........: "+Formatea.alinder("##,###,##0.00",cte1.comisiones()));
		System.out.println("Saldo Actualizado.: "+Formatea.alinder("##,###,##0.00",cte1.saldo()));
		System.out.println("Interes:..........: "+Formatea.alinder("##,###,##0.00",cte1.intereses()));
		System.out.println("Saldo.............: "+Formatea.alinder("##,###,##0.00",cte1.saldo()));
		
		
	}

}
