package Examen2;

import paq1.Leer;

public class main {

	public static void main(String[] args) {
		int numEmp=0;
		int claEst=0;
		
		
		do{
			System.out.println("Numero de Empleados: ");
			numEmp = Leer.datoInt();
		}while(numEmp <= 0);
		
		do
		{
			System.out.println("Cantidad de Claves de estimulo: ");
			claEst= Leer.datoInt();
		}while(claEst<=0);
		
		Empleado objetoEmp = new Empleado(numEmp);
		Estimulo objetoEst = new Estimulo(claEst);
		
		objetoEmp.dasplegar(objetoEst); 
		
	}

}
