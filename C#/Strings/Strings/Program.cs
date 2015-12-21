using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            // string myString = "go to your c:\\ drive";
            //string myString = "my \"So called\" life";
            //string myString = "what if i needed \n a new line?";
            //string myString = string.Format("{0}!", "Bonzai");
            //string myString = string.Format("Make: {0} (model: {1})", "BMW", "760li")

            string myString = string.Format("{0:C}", 123.45);
            //string myString = string.Format("{0:N}", 123456789);
            //string myString = string.Format("Phone number: {0:(###)-###-####}", 1234567890);

            //string myString = " ";
            //for (int i = 0; i < 100; i++)
            //{
            //    //myString = myString + "--" + i.ToString();
            //    myString += "--" + i.ToString();
            //}

            //StringBuilder myString = new StringBuilder();
            //for (int i = 0; i < 100; i++)
            //{
            //    myString.Append("--");
            //    myString.Append(i);
            //}

            //string myString = " That summer we took threes accross the board  ";
            ////myString = myString.Substring(5, 14);
            ////string myString = myString.ToUpper();
            ////myString = myString.Replace(" ", "--");
            //myString = String.Format("Length before: {0} -- After {1}",
            //    myString.Length, myString.Trim().Length);

            Console.WriteLine(myString.ToString());
            Console.ReadLine();

        }
    }
}
