package archivos;
import java.io.*;
public class LeeSecDatosPrim
{
	public static void mostrarFichero (String nombreFichero)
	throws IOException
	{
		PrintStream flujoS = System.out; // Salida Estandar
		DataInputStream dis = null; // Entrada de datos desde el fichero
		File fichero = null; // objeto que identifica el fichero
	
		try
		{	
			//Crear un objeto File que identifique al fichero
			fichero = new File (nombreFichero);
		
			//Verificar si el fichero existe
			if (fichero.exists())
			{
				//Si existe, abrir un flujo desde el mismo
				dis = new DataInputStream (new BufferedInputStream (new FileInputStream(fichero)));
			
				//Declarar los datos a leer desde el fichero
				String nombre, direccion;
				long telefono;
				do
				{
					//Leer un nombre, una direccion y un telefono desde el
					//fichero. Cuando se alcance el final del fichero Java
					//lanzara una excepcion del tipo IOFException
					nombre  = dis.readUTF();
					direccion = dis.readUTF();
					telefono = dis.readLong();
				
					// Mostrar los datos nombre, direccion y telefono
					flujoS.println(nombre);
					flujoS.println(direccion);
					flujoS.println(telefono);
					flujoS.println();
				}while (true);
			}
			else
				flujoS.println("El fichero no existe");
		}
		catch (EOFException e)
		{
			flujoS.println ("ya termine...nos vemos");
		}
		finally
		{
			//Cerar el flujo
			if (dis != null)
				dis.close();
		}
	}
	

	public static void main (String [] args)
	{
		byte [ ] nomFich = new byte [81];
		String nombreFichero = null;
		File fichero = null;
		int nbytes;
		
			try
			{
				do
				{
					System.out.print ("Nombre del fichero: ");
					nbytes = System.in.read (nomFich);
					nombreFichero = new String (nomFich, 0, nbytes-2); // 							menos  CR+LF
					nombreFichero = "C:\\" + nombreFichero;
					fichero = new File (nombreFichero);
				}while (!fichero.exists( ));
				
				mostrarFichero(nombreFichero);
			}
			catch (IOException e)
			{
				System.out.println ("Error: " + e.getMessage());
			}
	}

}
