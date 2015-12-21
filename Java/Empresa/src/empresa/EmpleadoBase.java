package empresa;
public class EmpleadoBase extends Empleado{
	EmpleadoBase(String nombre,int numerodeempleado,double sueldo){
		super(nombre, numerodeempleado, sueldo);
	}
	public void setSueldo(){
		s=2000;
	}	
	public double getSueldo(){
		s=2000;
		return s;
	}	
}
