package Tarea1;

import java.awt.Color;

import javax.swing.*;

public class Edificio extends JPanel
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame("Edificios");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Peach p = new Peach();
		f.add(p);
		f.setSize(817, 600);
		f.setVisible(true);
	}
}
