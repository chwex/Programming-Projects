<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" Debug="true" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        #form1 {
            width: 120%;
        }
        .floatLeft {}
    </style>
</head>

<body>
    <form id="form1" runat="server">
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:DBProyEmpConnectionString %>" OldValuesParameterFormatString="original_{0}" 
            SelectCommand="SELECT [Nombre], [Fecha Nacimiento] AS Fecha_Nacimiento, [Departamento], [Sueldo] FROM [ListaEmp]">
        </asp:SqlDataSource>

        <asp:Panel ID="pnlGrid" runat="server" CssClass="floatLeft" Width="751px">
            <h1>Lista de Empleados</h1>
            <asp:Button ID="btnNuevo" runat="server" Text="Nuevo" OnClick="nuevoEmpleado"  />
            <asp:GridView ID="Empleados" runat="server" AutoGenerateColumns="False" BackColor="White" BorderColor="#999999" BorderStyle="None" BorderWidth="1px" CellPadding="3" DataKeyNames="Nombre" DataSourceID="SqlDataSource1" GridLines="Vertical" Height="200px" Width="738px" OnRowCommand="ModificarTabla">
                <AlternatingRowStyle BackColor="Gainsboro" />
                <Columns>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" ReadOnly="True" SortExpression="Nombre" />
                    <asp:BoundField DataField="Fecha_Nacimiento" HeaderText="Fecha_Nacimiento" SortExpression="Fecha_Nacimiento" />
                    <asp:BoundField DataField="Departamento" HeaderText="Departamento" SortExpression="Departamento" />
                    <asp:BoundField DataField="Sueldo" HeaderText="Sueldo" SortExpression="Sueldo" />
                    <asp:ButtonField Text="Modificar" CommandName="Modifica"/>
                    <asp:ButtonField Text="Eliminar" CommandName="Elimina"/>
                </Columns>
                <FooterStyle BackColor="#CCCCCC" ForeColor="Black" />
                <HeaderStyle BackColor="#000084" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                <RowStyle BackColor="#EEEEEE" ForeColor="Black" />
                <SelectedRowStyle BackColor="#008A8C" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#F1F1F1" />
                <SortedAscendingHeaderStyle BackColor="#0000A9" />
                <SortedDescendingCellStyle BackColor="#CAC9C9" />
                <SortedDescendingHeaderStyle BackColor="#000065" />
        </asp:GridView>
        <br />
        </asp:Panel>

        <asp:Panel ID="pnlMod" runat="server" ccsClass="floatRight" CssClass="floatRight" Height="571px" ScrollBars="Auto" style="margin-top: 0px" Visible="false" Width="48%">
            <h1>ABC Empleados</h1>
            <asp:Label ID="lblConfirm" runat="server" ForeColor="#669900" Font-Bold="True" Font-Size="Large"></asp:Label>
            <br />
            <br />
            <asp:Label ID="lblNombre" runat="server" Text="Nombre: "></asp:Label>
            <asp:TextBox ID="txtNombre" runat="server"></asp:TextBox>
            <br />
            <asp:Label ID="lblApPaterno" runat="server" Text="Apellido Paterno: "></asp:Label>
            <asp:TextBox ID="txtApPaterno" runat="server"></asp:TextBox>
            <br />
            <asp:Label ID="lblApMaterno" runat="server" Text="Apellido Materno: "></asp:Label>
            <asp:TextBox ID="txtApMaterno" runat="server"></asp:TextBox>
            <br />
            <asp:Label ID="lblDepartamento" runat="server" Text="Departamento: "></asp:Label>
            <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="SqlDataSource2" DataTextField="Descripcion" DataValueField="Descripcion">
            </asp:DropDownList>
            <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:DBProyEmpConnectionString %>" SelectCommand="SELECT [Descripcion] FROM [Departamentos]"></asp:SqlDataSource>
            <br />
            <asp:Label ID="lblSueldo" runat="server" Text="Sueldo: "></asp:Label>
            <asp:TextBox ID="txtSueldo" runat="server"></asp:TextBox>
            <br/>
            <asp:Label ID="lblFecNac" runat="server" Text="Fecha de Nacimiento: "></asp:Label>
            <asp:TextBox ID="txtFecNac" runat="server"></asp:TextBox>
            <asp:Calendar ID="Calendar1" runat="server" BackColor="White" BorderColor="Black" BorderStyle="Solid" CellSpacing="1" Font-Names="Verdana" Font-Size="9pt" ForeColor="Black" Height="190px" NextPrevFormat="ShortMonth" Width="257px" OnSelectionChanged="fechaCalendario">
                <DayHeaderStyle Font-Bold="True" Font-Size="8pt" ForeColor="#333333" Height="8pt" />
                <DayStyle BackColor="#CCCCCC" />
                <NextPrevStyle Font-Bold="True" Font-Size="8pt" ForeColor="White" />
                <OtherMonthDayStyle ForeColor="#999999" />
                <SelectedDayStyle BackColor="#333399" ForeColor="White" />
                <TitleStyle BackColor="#333399" BorderStyle="Solid" Font-Bold="True" Font-Size="12pt" ForeColor="White" Height="12pt" />
                <TodayDayStyle BackColor="#999999" ForeColor="White" />
            </asp:Calendar>
            <br/>
            <asp:Button ID="btnCancelar" runat="server" style="margin-left: 0px" Text="Cancelar" OnClick="Cancelar_Click" />
            <asp:Button ID="btnGuardar" runat="server" style="margin-left: 114px" Text="Guardar" OnClick="addUpdate" />
        </asp:Panel>
            
        <p>
            &nbsp;</p>
    </form>
    </body>
</html>
