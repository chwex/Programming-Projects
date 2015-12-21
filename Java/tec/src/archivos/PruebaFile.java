package archivos;
import java.io.*;
public class PruebaFile {

	public static void main(String[] args) {
		File archivo = new File("Proyecto\\texto.txt");
		System.out.println("Nombre del archivo: "+archivo.getName());
		System.out.println("Directorio Padre: " +archivo.getParent());
		System.out.println("Ruta Relativa: "+archivo.getPath());
		System.out.println("Ruta Absoluta: "+archivo.getAbsolutePath());

	}

}
