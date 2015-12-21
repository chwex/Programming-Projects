package empresa;
public class Menu{
	String w="w";
	String w2="w2";
	String w3="w3";
	Menu(){
		w="*******************************************************************************\n   Escoja una opcion\n   (1)-Elaborar presupuesto\n   (2)-Actualizacion de empleados\n   (3)-Actualizacion de productos\n   (4)-Imprimir Ventas\n   (5)-Imprimir nomina\n   (6)-Terminar\n*******************************************************************************";
		w2="*******************************************************************************\n   Escoja una opcion\n   (1)-Dar de Alta un empleadoo\n   (2)-Dar de Baja un empleadoo\n   (3)-Cambios\n   (4)-Consultar datos\n   (5)-Regresar al menu principal\n*******************************************************************************";
		w3="*******************************************************************************\n   Escoja una opcion\n   (1)-Nuevo Producto\n   (2)-Eliminar Producto\n   (3)-Cambios\n   (4)-Consultar datos\n   (5)-Regresar al menu principal\n*******************************************************************************";
	}
	public String Menu(){
		return w;
	}
	public String Menu2(){
		return w2;
	}
	public String Menu3(){
		return w3;
	}	
}
