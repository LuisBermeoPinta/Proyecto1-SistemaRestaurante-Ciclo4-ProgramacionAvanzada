
package BaseDatos;

import Clases.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BDEmpl {
    
    Conexion con = new Conexion();
    
    public int InsertarEmpleado(Empleado objEmpleado) throws ClassNotFoundException, SQLException  {
        // Consulta SQL parametrizada para evitar inyección SQL
        String sentencia = "insert into Empleado (nombre, rol) "
               + "values (?, ?)";
       
       
       // Prepara la sentencia SQL con los parámetros
       PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
       ps.setString(1, objEmpleado.getNombre());
       ps.setString(2, objEmpleado.getRol());
       
       
       // Ejecuta la inserción y retorna el resultado
       return ps.executeUpdate();
    }    
    
    public ResultSet ExtraerIdentificador(Empleado objEmpleado) throws ClassNotFoundException, SQLException{
        String sentencia = "select id_Cliente from cliente where nombre = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setString(1, objEmpleado.getNombre());

        return ps.executeQuery();
    }
    
    
}
