using System;
using System.Data.SqlClient;
using ZeroToProgrammer.Tables;

namespace ZeroToProgrammer
{
    public partial class AddNewContent : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblError.Text = " ";
            lblError.Visible = false;
            lblSuccess.Text = " ";
            lblSuccess.Visible = false;

        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            if(string.IsNullOrWhiteSpace(txtTitle.Text))
            {
                lblError.Text = "Please enter a title: ";
                lblError.Visible = true;
            }

            if (string.IsNullOrWhiteSpace(txtContent.Text))
            {
                lblError.Text = "Please enter content: ";
                lblError.Visible = true;
            }
            
            

            //CrUD = Create, Update, Delete

            try
            {
                NewsTable.Add(txtTitle.Text, txtContent.Text);
            }
            catch (Exception ex)
            {

                lblError.Text = "Error Saving to database: \n" + ex.Message;
                lblError.Visible = true;
            }
            

            lblSuccess.Text = "News added successfully!";
            lblSuccess.Visible = true;
             
        }
    }
}