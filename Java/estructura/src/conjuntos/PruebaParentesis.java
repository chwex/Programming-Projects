package conjuntos;
import java.util.*;

public class PruebaParentesis {
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Proporcione la expresion a validar");
		String expresion = entrada.nextLine();
		
		// pila para guardar parentesis de apertura
		Stack<Character> pila = new Stack<Character>();
		
		boolean error = false;
		
		//procesar la cadena
		for(int i=0; i<expresion.length(); i++)
		{
			char c = expresion.charAt(i);
			if(c=='{' || c=='[' || c=='(')
				pila.push(c);
			else if(c=='}' || c==']' || c==')')
			{
				char temporal;
				try
				{
					temporal = pila.pop();
				}
				catch(EmptyStackException e)
				{
					error=true;
					break;
				}
				
				//comparar si el de apertura es igual al de cierre
				boolean correcto = (c=='}' && temporal=='{') ||
						           (c==']' && temporal=='[') ||
						           (c==')' && temporal=='(');
				
				if(!correcto)
				{
					error = true;
					break;
				}
			}
		}
		
		//validar que la pila este vacia
		if(!pila.empty())
			error=true;
		
		//mostrar resultados
		if(error)
			System.out.println("error dentro de la expresion");
		else
			System.out.println("La expresion es correcta");
	}

}
