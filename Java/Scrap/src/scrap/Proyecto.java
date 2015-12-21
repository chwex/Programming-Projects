package scrap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class Proyecto extends JFrame implements ActionListener {
	final double ERROR = 0.001;
	final int INTENTOS = 50;
	DecimalFormat formato=new DecimalFormat("####.######");
	String[]etiquetas = {"Instituto Tecnológico de Culiacán","Ingeniería en Sistemas Computacionales",
						"Nombre: Francisco José Valdez Bonilla","Materia: Métodos Numéricos",
						"Tema: Método mejorado de bisección","Horario: 11:00 - 12:00"};
	JPanel titulo, botones, centro;
	JScrollPane respuesta;
	JButton aceptar, salir;
	JLabel mensajeSol;
	JTextArea mensaje;
	String[]columnas = {"NC","A","B","C","f(A)","f(B)","f(C)"};
	Object[][]datos = new Object[50][columnas.length];
	JTable tablaRespuestas;
	public Proyecto() {
		super("Método mejorado de bisección");
		HazInterfaz();
		HazEscuchas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void HazInterfaz() {
		//Etiquetas para dar que la tabla no se vea tan grande
		add(new JLabel("                              "),BorderLayout.EAST);
		add(new JLabel("                              "),BorderLayout.WEST);
		//Panel de título
		titulo = new JPanel();
		titulo.setLayout(new BoxLayout(titulo,BoxLayout.Y_AXIS));
		for(int i=0;i<etiquetas.length;i++) {
			titulo.add(new JLabel(etiquetas[i]));
		}
		add(titulo,BorderLayout.NORTH);
		//Panel del centro
		centro = new JPanel();
		mensaje = new JTextArea();
		mensaje.setBackground(null);
		mensaje.setFont(new Font("Arial",1,18));
		mensaje.setText("\n\n\n\n\n\nEste procedimiento resuelve el cálculo de raíces de una función "
						+"\nutilizando el Método Mejorado de Bisección con la siguiente información:"
						+"\n\nFunción:  f(x)=xCos(x\u00B2)+4"
						+"\nA=5\nC=8"
						+"\nError: "+ERROR
						+"\nNúmero máximo de intentos: "+INTENTOS);
		mensaje.setEditable(false);
		centro.setLayout(new BoxLayout(centro,BoxLayout.Y_AXIS));
		centro.add(mensaje);	
		add(centro,BorderLayout.CENTER);
		//Panel de botones
		botones = new JPanel();
		botones.setLayout(new FlowLayout());
		aceptar = new JButton("Aceptar");
		botones.add(aceptar);
		salir = new JButton("Salir");
		botones.add(salir);
		add(botones,BorderLayout.SOUTH);
		//Hacer visible todo
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void HazEscuchas() {
		aceptar.addActionListener(this);
		salir.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == aceptar)	
			biseccion(5.0,8.0);
		else 
			dispose();
	}
	public void biseccion (double A, double C) {
		boolean tieneRaiz = false;
		centro.remove(mensaje);
		if (respuesta!=null) {
			centro.remove(respuesta);
			centro.remove(mensajeSol);
		}
		int i;
		double B=Integer.MAX_VALUE, funcionA, funcionB, funcionC;
		for (i=0;i<INTENTOS-1;i++) {
			funcionA = (A*Math.cos(Math.toRadians(A*A)))-4;
			funcionC = (C*Math.cos(Math.toRadians(C*C)))-4;
			if (!((funcionA*funcionC)<0)) {
				mensajeSol = new JLabel("La función f(x)=xCos(x\u00B2)+4 no tiene raíz, "+
										"puesto que nunca cruza el eje de las X");
				tieneRaiz = false;
				break;
			}
			B = (A+C)/2;
			funcionB = (B*Math.cos(Math.toRadians(B*B)))-4;
			//==Insertar a la tabla==
			Object[]datosA = {i+1,formato.format(A),formato.format(B),formato.format(C),
					formato.format(funcionA),formato.format(funcionB),formato.format(funcionC)};
			for (int j=0;j<columnas.length;j++)
				datos[i][j] = datosA[j];
			if (Math.abs(funcionB)<ERROR) {
				tieneRaiz = true;
				break;
			}
			else if ((C-B)<ERROR) {
				tieneRaiz = true;
				break;
			}
			if ((funcionB*funcionC)<0) 
				A = B;	
			else 
				C = B;
		}
		if (tieneRaiz) {
			mensajeSol = new JLabel("La raiz f(x)=xCos(x\u00B2)+4 es "+
					formato.format(B)+
					" que fue encontrada a los "+(i+1)+" intentos");
			tablaRespuestas = new JTable(datos,columnas);
			tablaRespuestas.setEnabled(false);
			respuesta = new JScrollPane(tablaRespuestas,
										ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
										ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			centro.add(respuesta);
			centro.add(mensajeSol);
		}
		else if (i==INTENTOS-1)
			mensajeSol = new JLabel("No se ha encontrado una raíz en los "+i+" intentos");
		validate();
	}
	public static void main (String[]args) {
		new Proyecto();
	}
}