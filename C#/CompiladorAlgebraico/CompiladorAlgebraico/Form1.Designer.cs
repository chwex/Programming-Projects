namespace CompiladorAlgebraico
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.tex_ecuacion = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.tex_variablex = new System.Windows.Forms.TextBox();
            this.cmd_compile = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.tex_resultado = new System.Windows.Forms.TextBox();
            this.txtBoxRes = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.btnEcu = new System.Windows.Forms.Button();
            this.txtBoxEcu = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(14, 20);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(70, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "ECUACIÓN";
            // 
            // tex_ecuacion
            // 
            this.tex_ecuacion.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tex_ecuacion.Location = new System.Drawing.Point(101, 17);
            this.tex_ecuacion.Multiline = true;
            this.tex_ecuacion.Name = "tex_ecuacion";
            this.tex_ecuacion.Size = new System.Drawing.Size(227, 37);
            this.tex_ecuacion.TabIndex = 1;
            this.tex_ecuacion.Text = "5+3-x";
            this.tex_ecuacion.TextChanged += new System.EventHandler(this.tex_ecuacion_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(14, 69);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(79, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "VARIABLE X";
            // 
            // tex_variablex
            // 
            this.tex_variablex.Location = new System.Drawing.Point(101, 66);
            this.tex_variablex.Multiline = true;
            this.tex_variablex.Name = "tex_variablex";
            this.tex_variablex.Size = new System.Drawing.Size(80, 20);
            this.tex_variablex.TabIndex = 3;
            this.tex_variablex.Text = "10";
            // 
            // cmd_compile
            // 
            this.cmd_compile.Location = new System.Drawing.Point(101, 101);
            this.cmd_compile.Name = "cmd_compile";
            this.cmd_compile.Size = new System.Drawing.Size(97, 23);
            this.cmd_compile.TabIndex = 4;
            this.cmd_compile.Text = "COMPILAR";
            this.cmd_compile.UseVisualStyleBackColor = true;
            this.cmd_compile.Click += new System.EventHandler(this.cmd_compile_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(14, 133);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(82, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "RESULTADO";
            // 
            // tex_resultado
            // 
            this.tex_resultado.Location = new System.Drawing.Point(101, 130);
            this.tex_resultado.Multiline = true;
            this.tex_resultado.Name = "tex_resultado";
            this.tex_resultado.ReadOnly = true;
            this.tex_resultado.Size = new System.Drawing.Size(227, 20);
            this.tex_resultado.TabIndex = 6;
            this.tex_resultado.TextChanged += new System.EventHandler(this.tex_resultado_TextChanged);
            // 
            // txtBoxRes
            // 
            this.txtBoxRes.Location = new System.Drawing.Point(475, 220);
            this.txtBoxRes.Multiline = true;
            this.txtBoxRes.Name = "txtBoxRes";
            this.txtBoxRes.ReadOnly = true;
            this.txtBoxRes.Size = new System.Drawing.Size(324, 61);
            this.txtBoxRes.TabIndex = 13;
            this.txtBoxRes.Text = "6\r\n0\r\n20\r\nError de compilación se esperaba numero despues de (\r\n";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(387, 223);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(82, 13);
            this.label4.TabIndex = 12;
            this.label4.Text = "RESULTADO";
            // 
            // btnEcu
            // 
            this.btnEcu.Location = new System.Drawing.Point(702, 182);
            this.btnEcu.Name = "btnEcu";
            this.btnEcu.Size = new System.Drawing.Size(97, 23);
            this.btnEcu.TabIndex = 11;
            this.btnEcu.Text = "COMPILAR";
            this.btnEcu.UseVisualStyleBackColor = true;
            this.btnEcu.Click += new System.EventHandler(this.button1_Click);
            // 
            // txtBoxEcu
            // 
            this.txtBoxEcu.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtBoxEcu.Location = new System.Drawing.Point(475, 33);
            this.txtBoxEcu.Multiline = true;
            this.txtBoxEcu.Name = "txtBoxEcu";
            this.txtBoxEcu.Size = new System.Drawing.Size(324, 143);
            this.txtBoxEcu.TabIndex = 8;
            this.txtBoxEcu.Text = "int x = 1; int y = 2; int z = 3;\r\nx+y+z;\r\nx*2+y/2-z;\r\nx*3+(2/1)*(z+5)/2; \r\nz+(*Y-" +
    "1);";
            this.txtBoxEcu.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(388, 36);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(70, 13);
            this.label6.TabIndex = 7;
            this.label6.Text = "ECUACIÓN";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(391, 9);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(71, 13);
            this.label7.TabIndex = 14;
            this.label7.Text = "OBJETIVO:\r\n";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(817, 293);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.txtBoxRes);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.btnEcu);
            this.Controls.Add(this.txtBoxEcu);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.tex_resultado);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.cmd_compile);
            this.Controls.Add(this.tex_variablex);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.tex_ecuacion);
            this.Controls.Add(this.label1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Compilador de funciones algebraicas";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox tex_ecuacion;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox tex_variablex;
        private System.Windows.Forms.Button cmd_compile;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox tex_resultado;
        private System.Windows.Forms.TextBox txtBoxRes;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button btnEcu;
        private System.Windows.Forms.TextBox txtBoxEcu;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
    }
}

