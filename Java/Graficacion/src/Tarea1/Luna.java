package Tarea1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Luna extends JPanel
{
	public void pintarLuna(Graphics g)
	{
		//varios circulos adentrp de un circulo
		g.setColor(new Color(232,235,174));
		g.fillOval(665, 20, 100, 100);
		
		g.setColor(Color.BLACK);
		g.drawOval(690, 33, 20, 20);
		g.drawOval(730, 40, 10, 10);
		g.drawOval(720, 60, 15, 15);
		g.drawOval(740, 70, 20, 20);
		g.drawOval(690, 60, 20, 20);
		g.drawOval(710, 80, 15, 15);
	}
	
}
