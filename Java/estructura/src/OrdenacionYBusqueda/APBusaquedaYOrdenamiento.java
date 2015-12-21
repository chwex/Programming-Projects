package OrdenacionYBusqueda;
import java.util.*;

public class APBusaquedaYOrdenamiento 
{
	public static void menu()
	{
				System.out.println("\tMENU:::[ORDENAMIENTO Y BUSQUEDA]:::\n");			
				System.out.println("1-ORDENAR POR SELECCION");
				System.out.println("2-ORDENAR POR INSERCION ");
				System.out.println("3-ORDENAR POR LA BURBUJA");
				System.out.println("4-ORDENAMIENTO RAPIDO");
				System.out.println("5-ORDENAR POR MEZCLA");
				System.out.println("6-BUSQUEDA BINARIA ");
				System.out.println("7-BUSQUEDA LINEAL");
				System.out.println("8-SALIR");		
	}
	
	public static void main (String [] args)
	{
		Random rnd=new Random();
		Integer[] array=new Integer[10];
		Scanner l =new Scanner (System.in);
		SortingAndSearching<Integer> uno = new SortingAndSearching <Integer>();
		int op;	
		
		do
		{
			menu();
			System.out.println("SELECCIONE UNA OPCION");
			op = l.nextInt();
			switch(op)
			{
				case 1: if(op==1)
				{
					System.out.println("NUMEROS GENERADOS ALEATORIAMENTE: ");
					for(int i=0;i<10;i++)
					{
						array[i]= rnd.nextInt(10)+1;	
						System.out.println(array[i]);
					}
					System.out.print(" \n");
					uno.selectionSort(array);
					System.out.println("NUMEROS ORDENADOS POR SELECCION: ");
					for(int i=0;i<10;i++)
					{		
						System.out.println(array[i]);
					}
					
					System.out.println(" \n\n");
				}
				break;
			
				case 2: if(op==2)
				{
					System.out.println("NUMEROS GENERADOS ALEATORIAMENTE: ");
					for(int i=0;i<10;i++)
					{		
						array[i]= rnd.nextInt(10)+1;	
						System.out.println(array[i]);
					}
					System.out.print(" \n");
					uno.insertionSort(array);
					System.out.println("NUMEROS ORDENADOS POR INSERCION: ");
					for(int i=0;i<10;i++)
					{
						System.out.println(array[i]);
					}
					System.out.println(" \n\n");
				}
				break;
		
				case 3: if(op==3)
				{
					System.out.println("NUMEROS GENERADOS ALEATORIAMENTE: ");
					for(int i=0;i<10;i++)
					{
						array[i]= rnd.nextInt(10)+1;	
						System.out.println(array[i]);
					}
					
					System.out.print(" \n");
					uno.bubbleSort(array);
					System.out.println("NUMEROS ORDENADOS POR METODO DE LA BURBUJA: ");
					
					for(int i=0;i<10;i++)
					{
						System.out.println(array[i]);
					}
					
					System.out.println(" \n\n");
				}
				break;
	
				case 4: if(op==4)
				{	
					System.out.println("NUMEROS GENERADOS ALEATORIAMENTE: ");
					for(int i=0;i<10;i++)
					{
						array[i]= rnd.nextInt(10)+1;	
						System.out.println(array[i]);
					}
					
					System.out.print(" \n");
					uno.quickSort(array, 0, array.length-1 );
					System.out.println("NUMEROS ORDENADOS POR ORDENACION RAPIDA: ");
			
					for(int i=0;i<10;i++)
					{
						System.out.println(array[i]);
					}
					System.out.println(" \n\n");
				}
				break;
		
				case 5:
					if(op==5)
					{
						System.out.println("NUMEROS GENERADOS ALEATORIAMENTE: ");
						for(int i=0;i<10;i++)
						{
							array[i]= rnd.nextInt(10)+1;	
							System.out.println(array[i]);
						}
						
						System.out.print(" \n");
						uno.mergeSort(array, 0, array.length-1);
						System.out.println("NUMEROS ORDENADOS POR MEZCLA: ");
				
						for(int i=0;i<10;i++)
						{
							System.out.println(array[i]);
						}
						System.out.println(" \n\n");	
					}
		
					break;
	
				case 6: if(op==6)
				{	
					for(int i=0;i<10;i++)
					{
						array[i]= rnd.nextInt(10)+1;
					}
		
					uno.insertionSort(array);
			
					System.out.println("POSIBLES NUMEROS QUE PUEDES BUSCAR");
					for(int i=0;i<10;i++)
					{
						System.out.println(+array[i]);
					}
			
					System.out.println("\n QUE ELEMENTO QUIERE BUSCAR: ");
					
					int target = l.nextInt();
			
					if(uno.binarySearch(array, 0, array.length-1, target) == false)
					{
						System.out.println("ELEMENTO NO ENCONTRADO");
						System.out.println(-1);
					}
		   
				}	
				break;
		
				case 7: if(op==7)
				{
					System.out.println("POSIBLES NUMERO QUE PUEDES BUSCAR");
					for(int i=0;i<10;i++)
					{
						array[i]= rnd.nextInt(10)+1;	
						System.out.println(array[i]);
					}
			
					System.out.println("\n QUE ELEMENTO QUIERE BUSCAR: ");
					int target = l.nextInt();
					uno.linearSearch(array, 0, array.length-1, target);
				}	
				break;
			}	
		}while(op!=8);		
	}
}