package paq1;

public class Repitevoid {
	
	public static void Repite(char C, int x){
		System.out.println("Caracter "+C);
		
		for(int i=1; i<=x; i++)
			System.out.print(C);
			System.out.println();
		
	}
	
	
	
	public static void main(String[]args){
		Repite('&',15);
		Repite('g',30);
	}
}
