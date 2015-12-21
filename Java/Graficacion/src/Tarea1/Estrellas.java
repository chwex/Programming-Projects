package Tarea1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Estrellas extends JPanel
{
	int x, y;
	public void pintarEstrellas(Graphics g)
	{
		//metodo para dibujar estrellas usando puntos
		g.setColor(new Color(191,245,236));
        for (int i = 0; i < 4500; i++)
        {
            x = (int)(Math.random()*800);
            y = (int)(Math.random()*600); 
            g.drawLine(x, y, x, y);
        }
	}
}
