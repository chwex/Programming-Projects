using System;
namespace Practice
{
    class Animal
    {
        public string hairColor;
        public int age;

        public void walk()
        {

        }

        public virtual void makeNoise()
        {
            Console.WriteLine("Growl");
            
        }
    }
}
