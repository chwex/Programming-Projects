package archivos;

import java.io.FileOutputStream;
import java.io.IOException;

public class Crea_sec_bytes_varios
{
	public static void main(String[] args) 
	{
		FileOutputStream fs = null;
		byte [] buffer=new byte[81];
		int nbytes;
		try
		{
			fs=new FileOutputStream("c:\\texto.txt");
			System.out.println("Escriba el texto que desea grabar en el archivo (Enter para terminar): ");
			nbytes=System.in.read(buffer);
			// System.out.print("Numero de bytes: "+nbytes);
			while (buffer[0] != 13)
			{
				fs.write(buffer,0,nbytes);
				System.out.println("Escriba el texto que desea grabar en el archivo ( Enter para terminar ): ");
				nbytes=System.in.read(buffer);
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
