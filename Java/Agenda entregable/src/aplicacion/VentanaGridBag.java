package aplicacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aplicacion.VentanaGridBag;

public class VentanaGridBag extends javax.swing.JDialog 
{
	public VentanaGridBag(java.awt.Frame parent, boolean modal) 
	{
		super(parent, modal);
		setSize(350,150);
		setLocation(400,200);

		//Derecha Listado
		JPanel jpCaptura = null;
			
		//Herramientas par la captura dentro del panel
		JLabel lblEocab;
		JLabel lblSinopsis;
		JButton yo;
		JTextArea uno;
		JTextArea jtaSinopsis;

		//Usando el GridBag
		//Texto
		this.getContentPane().setLayout (new GridBagLayout());
		JTextArea areaTexto = new JTextArea("Area texto");
		this.getContentPane().add (areaTexto);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0; // El área de texto empieza en la columna cero.
		constraints.gridy = 0; // El área de texto empieza en la fila cero
		constraints.gridwidth = 2; // El área de texto ocupa dos columnas.
		constraints.gridheight = 2; // El área de texto ocupa 2 filas.
		this.getContentPane().add (areaTexto, constraints);
		lblEocab = new JLabel("CAPTURA DE DATOS");
		constraints.fill = GridBagConstraints.RELATIVE;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
	
		constraints.weightx = 0.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTH;
	
		constraints.insets = new Insets(0,5,0,0);
		//c.ipadx = 0;
		//c.ipady=7;
	
		jpCaptura.add(lblEocab,constraints);
	
		//lblEocab.setIcon(new ImageIcon("dvd.pgj"));

		constraints.gridx = 1;// INDICA LA COLUMNA  EN QUE SE POSICIONA EL ELEMENTO
		constraints.gridy = 0;// INDICA LA FILA EN QUE SE POSICIONA EL ELEMENTO 
		jpCaptura.add(lblEocab, constraints);
		
		constraints.gridwidth =3;// INDICA EL ANCHO HORIZONTAL DE LAS FILAS
		constraints.gridheight= 1;// INDICA LA ALTURA VERTICAL DE LAS COLUMNAS
		
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady=7;
		jpCaptura.add(lblEocab,constraints);
		
		yo = new JButton ("Botón 2");
		constraints.gridx = 0;// INDICA LA COLUMNA  EN QUE SE POSICIONA EL ELEMENTO
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 0.5;
		constraints.gridx = 1;
		constraints.gridy = 0;
		jpCaptura.add (yo, constraints);
		
		constraints.insets = new Insets(1,5,1,0);
		lblSinopsis = new JLabel("Sipnosis");
		constraints.gridx = 0;
		constraints.gridy = 11;
		constraints.gridwidth =2;
		constraints.gridheight= 1;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;
		jpCaptura.add(lblSinopsis,constraints);
		jtaSinopsis = new JTextArea();
		constraints.gridx = 0;
		constraints.gridy = 12;
		constraints.gridwidth =2;
		constraints.gridheight= 2;
		constraints.weightx = 0.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BASELINE;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		jpCaptura.add(jtaSinopsis,constraints);
		
		constraints.insets = new Insets(1,5,3,2);
		uno = new JTextArea("ddd");
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth =1;
		constraints.gridheight= 1;
		constraints.weightx = 1.0;
		constraints.weighty = 0.0;
		uno.setBounds(34,43,23,43);
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		jpCaptura.add(uno,constraints);
		
		jtaSinopsis = new JTextArea();
		constraints.gridx = 0;
		constraints.gridy = 12;
		constraints.gridwidth =2;
		constraints.gridheight= 2;
		constraints.weightx = 0.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BASELINE;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		jpCaptura.add(jtaSinopsis,constraints);
		
		constraints.insets = new Insets(0,5,0,0);
		constraints.ipadx = 0;
		constraints.ipady=7;
		jpCaptura.add(lblEocab,constraints);
	}
} 