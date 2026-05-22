
package BaseDatos;

import Clases.Cliente;
import Clases.Pedido;
import Clases.Producto_Pedido;
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

    public void InsertarPedido(Pedido objPed) throws ClassNotFoundException, SQLException {
        // Consulta SQL parametrizada para evitar inyección SQL
        String Sentencia = "insert into Pedido (id_Cliente, estado, total, id_direccion_Entrega) "
               + "values (?, ?, ?, ?)" ;
       
       
       // Prepara la sentencia SQL con los parámetros
       PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
       ps.setInt(1, objPed.getObjCliente().getId_Cliente());       
       ps.setString(2, objPed.getEstado());
       ps.setDouble(3, objPed.getTotal());
       ps.setInt(4, objPed.getObjDir().getId_Direccion());
       ps.executeUpdate();
       
       // Ejecuta la inserción y retorna el resultado
    } 

    public ResultSet ExtraerPedido(Cliente objCliente) throws ClassNotFoundException, SQLException {
        String sentencia = "select max(cod_pedido) as cod_Pedido from Pedido where id_Cliente = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setInt(1, objCliente.getId_Cliente());

        return ps.executeQuery();        
        
        
    }
    
    public int InsertarProducto_Pedido(Producto_Pedido objProdPed) throws ClassNotFoundException, SQLException{
        // Consulta SQL parametrizada para evitar inyección SQL
        String Sentencia = "insert into Producto_Pedido (cod_Pedido, id_Producto, cantidad) "
               + "values (?, ?, ?)" ;
       
       
       // Prepara la sentencia SQL con los parámetros
       PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
       ps.setInt(1, objProdPed.getObjPed().getCod_Pedido());
       ps.setInt(2, objProdPed.getObjProd().getId_Producto());
       ps.setInt(3, objProdPed.getCantidad());
       
       
       // Ejecuta la inserción y retorna el resultado
       return ps.executeUpdate();        
    }
}

