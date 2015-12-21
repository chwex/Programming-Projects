package empresa;
import java.util.*;
public class Empresa{
	public static void main (String[]args){
//******************************Empleados*********************************************
		String [] nn={"Luis Arturo","Marcos Alan","Carlos Bau"};
		int [] cc={1,2,3};	
		double comision=200;
		double rw=0;
//******************************Productos*********************************************
		String [] np={"Alfombra lisa","Alfombra tejida","Alfombra larga","Tapices abstractos","Tapices ligeros","Lampara aerea","Lampara buro","Tapete moderno","Muebles de cuarto","Mueble de vista"};
		int [] cp={0,1,2,3,4,5,6,7,8,9};	
		double [] pp={145,205,250,150,185,285,220,120,150,215};	
//******************************Presupuesto variables*************************************
		Vector<Presupuesto> presupuest=new Vector<Presupuesto> (10,5);
		Vector<PresupuestoVenta> presupuestventa=new Vector<PresupuestoVenta> (10,5);
		int contadorpresupuesto=0;
		int contadorpresupuesto2=0;
		int con=0;
		int produc=0;
		int ww=0;
		double totalpresupuesto=0;
		int variableservicio=0;
		double costodeservicio=0;
//******************************Actualizacion de empleados variables*************************************
	String nomb="h";
	int contadorespecial=1;
	int contadorespecial2=3;
	int xxt=0;
	String nuevonombre="h";
//******************************EMPLEADO COMISION Y PRODUCTOS*********************************************
	Vector<Producto> producto=new Vector<Producto> (10,5);	
	Vector<EmpleadoComision> empleadoc=new Vector<EmpleadoComision> (10,5);
		for (int i=0;i<10;i++){
			producto.insertElementAt(new Producto(np[i],cp[i],pp[i]),i); 
			if (i<3){
				empleadoc.insertElementAt(new EmpleadoComision(nn[i],cc[i],rw),i); 
			}
		}
//******************************EMPLEADO BASE*********************************************
		Vector<EmpleadoBase> empleadob=new Vector<EmpleadoBase> (10,5);
		empleadob.insertElementAt(new EmpleadoBase("Jose Alan",0,0),0); 
//******************************PRODUCTOS*********************************************
		Vector<Integer> produc2=new Vector<Integer> (10,5);
//******************************CLIENTES*********************************************
		String nombre="h";
		String direccion="h";
		int codigopostal=0;
		int ndecliente=0;
		Vector<Cliente> cliente=new Vector<Cliente> (10,5);		
//******************************ACTUALIZACION DE EMPLEADOS*********************************************
	int contadorespecialproductos=10;
	int borrar=0;
	int precio=0;
	double nuevoprecio=0;
//*******************************IMPRIMIR VENTAS********************************************
	double totaldeventas=0;
	double salariototal=0;
//****************************************************************************************
//********************************************MENU****************************************
//****************************************************************************************
		Menu menu=new Menu();
			int variablemenu=0;
		while(con==0){
			System.out.println(menu.Menu());
			con=Keyboard.readInt();
//******************************Presupuesto*********************************************
			if (con!=6){
				if (con==1){
					System.out.println("Nombre del cliente");
						nombre=Keyboard.readString();
					System.out.println("Direccion");
						direccion=Keyboard.readString();
					System.out.println("Codigo Postal");
						codigopostal=Keyboard.readInt();
					cliente.insertElementAt(new Cliente(nombre,direccion,codigopostal),ndecliente); 
					ndecliente++;
					while(con==1){
						System.out.println("Teclee el codigo del producto");
						produc=Keyboard.readInt();
						if (produc==3 || produc==5 || produc==8){
							System.out.println("Desea el servicio de instalacion (1)-Si   (0)-No");
							variableservicio=Keyboard.readInt();
							if (variableservicio==1){
								switch(produc){
									case 3:costodeservicio=costodeservicio+100;break;
									case 5:costodeservicio=costodeservicio+200;break;
									case 8:costodeservicio=costodeservicio+300;break;
								}
							}
						}
						produc2.insertElementAt((Integer)produc, ww); 
						System.out.println("Desea agregar otro producto? (1)-Si   (0)-No");
						con=Keyboard.readInt();
						ww++;
					}
					System.out.println(cliente.elementAt(0).getNombre());
					int [] productoarreglo=new int[ww];
					for (int i=0; i<ww;i++){
						productoarreglo[i]=produc2.elementAt(i);
						System.out.println(np[produc2.elementAt(i)]+"\t\t"+pp[produc2.elementAt(i)]); 
						totalpresupuesto=totalpresupuesto+pp[produc2.elementAt(i)];
					}
					System.out.println("Costo de la instalacion(es)"+costodeservicio); 
					totalpresupuesto=totalpresupuesto+costodeservicio;
					System.out.println("Total\t\t\t"+totalpresupuesto);	
					System.out.println("El cliente concretara la compra? (1)-Si   (0)-No");
					int ccc=Keyboard.readInt();	
					if (ccc==1){
						System.out.println("Por favor teclea tu numero de empleado(por cierto bien hecho :D)");
						int cempleado=Keyboard.readInt();
						empleadoc.elementAt(cempleado).setSueldo(129);
						presupuestventa.insertElementAt(new PresupuestoVenta(nombre,ww,productoarreglo,totalpresupuesto), contadorpresupuesto2); 
						contadorpresupuesto2++;
						
					}
					else{
						System.out.println("awwww D:, para la proxima sera :D");
					}
					presupuest.insertElementAt(new Presupuesto(nombre,ww,productoarreglo,totalpresupuesto), contadorpresupuesto); 
					contadorpresupuesto++;
					
				}
//**************************************Actualizacion de empleados***************************************************	
				if (con==2){
					int x=1;
					while (x==1){
						System.out.println(menu.Menu2());
						x=Keyboard.readInt();
		//Altas~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						if (x==1){
							System.out.println("(1)-Empleado Base  o  (2)-Empleado Comision");
							int xx=Keyboard.readInt();
								if (xx==1){
									System.out.println("Nombre");
									nomb=Keyboard.readString();
									contadorespecial=1;
									empleadob.addElement(new EmpleadoBase(nomb,contadorespecial,0));
									contadorespecial++;
								}
								if (xx==2){
									System.out.println("Nombre");
									nomb=Keyboard.readString();
									empleadoc.addElement(new EmpleadoComision(nomb,contadorespecial2,rw));
									contadorespecial2++;
								}
						}
		//Bajas~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						if (x==2){
							System.out.println("(1)-Empleado Base  o  (2)-Empleado Comision");
							int xx=Keyboard.readInt();
								if (xx==1){
									System.out.println("Teclee el Numero de empleado al cual desea borrar");
									xxt=Keyboard.readInt();
									empleadob.removeElementAt(xxt);
								}
								if (xx==2){
									System.out.println("Teclee el Numero de empleado al cual desea borrar");
									xxt=Keyboard.readInt();
									empleadoc.removeElementAt(xxt);
								}
						}
		//Cambios~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						if (x==3){
							System.out.println("(1)-Empleado Base  o  (2)-Empleado Comision");
							int xx=Keyboard.readInt();
								if (xx==1){
									System.out.println("Teclee el Numero de empleado que desea modificar");
									xxt=Keyboard.readInt();
									System.out.println("Teclee el Nombre nuevo");
									nuevonombre=Keyboard.readString();	
									empleadoc.elementAt(xxt).setNuevoNombre(nuevonombre);
								}
								if (xx==2){
									System.out.println("Teclee el Numero de empleado que desea modificar");
									xxt=Keyboard.readInt();
									System.out.println("Teclee el Nombre nuevo");
									nuevonombre=Keyboard.readString();	
									empleadob.elementAt(xxt).setNuevoNombre(nuevonombre);								
								}
						}
		//Consultas~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						if (x==4){
							System.out.println("(1)-Empleado Base  o  (2)-Empleado Comision");
							int xx=Keyboard.readInt();
								if (xx==1){
									System.out.println("Teclee el Numero de empleado que desea consultar");
									xxt=Keyboard.readInt();
									System.out.println("Nombre: "+empleadoc.elementAt(xxt).getNombre()+"\nSalario"+empleadoc.elementAt(xxt).getSueldo());
								}
								if (xx==2){
									System.out.println("Teclee el Numero de empleado que desea consultar");
									xxt=Keyboard.readInt();
									System.out.println("Nombre: "+empleadob.elementAt(xxt).getNombre()+"\nSalario"+empleadob.elementAt(xxt).getSueldo());								
								}
						}															
					}
				}
//*****************************************Actualizacion de Productos******************************************************************************************
				if (con==3){
					int x=1;
					while (x==1){
						System.out.println(menu.Menu3());
						x=Keyboard.readInt();
		//Altas~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						if (x==1){
							System.out.println("Nombre");
							nomb=Keyboard.readString();
							System.out.println("Precio");
							precio=Keyboard.readInt();									
							producto.addElement(new Producto(nomb, contadorespecialproductos, precio));
							contadorespecialproductos++;
						}
					
		//Bajas~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						if (x==2){
							System.out.println("Teclee el Numero de producto al cual desea borrar");
							borrar=Keyboard.readInt();
							producto.removeElementAt(borrar);
						}
		//Cambios~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						if (x==3){
							System.out.println("Teclee el Numero de producto que desea modificar");
							borrar=Keyboard.readInt();
							System.out.println("Teclee el Nombre nuevo");
							nuevonombre=Keyboard.readString();	
							producto.elementAt(borrar).setNuevoNombre(nuevonombre);
							System.out.println("Teclee el Precio nuevo");
							nuevoprecio=Keyboard.readDouble();	
							producto.elementAt(borrar).setNuevoPrecio(nuevoprecio);
						}
		//Consultas~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						if (x==4){
							System.out.println("Teclee el Numero de producto que desea consultar");
							borrar=Keyboard.readInt();
							System.out.println("Nombre: "+producto.elementAt(borrar).getNombre()+"\nPrecio"+producto.elementAt(borrar).getPrecio());
						}															
					}					
				}
				if (con==4){
				System.out.println("                      Presupuestos Concretados (Ventas)");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
					for (int i=0; i<contadorpresupuesto2;i++){
						int [] imprimirventa=new int[presupuestventa.elementAt(i).getW()];
						System.out.println(presupuestventa.elementAt(i).getNombre());
						imprimirventa=presupuestventa.elementAt(i).getArreglo();
						totaldeventas=totaldeventas+presupuestventa.elementAt(i).getTotalP();
						System.out.println("*******************************************************************************"); 
						for (int j=0;j<presupuestventa.elementAt(i).getW();j++){
							System.out.println(np[imprimirventa[j]]+"\t\t"+pp[imprimirventa[j]]); 
						}
					}
					System.out.println("Total de ventas: \t"+totaldeventas);
					System.out.println("*******************************************************************************"); 
					totaldeventas=0;
				}			
				if (con==5){
					System.out.println("                                   Empresa, S.A.");
					System.out.println("                                Nomina de empleados");
					System.out.println("                      correspondiente a la semana del x al x" );
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");				
					System.out.println("Nombre\t\t\tSalario\t");
					for (int i=0;i<contadorespecial2;i++){
						System.out.println(empleadoc.elementAt(i).getNombre()+"\t\t"+empleadoc.elementAt(i).getSueldo());
						salariototal=salariototal+empleadoc.elementAt(i).getSueldo();
					}
					for (int j=0;j<contadorespecial;j++){
						System.out.println(empleadob.elementAt(j).getNombre()+"\t\t"+empleadob.elementAt(j).getSueldo());
						salariototal=salariototal+empleadob.elementAt(j).getSueldo();
					}
					System.out.println("Salario total a pagar:  "+salariototal);
					salariototal=0;
				}
				con=0;
			}
		}
		for (int i=0; i<contadorpresupuesto;i++){
			int [] imprimirv=new int[presupuest.elementAt(i).getW()];
			System.out.println(presupuest.elementAt(i).getNombre());
			imprimirv=presupuest.elementAt(i).getArreglo();
			for (int j=0;j<presupuest.elementAt(i).getW();j++){
				System.out.println(np[imprimirv[j]]+"\t\t"+pp[imprimirv[j]]); 
			}
		}		
	}
}