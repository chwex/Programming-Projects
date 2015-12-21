using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace CompiladorAlgebraico
{
    class Compilador
    {
        enum Simbolo
        {
            Ninguno,
            Suma, Resta, Multiplicación, División,
            AbrirParéntesis, CerrarParéntesis,
            Constante, Variable,
            FinDeLaExpresión, Declaracion, PuntoC
        }

        private string expresion, llave;
        private int posicion, varPos, valor;
        private Simbolo últimoSimbolo;
        private double últimaConstante;
        private string[] var;
        private Stack<double> pila;
        char c;
        Hashtable hash;

        public Compilador(string expresion)
        {
            this.expresion = expresion;
        }

        public double Evaluar()
        {
            this.pila = new Stack<double>();
            this.var = null;
            this.hash = new Hashtable();
            var = split(expresion); // dividir la expresion en "tokens"
            asigVar();//agregar variables dentro de una tabla hash
           
            for (int i = 0; i < varPos; i++)
            {
                posicion = posicion + var[i].Length;
            }
            posicion = posicion + hash.Count+2;

            últimoSimbolo = ObtenerSiguienteSímbolo();
            Expresion();
            if (pila.Count < 1)
                throw new Exception("Error al leer de la pila");
            return pila.Pop();
        }

        private Simbolo ObtenerSiguienteSímbolo()
        {
            do
            {
                if (posicion >= expresion.Length)
                    return Simbolo.FinDeLaExpresión;
                c = expresion[posicion++];
            }
            while (c == ' '); //Despreciamos los espacios en blanco 

            switch (c)
            { 
                case '(': return Simbolo.AbrirParéntesis;
                case ')': return Simbolo.CerrarParéntesis;
                case '+': return Simbolo.Suma;
                case '-': return Simbolo.Resta;
                case '*': return Simbolo.Multiplicación;
                case '/': return Simbolo.División;
            }
            if (Char.IsLetter(c))
                return Simbolo.Variable;
            if (c.CompareTo(';') == 0)
            {
                return Simbolo.PuntoC;

            }
            Regex re = new Regex(@"^\d+([,\.]\d+)?");
            string exp = expresion.Substring(posicion - 1);
            if (re.IsMatch(exp))
            {
                Match m = re.Match(exp);
                string s = m.Value;
                posicion += m.Length - 1;
                últimaConstante =
               double.Parse(s.Replace(".", ","));
                return Simbolo.Constante;
            }
            throw new Exception
            (
                "Simbolo no reconocido en la posición " + posicion
            );
        } // FIN OBTENER SIMBOLO 
 
        private void Expresion()
        {
            Factor(); //Termino();
            while (true)
            {
                switch (últimoSimbolo)
                {
                    case Simbolo.Suma:
                        últimoSimbolo = ObtenerSiguienteSímbolo();
                        Factor(); //Termino();
                        OperacionSuma();
                        break;
                    case Simbolo.Resta:
                        últimoSimbolo = ObtenerSiguienteSímbolo();
                        Factor();  //Termino();
                        OperacionResta();
                        break;
                    default: return;
                }
            }
        } // FIN EXPRESION 
 
        private void Factor()
        {
            if (últimoSimbolo == Simbolo.AbrirParéntesis)
            {
                últimoSimbolo = ObtenerSiguienteSímbolo();
                Expresion();
                if (últimoSimbolo != Simbolo.CerrarParéntesis)
                    throw new Exception("Falta ')'");
                últimoSimbolo = ObtenerSiguienteSímbolo();
            }
            else if (últimoSimbolo == Simbolo.Constante)
            {
                OperacionConstante();
                últimoSimbolo = ObtenerSiguienteSímbolo();
            }
            else if (últimoSimbolo == Simbolo.Variable)
            {
                OperacionVariable();
                últimoSimbolo = ObtenerSiguienteSímbolo();
            }
            else
                throw new Exception("Factor");
        } // FIN FACTOR 

        private void OperacionConstante()
        {
            pila.Push(últimaConstante);
        }
        private void OperacionVariable()
        {
            string cha = c.ToString();
            double hv = Convert.ToDouble(hash[cha]);
            pila.Push(hv);
        }
        private void OperacionSuma()
        {
            pila.Push(pila.Pop() + pila.Pop());
        }
        private void OperacionResta()
        {
            double op2 = pila.Pop();
            double op1 = pila.Pop();
            pila.Push(op1 - op2);
        }

        private static string[] split(string exp)
        {
            string[] var = null;
            char[] splitchar = { ' ' };
            var = exp.Split(splitchar);
            return var;
        }

        private void asigVar()
        {
            //validar el int
            if (var[varPos] == "int")
            {
                varPos++;

                //validar variable
                if (var[varPos].Length == 1)
                {
                    llave = var[varPos];
                    varPos++;
                    if (var[varPos] == "=")
                    {
                        varPos++;
                        int longitud = var[varPos].Length;
                        valor = Convert.ToInt32(var[varPos].Substring(0, longitud-1));
                        hash.Add(llave, valor);
                        varPos++;
                        if (var[varPos] == "int")
                            asigVar();
                        else
                        {
                            varPos++;
                            asigVar();
                        }                    
                    }
                    
                }
            }
            
        }
    }
}