package unidad2;
import java.util.*;

public class NumerosAleatorios {
	Random r = new Random();

	public static void main(String []args){
		NumerosAleatorios a = new NumerosAleatorios();
		int cont = 2;
		double n = a.random();
		double n2= a.random();
		double aux;
		double seRepite;
		System.out.println(n+"\n"+n2);
		while(true){
			cont++;
			aux = a.random();
			System.out.println(aux);
			if(aux==n){
				System.out.println("Se ha repetido la semilla: "+n+"\nNumero de Iteraciones: "+cont);
				seRepite=a.random();
				if(n2==seRepite)
				{
					System.out.println("El algoritmo se repite");
					break;
				}
				else
				{
					System.out.println("El algoritmo no se repite");
					break;
				}
				
			}
		}
	}
	public double random(){
		//return Double.parseDouble("0."+r.nextInt(10000));
		return (int) ((Math.random() * 9000) + 1000) / 10000.0;
	}
}
