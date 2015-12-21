package jdialog;

import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import aplicacion.VentanaPrincipal;

public class ClaseJDialog extends JDialog
{
	static final long serialVersionUID=1;
	private Container contenedor;
	JLabel labelTitulo;/*declaramos el objeto Label*/
	JTextArea areaDeTexto;
	String texto;
	
	public ClaseJDialog(VentanaPrincipal miVentanaPrincipal, boolean modal){
		/*Al llamar al constructor super(), le enviamos el
		 * JFrame Padre y la propiedad booleana que determina
		 * que es hija*/
		super(miVentanaPrincipal, modal);
		contenedor=getContentPane();
		contenedor.setLayout(null);
   		//Asigna un titulo a la barra de titulo
		setTitle("Topicos : JDialog");
		
		
		/*Propiedades del Label, lo instanciamos, posicionamos y
		 * activamos los eventos*/
		labelTitulo= new JLabel();
		labelTitulo.setText("CONTENEDOR JDIALOG");
		labelTitulo.setBounds(120, 20, 180, 23);
		
		/*texto="Esta ventana es un JDialog, es usada como ventana de\n"+ 
				"confirmacion o como su nombre lo dice, ventana de dialogo,\n"+
				"tiene una propiedad que le permite ser hija de un JFrame u\n"+ 
				"otro JDialog, de esta manera inhabilitamos la ventana padre\n"+
				"hasta que la ventana hija sea cerrada (intenta dar click sobre\n"+
				"alguno de los botones de la ventana principal)";*/
		texto=  "Esta ventana es un JDialog, es usada como ventana de\n"+ 
				"confirmacion o como su nombre lo dice, ventana de\n"+
				"dialogo, tiene una propiedad que le permite ser hija de\n"+
				"un JFrame u otro JDialog, de esta manera inhabilitamos\n"+
				"la ventana padre hasta que la ventana hija sea cerrada";
		areaDeTexto = new JTextArea();
		areaDeTexto.setText(texto);
		areaDeTexto.setBounds(15, 50, 360, 100);
		
		/*Agregamos los componentes al Contenedor*/
		contenedor.add(labelTitulo);
		contenedor.add(areaDeTexto);
		//tama�o de la ventana
		setSize(400,200);
		//pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);
	}
}
