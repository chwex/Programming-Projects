<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AddNewContent.aspx.cs" Inherits="ZeroToProgrammer.AddNewContent" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <style type="text/css">
        .auto-style1 {
            height: 168px;
        }
    </style>
    <title>Add New Content</title>
</head>
<body>
    <form id="form1" runat="server">
        <h1>Add New Content</h1>
        <table>
            <tr>
                <td colspan ="2" ">
                    <asp:Label ID="lblError" runat="server" Text="" ForeColor="Red" Visible="False"></asp:Label>
                </td>
            </tr>
            <tr>
                <td><asp:Label ID="Label1" runat="server" Text="Title"></asp:Label></td>
                <td><asp:TextBox ID="txtTitle" runat="server" Width="500px"></asp:TextBox></td>
            </tr>
            <tr>
                <td style="vertical-align:top; text-align: right" class="auto-style1"> <asp:Label ID="Label2" runat="server" Text="Content:"></asp:Label></td>
                <td class="auto-style1"> <asp:TextBox ID="txtContent" runat="server" Width="500px" TextMode="MultiLine" Height="158px"></asp:TextBox></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right">
                    <asp:Button ID="btnSubmit" runat="server" Text="Submit" OnClick="btnSubmit_Click" />
                </td>
            </tr>
            <tr>
                <td colspan ="2" ">
                    <asp:Label ID="lblSuccess" runat="server" Text="" ForeColor="Green" Visible="False"></asp:Label>
                </td>
            </tr>
        </table>
        <br />
        <br />
    </form>
</body>
</html>
