using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;

namespace ProyectoAyuda
{
    public class Forma
    {
        //Constructor
        public Forma()
        { 
        
        }

        //getters y setters de las propiedades de la forma
        public int codigoModulo { get; set; }
        public string descripcion { get; set; }
        public string URL { get; set; }
        public string contenido { get; set; }

        //cada forma cuenta con una lista de tipo componente y otra de tipo 
        //string que contiene los enlaces de las formas relacionadas
        public List<Componente> componentes { get; set; }
        public List<Categoria> categorias { get; set; }
        public List<string> referencias { get; set; }
    }
}
