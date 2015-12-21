using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
//AGREGAR REGEX 
using System.Text.RegularExpressions; 


namespace CompiladorAlgebraico
{
    class Compiler
    {
        enum Simbolo
        {
            Ninguno,
            Suma, Resta, Multiplicación, División,
            AbrirParéntesis, CerrarParéntesis,
            Constante, Variable,
            FinDeLaExpresión
        }

        //DECLARACION DE VARIABLES 
        private string expresion;
        private int posicion;
        private Simbolo últimoSimbolo;
        private double últimaConstante;
        private Stack<double> pila;
        private double valorDeX;

        //CONTRUSCTOR 
        public Compiler(string expresion)
        {
            this.expresion = expresion; 
        }

        //EVALUAR
        public double Evaluar(double x)
        {
            this.valorDeX = x;
            this.posicion = 0;
            this.pila = new Stack<double>();
            últimoSimbolo = ObtenerSiguienteSímbolo();
            Expresion();
            if (pila.Count < 1)
                throw new Exception("Error al leer de la pila");
            return pila.Pop();
        }

        //OBTENER EL SIGUIENTE SIMBOLO 
        private Simbolo ObtenerSiguienteSímbolo()
        {
            char c;
            do
            {
                if (posicion >= expresion.Length)
                    return Simbolo.FinDeLaExpresión;
                c = expresion[posicion++];
            }
            while (c == ' '); //Despreciamos los espacios en blanco 

            switch (c)
            {
                case 'x':
                case 'X': return Simbolo.Variable;
                case '(': return Simbolo.AbrirParéntesis;
                case ')': return Simbolo.CerrarParéntesis;
                case '+': return Simbolo.Suma;
                case '-': return Simbolo.Resta;
                case '*': return Simbolo.Multiplicación;
                case '/': return Simbolo.División;
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


        //EXPRESION 
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
                    case Simbolo.División:
                        últimoSimbolo = ObtenerSiguienteSímbolo();
                        Factor();  //Termino();
                        OperacionDivision();
                        break;
                    case Simbolo.Multiplicación:
                        últimoSimbolo = ObtenerSiguienteSímbolo();
                        Factor();  //Termino();
                        OperacionMultiplicacion();
                        break;
                    default: return;
                }
            }
        } // FIN EXPRESION 


        //FACTOR 
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
            else if (últimoSimbolo == Simbolo.División)
            {
                OperacionDivision();
                últimoSimbolo = ObtenerSiguienteSímbolo();
            }
            else if (últimoSimbolo == Simbolo.Multiplicación)
            {
                OperacionMultiplicacion();
                últimoSimbolo = ObtenerSiguienteSímbolo();
            }
            else
                throw new Exception("Factor");
        }

       // FIN FACTOR 


        // OPERACIONES 
        private void OperacionConstante()
        {
            pila.Push(últimaConstante);
        }
        private void OperacionVariable()
        {
            pila.Push(valorDeX);
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

        private void OperacionDivision()
        {
            double op2 = pila.Pop();
            double op1 = pila.Pop();
            pila.Push(op1 / op2);
        }

        private void OperacionMultiplicacion()
        {
            pila.Push(pila.Pop() * pila.Pop());
        }



    }
}
