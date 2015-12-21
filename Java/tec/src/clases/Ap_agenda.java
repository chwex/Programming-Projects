package clases;

import paq1.Leer;

public class Ap_agenda 
{
//	 aplicacion para trabajar con matrices de objetos
	public static int menu()
	{
		System.out.print("\n\n");
		System.out.println("1.- Buscar");
		System.out.println("2.- Buscar Siguiente");
		System.out.println("3.- Agregar");
		System.out.println("4.- Eliminar");
		System.out.println("5.- Salir");
		System.out.println();
		System.out.print("   Opcion:   ");
		int op;
		do
			op=Leer.datoInt();
		while (op<1 || op>5);
		return op;
	}
	
	public static void main(String [] args)
	{
		// crear un objeto lista de telefonos con cero elementos
		Agenda listatfnos =new Agenda();
		
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
				    // System.out.println("cad: "+cadenabuscar);
				    pos=listatfnos.buscar(cadenabuscar, 0);
				    // System.out.println("pos: "+pos);
				    if (pos==-1)
				    	if (listatfnos.longitud()!= 0)
				    		System.out.println("No se encontro..");
				    	else
				    		System.out.println("Agenda vacia..");
				    else
				    {
				    	System.out.println(listatfnos.obtenerValorEn(pos).obtenerNombre());
				        System.out.println(listatfnos.obtenerValorEn(pos).obtenerDireccion());
				        System.out.println(listatfnos.obtenerValorEn(pos).obtenerTelefono());
				    }
				    break;
			case 2: // buscar siguiente
     			    // System.out.println("pos: "+pos);
				    pos=listatfnos.buscar(cadenabuscar, pos+1);
				    if (pos==-1)
				    	if (listatfnos.longitud()!= 0)
				    		System.out.println("Busqueda fallida..");
				    	else
				    		System.out.println("Lista vacia..");
				    else
				    {
				    	System.out.println(listatfnos.obtenerValorEn(pos).obtenerNombre());
				        System.out.println(listatfnos.obtenerValorEn(pos).obtenerDireccion());
				        System.out.println(listatfnos.obtenerValorEn(pos).obtenerTelefono());
				    }
				    break;
				    
			case 3: // Agregar
				    System.out.print("Nombre...:  ");
				    nombre=Leer.dato();
				    System.out.print("Direccion:  ");
				    direccion=Leer.dato();
				    System.out.print("Telefono.:  ");
				    telefono=Leer.datoLong();
			        listatfnos.agregar(new Persona(nombre, direccion, telefono));
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
			        
			case 5: // salir
			
				    System.out.print("Hasta la vista BABE...");
				    listatfnos=null;
			}
		}while (opcion!=5);
	}

}
