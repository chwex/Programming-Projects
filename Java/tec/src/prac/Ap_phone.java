package prac;
import paq1.*;
public class Ap_phone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String p1 ="Windows Phone";
		String p2 ="iOS";
		String p3 ="Android";
		
		phone windowsPhone = new phone();
		phone ios = new phone();
		phone android = new phone();
		
		System.out.println(p1+" Make: ");
		String make = Leer.dato();
		windowsPhone.setMake(make);
		System.out.println(p1+" Color: ");
		String color = Leer.dato();
		windowsPhone.setColor(color);
		System.out.println(p1+" Storage: ");
		double storage = Leer.datoDouble();
		windowsPhone.setStorage(storage);
		
		/*System.out.println(p2+" Make: ");
		String make2 = Leer.dato();
		ios.setMake(make2);
		System.out.println(p2+" Color: ");
		String color2 = Leer.dato();
		ios.setColor(color2);
		System.out.println(p2+" Storage: ");
		double storage2 = Leer.datoDouble();
		ios.setStorage(storage2);
		
		System.out.println(p3+" Make: ");
		String make3 = Leer.dato();
		android.setMake(make3);
		System.out.println(p3+" Color: ");
		String color3 = Leer.dato();
		android.setColor(color3);
		System.out.println(p3+" Storage: ");
		double storage3 = Leer.datoDouble();
		android.setStorage(storage3);*/
		
		System.out.println(windowsPhone.fPhone());
		//System.out.println(ios.fPhone());
		//System.out.println(android.fPhone());
		
		System.out.println("El telefono Windows phone de "+windowsPhone.getStorage()+" GB acaba de tomar una foto.");
		windowsPhone.tomarFoto();
		System.out.println("Sus nuevas configuraciones son "+windowsPhone.fPhone());
	}

}
