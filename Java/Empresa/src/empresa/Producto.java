package empresa;
public class Producto{
	String n="w";
	int c=0;
	double p=0;
	Producto(String nombre,int codigo,double precio){
		n=nombre;
		c=codigo;
		p=precio;
	}
	public String getNombre(){
		return n;
	}
	public int getCodigo(){
		return c;
	}
	public double getPrecio(){
		return p;
	}
	public void setNuevoNombre(String nuevonombre){
		n=nuevonombre;
	}
	public void setCodigo(int codigo){
		c=codigo;
	}
	public void setNuevoPrecio(double nuevoprecio){
		p=nuevoprecio;
	}	
}
