package awt;

import java.awt.*;
import java.awt.event.*;

public class Catalogo 
{
	public static void main(String [] args)
	{
		
		Ventana WinMain = new Ventana("Catalogo de controles");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension tamanio = tk.getScreenSize();
		WinMain.setBounds(0, 0, tamanio.width, tamanio.height);
		WinMain.setVisible(true);
		WinMain.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				System.exit(0);
			}
		});
	
	}
	
}
