package swing;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils 
{
	public static final String DATE_FORMAT_NOW = "dd/MM/yyyy";
	
	public static String now()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
		
	}
	
	public static String now(String DateFormat)
	{
		Calendar cal =  Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
		return sdf.format(cal.getTime());
		
		
		
	}

}
