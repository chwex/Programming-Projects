package unidad2;
import java.util.*;

public class Circulo {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		System.out.print("Teclee el numero de veces que sera lanzado el dardo: ");
		double n = in.nextInt();
		double aciertos = 0;
		
		for(int i=0;i<n;i++)
		{
			double aux = dardo();
			if(aux>=0 && aux<=1 )
				aciertos++;
		}
		
		System.out.println("Numero de aciertos: "+aciertos);
		System.out.println("El valor aproximado de PI es: "+((aciertos/n)*4));
	}

	//ESTE METODO REGRESA EL RADIO DEL LUGAR DONDE CALLO EL DARDO
	public static double dardo(){
		Random r = new Random();
		double x = (double)((r.nextInt(2000)+1)-1000)/1000;
		double y = (double)((r.nextInt(2000)+1)-1000)/1000;
		
		//double x =(int) ((Math.random() * 9000) + 1000) / 10000.0;
		//double y =(int) ((Math.random() * 9000) + 1000) / 10000.0;
		
		//System.out.println("x: "+x+" "+"y: "+y);
		//System.out.println("Hipotenusa: "+Math.sqrt( Math.pow(x,2)+Math.pow(y,2) ));
		
		return Math.sqrt( Math.pow(x,2)+Math.pow(y,2) );
	}	
}