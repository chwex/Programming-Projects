using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace demo.Controller
{
    public class Domicilio
    {
        public Domicilio()
        { 
        
        }

        public string Calle { get; set; }
        public string Numero { get; set; }
        public string Colonia { get; set; }
        public string Ciudad { get; set; }
    }
}