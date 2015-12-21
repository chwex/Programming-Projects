using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practicaArboles
{
    class Child
    {
        Node node;
        Child next = null;

        public Child(Node node)
        {
            this.node = node;
        }

        public void addChild(Node node)
        {
            if (this.next == null)
                this.next = new Child(node);
            else
                this.next.addChild(node);
        }
    }
}
