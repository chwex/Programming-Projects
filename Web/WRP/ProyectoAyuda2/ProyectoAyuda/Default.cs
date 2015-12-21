using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ProyectoAyuda;

namespace ProyectoAyuda.Controller
{
    public class DefaultController : ApiController
    {
        // GET api/<controller>
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        [HttpPost]
        public Componente comp(Forma valor)
        {
            return new Componente();
        }
        
        [HttpPost]
        public Forma form(Modulo valor)
        {
            return new Forma();
        }

        [HttpPost]
        public Modulo mod(Negocio valor)
        {
            return new Modulo();
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