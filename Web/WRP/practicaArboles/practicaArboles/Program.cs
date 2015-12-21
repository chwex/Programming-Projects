using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practicaArboles
{
    class Program
    {
        static void Main(string[] args)
        {
            Node root = new Node("hey");
            root.addChild(new Node("you"));
            root.addChild(new Node("me"));
            root.addChild(new Node("them"));

            Node root2 = new Node("me");
            root2.addChild(new Node("him"));

            Console.Write(root.children.ToString());
            Console.ReadKey();
        }
    }
}
