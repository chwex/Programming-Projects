package Julio;


import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;                             
public class Agendacompleta 
{
	// atributos
	
	private PersonaC [] Directorio;			//  El vector directorio ( agenda ) es un vector de objetos ( personas )
	private int nElementos;                 //  Numero de elementos ( personas ) del vector ( agenda )
	
	// Metodos
	// Constructores
	
	public Agendacompleta()
	{
		// crear una lista vacia
		nElementos=0;                         //  Al inicio no hay personas en la agenda
		Directorio=new PersonaC[nElementos];   //  Se crea un vector ( agenda ) con 0 objetos ( personas )
	}
	
	// Interfaz
	
	public void unElementoMas(PersonaC [] v)       
	{                                                 
		nElementos=v.length;
		Directorio=new PersonaC[nElementos + 1];   //  Se crea un vector con un elemento mas
		// copiar el vector actual
		for (int i=0; i<nElementos; i++)          //  Se copian los elementos del vector ( El vector del parametro )
			Directorio[i]=v[i];                   //  en el nuevo vector, quedando un elemento al final vacio.
		nElementos++;                             //  Se actualiza el atributo de numero de elementos del vector 
	}
	
	public void unElementoMenos(PersonaC [] v)
	{
		if (v.length==0)
			return;
		else
		{
		   int k=0;
		   nElementos=v.length;
		   Directorio=new PersonaC[nElementos - 1];   //  Se crea un vector con un elemento menos
		   // copiar el vector actual
		   for (int i=0; i<nElementos; i++)          //  Se copian los elementos del vector ( El vector del parametro )  
			   if (v[i]!= null)                      //  en el nuevo vector, eliminado al elemento que previamente
				   Directorio[k++]=v[i];             //  se marco como eliminado ( Null ) en el metodo
		                                             //  eliminar de esta clase
		   nElementos--;                             //  Se actualiza el atributo de numero de elementos del vector
		}
	}
	
	public void asignarValorEn(int i, PersonaC objeto)
	{
		if (i>=0 && i<nElementos)                   // se asigna al elemento iesimo del vector el objeto persona
			Directorio[i]=objeto;                   // recibido en el parametro.
		else
			System.out.println("Indice fuera de limites...");
	}
	
	public PersonaC obtenerValorEn(int i)
	{
		if (i>=0 && i<nElementos)
			return Directorio[i];             // se obtiene el elemento iesimo del vector solicitado en el parametro
		else
		{
			System.out.println("Indice fuera de limites...");
			return null;
		}
	}
	
	public int longitud()
	{
		return nElementos;       // se obtiene el numero de elementos del vector
	}
	
	public void agregar(PersonaC obj)
	{
		unElementoMas(Directorio);				//  Se agrega un objeto ( persona ) al vector ( Agenda )
		asignarValorEn(nElementos-1,obj);
	}
	
	public boolean eliminar(long tel)
	{
		// buscar un telefono y eliminar el registro
		for(int i=0; i<nElementos; i++)
			if(Directorio[i].getTelefono()==tel)
			{
				Directorio[i]=null;                 // Se elimina un elemento del vector asignadole null a su referencia 
				unElementoMenos(Directorio);        // es decir, se elimina la referencia al objeto ( persona ) 
				return true;                        // a eliminar.
			}
		return false;
	}
	
	public int buscar(String str, int pos)        // pos es la posicion a partir de donde se va a iniciar la busqueda
	{
		String nom;
		if (str==null) return -1;
		if (pos<0) pos=0;
		for (int i=pos; i<nElementos; i++)       // se busca en el directorio  
		{
			nom=Directorio[i].getNombre();  
			if (nom==null) continue;
			// ? str es parte de nom..?
			if (nom.indexOf(str)>-1)
				return i;                      // regresa la posicion del elemento buscado
		}
		return -1;
	}
	
	public void ordenar()
	{
	PersonaC temp = null;
	
		for(int i=0;i<Directorio.length-1;i++)
		{
			for(int j=i+1;j<Directorio.length;j++)
			{
				if((Directorio[i].getNombre().compareTo(Directorio[j].getNombre()))>0)
				{
					temp=Directorio[i];
					Directorio[i]=Directorio[j];
					Directorio[j]=temp;
				}
			}
		}
	}
	
	public void desplegar()
	{
		System.out.println("\tNombre 	Direccion 			Telefono");
		for(int i=0; i<Directorio.length; i++)
		{
			
			System.out.print("\t"+Directorio[i].getNombre());
			System.out.print("\t"+Directorio[i].getDireccion()+"		");
			System.out.print("\t"+Directorio[i].getTelefono()+"		");
			System.out.println("");
		}
	}
	
	public void guardar(){ 
		FileWriter fichero = null;
		 PrintWriter pw = null;
		try{
			fichero = new FileWriter("C:\\Archivo.txt");
			pw = new PrintWriter(fichero);
			for(int i=0;i<Directorio.length;i++){
				pw.println(Directorio[i].getNombre()+" "+Directorio[i].getDireccion()+" "+Directorio[i].getTelefono());
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			System.out.println("Sus archivos ya se guardaron en C:/Archivo.txt");
			pw.close();
		}
}
public void cargar(){
		//File archivo = null;
		//FileReader fr = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		
		StringTokenizer tokens = null;
		try{
			//archivo = new File("C:\\Archivo.txt");
			//fr = new FileReader(archivo);
			fis = new FileInputStream("C:\\Archivo.txt");
			dis = new DataInputStream(fis);
			isr = new InputStreamReader(dis);
			br = new BufferedReader(isr);
			Directorio = new PersonaC[nElementos];
			unElementoMas(Directorio);
			String Linea;
			int k=0;
			while((Linea = br.readLine())!=null){
				tokens = new StringTokenizer(Linea);
				int i = 0;
				int v = tokens.countTokens();
				String t[] = new String[v];
				while(tokens.hasMoreTokens()){
					t[i] = tokens.nextToken();
					i++;
				}
				long z = Long.parseLong(t[2]);
				PersonaC p = new PersonaC(t[0],t[1],z);
				asignarValorEn(k,p);
				unElementoMas(Directorio);
				k++;
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Sus archivos se han cargado satisfactoriamente en la memoria");
			try{
				if(null != dis){
					dis.close();
				}
			} catch(Exception ee){
				ee.printStackTrace();
			}
		}
}
	
	
	
	
public  void imprimir (){
    // Creamos un Frame para obtener un objeto PrintJob sobre él	
    Frame f = new Frame( "prueba" );
    f.pack();
    // Se obtiene el objeto PrintJob
    PrintJob pjob = f.getToolkit().getPrintJob( f,"Impresion del Saludo",null );
    // Se obtiene el objeto graphics sobre el que pintar
    Graphics pg = pjob.getGraphics();     
    // Se fija el font de caracteres con que se escribe
    pg.setFont( new Font( "SansSerif",Font.PLAIN,12 ) );
    // Se escribe el mensaje de saludo
    int j=70;
    System.out.println("Listo, Gracias por llenar los Datos :)!");
    int n=70;
    
   // pg.drawString("nombre  "+" direccion "+" telefono ",n,90);
    for(int i=0; i<Directorio.length;i++){
    //pg.drawString(obj.getnombre(),n,90);
    	System.out.println("  ");
    pg.drawString(Directorio[i].getNombre()+"    "+Directorio[i].getDireccion()+"     "+Directorio[i].getTelefono(),n,j);
    // Se finaliza la página
    j=j+40;
    }
    pg.dispose();
    // Se hace que la impresora termine el trabajo y escupa la página
    pjob.end();          
    // Se acabó
    System.exit( 0 );    
	}	
				


	
	
		
}
