<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="News.aspx.cs" Inherits="ZeroToProgrammer.News" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <h1>News</h1>
        <asp:Label ID="lblError" ForeColor="Red" runat="server" Text="" Visible="false"></asp:Label>
        <asp:Panel ID="pnlNews" runat="server"></asp:Panel>

    </form>
</body>
</html>
