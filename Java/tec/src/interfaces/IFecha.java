package interfaces;
import java.util.*;
public interface IFecha 
{
	public final static int DIA_DEL_MES=Calendar.DAY_OF_MONTH;
	public final static int MES_DEL_AÑO=Calendar.MONTH;
	public final static int AÑO=Calendar.YEAR;
	
	public abstract int dia();
	public abstract int mes();
	public abstract int año();
}
