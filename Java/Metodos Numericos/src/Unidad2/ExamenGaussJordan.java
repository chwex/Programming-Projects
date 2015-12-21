package Unidad2;

import java.util.*;
public class ExamenGaussJordan 
{
    public static void mensaje() {
        System.out.println("\t\t\tInstituto Tecnologico de Culiacan"+
                "\n\t\t\t Ing. en Sistemas Computacionales"+
                "\n\nNombre: Carlos Baudelio Valdez Salazar"+
                "\nMateria: Metodos Numericos"+
                "\nTema: Eliminacion de Gauss-Jordan"+
                "\nHorario: 11:00 - 12:00");
    }
    
    public static void descripcion() 
    {
        System.out.println("\nEste programa resuelve una matriz por el método de Gauss-Jordan. Problema:"+
                "\nUna compañía produce y vende 4 tipos de mezclas de concreto. La mezcla 1 se vende en"+
                "\n1200, la mezcla 2 en 900, la mezcla 3 en 700 y la mezcla 4 en 1500. Por necesidad el"+
                "\nadministrador desea saber si es posible subir los precios de producción de los 4 tipos"+
                "\nde mezla de concreto o despedira los empleados para mantener en funcionalidad la"+
                "\nempresa. Se contrata a un Ing. Civil para supervisar la producción de los 4 tipos de"+
                "\nrecursos: Horas-hombre, grava, arena y agua. En el siguiente cuadro se resumen las"+
                "\ncantidades necesarias para c/u de los recursos:\n\n"+
                "Mezclas\tHombres-horas\tGrava\tArena\tAgua"+
                "\nM1\t\t\t3\t\t\t20\t\t10\t\t10\nM2\t\t\t4\t\t\t25\t\t15\t\t8\nM3\t\t\t7\t\t\t40\t\t20\t\t10\nM4\t\t\t20\t\t\t50\t\t22\t\t15\n\n"+
                "Diariamente el recurso humano trabaja 504 horas y el inventario diario de material de la"+
                "\nbodega es de 1970 Kg de grava, 90 Kg de arena y 601 Lt de agua.\nUtilice el Método de "+
                "Eliminación de Gauss-Jordan para calcular cuantas mezclas de cada\ntipo se pueden realizar "+
                "por día.");
        System.out.println();
    }

    public static void imprime(double[][]matriz) {
        System.out.println();
        for (int i=0;i<matriz.length;i++) {
            for (int j=0;j<matriz[i].length;j++)
                System.out.print(matriz[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }

	public static void main(String[] args) 
	{
		Scanner leer = new Scanner(System.in);
		int orden = 0;
		
		do
		{
		System.out.println("Orden de la matriz");
		orden = leer.nextInt();
		}while(orden < 2 || orden > 10);
		
		int[]ganancias = {1200,900,700,1500};
		double[][] datos = new double[orden][orden+1];
		double[][] datosCopia = new double[orden][orden+1];
		for(int i = 0; i<orden; i++)
		{
			for(int j=0; j < orden+1; j++)
			{
				System.out.println("Introdusca el dato de la posicion: ["+(i+1)+","+(j+1)+"]");
				datos[i][j]= leer.nextDouble();
				datosCopia[i][j] = datos[i][j]; 			
			}
		}
		
		//captura de conceptos
		String[] concepto = new String[orden];
		for(int i = 0; i<orden; i++)
		{
			System.out.println("Teclee el concepto #"+i+":");
			concepto[i] = leer.next();
		}
		
		mensaje();
		descripcion();
		
		//Proceso de eliminacion
		for(int k = 0; k < orden-1; k++)
		{
			double pivote = datosCopia[k][k];
			for(int i = k+1; i<orden; i++)
			{
				double mult2 = datosCopia[i][k];
				for(int j=k; j < orden+1; j++)
				{
					datosCopia[i][j] = ((pivote*datosCopia[i][j]) - (mult2*datosCopia[k][j]));
				}
			}
		}
		
		for(int k=orden-1;k>0;k--)
		{
			double pivote = datosCopia[k][k];
			for(int i=0;i<k;i++)
			{
				double factor=(datosCopia[i][k])/pivote;
				for(int j=k;j<=orden;j++)
				{
					datosCopia[i][j] = datosCopia[i][j]-(factor*datosCopia[k][j]);
				}
			}
		}
		
		//Matriz Unitaria

        for(int k=0;k<orden;k++){
            datosCopia[k][orden] = datosCopia[k][orden] / datosCopia[k][k];
            datosCopia[k][k] = datosCopia[k][k] / datosCopia[k][k];
        }
		
		mensaje();
				
		System.out.println();
		System.out.println("Matriz Original");
		for(int i = 0; i<orden; i++)
		{
			for(int j=0; j<=orden; j++)
			{
				System.out.print(datos[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("Matriz Transformada");
		for(int i = 0; i<orden; i++)
		{
			for(int j=0; j<=orden; j++)
			{
				//System.out.print(datosCopia[i][j]+"\t");
				double total = (double)Math.round(datosCopia[i][j]*100)/100;
				System.out.print((total)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("Resultado");
		
		System.out.println();
		
	    System.out.println("\nMezcla  Produccion  Ganancias");
	    for (int i=0;i<concepto.length;i++) {
	        
	    	double totalPro = (double)Math.round(datosCopia[i][orden]*100)/100;
	    	double totalGan = (double)Math.round(ganancias[i]*100)/100;
	    	System.out.println(concepto[i]+"         "+totalPro+"      "+(totalPro*totalGan));
	        
	    }		
	    
		}
	}