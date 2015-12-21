package Unidad2;
import java.text.DecimalFormat;
import java.util.*;
public class gaussSeidel {
	static DecimalFormat formatos = new DecimalFormat("####.#####");
	public static void mensaje() {
	       System.out.println("\t\t\tInstituto Tecnologico de Culiacan"+
	                "\n\t\t\t Ing. en Sistemas Computacionales"+
	                "\n\nNombre: Carlos Baudelio Valdez Salazar"+
	                "\nMateria: Metodos Numericos"+
	                "\nTema: Metodo de Gauss-Seidel"+
	                "\nHorario: 11:00 - 12:00");
	    }
	    public static void descripcion(){
	        System.out.println("");
	        System.out.println();
	    }
	    public static void imprime(double[][]matriz) {
	        System.out.println();
	        for (int i=0;i<matriz.length;i++) {
	            for (int j=0;j<matriz[i].length;j++)
	                System.out.print(matriz[i][j]+" ");
	            System.out.println();
	        }
	        System.out.println();
	    }
		public static void main(String[] args) {
			Scanner leer = new Scanner(System.in);
			int orden = 0;
			do{
			System.out.println("Orden de la matriz");
			orden = leer.nextInt();
			}while(orden < 2 || orden > 10);	
			double[][] datos = new double[orden][orden+1];
			for(int i = 0; i<orden; i++){
				for(int j=0; j < orden+1; j++){
					System.out.println("Introduzca el dato de la posicion: ["+(i+1)+","+(j+1)+"]");
					datos[i][j]= leer.nextDouble(); 			
				}
			}		
			//captura de conceptos
			String[] concepto = new String[orden];
			double[] vAct = new double[orden];
			double[] vAnt = new double[orden];			
			for(int i = 0; i<orden; i++){
				System.out.println("Teclee el concepto #"+(i+1)+":");
				concepto[i] = leer.next();
				vAnt[i] = 0;
				vAct[i] = 0;
			}		
			System.out.println("Error:");
			double error = leer.nextDouble();
			System.out.println("Calculos totales:");
			int TC = leer.nextInt();			
			mensaje();
			descripcion();		
			//impresion de los datos iniciales de las incognitas	
			double errorTotal = 0;
			int itera = 0;
			for(int i = 0; i<orden; i++){
				System.out.print(vAnt[i]+" ");
			}			
			System.out.print(errorTotal);	
			//Proceso de eliminacion
			do{
			//	System.out.print(itera);	
			//	System.out.print(errorTotal);	
				
				for(int k = 0; k < orden; k++){
					double suma = 0;
					double Coef = datos[k][k];			
					suma=suma+datos[k][orden];				
					for(int p = 0; p < orden; p++){
						if(k==p){
						continue;
						}else{
							if(p < k){
								suma = suma + ((datos[k][p]*-1.0)*vAct[p]);
							}
							else{
								suma = suma + ((datos[k][p]*-1.0)*vAnt[p]);
							}
						}					
					}
			
					suma = suma/Coef;
					vAct[k] = suma;
				}	
				
				System.out.println("\nCalculo del error total absoluto");
				errorTotal = 0;
				errorTotal = 0;
				for(int k=0; k<orden; k++){
					errorTotal = errorTotal+ Math.abs( (Math.abs(vAct[k])-Math.abs(vAnt[k]) ) );
				}
				
				System.out.println("Impresion de los datos del Nuevo Calculo");
				itera = itera +1;
				
				for(int k = 0; k<orden; k++){
					System.out.println(formatos.format(vAct[k]));
					vAnt[k] = vAct[k];
				}				
				System.out.println("Error Total: "+errorTotal);
			}while(errorTotal>error && itera<=TC);
			
			if(errorTotal>=error)
				System.out.println("El proceso supero el numero maximo de calculos y no encontro la mejor aproximacion.");
			
			else
				for(int k=0; k<orden; k++){
					System.out.println("X"+k+"= "+concepto[k]+"\t "+formatos.format(vAct[k]));
				}    
			}
		}
