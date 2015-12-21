import javax.swing.*;
import java.awt.*;


public class Mesa extends JPanel{
	private JLabel lblJugadores[];
	private int jugadores[];//INDICA CUANTAS VICTORIAS TIENE CADA JUGADOR
	private Naipes baraja;
	private int cont =0;
	private JLabel lbl[]=new JLabel[4];
	
	public Mesa(){
		super();
		jugadores = new int[4];
		baraja = new Naipes();
		interfas();
	}
	private void interfas(){
		this.setLayout(null);
		lblJugadores 	= new JLabel[4];
		lbl 			= new JLabel[4];
		
		for(int i=0;i<4;i++){
			lblJugadores[i]	= new JLabel();
			lblJugadores[i].setIcon(new ImageIcon("cards/b1fv.png"));
			lblJugadores[i].setSize(72,96);
			lbl[i]	= new JLabel(jugadores[i]+"");
			lbl[i].setForeground(Color.WHITE);
		}
		
		lblJugadores[0].setBounds(360, 155, 72, 96);//250
		lblJugadores[1].setBounds(640, 250, 72, 96);
		lblJugadores[2].setBounds(360, 335, 72, 96);
		lblJugadores[3].setBounds(85, 250, 72, 96);
		
		lbl[0].setBounds(390,115, 10, 10);
		lbl[1].setBounds(745, 290, 10, 10);
		lbl[2].setBounds(390, 460, 10, 10);
		lbl[3].setBounds(45, 290, 10, 10);
		
		
		for(int i=0;i<4;i++){
			this.add(lblJugadores[i]);
			this.add(lbl[i]);
		}
	} 

	public void start(int jugadas){
		//CUANDO NO HAY SUFICIENTES CARTAS
		if( (cont+jugadas)>13){
			JOptionPane.showMessageDialog(null, "No hay cartas suficientes");
			return;
		}
		
		//jugadas a realizarce
		int mayor 	= 0; //NOS INDICA EL JUGADOR QUE GANO
		int aux 	= 70;//INDICA LOS PUNTOS CON LOS QUE VA GANANDO
		cont +=jugadas;
		for(int i=0;i<jugadas;i++){
			for(int j=0;j<4;j++){
				lblJugadores[j].setIcon(baraja.carta());
				lblJugadores[j].update(lblJugadores[j].getGraphics());
				if(baraja.getValor() < aux){
					mayor 	= j;
					aux 	= baraja.getValor();
				}
				try{
					Thread.sleep(500);
				}catch(Exception e){}
			}
			jugadores[mayor]=jugadores[mayor]+1;
			for(int z=0;z<4;z++){
				lbl[z].setText(jugadores[z]+"");
				lbl[z].update(lbl[z].getGraphics());
			}
			
			mayor 	= 0;
			aux		= 70;
		}
	}
	
	public void reset(){
		jugadores = new int[4];
		baraja.reset();
		cont = 0;
		for(int i=0;i<4;i++){
			lblJugadores[i].setIcon(new ImageIcon("cards/b1fv.png"));
			lbl[i].setText(jugadores[i]+"");
		}
	}

	public void paint(Graphics g){
		g.drawImage(new ImageIcon("cards/mesa.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		this.setOpaque(false);
		super.paint(g);
	}
}
