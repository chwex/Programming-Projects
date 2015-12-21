package OrdenacionYBusqueda;

public class SortingAndSearching<T extends Comparable> {
    //Metodos de Ordenación...
    //Por Selección...
       public void selectionSort (T[] data)
       {
    	   int min;
    	   T temp;
    	   for (int index = 0; index < data.length-1; index++)
    	   {
    		   min = index;
    		   for (int scan = index+1; scan < data.length; scan++)
    			   if (data[scan].compareTo(data[min])<0)
    				   min = scan;
    		   
    		   // Intercambiar los valores
    		   temp = data[min];
    		   data[min] = data[index];
    		   data[index] = temp;
    	   }	
       } 
       
       //Por Insercción...
       public void insertionSort (T[] data)
       {
    	   for (int index = 1; index < data.length; index++)
    	   {
    		   T key = data[index];
    		   int position = index;
    		   
    		   // Desplazar los valores mayors hacia la derecha
    		   while (position > 0 && data[position-1].compareTo(key) > 0)
    		   {
    			   data[position] = data[position-1];
    			   position--;
    		   }
            
    		   data[position] = key;
    	   	}
       } 
       
       //Por Burbuja...
      public void bubbleSort (T[] data)
      {
    	  int position, scan;
    	  T temp;

    	  for (position =  data.length - 1; position >= 0; position--)
    	  {
    		  for (scan = 0; scan <= position - 1; scan++)
    		  {
    			  if (data[scan].compareTo(data[scan+1]) > 0)
    			  {
    				  // Intercambiar los valores
    				  temp = data[scan];
    				  data[scan] = data[scan + 1];
    				  data[scan + 1] = temp;
    			  }
    		  }
    	  }
      }
       
       //Por Rapido...
       public void quickSort (T[] data, int min, int max)
       {
    	   int indexofpartition;
    	   if (max - min  > 0)
    	   {
    		   // Crea las particiones
    		   indexofpartition = findPartition(data, min, max);
    		 
    		   // Ordena el lado izquierdo
    		   quickSort(data, min, indexofpartition - 1);
    		   
    		   // Ordena el lado derecho
    		   quickSort(data, indexofpartition + 1, max);
    	   }
       }
       
       //Metodo findPartition para usarse en Metodo Rapido...
       private int findPartition (T[] data, int min, int max)
       {
    	   int left, right;
    	   T temp, partitionElement;

    	   // utilizer el primer elemento como elemento de partición
    	   partitionElement = data[min];

    	   left = min;
    	   right = max;
    	   while (left<right)
    	   {
    		   // buscar un elemento que sea mayor que el elemento  de partición
    		   while (data[left].compareTo(partitionElement) <= 0 && left < right)
    			   left++;

    		   // buscar un elemento que sea menor que el elemento de partición
    		   while (data[right].compareTo(partitionElement) > 0)
    			   right--;
    		   
    		   // intercambiar los elementos
    		   if (left<right)
    		   {
    			   temp = data[left];
    			   data[left] = data[right];
    			   data[right] = temp;
    		   }
    	   }
    	   
    	   //mover el elemento de partición hasta el índice de partición
    	   temp = data[min];
    	   data[min] = data[right];
    	   data[right] = temp;
         
    	   return right;
       }
       
       //Por Mezcla...
       public void mergeSort (T[] data, int min, int max)
       {
    	   T[] temp;
    	   int index1, left, right;
    	   
    	   // volver al encontrarse una lista de longitude uno
    	   if (min == max)
    		   return;
    	   
    	   // Calcular la longitude y el punto medio de la lista
    	   int size = max - min + 1;
    	   int pivot = (min + max) / 2;
    	   temp = (T[])(new Comparable[size]);
    	   
    	   //ordenar la mitad izquierda de la lista
    	   mergeSort(data, min, pivot);
    	   
    	   //ordenar la mitad derecha de la lista
    	   mergeSort(data, pivot + 1, max);
    	   
    	   //copiar los datos ordenados al espacio de trabajo
    	   for (index1 = 0; index1 < size; index1++)
    		   temp[index1] = data[min + index1];
    	   
    	   // mezclar las dos listas ordenadas
    	   left = 0;
    	   right = pivot - min + 1;
    	   for (index1 = 0; index1 < size; index1++)
    	   {
    		   if (right <= max - min)
    			   if (left <= pivot - min)
    				   if (temp[left].compareTo(temp[right]) > 0)
    					   data[index1 + min] = temp[right++];               
    				   else
    					   data[index1 + min] = temp[left++];
    			   else
    				   data[index1 + min] = temp[right++];
    		   else
    			   data[index1 + min] = temp[left++];
    	   }
       }

//Metodos de Busqueda...
//Busqueda Lineal...
	public boolean linearSearch (T[] data, int min, int max, T target)
	{
		int index = min;
		int noE=-1;
		boolean found = false;
        while (!found && index <= max)
        {
            if (data[index].compareTo(target) == 0) 
                found = true;
            index++;
        } 
       
        if(found)
            System.out.println("EL ELEMENTO SE ENCUENTRA EN LA POSICION: "+index);
        else
            System.out.println("NO SE ENCONTRO EL ELEMENTO: "+noE+"\n");
        return found;
	}
	
	//Busqueda Binaria...
	public boolean binarySearch (T[] data, int min, int max, T target)
    {  
      boolean found = false;
      
      int midpoint = (min + max) / 2;  // determina el punto central
      
      if (data[midpoint].compareTo(target) == 0)
      {
         found = true;
         System.out.println("ELEMENTO ENCONTRADO EN LA POSICION:"+(midpoint+1)+"\n");
      }
   
      else if (data[midpoint].compareTo(target) > 0)
      {
         if (min <= midpoint - 1)
            found = binarySearch(data, min, midpoint - 1, target);  
      }
      
      else if (midpoint + 1 <= max)
      {
         found = binarySearch(data, midpoint + 1, max, target);
      }    
      return found;
    }
}