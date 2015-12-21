using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace ZeroToProgrammer.Tables
{
    public static class NewsTable
    {
        private static readonly string ConnStr = ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString;

        public static void Add(string title, string content)
        {
            using (SqlConnection conn = new SqlConnection(ConnStr))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand(
                    string.Format("INSERT INTO NEWS (Title, Content) VALUES ('{0}', '{1}')", title, content), conn);
                cmd.ExecuteNonQuery();
            }
        }

        
    }
}