
package BaseDatos;

import Clases.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BDPedido {
    Conexion con = new Conexion();

    public ResultSet ExtraerIdentificador(Pedido objPedido) throws ClassNotFoundException, SQLException{
        String sentencia = "select cod_Pedido from Pedido where cod_Pedido = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setInt(1, objPedido.getCod_Pedido());

        return ps.executeQuery();
    }  

    public int InsertarPedido(Pedido objPedido) throws ClassNotFoundException, SQLException {
        // Consulta SQL parametrizada para evitar inyección SQL
        String Sentencia = "insert into Pedido (estado, direccion_Entrega) "
               + "values (?, ?)" ;
       
       
       // Prepara la sentencia SQL con los parámetros
       PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
       ps.setString(1, objPedido.getEstado());
       ps.setString(2, objPedido.getDireccion_Entrega());
       
       
       // Ejecuta la inserción y retorna el resultado
       return ps.executeUpdate();
    } 
}

