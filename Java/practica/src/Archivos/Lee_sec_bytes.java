package archivos;

import java.io.FileInputStream;
import java.io.IOException;

public class Lee_sec_bytes
{
	// lee un solo registro de 81 bytes; si el archivo tiene mas de 81 bytes, estos no se consideran
	
	public static void main(String[] args) 
	{
		FileInputStream fe = null;
		byte [ ] buffer = new byte [81];
		int nbytes;

		try
		{
			fe = new FileInputStream ("c:\\textox.txt");			
			nbytes = fe.read (buffer, 0, 81);
			String str = new String (buffer, 0, nbytes);
			System.out.println (str);
		}
		catch (IOException e)
		{
			 System.out.println ("Error: " + e.toString( ));
		}
		finally
		{
			try
			{
				if (fe != null)
					fe.close ( );				
			}
			catch (IOException e)
			{
				 System.out.println ("Error: " + e.toString( ));
			}
		}	
	}

}
