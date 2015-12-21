
public class Alumno {
	String Nombre;
	String Apellido;
	
	//metodos get y set
	public String getNombre(){
		return Nombre;
	}
	
	public String getApellido(){
		return Apellido;
	}
	
	public void setNombre(String n){
		Nombre=n;
	}
	
	public void setApellido(String a){
		Apellido = a;
	}
	
	public String toString(){
		return getNombre()+" "+getApellido();
	}
}//fin de clase

