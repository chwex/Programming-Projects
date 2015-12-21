package lastEx;
import java.io.*;

import paq1.Formatea;
public class LeeAlumno
{
	
	public static void imprecion(double contador, double fem, double mas)
	{
		double porm=0, porf=0;
		porm=((mas/contador)*100);
		porf=((fem/contador)*100);
		System.out.println(" sexo"+"     cantidad  "+"   %: ");	
		System.out.println(" mujeres:  "+ fem+ "        "+Formatea.alinder("##.00", porf));	
		System.out.println(" hombres:  "+ mas+ "        "+Formatea.alinder("##.00", porm));	
		//System.out.println(" hombres:  "+ mas+ "        "+porm);
		System.out.println(" total:    "+ contador+ "       100.00");
	}
	
	
	public static void mostrarFichero (String nombreFichero)
	throws IOException
	{
		PrintStream flujoS = System.out; // Salida Estandar
		DataInputStream dis = null; // Entrada de datos desde el fichero
		File fichero = null; // objeto que identifica el fichero
	double contador=0;		double fem=0, mas=0;

	
	try
		{	
			fichero = new File (nombreFichero);
			if (fichero.exists())
			{
				dis = new DataInputStream (new BufferedInputStream (new FileInputStream(fichero)));
				do
				{					
				   long cuenta;
					String nombre;
					 char sexo;	
					cuenta = dis.readLong();
					nombre = dis.readUTF();
					sexo = dis.readChar();
				
					contador++;
					if(sexo=='f')
					{
					fem++;	
					}
					if(sexo=='m')
					{
					mas++;	
					}
						
				}while (true);
	
			}else
				flujoS.println("El fichero no existe");
		
		}
		catch (EOFException e)
		{
			//System.out.println ("Error: " + e.getMessage());
		}
	imprecion(contador,fem,mas);	
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
					nombreFichero = "c:\\" + nombreFichero;
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