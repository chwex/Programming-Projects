package Tarea1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Calle extends JFrame{
	public void pintarCalle(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		//pintar calle
		g2.setColor(new Color(46,51,46));
		g2.setStroke(new BasicStroke(3));
		g.fillRect(0, 400, 800, 40);
		g.setColor(Color.BLACK);
		g.drawRect(0, 400, 800, 40);
		
		//algoritmo rectangulos
		int x=10 ,y=415, w=20, h=6;
        g2.setColor(Color.WHITE);
		
        while(x<800)
        {
        	g.fillRect(x, y, w, h);
        	x=x+40;
        }
	}
}
