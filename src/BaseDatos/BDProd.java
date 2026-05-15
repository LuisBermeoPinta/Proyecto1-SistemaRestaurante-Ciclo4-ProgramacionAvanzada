
package BaseDatos;

import Clases.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BDProd {
    Conexion con = new Conexion();
    
    public int InsertarProducto(Producto objProducto) throws ClassNotFoundException, SQLException  {
        // Consulta SQL parametrizada para evitar inyección SQL
        String Sentencia = "insert into Producto (nombre, precio) "
               + "values (?, ?)" ;
       
       
       // Prepara la sentencia SQL con los parámetros
       PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
       ps.setString(1, objProducto.getNombre());
       ps.setDouble(2, objProducto.getPrecio());
       
       
       // Ejecuta la inserción y retorna el resultado
       return ps.executeUpdate();
    } 
    
    
    public ArrayList<Producto> ExtraerProductos() throws ClassNotFoundException, SQLException {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String Sentencia = "Select id_Producto, nombre, precio from Producto";
        PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
        ResultSet rs = ps.executeQuery();

        //Se lee la tabla virtual y obtenemos los datos de las columnas
        while (rs.next()) { 
            Producto producto = new Producto();
            producto.setId_Producto(rs.getInt("id_Producto"));            
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecio(rs.getDouble("precio"));
            
            listaProductos.add(producto);
            
        }
        rs.close();
        ps.close();
        return listaProductos;    
    }
    
    public int InsertarProductoPedido(ArrayList<Integer> cantidades, int cod_Pedido, ArrayList<Byte> prod_Elegidos) throws ClassNotFoundException, SQLException{
        int resultado = 0;
        for(int i = 0; i < cantidades.size(); i ++){
             String sentencia = "Insert into producto_pedido (cod_Pedido, id_Producto, cantidad)"
                    + "values (?, ?, ?)";
            PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
            ps.setInt(1, cod_Pedido);
            ps.setInt(2, prod_Elegidos.get(i));
            ps.setInt(3,  cantidades.get(i));    
            resultado += ps.executeUpdate();
            
        }
        return resultado;
    }
        
    
    public ResultSet ExtraerIdentificador(Producto objProducto) throws ClassNotFoundException, SQLException{
        String sentencia = "select id_Producto from Producto where nombre = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setString(1, objProducto.getNombre());

        return ps.executeQuery();
    }        
}
