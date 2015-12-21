//tarea: investigar la lista de los nombres de los controles del awt
package awt;
import java.awt.*;
import java.awt.event.*;
public class Ej1_AWT {

	public static void main(String[] args) 
	{
		Frame frame = new Frame();
		frame.setLayout(null);
		frame.setTitle("Mi primer AWT");
		frame.setBounds(200, 200, 500, 300);
		
		Button button = new Button("Salir");
		button.setBounds(30, 30, 100, 30);
		
		Button button2 = new Button("Boton 2");
		button2.setBounds(30, 70, 100, 30);
		
		TextField txt = new TextField();
		txt.setBounds(30, 110, 200, 30);
		
		Label label = new Label("Etiqueta");
		label.setBounds(30, 110, 100, 30);
		
		Checkbox check = new Checkbox("Opcion 1");
		check.setBounds(30, 140, 100, 25);
		
		List list = new List();
		list.setBounds(30, 165, 200, 50);
		list.add("E2");
		list.add("E3");
		list.add("E1");
		
		Scrollbar scroll = new Scrollbar();
		scroll.setBounds(470, 30, 30, 240);
		
		Scrollbar scroll2 = new Scrollbar(0);
		scroll2.setBounds(0, 270, 470, 30);
		
		TextArea txta = new TextArea();
		txta.setBounds(30, 229, 300, 50);
		
		frame.add(button);
		frame.add(button2);
		frame.add(txt);
		frame.add(label);
		frame.add(check);
		frame.add(list);
		frame.add(scroll);
		frame.add(scroll2);
		frame.add(txta);
		
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					System.out.println(evt.getActionCommand().toString());
					System.exit(0);
				}
			});
		
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				System.exit(0);
			}
		});
	}

}
