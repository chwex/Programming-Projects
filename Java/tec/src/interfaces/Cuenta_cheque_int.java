package interfaces;
import herencia.*;
import java.util.GregorianCalendar;

public class Cuenta_cheque_int extends Ccuenta implements IFecha 
{
	
	//  atributos
	
	private int transacciones;
	private double importePorTrans;
	private int transExentas;
	
	//  Constructores
	
	
	public Cuenta_cheque_int(double imptrans, int transex,  String cue, String nom, double sal, double tipo)
	{
		super( cue,nom, sal, tipo);
		transacciones=0;
		asignarimportePorTrans(imptrans);
		asignartransExentas(transex);
	}
	
	public void decrementarTransacciones()
	{
		transacciones--;
	}
	public int obtenertransacciones()
	{
		return transacciones;
	}
	
	public void asignarimportePorTrans(double imptrans)
	{
		if (imptrans<0)
		{
			System.out.println("Error:  Cantidad negativa...");
			return;
		}
		importePorTrans=imptrans;
	}
	
	public double obtenerimportePorTrans()
	{
		return importePorTrans;
	}
	
	public void asignartransExentas(int transex)
	{
		if (transex<0)
		{
			System.out.println("Error:  Cantidad negativa...");
			return;
		}
		transExentas=transex;
	}
	
	public int obtenertransExentas()
	{
		return transExentas;
	}
	
	public void deposito(double cantidad)
	{
		super.deposito(cantidad);
		transacciones++;
	}
	
	public void retiro(double cantidad)
	{
		super.retiro(cantidad);
		transacciones++;
	}
	
	public double comisiones()
	{
		if (dia()==1)
		{
			int n=transacciones-transExentas;
			if (n>0)
			{
				retiro(n*importePorTrans);
				return n*importePorTrans;
			}
			else
			{
			    transacciones=0;
			    return 0;
			}   
		}
		else
			return 0.0;
		
	}
	
	public double intereses()
	{
		if (dia()!=1)
			return 0.0;
		
		// acumular los intereses por mes solo los dias 1 de cada mes
		double interesesProducidos=0;
		// hasta 3000 euros al 0.5%, el resto al interes establecido
		
		if (saldo()<=3000)
     		interesesProducidos=saldo()*0.5/1200.00;
		else
			interesesProducidos=3000*0.5/1200 +(saldo()-3000)*getTasadeinteres()/1200.00;
		
		deposito(interesesProducidos);
		
		// este ingreso no debe incrementar las transacciones
		decrementarTransacciones();
		
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
