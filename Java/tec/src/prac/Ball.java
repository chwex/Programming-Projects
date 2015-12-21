package prac;

public class Ball
{
	private int size;
	private String color;
	private int airPressure = 20;
	private boolean isFlat = false;
	
	public Ball(int initSize, String initColor)
	{
		size = initSize;
		color = initColor;
	}
	
	public void bounce()
	{
		if(isFlat)
			System.out.println("Sorry, the "+color+" ball cannot bounce.");
		else
			System.out.println("The "+color+" ball is bouncing.");
	}
	
	public void deflate()
	{
		airPressure = 0;
		isFlat = true;
	}
	
	public void inflate()
	{
		airPressure=20;
		isFlat = false;
	}
	
	public void changeColor(String newColor)
	{
		color = newColor;
	}

}
