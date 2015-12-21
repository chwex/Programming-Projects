package herencia;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cuenta_cheques_esp extends Cuenta_cheques
{
//  Constructores
	

	
	public Cuenta_cheques_esp( double imptrans, int transex, String cue,String nom, double sal, double tasa)
	{
		super( imptrans,transex, cue,nom, sal, tasa);

	}
	
	public double intereses()
	{
		GregorianCalendar fechaActual=new GregorianCalendar();
		int dia=fechaActual.get(Calendar.DAY_OF_MONTH);
		
		if (dia!=1  || saldo()<3000)
			return 0.0;
		
		// acumular los intereses por mes solo los dias 1 de cada mes
		double interesesProducidos=0;

		interesesProducidos=saldo()*getTasadeinteres()/1200.00;
		
		
		deposito(interesesProducidos);
		
		// este ingreso no debe incrementar las transacciones
		decrementarTransacciones();
		
		return interesesProducidos;
		
	}

}
