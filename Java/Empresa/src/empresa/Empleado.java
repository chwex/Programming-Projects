package empresa;
public class Empleado extends Persona{
	int nde=0;
	double s=0;
	Empleado(String nombre,int numerodeempleado,double sueldo){
		super(nombre);
		nde=numerodeempleado;
		s=sueldo;
	}
	public int getNumEmpleado(){
		return nde;
	}
	public double getSueldo(){
		return s;
	}
	public void setNumEmpleado(int numerodeempleado){
		nde=numerodeempleado;
	}
}	

