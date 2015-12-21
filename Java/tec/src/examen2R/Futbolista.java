package examen2R;

public class Futbolista extends Deportista
{
	private double goles;
	private double imp;
	private double suelMens;
	public Futbolista()
	{
	}
	
	public Futbolista(String nom, String dom, double suelMens)
	{
		super(nom, dom, suelMens);
		setSueldo(suelMens);
		
	}
	
	

	public void setSueldo(double suelMens) {
		this.suelMens = suelMens;
	}

	public double bono() {
		
		if(goles<11)
		{
			imp=(goles*suelMens)/10;
			return imp;
		}
		if(goles>=11 && goles < 21)
		{
			imp=(goles*suelMens)/10;
			return imp;
		}
		
		return 0;
	}


	public String desplegar() {
		return null;
	}
}
