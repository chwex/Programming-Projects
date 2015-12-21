package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaSwing extends JFrame 
{
	static final long serialVersionUID=1;
	private JScrollBar scrollH;
	private JScrollBar scrollV;
	private JButton button;
	private JTextField txt;
	private JLabel etiqueta;
	private JCheckBox check1;
	private JCheckBox check2;
	private JCheckBox check3;
	private JCheckBox check4;
	private JCheckBox check5;
	private JCheckBox check6;
	private JList<?> list;
	//private CheckboxGroup CBG;
	private ButtonGroup BG;
	private JTextArea texto;
	private ImageIcon imagen;
	private JLabel eti;
	private JList<?> modelo;
	
	public VentanaSwing(String titulo, int w, int h)
	{
		super(titulo);
		this.setLayout(null);
		scrollV = new JScrollBar();
		scrollV.setBounds(1346, 27, 20, 720);
		//1346,768
		scrollH = new JScrollBar(0);
		scrollH.setBounds(0, 748, 1346, 20);
		
		button = new JButton("Salir");
		button.setBounds(30, 30, 100, 30);
		
		txt = new JTextField();
		txt.setBounds(30, 70, 200, 30);
		
		etiqueta = new JLabel("Etiqueta");
		etiqueta.setBounds(30, 110, 100, 30);
		
		//CBG = new CheckboxGroup();
		BG = new ButtonGroup();
		
		check1=new JCheckBox("Opcion1", null, true);
		check1.setBounds(30, 145, 100, 25);
		check2=new JCheckBox("Opcion2", null, true);
		check2.setBounds(30, 170, 100, 25);
		check3=new JCheckBox("Opcion3", null, true);
		check3.setBounds(30, 195, 100, 25);
		BG.add(check1);
		BG.add(check2);
		BG.add(check3);
		check4=new JCheckBox("Opcion4", null, true);
		check4.setBounds(30, 220, 100, 25);
		check5=new JCheckBox("Opcion5");
		check5.setBounds(30, 245, 100, 25);
		check6=new JCheckBox("Opcion6");
		check6.setBounds(30, 270, 100, 25);
		
		String [] Elementos = {"Elemento1","Elemento2","Elemento3","Elemento4"};
		list = new JList<Object>(Elementos);
		list.setBounds(30, 295, 200, 55);
		/*
		list.add("Elemento 1");
		list.add("Elemento 2");
		list.add("Elemento 3");
		*/
		JList<String> lista2 = new JList<String>();
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		modelo.addElement("Elemento1");
		modelo.addElement("Elemento2");
		modelo.addElement("Elemento3");
		lista2.setModel(modelo);
		lista2.setBounds(240, 295, 200, 55);
		
		texto = new JTextArea();
		texto.setBounds(30, 360, 300, 100);
		
		imagen = new ImageIcon(this.getClass().getResource("images/the-flash.png"));
		eti = new JLabel(imagen);
		eti.setBounds(30,470,200,250);
		
		this.add(scrollV);
		this.add(scrollH);
		this.add(button);
		this.add(txt);
		this.add(etiqueta);
		this.add(check1);
		this.add(eti);
		this.add(check2);
		this.add(check3);
		this.add(check4);
		this.add(check5);
		this.add(check6);
		this.add(list);
		this.add(texto);
		this.add(lista2);
		
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				System.exit(0);
			}
		}
				
				);
		
		
		
		
	}

}