package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import paq1.Leer;

public class Crea_sec_car_varios 
{
	public static void main(String[] args)
	{
		FileWriter fs = null;
		byte [] buffer=new byte[81];
		int nbytes;
		String nombreArchivo=null;
		File archivo=null;
		try
		{
			System.out.println("Nombre del Archivo: ");
			nbytes=System.in.read(buffer);
			nombreArchivo=new String (buffer,0,nbytes-2);
			archivo=new File("c:\\"+nombreArchivo);
			
			char resp='s';
			if (archivo.exists())
			{
				System.out.print("El Archivo existe; ?Deseas sobreescribirlo¿ (s/n) ");
				resp=Leer.datocar();
				
			}
			if (resp=='s')
			{
				
				System.out.println("Escribe el texto que deseas almacenar en el archivo: ");
				nbytes=System.in.read(buffer);
				String str = new String(buffer,0,nbytes);
				fs=new FileWriter(archivo);
				
				
				while (buffer[0] != 13)
				{
					fs.write(str,0,str.length());
					System.out.println("Escriba el texto que desea grabar en el archivo ( Enter para terminar ): ");
					nbytes=System.in.read(buffer);
					str = new String(buffer,0,nbytes);
				}
				
			}
		}
		catch (IOException e)
		{
			System.out.println("Error: "+ e.toString());
		}
		finally
		{
			try
			{
				// cerrar el archivo
				if (fs!=null)
					fs.close();
			}
			catch (IOException e)
			{
				System.out.println("Error: "+ e.toString());
			}
		}

	}

}
