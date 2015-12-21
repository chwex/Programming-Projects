using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;

namespace ProyectoAyuda.Controller
{
    public class Extension
    {
        public int IDExtension { get; set; }
        public string descExtension { get; set; }
        List<Negocio> negocios { get; set; }

        public Extension()
        { 
        
        }
        
        
    }
}
