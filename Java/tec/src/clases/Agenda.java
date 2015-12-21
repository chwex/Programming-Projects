package clases;

public class Agenda
{
	// atributos
	
	private Persona [] Directorio;			//  El vector directorio ( agenda ) es un vector de objetos ( personas )
	private int nElementos;                 //  Numero de elementos ( personas ) del vector ( agenda )
	
	// Metodos
	// Constructores
	
	public Agenda()
	{
		// crear una lista vacia
		nElementos=0;                         //  Al inicio no hay personas en la agenda
		Directorio=new Persona[nElementos];   //  Se crea un vector ( agenda ) con 0 objetos ( personas )
	}
	
	// Interfaz
	
	public void unElementoMas(Persona [] v)       
	{                                                 
		nElementos=v.length;
		Directorio=new Persona[nElementos + 1];   //  Se crea un vector con un elemento mas
		// copiar el vector actual
		for (int i=0; i<nElementos; i++)          //  Se copian los elementos del vector ( El vector del parametro )
			Directorio[i]=v[i];                   //  en el nuevo vector, quedando un elemento al final vacio.
		nElementos++;                             //  Se actualiza el atributo de numero de elementos del vector 
	}
	
	public void unElementoMenos(Persona [] v)
	{
		if (v.length==0)
			return;
		else
		{
		   int k=0;
		   nElementos=v.length;
		   Directorio=new Persona[nElementos - 1];   //  Se crea un vector con un elemento menos
		   // copiar el vector actual
		   for (int i=0; i<nElementos; i++)          //  Se copian los elementos del vector ( El vector del parametro )  
			   if (v[i]!= null)                      //  en el nuevo vector, eliminado al elemento que previamente
				   Directorio[k++]=v[i];             //  se marco como eliminado ( Null ) en el metodo
		                                             //  eliminar de esta clase
		   nElementos--;                             //  Se actualiza el atributo de numero de elementos del vector
		}
	}
	
	public void asignarValorEn(int i, Persona objeto)
	{
		if (i>=0 && i<nElementos)                   // se asigna al elemento iesimo del vector el objeto persona
			Directorio[i]=objeto;                   // recibido en el parametro.
		else
			System.out.println("Indice fuera de limites...");
	}
	
	public Persona obtenerValorEn(int i)
	{
		if (i>=0 && i<nElementos)
			return Directorio[i];             // se obtiene el elemento iesimo del vector solicitado en el parametro
		else
		{
			System.out.println("Indice fuera de limites...");
			return null;
		}
	}
	
	public int longitud()
	{
		return nElementos;       // se obtiene el numero de elementos del vector
	}
	
	public void agregar(Persona obj)
	{
		unElementoMas(Directorio);				//  Se agrega un objeto ( persona ) al vector ( Agenda )
		asignarValorEn(nElementos-1,obj);
	}
	
	public boolean eliminar(long tel)
	{
		// buscar un telefono y eliminar el registro
		for(int i=0; i<nElementos; i++)
			if(Directorio[i].obtenerTelefono()==tel)
			{
				Directorio[i]=null;                 // Se elimina un elemento del vector asignadole null a su referencia 
				unElementoMenos(Directorio);        // es decir, se elimina la referencia al objeto ( persona ) 
				return true;                        // a eliminar.
			}
		return false;
	}
	
	public int buscar(String str, int pos)        // pos es la posicion a partir de donde se va a iniciar la busqueda
	{
		String nom;
		if (str==null) return -1;
		if (pos<0) pos=0;
		for (int i=pos; i<nElementos; i++)       // se busca en el directorio  
		{
			nom=Directorio[i].obtenerNombre();  
			if (nom==null) continue;
			// ? str es parte de nom..?
			if (nom.indexOf(str)>-1)
				return i;                      // regresa la posicion del elemento buscado
		}
		return -1;
	}


}
