package examenes;
import paq1.Leer;
import paq1.Formatea;
class empleado
{
	private long [] numemp;
	private String [] nomemp;
	private int [] cveest;
	
	public empleado(int ne)
	{
		numemp=new long[ne];
		nomemp=new String[ne];
		cveest=new int[ne];
		
		for (int i=0; i<ne;i++)
		{
			System.out.print("Clave de Empleado.............: ");
			numemp[i]=Leer.datoLong();
			System.out.print("Nombre de Empleado............: ");
			nomemp[i]=Leer.dato();
			System.out.print("Clave de Estimulo del Empleado: ");
			cveest[i]=Leer.datoInt();
		}
		
	}
	
	public void despliega(estimulos ob)
	{
		String blancos;
		System.out.print("Clave del Empleado   Nombre                              Clave del estimulo   Importe");
		System.out.println();
		System.out.println();
		
		for (int i=0;i<cveest.length; i++)
		{
			blancos=gen_blancos(nomemp[i]);
			System.out.println("       "+Formatea.alinder("0000",numemp[i])+"          "+nomemp[i]+blancos+"        "+cveest[i]+"            "+ Formatea.alinder("##,##0.00", ob.obten_importe(cveest[i])));
			
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

class estimulos
{
	private int [] cveest;
	private double [] importe;
	
	public estimulos(int ne)
	{
        cveest=new int[ne];
        importe=new double[ne];
        
		for (int i=0; i<ne;i++)
		{
			System.out.print("Clave de Estimulo...: ");
			cveest[i]=Leer.datoInt();
			System.out.print("Importe del Estimulo: ");
			importe[i]=Leer.datoDouble();
		}
	}
	
	public double obten_importe(int cest)
	{
	    for (int i=0; i<cveest.length; i++)
	    {
	    	if (cveest[i]==cest)
	    		return importe[i];
	    }
	    return 0;
	}
}

public class Examen03_1 
{
    public static void main (String [] args)
    {
    	int nemp;
    	int nest;
    	do
    	{
    		System.out.print("Cantidad de Empleados: ");
    		nemp=Leer.datoInt();
    	}while(nemp<=0);
    	
    	do
    	{
    		System.out.print("Cantidad de Estimulos: ");
    		nest=Leer.datoInt();
    	}while(nest<=0);
    	
    	empleado objemp=new empleado(nemp);
    	estimulos objest=new estimulos(nest);
    	
    	objemp.despliega(objest);
    	
    }
}
