using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;

namespace ProyectoAyuda
{
    public class Componente
    {
        //Constructor
        public Componente()
        { 
        
        }

        //getters y setters de las propiedades de la clase
        public string descripcion { get; set; }
        public int codigo { get; set; }
        public string icono { get; set; }
        public string ayuda { get; set; }
        
    }
}
