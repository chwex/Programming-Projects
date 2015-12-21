using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ProyectoAyuda
{
    public class ServicioAyudaController
    {
        
        public string ObtenerAyudaURL(string URL)
        {
            return URL;
        }

        public Negocio ConsultarArbol(string URL)
        {
            var arbol = new List<Negocio>();

            return arbol;
        }

        public Forma ConsultarForma(string URL)
        {
            var lForma = new List<Forma>();
            
            return lForma;
        }

        public Modulo ConsultarModulo(string URL)
        {
            var lModulo = new List<Modulo>();

            return lModulo;
        }



    }

    
}