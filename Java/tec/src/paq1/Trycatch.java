package paq1;
public class Trycatch {
	public static void main(String args[]){
		
		int a,b;
		System.out.print("Teclea el valor de a: ");
		a=Leer.datoInt();
		System.out.print("Teclea el valor de b: ");
		b=Leer.datoInt();
		
		nose(a,b);
		System.out.println("Que ondas");
	}
	public static void nose(int a,int b){
	
	try{
	System.out.println("Cociente de "+a+"/"+b +" = "+(a/b));
	}
	
	catch(ArithmeticException error){
		System.out.println("Error, division por cero");
	}
	finally{
		System.out.println("Sigue el programa aunque haya o no habido una excepcion");
	}
}
	
}
