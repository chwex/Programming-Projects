package clases;
import paq1.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha 
{
	private int dia;
	private int mes;
	private int a�o;
	
	public Fecha()
	{
		asignarFecha();
	}
	
	public Fecha(int dd) // Constructor con un par�metro
	{
		asignarFecha(dd); // asignar fecha actual
		
	}
	
	public Fecha(int dd, int mm) // Constructor con dos par�metro
	{
		asignarFecha(dd,mm); // asignar fecha actual
		
	}
	
	public Fecha(int dd, int mm, int aaaa) // Constructor con tres par�metro
	{
		asignarFecha(dd,mm,aaaa); // asignar fecha actual
		
	}
	
	public Fecha(Fecha obj)
	{
		dia=obj.dia;
		mes=obj.mes;
		a�o=obj.a�o;
	}
	
	
	public void asignarFecha()
	{
		GregorianCalendar fechaActual=new GregorianCalendar();
		dia=fechaActual.get(Calendar.DAY_OF_MONTH);
		mes=fechaActual.get(Calendar.MONTH)+1;
		a�o=fechaActual.get(Calendar.YEAR);
	}
	
	public void asignarFecha(int dd) // asignarFecha con un par�metro
	{
		asignarFecha(); // asignar fecha actual
		dia=dd;
		if (!fechaCorrecta())
		{
			System.out.println("Fecha Incorrecta, se asigna la actual");
			asignarFecha();
		}
	}
	
	public void asignarFecha(int dd, int mm) // asignarFecha con dos par�metro
	{
		asignarFecha(); // asignar fecha actual
		dia=dd;
		mes=mm;
		if (!fechaCorrecta())
		{
			System.out.println("Fecha Incorrecta, se asigna la actual");
			asignarFecha();
		}
	}
	
	public void asignarFecha(int dd, int mm, int aaaa) // asignarFecha con tres par�metro
	{
		asignarFecha(); // asignar fecha actual
		dia=dd;
		mes=mm;
		a�o=aaaa;
		if (!fechaCorrecta())
		{
			System.out.println("Fecha Incorrecta, se asigna la actual");
			asignarFecha();
		}
	}
	
	public void asignarFecha(Fecha obj)
	{
		dia=obj.dia;
		mes=obj.mes;
		a�o=obj.a�o;
	}
	
	
	protected boolean bisiesto()
	{
		return ((a�o%4==0) && (a�o % 100 !=0) || a�o%400==0);
	}

	public void obtenerFecha(int [] arreglo_fecha)
	{
		arreglo_fecha[0]=dia;
		arreglo_fecha[1]=mes;
		arreglo_fecha[2]=a�o;
		
	}
	public String obtenerF()
	{
		return dia+"/"+mes+"/"+a�o;
	}
	
	
	public boolean fechaCorrecta()
	{
		boolean diaCorrecto, mesCorrecto, a�oCorrecto;
		a�oCorrecto=(a�o>=1582);
		mesCorrecto=(mes>=1) && (mes<=12);
		switch (mes)
		{
		case 2: if (bisiesto())
			        diaCorrecto=(dia>=1 && dia<=29);
				else
				    diaCorrecto=(dia>=1 && dia<=28);
				break;
		case 4:
		case 6:
		case 9:
		case 11: diaCorrecto=(dia>=1 && dia<=30);
		 		 break;
		default: diaCorrecto=(dia>=1 && dia<=31);
		         break;
		}
		return diaCorrecto && mesCorrecto && a�oCorrecto;
		
	}

	protected void finalize() throws Throwable  // destructor
	{
		System.out.println("Objeto destruido... ");
	}
	

}
