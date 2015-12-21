package proyectoPilas;
import java.util.*;
public class APposfija 
{
	public static void main(String[] args) 
	{
		Scanner leer = new Scanner(System.in);
		System.out.println("Insertar expresion aritmetica posfija con espacios entre caracteres");
		String cadena = leer.nextLine();
		posfija(cadena);
	}
	public static void posfija(String cadena)
	{
		TDAPila<String> cad = new metodosPila<String>();
		StringTokenizer st = new StringTokenizer(cadena);
		do
		{
			String tok= st.nextToken();
			if(!(tok.equals("+") || tok.equals("-") || tok.equals("*") || tok.equals("/")))
			{
				cad.push(tok);
			}
			if(tok.equals("+") || tok.equals("-") || tok.equals("*") || tok.equals("/"))
			{
				if(cad.peek()==null)
				{
					System.out.println("Expresion esta incorrecta");
					break;
				}
				String var2 = cad.pop();
				if(cad.peek()==null)
				{
					System.out.println("Expresion esta incorrecta");
					break;
				}			
				String var1 = cad.pop();
				double resultado = 0;				
				switch (tok)
				{
				case "+":resultado=(Double.parseDouble(var1))+(Double.parseDouble(var2));break;
				case "-":resultado=(Double.parseDouble(var1))-(Double.parseDouble(var2));break;
				case "*":resultado=(Double.parseDouble(var1))*(Double.parseDouble(var2));break;
				case "/":resultado=(Double.parseDouble(var1))/(Double.parseDouble(var2));break;
				}
				cad.push(String.valueOf(resultado));			
			}
			
		//System.out.println(cad.toString());		
	}while(st.hasMoreElements());
		if(cad.peek()!=null)
			System.out.println("El resultado de la expresion posfija es : "+cad.pop());
		System.out.println();
}
}
