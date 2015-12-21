package aplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class WinMain extends JFrame implements ActionListener,ListSelectionListener
{	
	//Elementos menu
	private JMenuBar menu;
	private JMenu jmarchivo,jmopciones,jmayuda;
	private JMenuItem jmiAgregar,jmibuscar,jmicambios,jmisalir,jmiacerca;
	
	//Elementos barra de herrmianetas 
	private JButton btnAgrega,  btnBusca, btnSalir, yo;
	private JTextField txtBusca;
	private JToolBar barraDeOpciones;

	// Elementos barra status 
	private JToolBar jtbStatus;
	private JLabel lblStatus, lblFecha, lblResgistros;

	//Elementos contenido
	private JSplitPane jspContenido;
	
	//Izquierdalistado
	private JScrollPane ScrollListado;
	private JList  jlsContactos;

	//Derecha Listado
	private JPanel jpCaptura;
	
	//Herramientas para la captura dentro del panel
	private JLabel lblEocab, lblNom, Clave, dir, tel;
	private JTextField  nom, cla,dire,tele, tel2;
	private JButton btnAgre,btnEliminar,btnActualizar, btnLimpiar;

	private final long serialVersionUID=1;
	
	//Constuctor 
	public WinMain ()
	{
		super("Mi Agenda Proyecto #1 Topicos Avanzados");
	 	
	 	//Configuracion del frame principal
	 	this.setSize(new Dimension(700,500));
	 	this.setLocationRelativeTo(null);
	 	this.setIconImage(new ImageIcon("Contacts.png").getImage());
	 	this.setResizable(true);//Para alarga la pantalla y que cresca
	 
	 	InitComponents();
	 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private  void InitComponents()
	{
		//Componentes Basicos de Agenda
		menu();
		Herramientas();
		status();
		controles();
		jlsContactos.addListSelectionListener(this);
	}
	
	private void menu() 
	{	
		menu= new JMenuBar();
		
		//Componentes Archivo
		jmarchivo= new JMenu("Archivo");
		
		jmiAgregar= new JMenuItem("Agregar");
		jmiAgregar.setMnemonic('A');
		jmiAgregar.addActionListener(this);
		jmarchivo.add(jmiAgregar);//Se agrega el menu item a la barra Archivo
		
		jmibuscar= new JMenuItem("Buscar");
		jmibuscar.setMnemonic('B');
		jmibuscar.addActionListener(this);
		jmarchivo.add(jmibuscar);//MenuItem que se agrega igual a la barra Archivo
		
		jmicambios= new JMenuItem("Cambio");
		jmicambios.setMnemonic('C');
		jmicambios.addActionListener(this);
		jmarchivo.add(jmicambios);//Otro menu Item
		
		jmisalir= new JMenuItem("Salir");
		jmisalir.setMnemonic('S');
		jmisalir.addActionListener(this);
		jmarchivo.add(jmisalir);//Menu Item
		
		
		//Componente Opciones	
		jmopciones= new JMenu("Opciones");
		
		//Componente Ayuda
		jmayuda= new JMenu("Ayuda");
		jmiacerca= new JMenuItem("Acerca de");
		jmiacerca.setMnemonic('A');
		jmiacerca.addActionListener(this);
		jmayuda.add(jmiacerca);
		
		//Agregado de Menus
		menu.add(jmarchivo);
		menu.add(jmopciones);
		menu.add(jmayuda);

		//Asignar a Menu Bar
		setJMenuBar(menu);
	}
	
	private void Herramientas() 
	{
		 
		btnAgrega = new JButton ("Agrega ");
		txtBusca  = new JTextField();
		btnBusca  = new JButton ("Buscar");
		btnSalir  = new JButton ("Salir");
		
		btnAgrega.addActionListener(this);
		btnBusca.addActionListener(this);
		btnSalir.addActionListener(this);
		
		barraDeOpciones = new  JToolBar("Opciones");
		barraDeOpciones.add(btnAgrega);
		barraDeOpciones.addSeparator(new Dimension(20,10));
		
		barraDeOpciones.add(new JSeparator(JSeparator.VERTICAL));
		barraDeOpciones.addSeparator(new Dimension(20,10));
		
		barraDeOpciones.add(txtBusca);
		barraDeOpciones.addSeparator(new Dimension(20,10));
		
		barraDeOpciones.add(btnBusca);
		barraDeOpciones.addSeparator(new Dimension(20,10));
		
		barraDeOpciones.add(btnSalir);
		barraDeOpciones.setFloatable(false);
		barraDeOpciones.setVisible(true);
		
		add(barraDeOpciones, BorderLayout.NORTH);
	}
	
	
	private void  controles() 
	{
		jspContenido = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		InitCaptura();	
		InitListado();  
		InitCap();
		jspContenido.add(ScrollListado);
		jspContenido.add(jpCaptura);  
		add(jspContenido, BorderLayout.CENTER);
	}
	
	private void InitListado()
	{
		
		ScrollListado = new JScrollPane();
		
		jlsContactos = new JList();
		jlsContactos.addListSelectionListener(new ListSelectionListener(){
			
					public void valueChanged(ListSelectionEvent e)
					{
						ActualizaStatusReg();
					}
				});
		
		LlenaListado(jlsContactos,"*");
		ScrollListado = new JScrollPane();
		
		ScrollListado.setViewportView(jlsContactos);
		ActualizaStatus("Lista");	
	}
	
	
	private void InitCaptura()
	{
		jpCaptura = new  JPanel();
		jpCaptura.setLayout(new GridBagLayout());
	}
	
	private void InitCap()
	{
		jpCaptura.setBackground(new Color(139,235,246));
		GridBagConstraints c = new GridBagConstraints();
		jpCaptura.updateUI();
		
		//Encabezado
		lblEocab = new JLabel("CAPTURA DE DATOS");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 2;
		c.ipady=8;
		jpCaptura.add(lblEocab,c);
		
		//Clave
	     Clave = new JLabel("CLAVE");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 0 ;
		c.ipady=7;	
		jpCaptura.add(Clave,c);
			
		//Nombre
        lblNom = new JLabel("NOMBRE");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 0;
		//c.ipady=7;
		jpCaptura.add(lblNom,c);
		
		//Direccion	
		dir = new JLabel("DIRECCION");
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;		
		c.weightx = 1.0;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 0;
		c.ipady=7;
		jpCaptura.add(dir,c);
		
		//Telefono
		tel = new JLabel("TELEFONO");
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;		
		c.weightx = 1.0;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 0;
		c.ipady=7;
		jpCaptura.add(tel,c);
		
		//TelefonoCel
		tel = new JLabel("TELEFONO CEL");
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;		
		c.weightx = 1.0;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 0;
		c.ipady=7;
		jpCaptura.add(tel,c);
				
		//TextBoxes
		//Clave
		cla = new JTextField ();
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;		
		c.weightx = 6.0;
		c.weighty = 1.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(5,5,5,5);
		c.ipadx = 30;
		c.ipady=2;
		jpCaptura.add(cla,c);
		
		//Nombre
		nom = new JTextField ();
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 3;
		c.gridheight = 1;		
		c.weightx = 6.0;
		c.weighty = 1.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 100;
		c.ipady=2;
		nom.setVisible(true);
		jpCaptura.add(nom,c);
		
		//Direccion
		dire = new JTextField ();
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;		
		c.weightx = 6.0;
		c.weighty = 1.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 100;
		c.ipady=2;
		nom.setVisible(true);
		jpCaptura.add(dire,c);
		
		//telefono
		tele = new JTextField ();
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;		
		c.weightx = 6.0;
		c.weighty = 1.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 80;
		c.ipady=3;
		nom.setVisible(true);
		jpCaptura.add(tele,c);
		
		//TelefonoCel
		tel2 = new JTextField ();
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 3;
		c.gridheight = 3;		
		c.weightx = 6.0;
		c.weighty = 1.1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(0,5,0,0);
		c.ipadx = 80;
		c.ipady=2;
		//nom.setVisible(true);
		jpCaptura.add(tel2,c);
		
		//botonAgregar
		btnAgre = new JButton ("Agregar");
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 2;		
		c.weightx = 11.0;
		c.weighty = 0.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(7,5,10,11);
		c.ipadx = 20;
		c.ipady=2;
		//nom.setVisible(true);
		btnAgre.addActionListener(this);
		jpCaptura.add(btnAgre,c);
		
		//BotonEliminar
		btnEliminar = new JButton ("Eliminar");
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 2;		
		c.weightx = 11.0;
		c.weighty = 0.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.ipadx = 20;
		c.ipady=2;
		btnEliminar.addActionListener(this);
		jpCaptura.add(btnEliminar,c);
		
		//BotonActualizar
		btnActualizar = new JButton ("Actualizar");
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 2;		
		c.weightx = 11.0;
		c.weighty = 0.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(7,5,10,11);
		c.ipadx = 20;
		c.ipady=2;
		//nom.setVisible(true);
		btnActualizar.addActionListener(this);
		jpCaptura.add(btnActualizar,c);
		
		//Boton Limpiar
		btnLimpiar = new JButton ("Limpiar");
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 2;		
		c.weightx = 11.0;
		c.weighty = 0.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;	
		c.insets = new Insets(7,5,10,11);
		c.ipadx = 20;
		c.ipady=2;
		//nom.setVisible(true);
		btnLimpiar.addActionListener(this);
		jpCaptura.add(btnLimpiar,c);
	}
	
	private void status() 
	{
		jtbStatus = new JToolBar();
		jtbStatus.setFloatable(false);
		
		lblStatus = new JLabel ("Listo");
		jtbStatus.add(lblStatus);
		jtbStatus.addSeparator( new Dimension(35,10));
		jtbStatus.add(new JSeparator(JSeparator.VERTICAL));
			
		lblResgistros = new JLabel();
		jtbStatus.add(lblResgistros);
		
		jtbStatus.addSeparator();
		jtbStatus.add(new JSeparator(JSeparator.VERTICAL));
		
		lblFecha= new JLabel(Utils.now());
		jtbStatus.add(lblFecha);
		
		add(jtbStatus, BorderLayout.SOUTH);
		
		lblFecha = new JLabel();
		jtbStatus.add(lblFecha);
	}

	private void ActualizaStatus(String texto)
	{
		lblStatus.setText(texto);
	}
		
	private void ActualizaStatusReg()
	{
		lblResgistros.setText(" Resultado del filtro:  "+(jlsContactos.getSelectedIndex()+1)+"  de  "+jlsContactos.getModel().getSize()+
				" contactos | Total de contactos: "+NumDeContactos());	
	}
	
	//Agregar
	public void AgregaRegistro()
	{
		DefaultListModel modelo;
		String Select;
		try
		{
			Connection con = ConexionDB.GetConnection();
			
			 Select = "INSERT INTO contactos(`clave`, `Nombre`, `Direccion`, `TelCasa`, `TelCel`) "
			 		+ "VALUES('"+cla.getText()+"', '"+nom.getText()+"', '"+dire.getText()+"', '"+tele.getText()+"', '"+tel2.getText()+"')";
				PreparedStatement st = con.prepareStatement(Select);
				st.execute();
				st.close();
				con.close();
				LimpiaReg();
				jpCaptura.updateUI();
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null, e, "Error: f "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	//Eiminar
	public void Eliminar()
	{	
		DefaultListModel modelo;
		String Select;
		try
		{
			Connection con = ConexionDB.GetConnection();
			 Select = "DELETE FROM `topicos`.`contactos` WHERE `contactos`.`Clave` ="+cla.getText()+""; 
				PreparedStatement st = con.prepareStatement(Select);
				
				st.executeUpdate();
				st.close();
				con.close();		
				LimpiaReg();
				LlenaListado(jlsContactos,"*");
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null, e, "Error: B "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Actualizar
	public void Actualiza()
	{
		DefaultListModel modelo;
		String Select;
		try
		{
			Connection con = ConexionDB.GetConnection();
			
			Select = "UPDATE `contactos` SET `Clave`='"+cla.getText()+"',`Nombre`='"+nom.getText()+
					"',`Direccion`='"+dire.getText()+"',`TelCasa`='"+tele.getText()+"',`TelCel`='"+tel2.getText()+
					"'  WHERE `contactos`.`Clave` = '"+cla.getText()+"'";
				PreparedStatement st = con.prepareStatement(Select);
				
				st.executeUpdate();
				st.close();
				con.close();		
				LimpiaReg();
				LlenaListado(jlsContactos,"*");
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null, e, "Error: f "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	//Limpiar registros
	public void LimpiaReg()
	{
		cla.setText(null);
		nom.setText(" ");
		dire.setText(" ");
		tele.setText(" ");
		tel2.setText(" ");
	}
	

	private int NumDeContactos()
	{
		int TotReg=0;
		try
		{
			Connection con = ConexionDB.GetConnection();
			String Select = "SELECT  COUNT(*) FROM `Contactos`";
			
			PreparedStatement st = con.prepareStatement(Select);
			ResultSet rs = st.executeQuery();
			rs.next();
			TotReg = rs.getInt(1);
			con.close();
			return TotReg;
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e, "Erro: este  "+ e.getMessage(),JOptionPane.ERROR_MESSAGE);
			return TotReg;
		}
	
	}
	
	public void LlenaListado(JList lista, String criterio)
	{
		DefaultListModel modelo;
		String select;
		try
		{
			Connection con = ConexionDB.GetConnection();
			if(criterio.equals("*"))
				select = "SELECT `Nombre` FROM `Contactos` ORDER BY `Nombre`";
			else
				select = "SELECT `Nombre` FROM `Contactos` WHERE `Nombre` LIKE '%"+criterio+"%' ORDER BY `Nombre`";
			
			PreparedStatement st = con.prepareStatement(select);
			ResultSet rs = st.executeQuery();
			modelo = new DefaultListModel();
			modelo.clear();
			lista.setModel (modelo);
			while (rs.next())
				modelo.addElement(rs.getString(1));
			con.close();
			ActualizaStatusReg();	
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null, e, "Error: no "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	public void LlenaTextBox(String n)
	{
		try
		{
			String select;
			Connection con = ConexionDB.GetConnection();
		
			select = "SELECT  *  FROM `Contactos` WHERE `Nombre` LIKE '%"+n+"%'";
				
			PreparedStatement st = con.prepareStatement(select);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				cla.setText(rs.getString(1));
				nom.setText(rs.getString(2));
				dire.setText(rs.getString(3));
				tele.setText(rs.getString(4));
				tel2.setText(rs.getString(5));	
			}
			con.close();		
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null, e, "Error: no "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource()==jmibuscar)
		{
		}
		
		if (event.getSource()==jmicambios)
		{
		}
		
		if (event.getSource()==jmisalir)
		{
				System.exit(0);
		}
		
		if (event.getSource()==jmiacerca)
		{
		JOptionPane.showMessageDialog(this,"Mi agenda\nVersion 1.0\n\n"+ " Elaborado por: Carlos Baudelio Valdez Salazar\n"+
		"(c) Copyright 2015 "," Acerca de mi Agenda", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Contacts.png"));
		}
		
		if (event.getSource()==btnSalir)
		{
				System.exit(0);
		}
		
		if (event.getSource()==jmiAgregar|| event.getSource()== btnAgrega)
		{
			InitCap();
		}
		
		if (event.getSource()==btnEliminar)
		{
			Eliminar();
		}
		
		if (event.getSource()==btnActualizar)
		{
			Actualiza();
		}
		
		if(event.getSource() == btnAgre)
		{
			AgregaRegistro();
			LlenaListado(jlsContactos,"*");
		}
		
		if(event.getSource() == btnLimpiar)
		{
			LimpiaReg();
		}
		
		if(event.getSource() == btnBusca)
		{
			LlenaListado(jlsContactos, txtBusca.getText());
		}
	}

	public void valueChanged(ListSelectionEvent e) 
	{
		if(e.getSource()==jlsContactos)
		{
			LlenaTextBox((String) jlsContactos.getSelectedValue());
		}			
	}
}
