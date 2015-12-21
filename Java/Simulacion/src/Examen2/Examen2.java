package Examen2;
import java.util.Scanner;
public class Examen2 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int num, numAux;
		String numStr = "", numStrAux = "", numStrAux2 = "";
		System.out.print("Ingrese la semilla: ");
		num = in.nextInt();
		System.out.println("n\t\tSem\t\tSemSqr\t\tnumInt\t\tSig");
		for (int i=0;i<100;i++)
		{
			if (num<100)
				break;
			numAux = num;
			num = num*num;
			numStr = Integer.toString(num);
			for (int j=0;j<numStr.length();j++)
			{
				if(j==0 || j==numStr.length()-1)
					continue;
				numStrAux = numStrAux + numStr.charAt(j);
			}
			numStrAux2 = numStrAux;
			if (numStrAux.length()==4)
				numStrAux = numStrAux.substring(0, 3);
			num = Integer.parseInt(numStrAux);
			System.out.println(i+"\t\t"+numAux+"\t\t"+numStr+"\t\t"+numStrAux2+"\t\t"+num);
			numStrAux = "";	
		}
	}

}
