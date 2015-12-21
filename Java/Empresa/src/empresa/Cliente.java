package empresa;
public class Cliente extends Persona{
	String dir="h";
	int codigop=0;
	Cliente(String nombre,String direccion,int codigopostal){
		super(nombre);
		dir=direccion;
		codigop=codigopostal;
	}
	public String getDireccion(){
		return dir;
	}
	public int getCodigoPostal(){
		return codigop;
	}
}	