package Examen2;

import paq1.Leer;

public class Estimulo 
{

	private int [] claEst;
	private double [] importe;
	
	public Estimulo(int numEmp)
	{
		claEst=new int[numEmp];
		importe = new double[numEmp];
		
		for(int i=0; i<numEmp; i++)
		{
			System.out.println("Clave de estimulo: ");
			claEst[i]=Leer.datoInt();
			System.out.println("Importe del Estumulo:");
			importe[i]=Leer.datoDouble();
		}
	
		
	}
			
	public double getimporte(int cEst)
	{
		for(int i=0; i<claEst.length;i++)
		{
			if(claEst[i]==cEst)
				return importe[i];
		}
		return 0;
	}


}

