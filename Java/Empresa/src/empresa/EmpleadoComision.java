package empresa;
public class EmpleadoComision extends Empleado{
	EmpleadoComision(String nombre,int numerodeempleado,double sueldo){
		super(nombre, numerodeempleado, sueldo);
	}
	public void setSueldo(double comision){
		s=s+comision;
	}	
	public double getSueldo(double comision){
		s=s+comision;
		return s;
	}	
}
