package herencia;

public class Banco
{
		private Ccuenta[] clientes;
		private int nElementos;
		
		public Banco()
		{
			nElementos = 0;
			clientes = new Ccuenta[nElementos];
		}
		
		private void unElementoMas(Ccuenta [] clientesActuales)
		{
			nElementos = clientesActuales.length;
			clientes = new Ccuenta[nElementos + 1];
			for(int i = 0; i < nElementos; i++)
				clientes[i]=clientesActuales[i];
			nElementos++;
		}
		
		private void unElementoMenos(Ccuenta[] clientesActuales)
		{
			if(clientesActuales.length == 0)
				return;
			int k = 0;
			nElementos = clientesActuales.length;
			clientes = new Ccuenta[nElementos - 1];
			for(int i = 0; i < nElementos; i++)
				if(clientesActuales[i] != null)
					clientes[k++] = clientesActuales[i];
			nElementos--;
		}
		
		public void asignarClienteEn(int i, Ccuenta objeto)
		{
			if ( i >=0 && i < nElementos)
				clientes[i] = objeto;
			else
				System.out.println("Indice fuera de limites");
		}
		
		public Ccuenta obtenerClienteEn(int i)
		{
			if ( i >=0 && i < nElementos)
				return clientes[i];
			else
			{
				System.out.println("Indice fuera de los limites");
				return null;
			}
		}
		
		public int longitud()
		{
			return nElementos;
		}
		
		public void añadir(Ccuenta obj)
		{
			unElementoMas(clientes);
			asignarClienteEn( nElementos - 1, obj );
		}
		
		public boolean eliminar(String cuenta)
		{
			for ( int i = 0; i < nElementos; i++ )
				if( cuenta.compareTo(clientes[i].getCuenta()) == 0)
				{
					clientes[i] = null;
					unElementoMenos(clientes);
					return true;
				}
			return false;
		}
		
		public int buscar(String str, int pos)
		{
			String nom, cuen;
			if(str == null)
				return -1;
			if(pos < 0)
				pos = 0;
			for(int i = pos; i < nElementos; i++)
			{
				nom = clientes[i].getNombre();
				if(nom == null)
					continue;
				if(nom.indexOf(str) > -1)
					return i;
				cuen = clientes[i].getCuenta();
				if(cuen == null)
					continue;
				if(cuen.indexOf(str)> -1)
					return i;
			}
			return -1;
		}
}



