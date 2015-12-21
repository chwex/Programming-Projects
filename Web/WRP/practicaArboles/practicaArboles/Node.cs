using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practicaArboles
{
    class Node
    {
        public string data;
        public Child children = null;

        public Node(string data)
        {
            this.data = data;
        }

        public void addChild(Node node)
        {
            if (this.children == null)
                this.children = new Child(node);
            else
                this.children.addChild(node);
        }
    }
}
