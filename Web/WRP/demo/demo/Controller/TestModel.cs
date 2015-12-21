using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace demo.Controller
{
    public class TestModel
    {
        public TestModel() {
            Demo = "Demo de ejemplo";
        }
        public string Demo { get; set; }
        public int ID { get; set; }
    }
}
