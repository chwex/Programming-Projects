package examen1;
import paq1.Leer;
public class ex1 {
	public static void cad(int num)
	{
		if(num>0)
		{
			cad(num-1);
		if(num%2!=0)
		{
			
			System.out.println();
			
		}
		else
		
			System.out.println(num);
			
		}
		
		}
	

	public static void main(String[] args) {
		int num=0;
		do
		{
			System.out.println("Teclea un numero entero positivo mayor");
		    num = Leer.datoInt();
		}while(num<=0);
		cad(num);
	}

}
