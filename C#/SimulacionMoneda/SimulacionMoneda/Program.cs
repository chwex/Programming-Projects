using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SimulacionMoneda
{
    class Program
    {
        static void Main(string[] args)
        {
            int NT = 0;
            double tiro = 0, aguila = 0, sello = 0;
            Random rnd = new Random();

            System.Console.WriteLine("¿Cuantas veces a tirar moneda?");
            NT = int.Parse(Console.ReadLine());

            for (int i = 0; i < NT; i++)
            {
                tiro = rnd.NextDouble();
                if (tiro>=0 && tiro<.5)
                {
                    System.Console.WriteLine("Aguila " + Math.Round(tiro, 4, MidpointRounding.AwayFromZero));
                    aguila++;
                }

                if (tiro >= .5 && tiro <= 1)
                {
                    System.Console.WriteLine("Sello " + Math.Round(tiro, 4, MidpointRounding.AwayFromZero));
                    sello++;
                }
                System.Console.WriteLine();
            }

            
            System.Console.WriteLine("Aguilas Tiradas = " + aguila +"= "+ Math.Round(((aguila/NT)*100), 2, MidpointRounding.AwayFromZero)+"%");

            System.Console.WriteLine("Sellos Tirados = " + sello +"= " + Math.Round(((sello/NT)*100), 2, MidpointRounding.AwayFromZero) + "%");

            Console.ReadLine();
        }
    }
}
