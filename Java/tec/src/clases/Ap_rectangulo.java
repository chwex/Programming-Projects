package clases;

import paq1.Formatea;
import paq1.Leer;

public class Ap_rectangulo
{

	/*
	  Despliega la superficie y el perimetro del rectangulo.@param args
	*/
	public static void main(String[] args) 
	{
		double base,altura;
		
		do
		{
			System.out.print("teclea la base del rectangulo: ");
			base=Leer.datoDouble();
		}while(base<=0);
		
		do
		{
			System.out.print("teclea la altura del rectangulo: ");
			altura=Leer.datoDouble();
		}while(altura<=0);
		
		Rectangulo rect1=new Rectangulo(50,50);
		
		rect1.setBase(base);
		rect1.setAltura(altura);
		//rect1.asigna_base_altura(base, altura);
		
		System.out.println("\nDatos del rectangulo: \n");
		
		//System.out.println("Superficie = "+Formatea.alinder("##,##0.00", rect1.getBase()*rect1.getAltura()));
		//System.out.println("Perimetro  = "+Formatea.alinder("##,##0.00", 2*(rect1.getBase()+rect1.getAltura())));
		
		System.out.println("Superficie = "+Formatea.alinder("##,##0.00", rect1.sup()));
		System.out.println("Perimetro  = "+Formatea.alinder("##,##0.00", rect1.per()));
		
	}

}
