package archivos;

import java.io.FileInputStream;
import java.io.IOException;

public class Lee_sec_bytes_varios 
{
	public static void main(String[] args) 
	{
		FileInputStream fe = null;
		byte [ ] buffer = new byte [81];
		int nbytes;

		try
		{
			fe = new FileInputStream ("c:\\texto.txt");			
			nbytes = fe.read (buffer, 0, 81);
			String str = new String (buffer, 0, nbytes);
			while (nbytes!=-1)
			{
				System.out.println (str);
				nbytes = fe.read (buffer, 0, 81);
				
				if (nbytes!=-1)
					str = new String (buffer, 0, nbytes);
			}
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
