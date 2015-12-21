package Examen2;
import paq1.*;
import clases.Persona;

public class Empleado
{
	private long [] numEmpleado;
	private String [] nomEmpleado;
	private int [] claEst;
	
	public Empleado(int numEmp)
	{
		numEmpleado = new long[numEmp];
		nomEmpleado = new String[numEmp];
		claEst= new int[numEmp];
		
		for(int i=0; i<numEmp;i++)
		{
			System.out.print("Numero de Empleado...:  ");
	    	numEmpleado[i]=Leer.datoLong();
	    	System.out.print("Nombre de Empleado:  ");
	    	nomEmpleado[i]=Leer.dato();
	    	System.out.print("Clave de Estimulo.:  ");
	    	claEst[i]=Leer.datoInt();
		}       
	}
	
	public void dasplegar(Estimulo ob)
	{
		System.out.print("Clave del Empleado   Nombre                    Clave del estimulo   Importe");
		System.out.println();
		for(int i=0; i<=claEst.length; i++)
		{
			System.out.println("       "+Formatea.alinder("0000",numEmpleado[i])+"          "+nomEmpleado[i]+"        "+claEst[i]+"            "+ Formatea.alinder("##,##0.00", ob.getimporte(claEst[i])));
		}
	}
}
