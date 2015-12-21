using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;

namespace ProyectoAyuda
{
    public class PreguntasFrecuentes
    {
        //Constructor de la clase
        public PreguntasFrecuentes()
        { 
        
        }

        //Getters y setters de las propiedades de la clase
        public int codigo { get; set; }
        public string pregunta { get; set; }
        public string respuesta { get; set; }
        public int negocio { get; set; }
        public int modulo { get; set; }

    }
}
