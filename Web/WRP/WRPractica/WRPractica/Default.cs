using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WRPractica.Controller;

namespace WRPractica
{
    public class Default : ApiController
    {
        // GET api/<controller>
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        //[HttpPost]
        //public Empleado empleado(Empresa valor) {  
        //    return new Empleado;
        //}

        [HttpPost]
        public IEnumerable<Empleado> ObtenerEmpleados(Empresa valor)
        {
            var lista = new List<Empleado>();
            var empresa = new Empresa();
            
            for (int i = 0; i < 3 ; i++)
			{
                lista.Add(new Empleado { });
			}
            return lista;
        }

        // GET api/<controller>/5
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<controller>
        public void Post([FromBody]string value)
        {
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
        }
    }
}