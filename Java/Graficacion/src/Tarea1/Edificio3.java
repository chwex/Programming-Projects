package Tarea1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Edificio3 
{
	public void pintarEdificio(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//inicializar coordenadas de poligonos Efecto 3D (Poligonos) 
		int polx[] = {200, 220, 220, 200};
		int poly[] = {100,80,460,480};
		int polxt[] ={60,80,220,200};
		int polyt[] ={100,80,80,100};
		
		//Dibujar el rectangulo y los poligonos del edificio (Color, Rectangulo y Poligonos)
		g2.setColor(new Color(186,94,0));
		g2.fillRect(60, 100, 140, 380);
		g2.fillPolygon(polx, poly, 4);
		g2.fillPolygon(polxt, polyt, 4);
		
		//Puerta edificio (Color y Rectangulo)
		g2.setColor(new Color(25,62,105));
		g2.fillRect(100, 460, 60, 20);
		
		//Dibujar bordes (Color, rectangulo, poligono y lineas)
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.drawRect(60, 100, 140, 380);
		g2.drawPolygon(polx, poly, 4);
		g2.drawPolygon(polxt, polyt, 4);
		g2.drawLine(100, 460, 100, 480);
		g2.drawLine(120, 460, 120, 480);
		g2.drawLine(140, 460, 140, 480);
		g2.drawLine(100, 460, 160, 460);
		g2.drawLine(160, 460, 160, 480);
		
		//Algoritmo para dibujar ventanas usando colores, rectangulos y poligonos
		g2.setColor(Color.BLUE);
		int px1=205, px2=215,px3=215,px4=205,py1=140,py2=120,py3=140,py4=160;
		int polwx[] = {px1,px2,px3,px4};
		int polwy[] = {py1,py2,py3,py4};
		int x=80, y = 140, w=40, h=20;
		for(int i = 1; i<=8; i++)
		{
			g2.fillRect(x, y, w, h);
			g2.fillPolygon(polwx, polwy, 4);
			g2.setColor(Color.BLACK);
			g2.drawPolygon(polwx, polwy, 4);
			g2.drawRect(x, y, w, h);
			g2.setColor(Color.BLUE);
			
			if(x<140)
				x=x+60;
			else
			{
				x=x-60;
				y=y+80;
			}
			for(int j = 0; j<polwy.length;j++)
			{
				polwy[j]= polwy[j]+40;
			}
		}
		
		//ciclo para dibujar ventanas dentro del efecto 3D
		x=80; y = 180; w=20; h=20;
		for(int i = 1; i<=12; i++)
		{
			g2.fillRect(x, y, w, h);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, w, h);
			g2.setColor(Color.BLUE);
			
			if(x<160)
				x=x+40;
			else
			{
				x=x-80;
				y=y+80;
			}
		}
		int estx[] = {200,140,0,60};
		int esty[] = {480,540,540,480};
		g2.setColor(Color.DARK_GRAY);
		g2.fillPolygon(estx, esty, 4);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(estx, esty, 4);
	}
}
