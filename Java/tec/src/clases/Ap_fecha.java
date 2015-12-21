package clases;
import paq1.*;
public class Ap_fecha 
{
	
	
	public static void main(String[] args)
	{
		
		int mes;
		int dia;
		int año;
		System.out.print("Teclea el dia ");
		dia=Leer.datoInt();	
		System.out.print("Teclea el mes ");
		mes=Leer.datoInt();	
		System.out.print("Teclea el año ");
		año=Leer.datoInt();	
		
	  System.out.println("Prueba Clase Fecha...");
	  Fecha fecha=new Fecha(dia,mes);
	  //Fecha fecha1=new Fecha(fecha);
      System.out.println("Fecha solicitada "+fecha.obtenerF());
	}

}
