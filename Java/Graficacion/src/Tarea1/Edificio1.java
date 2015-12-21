package Tarea1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Edificio1 
{
	public void pintarEdificio(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		int polx[] = {260, 280,280, 260};
		int poly[] = {40,20,360,380};
		int polxt[] ={100,120,280,260};
		int polyt[] ={40,20,20,40};
		
		//dibujar rectangulo principal y poligonos para efecto 3D
		g2.setColor(new Color(67,209,84));
		g2.fillRect(100, 40, 160, 340);
		g2.fillPolygon(polx, poly, 4);
		g2.fillPolygon(polxt, polyt, 4);
		
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.drawRect(100, 40, 160, 340);
		g2.drawPolygon(polx, poly, 4);
		g2.drawPolygon(polxt, polyt, 4);
		
		g2.setColor(new Color(53,120,196));
		int x=220, y = 80, w=20, h=20;
		int px1=265, px2=275,px3=275,px4=265,py1=80,py2=60,py3=80,py4=100;
		int polwx[] = {px1,px2,px3,px4};
		int polwy[] = {py1,py2,py3,py4};
		
		//ciclo para el dibujo de ventanas cuadradas y poligonos 
		for(int i = 1; i<=7; i++)
		{
			g2.fillRect(x, y, w, h);
			g2.fillPolygon(polwx, polwy, 4);
			g2.setColor(Color.BLACK);
			g2.drawPolygon(polwx, polwy, 4);
			g2.drawRect(x, y, w, h);
			g2.setColor(new Color(53,120,196));
			y=y+40;
			
			for(int j = 0; j<polwy.length;j++)
			{
				polwy[j]= polwy[j]+40;
			}			
		}
	}
}
