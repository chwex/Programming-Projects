package Unidad1;

public class metodoSecanteFinal {

	public static void main(String[] args) {
		encabezado();
		double error = 1e-4; //error=0.0001
	    double x1=-4 , x2 =2; // intervalos x1=-4 & x2=2
	    int NC = 24; // Total de calculos: 24
	    double x3 = secante(NC, error, x1, x2);
	    System.out.printf("La raiz de la funcion x^3+2x^2-10 es %1.6f",x3 ); // resultado final
	}//fin de metodo
	
	public static double secante(int NC, double error, double x1, double x2) 
	{
	    int k = 1;
	   
	    while ((k<NC)) 
	    {
	    	double x3 = (x1-((x1-x2)*(f(x1)))/(f(x1)-f(x2)));
	    	System.out.printf("%d\t %1.6f\t %1.6f\t %1.6f\t %1.6f\t %1.6f\t %1.6f\n",k,x1,x2,x3,f(x1),f(x2),f(x3));
	    	
	    	if (Math.abs(f(x3))<error) 
	    	{
	    		System.out.println("");
	    		System.out.println("La raiz se encontro en " + k+" iteraciones");
	    		return x3;
	    	}
		    
	    	x1 = x2;
	    	x2 = x3;
	    	k++;
	    }
	    System.out.println("La raiz no se encontro antes de las " + k + " iteraciones");
	    return 0;
	}//fin de metodo

	public static double f(double x) 
	{
		return (x*x*x)+(2*x*x)-10;
    }//fin de metodo
	
	public static void encabezado()
	{
		
		System.out.println("          Instituto Tecnologico de Culiacan");
		System.out.println("        Nombre: Carlos Baudelio Valdez Salazar");
		System.out.println("               Materia: Métodos Numéricos");
		System.out.println("               Tema: Método de la Secante");
		System.out.println("                 Horario: 11:00 - 12:00");
		System.out.println();
		System.out.printf("NC \t     x1\t\t    x2 \t\t    x3 \t\t     F(x1)\t    F(x2) \t   F(x3) \t\n");	
	}	//fin de metodo
}//fin de clase