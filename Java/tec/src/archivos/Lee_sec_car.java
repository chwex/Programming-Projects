package archivos;

import java.io.*;

public class Lee_sec_car 
{

	public static void main(String[] args)
	{
		byte [] nomfich= new byte[81];
		String nombreArchivo=null;
		File archivo=null;
		int nbytes, ncars;
		
		FileReader fe = null;
		char [] buffer=new char[81];
		
		try
		{
			do
			{
				System.out.print("Nombre del Archivo: ");
				nbytes=System.in.read(nomfich);
				nombreArchivo=new String (nomfich,0,nbytes-2);
				archivo=new File("c:\\"+nombreArchivo);
			}while(!archivo.exists());
			
			fe=new FileReader(archivo);
			ncars=fe.read(buffer,0,81);
			String str=new String (buffer,0,ncars);
			System.out.println(str);
			
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
				if (fe!=null)
					fe.close();
			}
			catch (IOException e)
			{
				System.out.println("Error: "+ e.toString());
			}
		}

	}

}
