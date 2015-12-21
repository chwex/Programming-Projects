package aplicacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
	@SuppressWarnings("finally")
	public static Connection GetConnection(){
		Connection conexion=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost/Topicos";
			String usuarioDB="Sistema";
			String passwordDB="Sistema";
			conexion= DriverManager.getConnection(servidor, usuarioDB,passwordDB);
		}
		catch (ClassNotFoundException ex){
			JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexion con la BD"+ex.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexion con la BD"+ex.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexion con la BD"+ex.getMessage(),JOptionPane.ERROR_MESSAGE);
	      
		}
		finally{
						return conexion;
		}
	}

}
