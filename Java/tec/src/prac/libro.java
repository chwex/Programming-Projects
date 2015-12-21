package prac;

import java.awt.*;
import java.math.*;
import java.util.*; 
import paq1.Leer;

public class libro {

	public static  void imprimir (int v[]){
	    /*// Creamos un Frame para obtener un objeto PrintJob sobre él	
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
	    pg.drawString("",n,j);
	   // pg.drawString("nombre  "+" direccion "+" telefono ",n,90);
	    for(int i=0; i<v.length; i++){
	    pg.drawString(Integer.toString(v[i]),n,90);
	    	System.out.println("  ");
	   // pg.drawString(Directorio[i].getNombre()+"    "+Directorio[i].getDireccion()+"     "+Directorio[i].getTelefono(),n,j);
	    // Se finaliza la página
	    j=j+40;
	    }
	    pg.dispose();
	    // Se hace que la impresora termine el trabajo y escupa la página
	    pjob.end();          
	    // Se acabó
	    System.exit( 0 );    
	    */
		
			 
		  public book() {
			  
		  }
		}
		
	public static void main(String[] args) {
		int v[];
		v=new int[60];
		
		for(int i=0; i<v.length; i++)
		{
			Random r = new Random();
			v[i]= 1 + r.nextInt(10);
		}
	imprimir(v);
	}

}
