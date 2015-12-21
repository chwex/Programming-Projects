package Julio;
import paq1.Leer;
public class Ap_agendacompleta
{
//	esta es la agenda completa con las opciones adicionales que son ordenar, desplegar e imprimir
	public static int menu()
	{
		System.out.print("\n\n");
		System.out.println("1.- Buscar");
		System.out.println("2.- Buscar Siguiente");
		System.out.println("3.- Agregar");
		System.out.println("4.- Eliminar");
		System.out.println("5.- Ordenar");
		System.out.println("6.- Desplegar");
		System.out.println("7.- Imprimir");
		System.out.println("8.- Guardar los datos en archivos");
		System.out.println("9.- leer los datos en archivos");
		System.out.println("10.- Salir");
		System.out.println();
		System.out.print("   Opcion:   ");
		int op;
		do
			op=Leer.datoInt();
		while (op<1 || op>10);
		return op;
	}
	
	public static void main(String [] args)
	{
		// crear un objeto lista de telefonos con cero elementos
		Agendacompleta listatfnos = new Agendacompleta();
		
		int opcion=0;
		int pos=-1;
		String cadenabuscar=null;
		String nombre, direccion;
		long telefono;
		boolean eliminado;
		
		do
		{
			opcion=menu();
			switch (opcion)
			{
			case 1: // buscar
				    System.out.print("Cadena..:  ");
				    cadenabuscar=Leer.dato();
				    pos=listatfnos.buscar(cadenabuscar, 0);
				    if (pos==-1)
				    	if (listatfnos.longitud()!= 0)
				    		System.out.println("No se encontro..");
				    	else
				    		System.out.println("Agenda vacia..");
				    else
				    {
				    	System.out.println(listatfnos.obtenerValorEn(pos).getNombre());
				        System.out.println(listatfnos.obtenerValorEn(pos).getDireccion());
				        System.out.println(listatfnos.obtenerValorEn(pos).getTelefono());
				    }
				    break;
			case 2: // buscar siguiente
     			    pos=listatfnos.buscar(cadenabuscar, pos+1);
				    if (pos==-1)
				    	if (listatfnos.longitud()!= 0)
				    		System.out.println("Busqueda fallida..");
				    	else
				    		System.out.println("Lista vacia..");
				    else
				    {
				    	System.out.println(listatfnos.obtenerValorEn(pos).getNombre());
				        System.out.println(listatfnos.obtenerValorEn(pos).getDireccion());
				        System.out.println(listatfnos.obtenerValorEn(pos).getTelefono());
				    }
				    break;
				    
			case 3: // Agregar
				    System.out.print("Nombre...:  ");
				    nombre=Leer.dato();
				    System.out.print("Direccion:  ");
				    direccion=Leer.dato();
				    System.out.print("Telefono.:  ");
				    telefono=Leer.datoLong();
			        listatfnos.agregar(new PersonaC(nombre, direccion, telefono));
			        break;
			        
			case 4: // eliminar
				    System.out.print("Telefono.:  ");
			        telefono=Leer.datoLong();
			        eliminado=listatfnos.eliminar(telefono);
			        if (eliminado)
			        	System.out.println("Registro Eliminado...");
			        else
			        	if (listatfnos.longitud()!=0)
			        		System.out.println("Telefono no encontrado...");
			        	else
			        		System.out.println("Lista vacia...");
			        break;
			        
			case 5: // Ordenar
					if (listatfnos.longitud()>1)
					{
						listatfnos.ordenar();
						System.out.println("Lista ordenada");
					}
						else
						{
							System.out.println("Error: la lista esta vacía o solo tiene un registro");
							System.out.println("Agrega nas registros");
						}
					break;
			case 6: // Desplegar
			        if(listatfnos.longitud()>0)
			        {
			        	listatfnos.desplegar();	
			        }
			        	else	
			    
			        	{
			        		System.out.println("Error: la lista esta vacía");
			        	}
			        break;
			        
			case 7: // Imprimir desde mpresora los datos de la agenda
				
				if(listatfnos.longitud()>0)
			        {
			     
			        	listatfnos.imprimir();
			        }
			        	else	
			        	{
			        		System.out.println("Error: la lista esta vacía");
			        	}
			        break;
			        
			case 8: // Imprimir desde mpresora los datos de la agenda
				
				if(listatfnos.longitud()>0)
			        {
			     
			        	listatfnos.guardar();
			        }
			        	else	
			        	{
			        		System.out.println("Error: la lista esta vacía");
			        	}
			        break;     
			
			case 9: // Imprimir desde mpresora los datos de la agenda
				listatfnos.cargar();
			        break;
			case 10: // salir
			
				    System.out.print("Adios");
				    listatfnos=null;
			}
		}while (opcion!=10);
	}

}