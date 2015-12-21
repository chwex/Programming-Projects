package archivos;
import java.io.*;
import paq1.*;
//import java.io.BufferedInputStream;
//import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;

public class Lee_objetos_sec 
{
	public static void leerArchivoObjetos (String nombreArchivo)
	throws IOException
	{
		PrintStream flujoS = System.out; // Salida Estandar
		ObjectInputStream ois = null; // Entrada de objetos desde el archivo
		File archivo = null; // objeto que identifica el archivo
		int ca=0;
		try
		{	
			//Crear un objeto File que identifique al archivo
			archivo = new File (nombreArchivo);
		
			//Verificar si el archivo existe
			if (archivo.exists())
			{
				//Si existe, abrir un flujo desde el mismo
				ois = new ObjectInputStream (new FileInputStream(archivo));
			
				//Declarar los datos a leer desde el fichero
				// String nombre, direccion;
				// long telefono;
				Cpersona persona=null;
				do
				{
					//Leer un objeto desde el fichero.
					//Cuando se alcance el final del archivoi Java
					//lanzara una excepcion del tipo EOFException
					persona=(Cpersona)ois.readObject();
				    ca++;
					// Mostrar los datos nombre, direccion y telefono
					flujoS.println(persona.obtenerNombre());
					flujoS.println(persona.obtenerDireccion());
					flujoS.println(persona.obtenerTelefono());
					flujoS.println();
				}while (true);
			}
			else
				flujoS.println("El archivo no existe");
		}
		catch (EOFException e)
		{
			flujoS.println ("Total de alumnos: "+ca);
			flujoS.println ("Fin del listado");
		}
		catch (ClassNotFoundException c)
		{
			flujoS.println ("Clase no encontrada");
		}
		finally
		{
			//Cerar el flujo
			if (ois != null)
				ois.close();
		}
	}
	

	public static void main (String [] args)
	{
		byte [ ] nomArch = new byte [81];
		String nombreArchivo = null;
		File archivo = null;
		int nbytes;
		
			try
			{
				do
				{
					System.out.print ("Nombre del archivo: ");
					nbytes = System.in.read (nomArch);
					nombreArchivo = new String (nomArch, 0, nbytes-2); // 							menos  CR+LF
					nombreArchivo = "g:\\" + nombreArchivo;
					archivo = new File (nombreArchivo);
				}while (!archivo.exists( ));
				
				leerArchivoObjetos(nombreArchivo);
			}
			catch (IOException e)
			{
				System.out.println ("Error: " + e.getMessage());
			}
	}

}
