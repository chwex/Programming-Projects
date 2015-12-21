package archivos;

import java.io.FileOutputStream;
import java.io.IOException;

public class Crea_sec_bytes 
{
	public static void main(String[] args)
	{
		
		// lee una sola linea de texto...cada vez que se corre
		// pero si se corre mas veces los textos tecleados van reemplazando.
		// si se le pone el parametro true al crear el flujo fs los textos se van adicionando
		
		FileOutputStream fs = null;
		byte [ ] buffer = new byte [81];
		int nbytes;

		try
		{
			System.out.println ("Escriba el texto que desea almacenar en el fichero: ");
			nbytes = System.in.read (buffer);
			System.out.print("Numero de Caracteres Tecleados: "+nbytes);
			//fs = new FileOutputStream ("c:\\texto.txt");
			fs = new FileOutputStream ("c:\\textox.txt", true);
			fs.write(buffer, 0, nbytes);

		}
		catch (IOException e )
		{
			System.out.println ("Error: " + e.toString ( ));
		}
		finally
		{
			try
			{
				//Cerrar  el fichero
				if  (fs != null)
					fs.close();
			}
			catch (IOException e)
			{
				System.out.println ("Error: " + e.toString ( ));
			}
		}
	}

}
