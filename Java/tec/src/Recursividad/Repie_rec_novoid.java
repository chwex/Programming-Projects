package Recursividad;

public class Repie_rec_novoid {

	static String cadena;
	public static String repite(String c, int n){
		if(n==1){
			cadena=c;
			return cadena;
		}
		cadena=repite(c,n-1);
		cadena = cadena+c;
		return cadena;
	}
	public static void main(String[] args) {
	
		System.out.println(repite("$",10));
		System.out.println(repite("*",20));

	}

}
