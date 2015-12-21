package herencia;
import java.util.*;

public class Cuenta_ahorro extends Ccuenta
{
	private double cuotaMantenimiento;
	
	public Cuenta_ahorro()
	{
	}
	
	public Cuenta_ahorro(double imp, String cta, String nom, double sdo,double tasa)
	{   
		super(cta,nom, sdo,tasa);
		if (imp <0 )
			System.out.print("Error, cantidad negativa...");
		else
			cuotaMantenimiento=imp;
		   //asignar_cuotaMantenimiento(imp);
	}
	
	
	
	public double getCuotaMantenimiento() {
		return cuotaMantenimiento;
	}

	public void setCuotaMantenimiento(double cuotaMantenimiento) {
		this.cuotaMantenimiento = cuotaMantenimiento;
	}

	
	public double comisiones()
	{
		GregorianCalendar fechaActual=new GregorianCalendar();
		int dia=fechaActual.get(Calendar.DAY_OF_MONTH);
		//System.out.print("Dia de la computadora: "+dia);
		//dia=1;
		if (dia==28)
		{
			retiro(cuotaMantenimiento);
            return cuotaMantenimiento;
		}
		return 0;
	
	}
	
	
	public double intereses()
	{
		double intereses_producidos;
		GregorianCalendar fechaActual=new GregorianCalendar();
		int dia=fechaActual.get(Calendar.DAY_OF_MONTH);
		//dia=1;
		if (dia==28)
		{
			intereses_producidos=saldo()*getTasadeinteres()/1200;
		    deposito(intereses_producidos);
		    return intereses_producidos;
		}
		return 0;
	
	}
	
	
	
}
