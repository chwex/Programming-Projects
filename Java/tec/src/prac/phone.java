package prac;
import paq1.*;

public class phone {
	private String make;
	private double storage;
	private String color;


	public phone()
	{
		
	}
	
	public String getMake()
	{
		return make;
	}



	public void setMake(String make)
	{
		this.make = make;
	}



	public double getStorage()
	
	{
		return storage;
	}


	public void setStorage(double storage)
	{
		this.storage = storage;
	}



	public String getColor()
	{
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}

	public String fPhone()
	{
		return(make+" "+color+" "+storage);
	}

	public double tomarFoto()
	{
		storage = storage -(0.2);
		return storage;
	}


}
