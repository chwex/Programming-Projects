using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practice
{
    class Program
    {
        static void Main(string[] args)
        {
            dog myDog = new dog();
            //myDog.sayWoof();
            cat mycat = new cat();
            //mycat.sayMeow();

          
            Animal[] animals = new Animal[5];
            animals[0] = new dog();
            animals[1] = new cat();

            foreach (Animal a in animals)
            {
                a.makeNoise();
            }
            
            Console.ReadKey();
        }
    }
}
