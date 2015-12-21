package awt;
import java.awt.*;
public class Ej2_AWT 
{

	public static void main(String[] args) 
	{
		Frame frame = new Frame();
		frame.setBounds(200,200,400,300);
		frame.setTitle("Otro Ejemplo");
		frame.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 400, 300);
		panel.setBackground(Color.BLUE);
		panel.setLayout(null);
		
		Button button = new Button();
		button.setBounds(200, 150, 70, 20);
		
		panel.add(button);
		frame.add(panel);
		
		frame.setVisible(true);

	}

}
