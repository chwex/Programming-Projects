import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextField txtJugadas;
	private JButton btnJugar; 
	private JButton btnReset;
	private Mesa mesa; 
	

	public Start(){
		interfas();
		escuchadores();
		setVisible(true);
	}
	
	public void interfas(){
		this.setSize(800,750);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setTitle("Poker");
		this.setIconImage(new ImageIcon("cards/Poker.jpg").getImage());
        UIManager.put("Button.defaultButtonFollowsFocus",Boolean.TRUE);
		
		panel 		= new JPanel();
		panel.setLayout(new GridLayout(0,2,5,5));
		
		//CREAR COMPONENTES
		txtJugadas 	= new JTextField();
		btnJugar 	= new JButton("Comenzar");
		btnReset	= new JButton("Reset");
		
		//AGREGAR COMPONENTES
		panel.add(new JLabel("Numero de jugadas"));
		panel.add(txtJugadas);
		panel.add(btnJugar);
		panel.add(btnReset);
		
		this.add(panel,BorderLayout.SOUTH);
		mesa = new Mesa();
		this.add(mesa);
	}
	
	public void escuchadores(){
		btnJugar.addActionListener(this);
		btnReset.addActionListener(this);
		
		txtJugadas.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent a) {
		
		//CUANDO SE PRESIONA EL BOTON RESET
		if(a.getSource()==btnReset){
			//REINICIAR LA MESA
			mesa.reset();
			txtJugadas.grabFocus();
			return;
		}
		
		//CUANDO SE PRESIONA EL BOTON COMENZAR
		if(a.getSource()==btnJugar){
			//SI LA CAJA DE TEXTO ESTA VACIA
			if(txtJugadas.getText().length()==0)
				JOptionPane.showMessageDialog(null, "Ingrese valores en la caja de texto");
			else
				try{
					int in = Integer.parseInt(txtJugadas.getText());
					if(in>13){
						JOptionPane.showMessageDialog(null, "Debes dar un numero menor a 13"); //ESTO ES POR EL NUMERO DE CARTAS
						return;
					}
					mesa.start(in);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Ingrese solo numeros.");
					return;
				}
			txtJugadas.grabFocus();
			return;
		}
		//CUANDO SE LE DA ENTER AL TEXTFIELD
		btnJugar.grabFocus();
	}

	public static void main(String []args){
		new Start();
	}
}