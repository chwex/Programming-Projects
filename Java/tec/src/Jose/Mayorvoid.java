package Jose;

public class Mayorvoid {

	public static void Mayor2(double x, double y)
	{
		if (x>y)
			System.out.println("de la lista de numeros x= "+x+" , y= "+y+" el mayor es: "+x);
		else 
			System.out.println("de la lista de numeros x= "+x+" , y= "+y+" el mayor es: "+y);
	}
	
	public static void Mayor2(double x, double y, double z)
	{
		if (x>y && x>z)
		{
			System.out.println("de la lista de numeros x= "+x+" , y= "+y+", z= "+z+" el mayor es: "+x);
		}
		else
			if (y>x && y>z)
			{
				System.out.println("de la lista de numeros x= "+x+" , y= "+y+", z= "+z+" el mayor es: "+y);
			}
			else
				System.out.println("de la lista de numeros x= "+x+" , y= "+y+", z= "+z+" el mayor es: "+z);
	}
	public static void main(String[] args) {
		double x=5;
		double y=17;
		double z=15;
		
		Mayor2(x,y);
		Mayor2(x,y,z);
	}

}
