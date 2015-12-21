package archivos;
import java.io.*;
public class Cpersona implements Serializable 
{
//	 atributos
	private String nombre;
	private String direccion;
	private long telefono;
	
	// Metodos
	// constructores
	
	public Cpersona()
	{}
	public Cpersona(String nom, String dir, long tel)
	{
		nombre=nom;
		direccion=dir;
		telefono=tel;
	}
	
	// interfaz
	
	public void asignarNombre(String nom)
	{
		nombre=nom;
	}
	
	public void asignarDireccion(String dir)
	{
		direccion=dir;
	}

	public void asignarTelefono(long tel)
	{
		telefono=tel;
	}

	public String obtenerNombre()
	{
		return nombre;
	}

	public String obtenerDireccion()
	{
		return direccion;
	}

	public long obtenerTelefono()
	{
		return telefono;
	}


}
