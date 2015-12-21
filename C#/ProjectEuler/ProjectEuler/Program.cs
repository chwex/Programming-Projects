using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEuler
{
    class Program
    {
        static void Main(string[] args)
        {
            //Euler1();
            //Euler2();
            //Euler3();
            Console.ReadLine();
        }

        public static void Euler1 ()
        {
            int suma=0;
            for (int i = 0; i <1000; i++)
            {
                if (i%3==0 || i%5==0)
                    suma = suma + i;
            }

            Console.WriteLine(suma);
            Console.ReadLine();
        }

        public static void Euler2()
        {
            int suma=0, a=1, b=1, fib=0;
            while(fib <= 4000000)
            {
                if (fib % 2 == 0)
                    suma = suma + fib;

                fib = a + b;
                a = b;
                b = fib;
            }

            Console.WriteLine(suma);
            Console.ReadLine();
            
        }

        public static void Euler3()
        {
            const long numm = 600851475143;
            long newnumm = numm;
            long largestFact = 0;

            int counter = 2;
            while (counter * counter <= newnumm)
            {
                if (newnumm % counter == 0)
                {
                    newnumm = newnumm / counter;
                    largestFact = counter;
                }
                else
                {
                    counter++;
                }
            }
            if (newnumm > largestFact)
            { // the remainder is a prime number
                largestFact = newnumm;
            }

            Console.WriteLine(largestFact);
            Console.ReadLine();
        }

        public static Boolean isPrime(long number)
        {

            if (number == 1) return false;
            if (number == 2) return true;

            if (number % 2 == 0) return false; //Even number     

            for (long i = 3; i < number; i += 2)
            {
                if (number % i == 0) return false;
            }

            return true;

        }

    }
}
