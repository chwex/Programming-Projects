import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Agendacompleta extends Frame
{

public  void imprimir (){
try {
    PrinterJob pjob = PrinterJob.getPrinterJob();
    pjob.setJobName("Graphics Demo Printout");
    pjob.setCopies(1);
    pjob.setPrintable(new Printable() {
      public int print(Graphics pg, PageFormat pf, int pageNum) {
          int j=70;
    	  int n=70;
    	
    	  pg.drawString("       [nombre]          "+"[Direccion]    "+"        "+"[Telefono]", 60, 50);
    	  for(int i=0; i<Directorio.length;i++){
    	  if (pageNum > 1) // we only print one page
         
        return Printable.NO_SUCH_PAGE; // ie., end of job
        pg.drawString("["+(i+1)+"]   "+Directorio[i].getNombre()+"             "+Directorio[i].getDireccion()+"               "+Directorio[i].getTelefono() , n, j);
        j=j+80;
    	  }
    //   System.out.println("Listo, Gracias por llenar los Datos :)!");
        return Printable.PAGE_EXISTS; 
      }
    });
   
    if (pjob.printDialog() == false) // choose printer
      return; 
    pjob.print(); 
  } catch (PrinterException pe) {
    pe.printStackTrace();
  }
}
}