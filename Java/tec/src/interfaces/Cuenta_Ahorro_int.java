package interfaces;
import herencia.*;
import java.util.GregorianCalendar;

public class Cuenta_Ahorro_int extends Ccuenta implements IFecha
{
// atributos
	
	private double cuotaMantenimiento;
	
	// constructores
	
	
	public Cuenta_Ahorro_int(double cuota,  String cue,String nom, double sal, double tasa)
	{
		super(cue,nom,sal,tasa);
		//asignarCuotaMant(cuota);
		//setNombre(nom);
		//setCuenta(cue);
		//deposito(sal);
		asignarCuotaMant(cuota);
		
	}
	
	public void asignarCuotaMant(double cantidad)
	{
		if (cantidad<0)
		{
			System.out.println("Error: Cantidad negativa...");
			return;
		}
		cuotaMantenimiento=cantidad;
	}
	
	public double obtenerCuotaMant()
	{
		return cuotaMantenimiento;
	}
	
	public double comisiones()
	{
		// se aplican mensualmente por el mantenimiento de la cuenta
		
		if (dia()==1)
		{
			retiro(cuotaMantenimiento);
		    return cuotaMantenimiento;
		}
		else
			return 0;
	}
	
	
	public double intereses()
	{
		if (dia()!=1)
			return 0.0;
		double interesesProducidos=0;
		interesesProducidos=saldo()*getTasadeinteres()/1200.00;
		deposito(interesesProducidos);
		return interesesProducidos;
		
	}
	
	public int dia()
	{
		GregorianCalendar fechaActual = new GregorianCalendar();
		return 1;
		//return fechaActual.get(DIA_DEL_MES);
		
	}
	
	
	public int mes()
	{
		return 0;
	}
	
	
	
	public int año()
	{
		return 0;
	}
	

}
