using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;

namespace ProyectoAyuda
{
    public class Modulo
    {
        //Constructor
        public Modulo()
        {
        
        }

        //getters y setters de las propiedades de la clase
        public string descripcion { get; set; }
        public int codigo { get; set; }
        public int codigoNegocio { get; set; }
        
        //lista de tipo forma que contiene las formas dentro del modulo
        public List<Forma> formas {get; set;}
    }
}
