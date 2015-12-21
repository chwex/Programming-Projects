using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ProyectoAyuda.Controller
{
    public class NodoArbol<T>
    {
        //Contiene el valor del nodo
        private T valor;

        //Demuestra si el nodo tiene un padre o no
        private bool tienePadre;

        //Contiene al hijo del nodo(Zero o mas)
        private List<NodoArbol<T>> hijos;

        //construye un nodo del arbol y se le manda el valor del arbol
        public NodoArbol(T valor)
        {
            if (valor == null)
            {
                throw new ArgumentNullException(
                    "No se puede insertar un valor nulo.");
            }
            this.valor = valor;
            this.hijos = new List<NodoArbol<T>>();
        }

        //El valor del nodo
        public T Valor
        {
            get { return this.valor; }
            set { this.valor = value; }
        }

        //El numero de nodos hijos
        public int ContarHijos
        {
            get { return this.hijos.Count; }
        }

        //Agrega hijo al nodo y se le manda al hijo a agregar por parametro
        public void AgregaHijo(NodoArbol<T> hijo)
        {
            if (hijo == null)
            {
                throw new ArgumentNullException("No se puede agregar balor nulo");
            }

            if (hijo.tienePadre)
            {
                throw new ArgumentException("El nodo ya tiene padre.");
            }

            hijo.tienePadre = true;
            this.hijos.Add(hijo);
        }

        //Toma el hijo de un indice dado. Se le manda como parametro el indice del hijo
        //Y regresa el hijo en la posicion dada
        public NodoArbol<T> GetHijo(int indice)
        {
            return this.hijos[indice];
        }
    }
}