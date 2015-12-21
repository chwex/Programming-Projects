using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;

namespace ProyectoAyuda.Controller
{
    public class Forma
    {
        public int IDForma { get; set; }
        public string descForma { get; set; }
        public string iconoForma { get; set; }
        public string extraForma { get; set; }
        public string identificadorURL { get; set; }
        public List<Componente> componentes { get; set; }

        public Forma()
        { 
        
        }

        //public void agregarForma();
        //public void elimnarForma();
    }
}
