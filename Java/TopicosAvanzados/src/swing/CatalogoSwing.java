package swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class CatalogoSwing 
{
	public static void main(String [] args)
	{
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension tamanio = tk.getScreenSize();
		VentanaSwing WinMain = new VentanaSwing("Catalogo de controles Swing", tamanio.width, tamanio.height);
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