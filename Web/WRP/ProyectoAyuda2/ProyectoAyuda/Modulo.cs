using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;


namespace ProyectoAyuda.Controller
{
    public class Modulo
    {
        public int IDModulo { get; set; }
        public string descModulo { get; set; }
        public List<Forma> formas { get; set; }

        public Modulo()
        { 
            
        }

        //public void agregarModulo();
        //public void elimnarModulo();
    }
}
