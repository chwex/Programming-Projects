package Unidad2;
import java.util.*;
public class eliminacionGauss 
{
    public static void mensaje() {
        System.out.println("\t\t\tInstituto Tecnológico de Culiacán"+
                "\n\t\t\t Ing. en Sistemas Computacionales"+
                "\n\nNombre: Carlos Baudelio Valdez Salazar"+
                "\nMateria: Métodos Numéricos"+
                "\nTema: Eliminación de Gauss"+
                "\nHorario: 11:00 - 12:00");
    }
    
    public static void descripcion() 
    {
        System.out.println("\n\nEste programa resuelve una matriz por el método de Gauss. Problema:"+
                "\nUna empresa produce tres productos: A, B y C, los que procesa en"+
                "\ntres maquinas: M1, M2 y M3. El tiempo en horas requerido para procesar"+
                "\nuna unidad de cada producto por las tres máquinas esta dado por lo siguiente:"+
                "");
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
		
		//regresion
		 double[] vector = new double[orden];
	        for (int i = orden - 1; i >= 0; i--) 
	        {
	            double adicion = 0.0;
	            for (int j = i + 1; j < orden; j++) {
	                adicion += datosCopia[i][j] * vector[j];
	            }
	            vector[i] = (datosCopia[i][orden] - adicion) / datosCopia[i][i];
	        }
	
		//desplegar matrices
	    System.out.println("Matriz Original");
	    for(int i=0; i<orden; i++)
		{
			for(int j=0; j < orden+1; j++)		
				System.out.print(datos[i][j]+"     ");	
			System.out.println();
		}
	    
	    System.out.println();
	    System.out.println("Matriz Transformada");
		for(int i=0; i<orden; i++)
		{
			for(int j=0; j < orden+1; j++)		
				System.out.print(datosCopia[i][j]+"     ");	
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//impresion de valores de x
		for(int i=0; i<orden; i++)
		{
			System.out.print(concepto[i]+" = ");
			System.out.println(vector[i]);
		}	
		}
	}