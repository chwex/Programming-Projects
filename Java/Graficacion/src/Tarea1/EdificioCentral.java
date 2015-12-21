package Tarea1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class EdificioCentral 
{
	public void pintarEdificio(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		int polx[] = {520, 560, 560, 520};
		int poly[] = {60,20,480,520};
		int polxt[] ={320,360,560,520};
		int polyt[] ={60,20,20,60};
		int x=320, y=100, w=40, h=40;
		int px1=520, px2=560, px3=560, px4=520, py1=100, py2=60, py3=100, py4=140;
		int polwx[] = {px1,px2,px3,px4};
		int polwy[] = {py1,py2,py3,py4};
		int polisidey[] = {480,440,480,520};
		
		//dibujar rectangulo y poligonos principales para el efecto 3D
		g2.setColor(new Color(79,99,96));
		g2.fillRect(320, 60, 200, 460);
		g2.fillPolygon(polx, poly, 4);
		g2.fillPolygon(polxt, polyt, 4);
		
		g2.setStroke(new BasicStroke(2));
		g2.setColor(new Color(22,199,169));
		g2.fillRect(320, 480, 200, 40);
		g.fillPolygon(polwx, polisidey, 4);
		
		g2.setColor(Color.BLACK);
		g2.drawRect(380, 500, 80, 20);
		g2.drawRect(320, 480, 200, 40);
		g2.drawRect(320, 60, 200, 460);
		g2.drawPolygon(polx, poly, 4);
		g2.drawPolygon(polxt, polyt, 4);
		g.drawPolygon(polwx, polisidey, 4);
		
		//ciclo para dibujar ventanas laterales
		g2.setColor(new Color(22,199,169));
		for(int j=1; j<=11; j++)
		{
			if(polwy[0]==100 || polwy[0]==140 || polwy[0]==220 || polwy[0]==260 || polwy[0]==340 || polwy[0]==380 )
			{
				g.fillPolygon(polwx, polwy, 4);
				g.setColor(Color.BLACK);
				g.drawPolygon(polwx, polwy, 4);
				g.drawLine(polwx[1]-20, polwy[1]+20, polwx[1]-20, polwy[1]+60);
				g2.setColor(new Color(22,199,169));
				
				for(int k=0; k<polwy.length; k++)
				{
					polwy[k] = polwy[k]+40;
				}
			}
			
			else
			{
				for(int k=0; k<polwy.length; k++)
				{
					polwy[k] = polwy[k]+40;
				}
			}
		}
		
		//ciclo para dibujar ventanas frontales
		for(int i =1; i<=30; i++)
		{
			g.fillRect(x, y, w, h);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, w, h);
			g2.setColor(new Color(22,199,169));
			
			if(y>=100 && y<=180)
			{
				if(x<480)
					x=x+40;
				else
				{
					x=x-160;
					y=y+40;
				}
			}
			
			else if(y>=220 && y<=300)
			{
				if(x<480)
					x=x+40;
				else
				{
					x=x-160;
					y=y+40;
				}
			}
			else if(y>=340 && y<=420)
			{
				if(x<480)
					x=x+40;
				else
				{
					x=x-160;
					y=y+40;
				}
			}
			
			if((x==320 && y==180) || (x==320 && y==300))
			{
				y=y+40;
			}
		}
	}
}
