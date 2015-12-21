//Proyecto RFC
//Valdez Salazar Carlos Baudelio

package RFCVerificador;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VerificarRFC extends JFrame 
{
	private static final long serialVersionUID = 1L;
	JTextField field1 = new JTextField();
	JLabel lblRFC = new JLabel();
	JLabel lblSample = new JLabel();
	
	public VerificarRFC() 
	{
		this.getContentPane().setLayout(new GridLayout(2,2));
		
		lblRFC.setText("RFC");
		lblSample.setText("Ejemplo RFC: LLLLNNNNNN ");
		field1.setText("");
		field1.setPreferredSize(new Dimension (200,24));
		
		add(lblRFC);
		add(field1);
		add(lblSample);
		
		
		field1.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {

				JTextField txt = (JTextField) e.getSource();
				char keyChar = e.getKeyChar();
				e.setKeyChar(Character.toUpperCase(keyChar));

				int longitud = txt.getText().length();

				if (longitud >= 10) {
					e.consume();
					return;
				}

				if (longitud < 4
						&& (!Character.isLetter(keyChar) || keyChar == 'ñ' || keyChar == 'Ñ')) {
					e.consume();
					return;
				}

				String contenido = txt.getText();

				if (longitud >= 4) {
					switch (longitud) {
					//Anio
					case 4:
					case 5:
						if (!Character.isDigit(keyChar)) {
							e.consume();
							return;
						}
						break;
					//Mes
					case 6:
						if (keyChar != '0' && keyChar != '1') {
							e.consume();
							return;
						}
						break;
					case 7:
						if (contenido.charAt(6) == '1') {
							if (keyChar < '0' || keyChar > '2') {
								e.consume();
								return;
							}
							return;
						}
						if (!Character.isDigit(keyChar) || keyChar == '0') {
							e.consume();
							return;
						}
						break;
					//Dia
					case 8:
						if (keyChar < '0' || keyChar > '3') {
							e.consume();
							return;
						}
						break;
					case 9:
						if (contenido.charAt(8) == '3') {
							if (keyChar < '0' || keyChar > '1') {
								e.consume();
								return;
							}
							return;
						}
						if (contenido.charAt(8) == '0') {
							if (keyChar == '0') {
								e.consume();
								return;
							}
							return;
						}
						if (!Character.isDigit(keyChar)) {
							e.consume();
							return;
						}
						break;
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private static void createAndShowGUI() 
	{
		JFrame frame = new VerificarRFC();
		frame.pack();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		createAndShowGUI();
	}
	
	
}
