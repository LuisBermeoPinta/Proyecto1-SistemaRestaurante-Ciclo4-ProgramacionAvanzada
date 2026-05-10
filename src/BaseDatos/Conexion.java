
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    // Objeto Connection que representa la conexión a la BD
    public Connection con;
    

    public Connection getConnection () throws ClassNotFoundException, SQLException {
        // Driver JDBC para MySQL (versión actualizada)
        String driver =  "com.mysql.cj.jdbc.Driver";
        
        // URL de conexión: localhost:3306/base_de_datos
        String url = "jdbc:mysql://127.0.0.1:3306/bd_restaurante";
        
        // Cargar el driver de MySQL
        Class.forName(driver);
        
        // Establecer conexión con usuario: root, contraseña: root
        return DriverManager.getConnection(url,"root","root");
    }    
    
    
    public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
        // Usa el método getConnection y almacena la conexión en la variable de instancia
        con = getConnection();
        return con;
    }
    

    public void CerrarConexion() throws SQLException{
       // Verifica que la conexión no sea nula antes de cerrar
       if (con != null && !con.isClosed()) {
           con.close();
       }
    }    
    
}
