package herencia;

public abstract class Ccuenta
{
	private String cuenta;
	private String nombre;
	private double saldo;
	private double tasadeinteres;
	
	public Ccuenta()
	{
	}
	
	public Ccuenta(String cta, String nom,double sdo, double tasa)
	{
		setCuenta(cta);
		setNombre(nom);
		deposito(sdo);
		setTasadeinteres(tasa);
	}
	
	
	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTasadeinteres() {
		return tasadeinteres;
	}

	public void setTasadeinteres(double tasadeinteres) {
		this.tasadeinteres = tasadeinteres;
	}

	public void deposito(double importe)
	{
		if (importe<0)
			System.out.println("Error: Cantidad negativa..");
		else
			saldo=saldo+importe;
	}
	
	public void retiro(double importe)
	{
		if (saldo<importe)
			System.out.println("Error: No hay saldo en la cuenta..");
		else
			saldo-=importe;
	}
	
	public double saldo()
	{
		return saldo;
	}
	
	public abstract double intereses();
	public abstract double comisiones();
	

}
