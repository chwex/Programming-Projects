package clases;
import paq1.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha 
{
	private int dia;
	private int mes;
	private int año;
	
	public Fecha()
	{
		asignarFecha();
	}
	
	public Fecha(int dd) // Constructor con un parámetro
	{
		asignarFecha(dd); // asignar fecha actual
		
	}
	
	public Fecha(int dd, int mm) // Constructor con dos parámetro
	{
		asignarFecha(dd,mm); // asignar fecha actual
		
	}
	
	public Fecha(int dd, int mm, int aaaa) // Constructor con tres parámetro
	{
		asignarFecha(dd,mm,aaaa); // asignar fecha actual
		
	}
	
	public Fecha(Fecha obj)
	{
		dia=obj.dia;
		mes=obj.mes;
		año=obj.año;
	}
	
	
	public void asignarFecha()
	{
		GregorianCalendar fechaActual=new GregorianCalendar();
		dia=fechaActual.get(Calendar.DAY_OF_MONTH);
		mes=fechaActual.get(Calendar.MONTH)+1;
		año=fechaActual.get(Calendar.YEAR);
	}
	
	public void asignarFecha(int dd) // asignarFecha con un parámetro
	{
		asignarFecha(); // asignar fecha actual
		dia=dd;
		if (!fechaCorrecta())
		{
			System.out.println("Fecha Incorrecta, se asigna la actual");
			asignarFecha();
		}
	}
	
	public void asignarFecha(int dd, int mm) // asignarFecha con dos parámetro
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
	
	public void asignarFecha(int dd, int mm, int aaaa) // asignarFecha con tres parámetro
	{
		asignarFecha(); // asignar fecha actual
		dia=dd;
		mes=mm;
		año=aaaa;
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
		año=obj.año;
	}
	
	
	protected boolean bisiesto()
	{
		return ((año%4==0) && (año % 100 !=0) || año%400==0);
	}

	public void obtenerFecha(int [] arreglo_fecha)
	{
		arreglo_fecha[0]=dia;
		arreglo_fecha[1]=mes;
		arreglo_fecha[2]=año;
		
	}
	public String obtenerF()
	{
		return dia+"/"+mes+"/"+año;
	}
	
	
	public boolean fechaCorrecta()
	{
		boolean diaCorrecto, mesCorrecto, añoCorrecto;
		añoCorrecto=(año>=1582);
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
		return diaCorrecto && mesCorrecto && añoCorrecto;
		
	}

	protected void finalize() throws Throwable  // destructor
	{
		System.out.println("Objeto destruido... ");
	}
	

}
