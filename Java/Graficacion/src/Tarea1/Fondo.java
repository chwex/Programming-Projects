package Tarea1;
import java.awt.*;
import java.awt.Event.*;

import javax.swing.*;

public class Fondo extends JPanel
{
	public void pintarFondo(Graphics g)
	{
		
		Estrellas stars = new Estrellas();
		Graphics2D g2 = (Graphics2D) g;
		
		//Degradado en el Background
		GradientPaint gp1 = new GradientPaint(0, 0, Color.blue, 800, 600, Color.black, true);
		g2.setPaint(gp1);
		g2.fillRect(0, 0, 800, 600);
		
		//pintar estrellas
		stars.pintarEstrellas(g);
		
	}
}
