using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;

namespace ProyectoAyuda.Controller
{
    public class Negocio
    {
        public int IDNegocio { get; set; }
        public string descNegocio { get; set; }
        List<Modulo> modulos { get; set; }
        
        public Negocio() 
        {
            
        }
        //public void agregarNegocio();
        //public void elimnarNegocio();
    }
}
