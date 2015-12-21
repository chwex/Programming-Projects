using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;

namespace ProyectoAyuda
{
    public class Categoria
    {
        //Constructor
        public Categoria()
        { 
        }

        //Getters y setters de as propiedades de la clase
        public string nombre { get; set; }
        public int codigo { get; set; }

    }
}
