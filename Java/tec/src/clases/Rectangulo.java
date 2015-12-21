package clases;

public class Rectangulo 
{
	// atributos
	private double base;
	private double altura;
	
	public Rectangulo(double ba,double al)
	{
		base=ba;
		altura=al;
	}
	
	// metodos
	
	public double getBase()
	{
		return base;
	}
	
	public void setBase(double base) 
	{
		this.base = base;
	}
	
	public double getAltura() 
	{
		return altura;
	}
	
	public void setAltura(double altura)
	{
		this.altura = altura;
	}
	
	
	// metodos especiales
	
	public double sup()
	{
		return base*altura;
	}
	
	public double per()
	{
		return 2*(base+altura);
	}
	
	public void asigna_base_altura(double ba, double al)
	{
		base=ba;
		altura=al;
	}
	
	
	
	
}
