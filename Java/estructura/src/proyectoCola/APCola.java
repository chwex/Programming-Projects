package proyectoCola;

import java.util.*;
public class APCola 
{
	public static void main(String [] args)
	{
		
		metodosCola<Integer> clave = new metodosCola<Integer>();
		metodosCola<Character> mensaje = new metodosCola<Character>();
		metodosCola<Integer> aux = new metodosCola<Integer>();
		metodosCola<Character> auxcaracter = new metodosCola<Character>();
		
		Scanner leer = new Scanner(System.in);
		System.out.println("Teclear mensaje a cifrar");
		String mensaje1 = leer.nextLine();
		
		System.out.println("Cuantas claves?");
		int cantidad = leer.nextInt();
		int [] clv = new int[cantidad];
		
		for(int i=0; i<clv.length; i++)
		{
			System.out.println("Teclear clave");
			int numero = leer.nextInt();
			clv[i] = numero;
		}
		
		for(int i = 0; i<mensaje1.length(); i++)
		{
			char c = mensaje1.charAt(i);
			mensaje.enqueue(c);
		}		
		
		for(int i = 0; i<clv.length; i++)
		{
			clave.enqueue(clv[i]);
		}
		
		int resultadoSum=0;
		Iterator<Character> it1 = mensaje.iterator(); 
		Iterator<Integer> it2 = clave.iterator();
		
		while(it1.hasNext())
		{
			resultadoSum = it1.next()+it2.next();					
			char resultado2 = (char) resultadoSum;	
			aux.enqueue(resultadoSum);
			auxcaracter.enqueue(resultado2);
			
			if(!it2.hasNext())
			{
				Iterator<Integer> it3 = clave.iterator();
				it2 = it3;
			}
		}
		
		Iterator<Character> iter1 = auxcaracter.iterator();
		Iterator<Integer> iter2 = clave.iterator();
		int resultadoRes = 0;
		String res = "";
		
		while(iter1.hasNext())
		{
			resultadoRes= iter1.next()-iter2.next();		
			res = (res + (char) resultadoRes);
			
			if(!iter2.hasNext())
			{
				Iterator<Integer> iter3 = clave.iterator();
				iter2 = iter3;
			}
		}
		
		System.out.println("Mensaje Tecleado");
		System.out.println(mensaje1);
		System.out.println();
		System.out.println("Claves a Usar");
		System.out.println(clave.toStringClave());
		System.out.println("\n");
		System.out.println("Mensaje Cifrado");
		System.out.println(auxcaracter.toString());
		System.out.println();
		System.out.println("Mensaje Decifrado");
		System.out.println(res);
		}
}