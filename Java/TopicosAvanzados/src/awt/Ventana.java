package awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends Frame 
{
	static final long serialVersionUID=1;
	private Scrollbar scrollH;
	private Scrollbar scrollV;
	private Button button;
	private TextField txt;
	private Label etiqueta;
	private Checkbox check1;
	private Checkbox check2;
	private Checkbox check3;
	private Checkbox check4;
	private Checkbox check5;
	private Checkbox check6;
	private List list;
	private CheckboxGroup CBG;
	private TextArea texto;
	
	public Ventana(String titulo)
	{
		super(titulo);
		this.setLayout(null);
		scrollV = new Scrollbar();
		scrollV.setBounds(1346, 27, 20, 720);
		//1346,768
		scrollH = new Scrollbar(0);
		scrollH.setBounds(0, 748, 1346, 20);
		
		button = new Button("Salir");
		button.setBounds(30, 30, 100, 30);
		
		txt = new TextField();
		txt.setBounds(30, 70, 200, 30);
		
		etiqueta = new Label("Etiqueta");
		etiqueta.setBounds(30, 110, 100, 30);
		
		CBG = new CheckboxGroup();
		
		check1=new Checkbox("Opcion1", CBG, true);
		check1.setBounds(30, 145, 100, 25);
		check2=new Checkbox("Opcion2", CBG, true);
		check2.setBounds(30, 170, 100, 25);
		check3=new Checkbox("Opcion3", CBG, true);
		check3.setBounds(30, 195, 100, 25);
		
		check4=new Checkbox("Opcion4", null, true);
		check4.setBounds(30, 220, 100, 25);
		check5=new Checkbox("Opcion5");
		check5.setBounds(30, 245, 100, 25);
		check6=new Checkbox("Opcion6");
		check6.setBounds(30, 270, 100, 25);
		
		list = new List();
		list.setBounds(30, 295, 200, 55);
		list.add("Elemento 1");
		list.add("Elemento 2");
		list.add("Elemento 3");
		
		texto = new TextArea();
		texto.setBounds(30, 360, 300, 100);
		
		this.add(scrollV);
		this.add(scrollH);
		this.add(button);
		this.add(txt);
		this.add(etiqueta);
		this.add(check1);
		this.add(check2);
		this.add(check3);
		this.add(check4);
		this.add(check5);
		this.add(check6);
		this.add(list);
		this.add(texto);
		
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				System.exit(0);
			}
		}
				
				);
		
		
		
		
	}

}
