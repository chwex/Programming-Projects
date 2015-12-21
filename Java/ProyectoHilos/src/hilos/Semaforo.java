//Carlos Baudelio Valdez Salazar
//Proyecto Hilos
//Topicos Avanzados de la Programacion

package hilos;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Semaforo extends JFrame implements ActionListener
{
	Image imagenBuffer = null;
	Graphics g;
	int flag = 0; //bandera
	int x=120;//posicion de incio de xwing
	Timer timer;
	ImageIcon fondo = new ImageIcon("starWarsBack.png"), xWing = new ImageIcon("xWing.png");
	int inc = 30; //velocidad de x-wing
	
	public Semaforo()
	{
		interfaz();
	}

	public void interfaz() 
	{
		timer = new Timer(50, this); //velocidad del timer
		timer.setRepeats(true);
		timer.start();
		
		setSize(1000,563);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		imagenBuffer = createImage(getWidth(), getHeight());
		g=(Graphics2D) imagenBuffer.getGraphics();
		draw();

	}

	public void draw() 
	{
		
		super.paint(g);
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);//dibuja fondo
		g.setColor(Color.BLACK);
		g.fillRect(855, 0, 42, 563);//dibuja meta

		g.drawImage(xWing.getImage(), x, 100, 100, 65,this); //dibuja xwing
		g.setColor(Color.GREEN);
		
		//dibuja luz verde e incrementa x
		if(flag >=0 && flag<120)
		{
			g.fillOval(920, 294+200, 50, 50);
			x = x+inc;
		}
		
		//Dibuja luz amarilla
		if(flag>=120 && flag<=160)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(920,264+200,50,50);
			if(x>=480 || x<=460)
				x=x+inc;
		}
		
		//Dibuja luz roja
		if(flag>160)
		{
			g.setColor(Color.RED);
			g.fillOval(920,234+200,50,50);
			if(x<=720 || x>=780)
				x=x+inc;
		}
		
		if(flag==200)
			flag=0;

		if(x>=1000)
			x=0;
	
        repaint();
	}

	public void paint( Graphics g) 
	{
		g.drawImage(imagenBuffer, 0, 0, getWidth(), getHeight(), this);
		g.dispose();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		flag++;
		draw();
	}
	
	public static void main(String[]a)
	{
		new Semaforo();
	}
}
