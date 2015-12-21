package herencia;
import java.util.*;
public class Cuenta_cheques extends Ccuenta 
{
	private int transacciones;
	private double importexTransaccion;
	private int transaccionesExenteas;
	
	
	public Cuenta_cheques(double imptran, int tranexentas, String cta, String nom, double sdo, double tasa)
	{
		super(cta, nom, sdo, tasa);
		transacciones=0;
		setImportexTransaccion(imptran);
		setTransaccionesExentas(tranexentas);
	}
	
	public void decrementarTransacciones()
	{
		transacciones--;
	}
	
	public int getTransacciones()
	{
		return transacciones;
	}
	
	public void setImportexTransaccion(double imptran)
	{
		importexTransaccion=imptran;
	}
	
	public double getImportexTransaccion()
	{
		return importexTransaccion;
	}
	
	
	public void setTransaccionesExentas(int tranexentas)
	{
		transaccionesExenteas=tranexentas;
	}
	
	public int getTransaccionesExentas()
	{
		return transaccionesExenteas;
	}
	
	public void deposito(double imp)
	{
		super.deposito(imp);
		transacciones++;
	}
	
	public void retiro(double imp)
	{
		super.retiro(imp);
		transacciones++;
	}
	
	
	public double comisiones()
	{
		GregorianCalendar fechaactual=new GregorianCalendar();
		int dia=fechaactual.get(Calendar.DAY_OF_MONTH);
		//dia=1;
		if (dia==30)
		{
			int n=transacciones - transaccionesExenteas;
			if (n>0)
			{
				retiro(n*importexTransaccion);
				transacciones=0;
				return n*importexTransaccion;
			}
			else
			{
				transacciones=0;
				return 0;
			}
		}
		else
			return 0;
	}
	
	public double intereses()
	{
		GregorianCalendar fechaactual=new GregorianCalendar();
		int dia=fechaactual.get(Calendar.DAY_OF_MONTH);
		//dia=1;
		if (dia==30)
		{
			double interesesProducidos;
			if (saldo()<=3000)
				interesesProducidos=saldo()*.5/1200;
			else
				interesesProducidos=3000*.5/1200 + (saldo()-3000)*getTasadeinteres()/1200;
			deposito(interesesProducidos);
			decrementarTransacciones();
			return interesesProducidos;
		}
		else
			return 0;
	}
	
	
	
}
