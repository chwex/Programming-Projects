using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    SqlConnection sqlConnection = new SqlConnection("Server=DBProyEmp.mssql.somee.com;Database=DBProyEmp;User Id=chwex_SQLLogin_2;Password=kmcun3c6te;");

    protected void Page_Load(object sender, EventArgs e)
    {

    }

    //Metodo para modificar la tabla
    protected void ModificarTabla(object sender, GridViewCommandEventArgs e)
    {
        //Al darle click a modificar hace una conexion a SQL para obtener todos los valores del empleado en cuestion
        Empleados.Attributes.Add("onclick", "return confirm(\"¿Estas seguro de Modificar/Eliminar el registro?\")");
        if (e.CommandName == "Modifica")
        {
            lblConfirm.Text = "Modificar Empleado";
            int index = Convert.ToInt32(e.CommandArgument);
            string temp = Empleados.Rows[index].Cells[1].Text;
            
            SqlCommand cmd = new SqlCommand();
            SqlDataReader reader;

            cmd.CommandText = "SELECT e.nombre, e.ApPaterno, e.ApMaterno, e.Sueldo, e.FecNac, l.Descripcion FROM Empleados e INNER JOIN Departamentos l ON e.Departamento = l.Puesto WHERE FecNac='" + temp + "'";
            cmd.CommandType = CommandType.Text;
            cmd.Connection = sqlConnection;

            try
            {
                sqlConnection.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    txtNombre.Text = (reader["Nombre"].ToString());
                    txtApPaterno.Text = (reader["ApPaterno"].ToString());
                    txtApMaterno.Text = (reader["ApMaterno"].ToString());
                    txtSueldo.Text = (reader["Sueldo"].ToString());
                    DateTime fecha = Convert.ToDateTime(reader["FecNac"]);
                    txtFecNac.Text = fecha.ToString("dd/MM/yyyy");
                    string ddm = (reader["Descripcion"].ToString());
                    DropDownList1.SelectedValue = ddm; 
                } 
            }
            catch (Exception ex)
            {
                lblConfirm.Text = "Error al Obtener Datos" + ex.Message;
                lblConfirm.Visible = true;
            }
            sqlConnection.Close();
            this.Empleados.DataBind();

            pnlMod.Visible = true;
        }

        //se elimina al empleado
        if (e.CommandName == "Elimina")
        {
            int index = Convert.ToInt32(e.CommandArgument);
            string temp = Empleados.Rows[index].Cells[1].Text;
           
            
            SqlCommand cmd = new SqlCommand();
            SqlDataReader reader;

            cmd.CommandText = "DELETE FROM Empleados WHERE FecNac='"+temp+"'";
            cmd.CommandType = CommandType.Text;
            cmd.Connection = sqlConnection;

            try
            {
                sqlConnection.Open();
                reader = cmd.ExecuteReader();
            }
            catch (Exception ex)
            {
                lblConfirm.Text = "Error al Borrar"+ex.Message;
                lblConfirm.Visible = true;
            }
            sqlConnection.Close();
            this.Empleados.DataBind();
        }
        this.Empleados.DataBind();
    }

    protected void fechaCalendario(object sender, EventArgs e)
    {
        string fecha = Calendar1.SelectedDate.ToString("dd/MM/yyyy");
        txtFecNac.Text = fecha.Replace("/", "-");
    }

    protected void nuevoEmpleado(object sender, EventArgs e)
    {
        limpiaForma();
        lblConfirm.Text = "Agregar Nuevo Empleado.";
        pnlMod.Visible = true;
    }

    protected void addUpdate(object sender, EventArgs e)
    {
        if(lblConfirm.Text=="Agregar Nuevo Empleado.")
        {
            //agregar nuevo registro
            string nombre = txtNombre.Text;
            string apPaterno = txtApPaterno.Text;
            string apMaterno = txtApMaterno.Text;
            string FecNac = Calendar1.SelectedDate.ToString("MM/dd/yyyy");
            string sueldo = txtSueldo.Text;
            string departamento = DropDownList1.Text;

            //obtener la clave de la categoria
            int categoria = getCategoria(departamento);

            SqlCommand cmd = new SqlCommand();
            SqlDataReader reader;

            cmd.CommandText = "INSERT INTO Empleados VALUES('"+nombre+"','"+apPaterno+"','"+apMaterno+"','"+FecNac+"',"+categoria+","+sueldo+")";
            cmd.CommandType = CommandType.Text;
            cmd.Connection = sqlConnection;

            try
            {
                sqlConnection.Open();
                reader = cmd.ExecuteReader();
            }
            catch (Exception ex)
            {
                lblConfirm.Text = "Error al insertar" + ex.Message;
                lblConfirm.Visible = true;
                sqlConnection.Close();
            }

            sqlConnection.Close();
            this.Empleados.DataBind();
            pnlMod.Visible = false;
        }

        if (lblConfirm.Text == "Modificar Empleado")
        {
            string nombre = txtNombre.Text;
            string apPaterno = txtApPaterno.Text;
            string apMaterno = txtApMaterno.Text;
            string nomCom = nombre + ' ' + apPaterno + ' ' + apMaterno;

            DateTime fecha = DateTime.ParseExact(txtFecNac.Text,"dd/MM/yyyy",null);
            string FecNac = fecha.ToString("MM/dd/yyyy");
            FecNac = FecNac.Replace("/", "-");
            int empID = getempID(nomCom, FecNac);
            string sueldo = txtSueldo.Text;
            string departamento = DropDownList1.Text;

            //obtener la clave del Departamento
            int categoria = getCategoria(departamento);

            SqlCommand cmd = new SqlCommand();
            SqlDataReader reader;

            cmd.CommandText = "UPDATE Empleados SET Nombre='" + nombre + "', ApPaterno= '" + apPaterno + "', ApMaterno= '" + apMaterno + "', FecNac= '" + FecNac + "', Departamento= " + categoria + ", Sueldo= " + sueldo + " WHERE Clave_Emp = "+empID;
            cmd.CommandType = CommandType.Text;
            cmd.Connection = sqlConnection;

            try
            {
                sqlConnection.Open();
                reader = cmd.ExecuteReader();
            }
            catch (Exception ex)
            {
                lblConfirm.Text = "Error al Modificar" + ex.Message;
                lblConfirm.Visible = true;
                sqlConnection.Close();
            }

            sqlConnection.Close();
            this.Empleados.DataBind();
            pnlMod.Visible = false;
        }
        this.Empleados.DataBind();
    }

    //obtener el puesto del departamento
    private int getCategoria(string departamento)
    {
        int categoria = 0;

        SqlCommand cmd = new SqlCommand();

        cmd.CommandText = "SELECT Puesto From Departamentos WHERE Descripcion = '"+departamento+"'";
        cmd.CommandType = CommandType.Text;
        cmd.Connection = sqlConnection;

        try
        {
            sqlConnection.Open();
            categoria = Convert.ToInt32(cmd.ExecuteScalar());
        }
        catch (Exception ex)
        {
            lblConfirm.Text = "Error al Borrar" + ex.Message;
            lblConfirm.Visible = true;
            return categoria;
        }

        sqlConnection.Close();
        this.Empleados.DataBind();

        return categoria;
    }

    //obtener el empId del registro a cambiarse
    private int getempID(string nom, string fec)
    {
        int empID = 0;
       
        SqlCommand cmd = new SqlCommand();

        cmd.CommandText = "SELECT EmpID From ListaEmp WHERE Nombre = '" + nom + "' OR [Fecha Nacimiento] = '"+fec+"'";
        cmd.CommandType = CommandType.Text;
        cmd.Connection = sqlConnection;

        try
        {
            sqlConnection.Open();
            empID = Convert.ToInt32(cmd.ExecuteScalar());
        }
        catch (Exception ex)
        {
            lblConfirm.Text = "Error al obtener EmpID" + ex.Message;
            lblConfirm.Visible = true;
            return empID;
        }

        sqlConnection.Close();
        this.Empleados.DataBind();

        return empID;
    }

    private void limpiaForma()
    {
        txtNombre.Text = "";
        txtApPaterno.Text = "";
        txtApMaterno.Text = "";
        txtFecNac.Text = "";
        txtSueldo.Text = "";
    }

    protected void Cancelar_Click(object sender, EventArgs e)
    {
        limpiaForma();
        pnlMod.Visible = false;
    }
}