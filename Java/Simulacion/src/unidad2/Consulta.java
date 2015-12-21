package unidad2;
import java.util.*;

public class Consulta {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		double dias[] = new double[6];
		
		System.out.print("Ingrese el numero de dias ");
		double n = in.nextInt();
		
		for(int i=0;i<n;i++){
			double aux = (double)(r.nextInt(10001));
			aux /=10000;
			if(aux>=0 && aux<=0.05)
				dias[0]++;
			if(aux>0.05 && aux<=0.15)
				dias[1]++;
			if(aux>0.15 && aux<=0.35)
				dias[2]++;
			if(aux>0.35 && aux<=0.65)
				dias[3]++;
			if(aux>0.65 && aux<=0.85)
				dias[4]++;
			if(aux>0.85 && aux<=1)
				dias[5]++;
		}
		imprime(dias, n);
	}
	
	public static void imprime(double datos[], double n ){
		
		System.out.println("*Consulta\t*Frecuencia*\t*Frec. Relat*\t*Frec. Rel. Acum.\t*Consulta\t*Porcentaje");
		System.out.println("0\t\t10\t\t0.05\t\t0.05\t\t\t"+datos[0]+"\t\t"+(datos[0]/n)*100+"%");
		System.out.println("1\t\t20\t\t0.10\t\t0.15\t\t\t"+datos[1]+"\t\t"+(datos[1]/n)*100+"%");
		System.out.println("2\t\t40\t\t0.20\t\t0.35\t\t\t"+datos[2]+"\t\t"+(datos[2]/n)*100+"%");
		System.out.println("3\t\t60\t\t0.30\t\t0.65\t\t\t"+datos[3]+"\t\t"+(datos[3]/n)*100+"%");
		System.out.println("4\t\t40\t\t0.20\t\t0.85\t\t\t"+datos[4]+"\t\t"+(datos[4]/n)*100+"%");
		System.out.println("5\t\t30\t\t0.15\t\t1.00\t\t\t"+datos[5]+"\t\t"+(datos[5]/n)*100+"%");
	}
}
