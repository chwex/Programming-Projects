package archivos;
import java.io.*;
import paq1.Leer;
public class CreaSecDatosPrim 
{
	public static void crearFichero (File fichero)
	throws IOException
	{
		PrintStream flujoS = System.out; // Salida Estandar
		DataOutputStream dos = null; // Salida de datos hacia el fichero
		char resp;

		try
		{
			//Crear un flujo hacia el fichero que permita escribir
			//datos de tipo primitivos y que utilice un buffer.
			dos = new DataOutputStream (new BufferedOutputStream (new FileOutputStream (fichero)));

			//Declarar los datos a escribir en el fichero
			String nombre, direccion;
			long telefono;
		
			//Leer datos de la entrada estandar y escribirlos
			//en el fichero
			do		
			{
				flujoS.print("nombre: ");
				nombre = Leer.dato();
				flujoS.print("direccion: ");
				direccion = Leer.dato();
				flujoS.print("telefono: ");
				telefono = Leer.datoLong();

				//Almacenar un nombre, una direccion y un telefono en
				//el fichero
				dos.writeUTF(nombre);
				dos.writeUTF(direccion);
				dos.writeLong(telefono);
	
				flujoS.print ("¿ Desea escribir otro registro ? (s/n) ");
				resp = Leer.datocar();
				
			}while (resp == 's');
		}
		catch(IOException e)
		{
			flujoS.print("Error Al Crear Archivo: "+ e.getMessage());
		}
		finally
		{
			//Cerrar el flujo
			if (dos != null)
			dos.close();
		}
	}
		
	public static void main (String [] args)
	{
		//PrintStream flujoS = System.out; // Salida Estandar
		String nombreFichero = null; //nombre del fichero
		File fichero = null; //objeto que identifica el fichero

		try
		{
			//Crear un objeto File que identifique al fichero
			System.out.print("Nombre del fichero: ");
			nombreFichero = Leer.dato();
			fichero = new File("C:\\" + nombreFichero);

			//Verificar si el fichero existe
			char resp = 's';
			if (fichero.exists())
			{
				System.out.print ("El fichero existe, ¿Desea sobreescribirlo? (s/n) ");
				resp = Leer.datocar();
				
			}
			if (resp == 's')
			{
				crearFichero (fichero);
			}
		}
		catch (IOException e)
		{
			System.out.println ("Error Al Leer el Nombre Del Archivo o Al Confirmar: " + e.getMessage());
		}
	}

}
