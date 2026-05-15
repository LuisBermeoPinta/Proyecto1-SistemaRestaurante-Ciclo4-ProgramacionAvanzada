
package BaseDatos;

import Clases.Cliente;
import Clases.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BDPed {
    Conexion con = new Conexion();

    public ResultSet ExtraerIdentificador(Pedido objPedido, int id_Cliente) throws ClassNotFoundException, SQLException{
        String sentencia = "select cod_Pedido from Pedido where id_Cliente = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setInt(1, id_Cliente);

        return ps.executeQuery();
    }  

    public int InsertarPedido(Pedido objPed, int id_Cliente) throws ClassNotFoundException, SQLException {
        // Consulta SQL parametrizada para evitar inyección SQL
        String Sentencia = "insert into Pedido (id_Cliente, estado) "
               + "values (?, ?)" ;
       
       
       // Prepara la sentencia SQL con los parámetros
       PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
       ps.setInt(1, id_Cliente);       
       ps.setString(2, objPed.getEstado());
       
       
       // Ejecuta la inserción y retorna el resultado
       return ps.executeUpdate();
    } 
}

