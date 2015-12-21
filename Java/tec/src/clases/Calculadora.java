package clases;

public class Calculadora 
{
	private double operando1;
	private double operando2;
	private double res;
	
	
	public Calculadora()
	{
	}
	
	
	//public Calculadora(Ap_calculadora yo)
	
	public Calculadora(double op1, double op2)
	{
		operando1=op1;
		operando2=op2;
		res=0;
	}
	
	public double getOperando1() {
		return operando1;
	}
	public void setOperando1(double operando1) {
		this.operando1 = operando1;
	}
	public double getOperando2() {
		return operando2;
	}
	public void setOperando2(double operando2) {
		this.operando2 = operando2;
	}
	public double getRes() {
		return res;
	}

	public double sumar()
	{
		res=operando1+operando2;
		return res;
	}
	
	public double restar()
	{
		res=operando1-operando2;
		return res;
	}
	
	public double multiplicar()
	{
		res=operando1*operando2;
		return res;
	}
	
	public double dividir()
	{
		if (operando2==0)
			res=0;
		else
			res=operando1/operando2;
		return res;
	}
}
