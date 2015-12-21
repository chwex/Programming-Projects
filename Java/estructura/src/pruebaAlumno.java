
import java.util.Scanner;
public class pruebaAlumno {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Nombre: ");
		String Nombre=leer.nextLine();
		System.out.println("Apellido: ");
		String Apellido = leer.nextLine();
		Alumno al = new Alumno();
		al.setNombre(Nombre);
		al.setApellido(Apellido);
		System.out.println(al);
	}

}
