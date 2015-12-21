using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace demo.Controller
{
    public class Empleado
    {
        public Empleado()
        { 
        
        }

        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Sexo { get; set; }
        public List<Domicilio> domicilios { get; set; }
    }
}