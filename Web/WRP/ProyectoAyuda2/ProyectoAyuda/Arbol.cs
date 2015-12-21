using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ProyectoAyuda.Controller
{
    //Esta clase representa la estructura de datos del arbol y sigue siendo de tipo T
    public class Arbol<T>
    {
        //La raiz del arbol
        private NodoArbol<T> raiz;

        //Construye el arbol y se le manda el valor del nodo por parametro
        public Arbol(T valor)
        {
            if (valor == null)
            {
                throw new ArgumentNullException("No se puede insertar valor nulo");
            }

            this.raiz = new NodoArbol<T>(valor);
        }

        //Construye el arbol, se le manda el valor de la raiz y dentro de 
        //un arreglo a los hijos del nodo raiz
        public Arbol(T valor, params Arbol<T>[] hijos)
            : this(valor)
        {
            foreach (Arbol<T> hijo in hijos)
            {
                this.raiz.AgregaHijo(hijo.raiz);
            }
        }

        //Cruza e imprime el arbol de una manera Depth-First Search (DFS)
        //Se le mandan como parametros la raiz y los espacios para separar las relaciones
        private void ImprimeDFS(NodoArbol<T> raiz, string espacios)
        {
            if (this.raiz == null)
            {
                return;
            }

            Console.WriteLine(espacios + raiz.Valor);

            NodoArbol<T> hijo = null;
            for (int i = 0; i < raiz.ContarHijos; i++)
            {
                hijo = raiz.GetHijo(i);
                ImprimeDFS(hijo, espacios + "    ");
            }
        }

        //Cruza e imprime el arbol de manera DFS
        public void CruzarDFS()
        {
            this.ImprimeDFS(this.raiz, string.Empty);
        }
    }
}
