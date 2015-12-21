package clases;

import paq1.Leer;

public class Ap_calculadora 
{

	/**
	 * @param args
	 */
	public static int menu()
	{
		int opc;
		do
		{
			System.out.println("1.- Sumar");
			System.out.println("2.- Restar");
			System.out.println("3.- Multiplicar");
			System.out.println("4.- Dividir");
			System.out.println("5.- Salir");
			System.out.print("\nSeleccione su opción: ");
			opc=Leer.datoInt();
		}while(opc<1 || opc>5);
		return opc;
		
	}
	
	public static void main(String [] args)
	{
		double dato1;
		double dato2;
		double res;
		int operacion;
		
		Calculadora cal=new Calculadora();
		
		do
		{
			operacion=menu();
			if (operacion!=5)
			{
				System.out.print("Teclea el dato1 ( Enter, resultado abterior ): ");
				dato1=Leer.datoDouble();
				if (Double.isNaN(dato1))
					dato1=cal.getRes();
				
				System.out.print("Teclea el dato2 ( Enter, resultado abterior ): ");
				dato2=Leer.datoDouble();
				if (Double.isNaN(dato2))
					dato2=cal.getRes();
				
				cal.setOperando1(dato1);
				cal.setOperando2(dato2);
				
				switch (operacion)
				{
					case 1: System.out.println("Suma= "+ cal.sumar());
					        break;
					case 2: System.out.println("Resta= "+ cal.restar());
			                break;
					case 3: System.out.println("Multiplicar= "+ cal.multiplicar());
			                break;
					case 4: System.out.println("Dividir= "+ cal.dividir());
			                break;
				        
				}
				
			}
			else
			{
				System.out.println("hasta la vista babe...");
				break;
			}
		}while (true);
	}
	
	/*
	public static void main(String [] args)
	{
		Ap_calculadora ap=new Ap_calculadora();
		Calculadora calc2=new Calculadora(ap);
	}
	*/

}
