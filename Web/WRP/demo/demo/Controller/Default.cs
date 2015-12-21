using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace demo.Controller
{

    public class DefaultController : ApiController
    {

        // GET api/<controller>
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        [HttpPost]
        public TestModel Test(TestSolicitud value){
            return new TestModel();
        }

        [HttpPost]
        public IEnumerable<TestModel> ObtenerLista(TestSolicitud value)
        {

            var lista = new List<TestModel>();
            
            for (int x = 0; x <= value.Total; x++)
            {
                lista.Add(new TestModel { Demo = string.Format("Elemento {0}", x), ID = x });
            }
            
            return lista;
        }

        [HttpPost]
        public string GuardarLista(TestSolicitud value)
        {
            return "Se guardo";
        }

        [HttpPost]
        public string Mensaje()
        {
            return "mensaje";
        }

        [HttpGet]
        public IEnumerable<Employee> Northwind()
        {
            var empleados = new List<Employee>();
            NorthwindDataContext db = new NorthwindDataContext();

            var emp =
                from e in db.Employees
                select new
                {
                    e.FirstName,
                    e.LastName,
                    e.EmployeeID
                };

            foreach (var emple in emp)
            {
                empleados.Add(new Employee { 
                    FirstName = emple.FirstName, 
                    LastName= emple.LastName,
                    EmployeeID = emple.EmployeeID
                });
            }

            return empleados;
        }

        [HttpPost]
        public IEnumerable<TestModel> Generar(TestSolicitud value)
        {

            var lista = new List<TestModel>();

            for (int x = 0; x <= value.Total; x++)
            {
                string gen = Path.GetRandomFileName();
                gen = gen.Replace(".", ""); 
                lista.Add(new TestModel { Demo = string.Format(gen), ID = x });
            }

            return lista;

        }

        [HttpPost]
        public IEnumerable<TestModel> GetInfo(TestSolicitud value)
        {
            var lista = new List<TestModel>();

            if (value.Total == 3)
            {
                lista.Add(new TestModel { Demo = "Carlos Valdez", ID = 2 });
                lista.Add(new TestModel { Demo = "Brandon Valdez", ID = 1 });
                lista.Add(new TestModel { Demo = "Tony Valdez", ID = 3 });
            }
            else
            {
                for (int i = 0; i < value.Total; i++)
                {
                    lista.Add(new TestModel { Demo = string.Format("Sin valor en {0}", i+1), ID = i });
                }
            }

            return lista;
        }

        [HttpPost]
        public IEnumerable<Empleado> obtenerDefault()
        {
            var empleado = new List<Empleado>();
            var domicilio = new List<Domicilio>();

            domicilio.Add((new Domicilio
            {
                Calle = "Aquitectos",
                Numero = "128",
                Colonia = "Tierra Blanca",
                Ciudad = "Culiacan"
            }));

            empleado.Add(new Empleado
            {
                Nombre = "Carlos",
                Apellido = "Valdez",
                Sexo = "male",
                domicilios = domicilio
            });

            return empleado;
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