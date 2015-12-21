package Tarea1;
import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;
public class Peach extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);

		//Inicializacion de Objetos
		Fondo fondo = new Fondo();
		Estrellas stars = new Estrellas();
		Luna luna = new Luna();
		Calle calle = new Calle();
		Edificio1 ed1 = new Edificio1();
		Edificio2 ed2 = new Edificio2();
		Edificio3 ed3 = new Edificio3();
		EdificioCentral ced = new EdificioCentral();
		
		super.paintComponent(g);
		fondo.pintarFondo(g);
		stars.pintarEstrellas(g);
		
		//pintar zacate
		g.setColor(new Color(3,82,5));
		g.fillRect(0, 160, 800, 400);
		
		//Pintar Oval
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.DARK_GRAY);
		g2.fillOval(280, 440, 300, 150);
		g2.setColor(Color.BLACK);
		g2.drawOval(280, 440, 300, 150);
		
		calle.pintarCalle(g);
		luna.pintarLuna(g);
		ed1.pintarEdificio(g);
		ed2.pintarEdificio(g);
		ed3.pintarEdificio(g);
		ced.pintarEdificio(g);
	}
}
