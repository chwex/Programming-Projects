package clases;
import paq1.*;
public class Ap_fecha 
{
	
	
	public static void main(String[] args)
	{
		
		int mes;
		int dia;
		int a�o;
		System.out.print("Teclea el dia ");
		dia=Leer.datoInt();	
		System.out.print("Teclea el mes ");
		mes=Leer.datoInt();	
		System.out.print("Teclea el a�o ");
		a�o=Leer.datoInt();	
		
	  System.out.println("Prueba Clase Fecha...");
	  Fecha fecha=new Fecha(dia,mes);
	  //Fecha fecha1=new Fecha(fecha);
      System.out.println("Fecha solicitada "+fecha.obtenerF());
	}

}
