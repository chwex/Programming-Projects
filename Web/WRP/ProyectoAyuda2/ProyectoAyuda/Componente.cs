using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;

namespace ProyectoAyuda.Controller
{
    public class Componente
    {
        public int IDComponente { get; set; }
        public string descComponente { get; set; }
        public string iconoComponente { get; set; }
        public int extraComponente { get; set; }

        public Componente()
        {

        }

        //public void agregarComponente();
        //public void elimnarComponente();
    }


}
