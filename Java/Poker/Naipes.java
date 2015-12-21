import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Naipes {
	private ImageIcon cards[];
	private boolean valido [];
	private int total = 52;
	private int valor = -1;
	private Random r;
	
	public Naipes(){
		cards  = new ImageIcon[52];
		valido = new boolean[52];
		r = new Random();
		creaCartas();
	}
	
	private void creaCartas(){
		for (int i=0;i<cards.length;i++)
			cards [i] = new ImageIcon("cards/"+(i+1)+".png");
	}
	
	//DEVUELVE EL NUMERO DE CARTAS QUE HAN SALIDO
	public int getTotal(){
		return total;
	}
	//DEVUELVE UNA CARTA AL AZAR
	public ImageIcon carta(){
		int out =-1;
		while(true){
			out = r.nextInt(52);
			if(!valido[out]){
				valido[out]	= true;
				break;
			}
		}
		
		total--;
		valor = out;
		return cards[out];
	}
	
	public int getValor(){
		return valor;
	}
	
	public void reset(){
		for(int i=0;i<valido.length;i++)
			valido[i] = false;
		
		valor = -1;
		total = 52;
	}
}
