package Tarea1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

public class Edificio2 
{
	public void pintarEdificio(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		int polx[] = {760, 800,800,760};
		int poly[] = {200,160,320,380};
		int polxt[] ={620,660,800,760};
		int polyt[] ={200,160,160,200};
		int poltrix[]={620,690,760};
		int poltriy[]={200,140,200};
		int poltribx[]={660,730,800};
		int poltriby[]={160,100,160};
		
		//dibujar rectangulo principal y poligonos para efecto 3D
		g2.setStroke(new BasicStroke(2));
		g2.setColor(new Color(191,11,56));
		g2.fillRect(620, 200, 140, 180);
		g2.fillPolygon(polx, poly, 4);
		g2.fillPolygon(polxt, polyt, 4);
		
		//Puerta
		g2.setColor(new Color(21,59,49));
		g2.fillRect(670, 350, 20, 30);
		g2.fillRect(690, 350, 20, 30);
		
		
		g2.setColor(Color.BLACK);
		g2.drawRect(620, 200, 140, 180);
		g2.drawRect(670, 350, 20, 30);
		g2.drawRect(690, 350, 20, 30);
		g2.drawPolygon(polx, poly, 4);
		g2.drawPolygon(polxt, polyt, 4);
		
		//ciclo para dibujar ventanas de tipo arco
		double x=640, y=220, w=40, h=40, start=0, extent=180;
		for(int i = 1; i<=6; i++)
		{
			Arc2D.Double arc = new Arc2D.Double(Arc2D.OPEN);
			g2.setStroke(new BasicStroke(2));
			arc.setFrame(x, y, w, h);
			arc.setAngleStart(start);
			arc.setAngleExtent(extent);
			g2.setColor(Color.BLACK);
			g2.draw(arc);
			g2.setColor(new Color(42,135,112));
			g2.fill(arc);
			
			if(x<700)
			{
				x=x+60;
			}
			else
			{
				x=x-60;
				y=y+40;
			}
		}
		
		//dibujar triangulo con efecto 3D
		g2.setColor(new Color(21,59,49));
		g2.fillPolygon(poltribx, poltriby, 3);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(poltribx, poltriby, 3);
		
		g2.setColor(new Color(21,59,49));
		g2.fillPolygon(poltrix, poltriy, 3);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(poltrix, poltriy, 3);
		g2.drawLine(690, 140, 730, 100);
		
		int[] tridx = {690,730,800,760};
		int[] tridy = {140,120,160,200};
		int[] triix = {690,730,660,620};
		int[] triiy = {140,120,160,200};

		g2.setColor(new Color(21,59,49));
		g2.fillPolygon(tridx, tridy, 4);
		g2.fillPolygon(triix, triiy, 4);
	}
}
