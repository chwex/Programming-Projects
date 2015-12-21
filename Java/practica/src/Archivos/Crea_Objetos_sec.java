package archivos;
import paq1.*;
import java.io.*;
// import java.io.BufferedOutputStream;
// import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import paq1.Leer;

public class Crea_Objetos_sec  
{
	static long x;
	public static void crearArchivoSecObjetos (File archivo)
	throws IOException
	{
		PrintStream flujoS = System.out; // Salida Estandar
		ObjectOutputStream oos = null; // Salida de objetos hacia el archivo
		char resp;

		try
		{
			//Crear un flujo hacia el archivo que permita escribir
			// objetos.
			oos = new ObjectOutputStream (new FileOutputStream (archivo));

			//Declarar los datos a escribir en el archivo
			String nombre, direccion;
			long telefono;
		
			//Leer datos de la entrada estandar y escribirlos
			//en el archivo
			do		
			{
				flujoS.print("nombre: ");
				nombre = Leer.dato();
				flujoS.print("direccion: ");
				direccion = Leer.dato();
				flujoS.print("telefono: ");
				telefono = Leer.datoLong();

				//Crear un objeto CPersona y almacenarlo en el archivo
				oos.writeObject(new Cpersona(nombre,direccion, telefono));
	
				flujoS.print ("¿ Desea escribir otro registro ? (s/n) ");
				resp = Leer.datocar();
				
			}while (resp == 's');
		}
		catch (IOException e)
		{
			flujoS.println ("Error: " + e.getMessage());
		}
		finally
		{
			//Cerrar el flujo
			if (oos != null)
			    oos.close();
		}
	}
		
	public static void main (String [] args)
	{
		PrintStream flujoS = System.out; // Salida Estandar
		String nombreArchivo = null; //nombre del archivo
		File archivo = null; //objeto que identifica el archivo

		try
		{
			//Crear un objeto File que identifique al archivo
			flujoS.print ("Nombre del archivo: ");
			nombreArchivo = Leer.dato();
			archivo = new File("g:\\" + nombreArchivo);

			//Verificar si el archivo existe
			char resp = 's';
			if (archivo.exists())
			{
				flujoS.print ("El archivo existe, ¿Desea sobreescribirlo? (s/n) ");
				resp = Leer.datocar();
				
			}
			if (resp == 's')
			{
				crearArchivoSecObjetos(archivo);
			}
		}
		catch (IOException e)
		{
			flujoS.println ("Error: " + e.getMessage());
		}
	}

}
