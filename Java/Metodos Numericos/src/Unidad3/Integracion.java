package Unidad3;
import java.util.*;
public class Integracion {

    public static void mensaje() {
        System.out.println("\n\t\t\tInstituto Tecnológico de Culiacán"+
                "\n Ing. en Sistemas Computacionales"+
                "\n\nNombre: Carlos Baudelio Valdez Salazar"+
                "\nMateria: Métodos Numéricos"+
                "\nTema: Integración"+
                "\nHorario: 11:00 - 12:00\n");
        System.out.println("El consumo diario de una franquicia está dada por la"
                + "\nintegral definida en función de f(x) = ∫(3+(x^3/x))dx"
                + "\nTabule y grafique la función para saber cuál será el consumo \ndurante los días del 4 al 7. "
                + "\nUtilíce una mejor aproximación de 6 trapecios.");
        System.out.println();
    }
    
    public static void main(String[] args) 
    {
        //Declaracion de Variables
        Scanner leer = new Scanner(System.in);
        int n, n2;
        double a, b, h, h2, ah, area, f_a, f_ah, areaTotal = 0;
        String concepto;
      
        //Mensaje y captura de datos
        mensaje();
        
        System.out.println("Defina el límite inferior: ");
        a = leer.nextDouble();
        
        System.out.println("Defina el límite superior: ");
        b = leer.nextDouble();
        
        System.out.println("Número de trapecios: ");
        n = leer.nextInt();
                
        //Concepto y inicializacion de variables
        System.out.println("Concepto: ");
        concepto = leer.next();
        h = (b-a)/n;
        h2 = h/2;
        
        //Integración
        System.out.println("TC"+"\ta"+"\ta+h"+"\tf(a)"+"\tf(a+h)"+"\tÁrea");
        for (int i=0; i<n; i++) 
        {
            ah = a+h;
            
            //funcion
            f_a = 3+Math.pow(a,2);
            f_ah = 3+Math.pow(ah,2);
            area = h2*(f_a+f_ah);
        
            System.out.println((i+1)+"\t"+a+"\t"+ah+"\t"+f_a+"\t"+f_ah+"\t"+area);
            areaTotal+=area;
            a = ah;
        }
        System.out.println("\nÁrea total = "+(areaTotal)+" "+concepto);
    }
    
}