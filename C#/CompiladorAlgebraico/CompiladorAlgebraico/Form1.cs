using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace CompiladorAlgebraico
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void cmd_compile_Click(object sender, EventArgs e)
        {
            //Se ejecuta una vez, creando el método dinámico 
            string expresion = tex_ecuacion.Text;
            Compiler compile = new Compiler(expresion);

            //Se ejecuta cuantas veces sea necesario 
            double x = Convert.ToDouble(tex_variablex.Text);
            double resultado = compile.Evaluar(x);

            tex_resultado.Text = resultado.ToString(); 
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string expresion = txtBoxEcu.Text;
            expresion = expresion.Replace(System.Environment.NewLine, " ");
            expresion = expresion.Replace("\r", " ");
            Compilador compilar = new Compilador(expresion);
            double resultado = compilar.Evaluar();
            txtBoxRes.Text = resultado.ToString();
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void tex_ecuacion_TextChanged(object sender, EventArgs e)
        {

        }

        private void tex_resultado_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
