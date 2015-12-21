package examen2R;
public class Beisbolista extends Deportista
{
	private int numBat;
	private int numHits;
	
	public Beisbolista()
	{
	}
	
	public Beisbolista(String nom, String dom, double suelMens)
	{
		super(nom, dom, suelMens);
	}
	
	public double bono(int numHits, int numBat, double suelMens)
	{
		int porBat;
		porBat = (numHits/numBat)*1000;
		
		if(porBat>=0 && porBat<=100)
		{
			return suelMens;
		}
		if(porBat>=101 && porBat<=200)
		{
			return suelMens*2;
		}
		if(porBat>=201 && porBat<=300)
		{
			return suelMens*3;
		}
		if(porBat>=301)
		{
			return suelMens*5;
		}
		return 0;
	}

	
	public String desplegar() {
		
		
		return null;
	}


	public double bono() {
		
		return 0;
	}
	
}
