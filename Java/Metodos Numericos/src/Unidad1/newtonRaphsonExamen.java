package Unidad1;
import java.util.*;
class newtonRaphsonExamen 
{
	static Vector<Double> raices = new Vector<Double>(0,1);
	public static void main(String[] args) 
	{
		encabezado();
		Scanner leer = new Scanner(System.in);
		System.out.println("Teclea el inicio del intervato (x1) ");
		double x1 = leer.nextDouble();
		System.out.println("Teclea el error: ");
		double error = leer.nextDouble();
		System.out.println("Leer el numero de calculos totales: ");
		int NC = leer.nextInt();
		double x2=0;
		
		//meterlo dendro de un ciclo
		for(double i=x1; x1<=8; x1+=.1){
			x2 = raphson(NC, error, x1);
		}
		System.out.printf("La raiz de la funcion 3x^3+2x^2+3x-2 es %1.6f",x2); // resultado final
		for (int i=0;i<raices.size();i++)
			System.out.println(raices.elementAt(i));
	}//fin de metodo
			
	public static double raphson(int NC, double error, double x1) 
	{
		int k = 1;
	    boolean tieneRaiz=false;
	    
		double funcion_x1, funcion_x2, prima_x1;
		
		encabezadoB();
		System.out.printf("NC \t     x1\t\t    F(x1) \t    F'(x1) \t     x2\t           F(x2) \t   \t\n");	
		while ((k<NC)) 
		{
			funcion_x1 = f(x1);
			prima_x1 = fPrima(x1);
			double x2 = (x1-((funcion_x1)/prima_x1));
			funcion_x2 = f(x2);
			System.out.printf("%d\t %1.6f\t %1.6f\t %1.6f\t %1.6f\t %1.6f\n",k,x1,funcion_x1,prima_x1,x2,funcion_x2);  	
			if (Math.abs(funcion_x2)<error) 
			{
				System.out.println("");
				System.out.println("La raiz se encontro en " + k+" iteraciones");
				//return x2;
				tieneRaiz=true;
				
			}	  
			if(tieneRaiz)
			{
				raices.add(x2);
				x1=x2-.1;
				tieneRaiz=false;
				return x2;
			}
			
			else{
			x1 = x2;
			}
			//funcion_x1 = funcion_x2;
			k++;		
		}
		System.out.println("La raiz no se encontro antes de las " + k + " iteraciones");
		return 0;
	 }//fin de metodo

	public static double f(double x) 
	{
		return x*Math.cos(Math.toRadians(x*x))-4;
		  //return x*Math.toDegrees(Math.cos(Math.toRadians(x*x)))-4;
	}//fin de metodo
	
	public static double fPrima(double x)
	{
		return Math.cos(Math.toRadians(x*x))-2*x*x*Math.sin(Math.toRadians(x*x));
	}// fin de metodo
			
	
	
	
	public static void encabezado()
	{				
		System.out.println("          Instituto Tecnologico de Culiacan");
		System.out.println("        Ingenieria en Sistemas Computacionales");
		System.out.println("        Alumno: Carlos Baudelio Valdez Salazar");
		System.out.println("               Materia: Métodos Numéricos");
		System.out.println("               Tema: Método Newton Raphson");
		System.out.println("                 Horario: 11:00 - 12:00");
		System.out.println();
	}	//fin de metodo
			
	public static void encabezadoB()
	{				
		System.out.println("          Instituto Tecnologico de Culiacan");
		System.out.println("        Ingenieria en Sistemas Computacionales");
		System.out.println("        Alumno: Carlos Baudelio Valdez Salazar");
		System.out.println("               Materia: Métodos Numéricos");
		System.out.println("               Tema: Método Newton Raphson");
		System.out.println();
	}	//fin de metodo
}//fin de clase