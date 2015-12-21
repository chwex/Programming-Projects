using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WRPractica.Controller;

namespace WRPractica.Controller
{
    public class Empresa
    {
        public string empresa { get; set; }
        public int ID { get; set; }
        public List<Empleado> ListaEmpleados { get; set; }
        public Empresa() { 
 
        }

    }
}