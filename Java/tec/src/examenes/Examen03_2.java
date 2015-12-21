package examenes;
import paq1.Formatea;
import paq1.Leer;

class alumno32
{
	private long [] cuenta;
	private String [] nom;
	private int [] cvepgan;
	
	public alumno32(int ne)
	{
		cuenta=new long[ne];
		nom=new String[ne];
		cvepgan=new int[ne];
		
		for (int i=0; i<ne;i++)
		{
			System.out.print("Clave del Alumno..............: ");
			cuenta[i]=Leer.datoLong();
			System.out.print("Nombre de Alumno..............: ");
			nom[i]=Leer.dato();
			System.out.print("Clave de Puntos Ganados.......: ");
			cvepgan[i]=Leer.datoInt();
		}
		
	}
	
	public void despliega(puntosg ob)
	{
		String blancos;
		System.out.print("Cuenta del Alumno   Nombre                              Clave de P. Ganados   Puntos");
		System.out.println();
		System.out.println();
		
		for (int i=0;i<cuenta.length; i++)
		{
			blancos=gen_blancos(nom[i]);
			System.out.println("       "+Formatea.alinder("0000",cuenta[i])+"          "+nom[i]+"        "+cvepgan[i]+"            "+ Formatea.alinder("##,##0.00", ob.obten_puntos(cvepgan[i])));
			
		}
	}
	
	public String gen_blancos(String blancos)
	{
		int limite=36-blancos.length();
		String regresa="";
		for (int i=0; i<limite;i++)
		    regresa=regresa+" ";
		return regresa;
	}
}

class puntosg
{
	private int [] cvepga;
	private double [] puntos;
	
	public puntosg(int ne)
	{
        cvepga=new int[ne];
        puntos=new double[ne];
        
		for (int i=0; i<ne;i++)
		{
			System.out.print("Clave de P. Ganados..: ");
			cvepga[i]=Leer.datoInt();
			System.out.print("Puntos Ganados.......: ");
			puntos[i]=Leer.datoDouble();
		}
	}
	
	public double obten_puntos(int cpun)
	{
	    for (int i=0; i<cvepga.length; i++)
	    {
	    	if (cvepga[i]==cpun)
	    		return puntos[i];
	    }
	    return 0;
	}
}


public class Examen03_2 
{

	public static void main(String[] args) 
	{
		int nalu;
    	int ncpga;
    	do
    	{
    		System.out.print("Cantidad de Alumnos: ");
    		nalu=Leer.datoInt();
    	}while(nalu<=0);
    	
    	do
    	{
    		System.out.print("Cantidad de claves de Puntos ganados: ");
    		ncpga=Leer.datoInt();
    	}while(ncpga<=0);
    	
    	alumno32 objalu=new alumno32(nalu);
    	puntosg objpga=new puntosg(ncpga);
    	
    	objalu.despliega(objpga);
 
	}

}
