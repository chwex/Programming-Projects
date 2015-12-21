package Pmetodos;



public class Cmetodos {


	public static double   mayor2 (double x1,double x2){
		
		if (x1>x2)
			return x1;
			else return x2;
		}
		
	
	public static String repite2(String a, int b){
		String cadena="";
		for (int i=0; i<b; i++)
			cadena=cadena+a;
			
		return cadena;
		
	}

}
