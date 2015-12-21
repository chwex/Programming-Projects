using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;

namespace ProyectoAyuda
{
    public class Negocio
    {
        //Constructor
        public Negocio()
        { 
            
        }

        //getters y setters de las propiedades de la clase
        public string descripcion { get; set; }
        public int codigo { get; set; }

        //metodo para armar arbol
        public List<Negocio> ArmarArbol()
        {
            List<Negocio> lista = new List<Negocio>();
            
            //algoritmo para armar arbol
            return lista;
        }

    }
}
