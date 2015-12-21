package interfaces;

import paq1.Formatea;

public class Ap_cuenta_cheques_int 
{
	  public static void main(String [] args)
	  {
		  Cuenta_cheque_int cliente01= new Cuenta_cheque_int(10.00,0,"12345","Janeth Rodriguez", 1000000,12); 
		  // Cuenta_Corriente cliente01=new Cuenta_Corriente();
		  cliente01.deposito(1000000);
		  cliente01.retiro(500);
		  cliente01.retiro(1500);
		  //cliente01.deposito(2000);
	      System.out.println("\tEstado de cuenta del cliente: ");
	      System.out.println();
	      
	      System.out.println("\tNombre...............: "+ cliente01.getNombre());
	      System.out.println("\tCuenta...............: "+ cliente01.getCuenta());
	      System.out.println("\tImporte x Transaccion: "+ Formatea.alinder("##,###,###,##0.00",cliente01.obtenerimportePorTrans()));
	      System.out.println("\tTransacciones........: "+ Formatea.alinder("##0",cliente01.obtenertransacciones()));
	      System.out.println("\tTransacciones Ex.....: "+ Formatea.alinder("##0",cliente01.obtenertransExentas()));
	      System.out.println("\tSaldo Inicial........: "+ Formatea.alinder("##,###,###,##0.00",cliente01.saldo()));
	      System.out.println("\tComisiones...........: "+ Formatea.alinder("##,###,###,##0.00",cliente01.comisiones()));
	      System.out.println("\tSaldo con comisiones.: "+ Formatea.alinder("##,###,###,##0.00",cliente01.saldo()));
	      System.out.println("\tIntereses............: "+ Formatea.alinder("##,###,###,##0.00",cliente01.intereses()));
	      System.out.println("\tSaldo Actual.........: "+ Formatea.alinder("##,###,###,##0.00",cliente01.saldo()));
	
	      
	    		  
	    //  System.out.println("\tImp. Trans: "+ Formatea.alinder("##,###,###,##0.00",cliente01.obtenerimportePorTrans()));
	      
	      
	      		
	  }
}
