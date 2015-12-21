package Julio;

public class PersonaC
{
	// atributos
	private String nombre;
	private String direccion;
	private long telefono;
	
	//constructores y metodos especiales
	
	public PersonaC()
	{}
	
	
	public PersonaC(String nombre, String direccion, long telefono)
	{
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public String getNombre()
	{
		return nombre;
	}

	public String getDireccion()
	{
		return direccion;
	}

	public long getTelefono()
	{
		return telefono;
	}


}