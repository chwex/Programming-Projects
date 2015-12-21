package empresa;
import java.util.*;
public class Presupuesto{
	String nom="h";
	int w=0;
	double tp=0;
	Vector<Integer> pa=new Vector<Integer> (10,5);
	Presupuesto(String nombre,int ww,int[] productoarreglo,double totalpresupuesto){
		nom=nombre;
		w=ww;
		tp=totalpresupuesto;	
		for (int i=0;i<ww;i++){
			pa.insertElementAt((Integer)productoarreglo[i], i);			
		}		
	}
	public String getNombre(){
		return nom;
	}
	public int getW(){
		return w;
	}
	public int[] getArreglo(){
	int [] paa=new int [w];
	for (int j=0;j<w;j++){
		paa[j]=(int)pa.elementAt(j);	
	}	
		return paa;
	}
	public double getTotalP(){
		return tp;
	}	
}	

