package Jose;

public class Mayornovoid {

	public static double Mayor(double x, double y, double z)
	{
		if (x>y && x>z)
		{
			return x;
		}
		else
			if (y>x && y>z)
			{
				return y;
			}
			else
				return z;
	}
	
	public static double Mayor(double x, double y)
	{
		if (x>y)
			return x;
		else 
			return y; 
	}
	public static void main(String[] args) {
		
		double x=5;
		double y=17;
		double z=15;
		
		System.out.println("de la lista de numeros x= "+x+" , y= "+y+", z= "+z+" el mayor es: "+Mayornovoid.Mayor(x, y, z));
         System.out.println();
         System.out.println("de la lista de numeros x= "+x+" , y= "+y+" el mayor es: "+Mayornovoid.Mayor(x, y));
	}

}
