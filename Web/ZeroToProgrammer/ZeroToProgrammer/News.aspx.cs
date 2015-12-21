using System;
using System.Data.SqlClient;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;

namespace ZeroToProgrammer
{
    public partial class News : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblError.Text=String.Empty;
            lblError.Visible= false; 

            SqlConnection conn = new SqlConnection("Server=localhost;Database=ZeroToProgrammer;Trusted_Connection=True;");
            SqlCommand cmd = new SqlCommand("SELECT Title, Content, ModifiedDate FROM News", conn);

            SqlDataReader reader;

            try
            {
                conn.Open();
                reader = cmd.ExecuteReader();
            }

            catch (Exception ex)
            {

                lblError.Text = "Error Saving to database: \n" + ex.Message;
                lblError.Visible = true;
                return;
            }
            

            if (!reader.HasRows)
            {
                lblError.Text="No results found";
                lblError.Visible= true; 
                return;
            }
	

            while (reader.Read())
            {
                Panel panel = new Panel();

                HtmlGenericControl header = new HtmlGenericControl("h2");
                header.InnerHtml = reader.GetString(0);
                panel.Controls.Add(header);

                HtmlGenericControl date = new HtmlGenericControl("p");
                date.InnerHtml = reader.GetDateTime(2).ToString("M/d/yyyy");
                panel.Controls.Add(date);

                HtmlGenericControl body = new HtmlGenericControl("p");
                body.InnerHtml = reader.GetString(1);
                panel.Controls.Add(body);

                pnlNews.Controls.Add(panel);

            }

            reader.Close();
            conn.Close();

        }
    }
}