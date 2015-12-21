package clases;

import paq1.Formatea;
import paq1.Leer;

public class Ap_pila 
{
	public static int menu()
	{
		int opc;
		do
		{
			System.out.println();
			System.out.println("\t0.- Salir del menu");
			System.out.println("\t1.- Mete un dato a la pila");
			System.out.println("\t2.- Saca un dato de la pila");
			System.out.println("\t3.- Despliega la pila");
			System.out.println();
			System.out.print("\tSeleccione su opcion:");
			opc=Leer.datoInt();	
		}while (opc<0 || opc>3);
		
		return opc;

	}
	
	public static void main(String [] args)
	{
		int n;
		int opc;
		String sigue; 
		
		do
		{
			System.out.print("Numero de elementos de la pila: ");
			n=Leer.datoInt();
		}while (n<1);
		
		pila opila=new pila(n);
		
		do
		{
			opc=menu();
			if (opc==0)
			{
				System.out.println("Hasta la vista....");
				break;
			}
			
			switch (opc)
			{
			   case 1:  double valor;
				    	if (opila.pilallena())
					    {
						   System.out.println("La pila esta llena, no se pueden meter mas datos..");
						   System.out.println("Oprima un Enter para continuar...");
						   sigue=Leer.dato();
					    }
				    	else
				    	{
				    		System.out.println("Valor a introducir a la pila: ");
				    		valor=Leer.datoDouble();
				    		opila.metepila(valor);
				    	}
				    	break;
				    	
			   case 2:  
		    	        if (opila.pilavacia())
				           System.out.println("La pila esta vacia, no se pueden sacar mas datos..");
		    	        else
		    		       System.out.println("Valor sacado: "+Formatea.alinder("###,##0.00", opila.sacapila()));
		    	       
		    	        System.out.println("Oprima un Enter para continuar...");
				        sigue=Leer.dato();
		    		    break;
		    		    
			   case 3:
				   		if (opila.pilavacia())
				           System.out.println("La pila esta vacia, no se pueden desplegar datos..");
		    	        else
		    		       opila.desppila();
		    	       
		    	        System.out.println("Oprima un Enter para continuar...");
				        sigue=Leer.dato();
		    		    break;
				   		
		    	
			}
			
		}while(true);
			
	}
}
