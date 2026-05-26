package BaseDatos;

import Clases.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BDProd {

    Conexion con = new Conexion();

    public int InsertarProducto(Producto objProducto) throws ClassNotFoundException, SQLException {
        String Sentencia = "insert into Producto (nombre, precio) "
                + "values (?, ?)";

        // Prepara la sentencia SQL con los parámetros
        PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objProducto.getNombre());
        ps.setDouble(2, objProducto.getPrecio());

        return ps.executeUpdate();
    }

    public int InsertarProductoPedido(ArrayList<Integer> cantidades, int cod_Pedido, ArrayList<Byte> prod_Elegidos) throws ClassNotFoundException, SQLException {
        int resultado = 0;
        for (int i = 0; i < cantidades.size(); i++) {
            String sentencia = "Insert into producto_pedido (cod_Pedido, id_Producto, cantidad)"
                    + "values (?, ?, ?)";
            PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
            ps.setInt(1, cod_Pedido);
            ps.setInt(2, prod_Elegidos.get(i));
            ps.setInt(3, cantidades.get(i));
            resultado += ps.executeUpdate();

        }
        return resultado;
    }

    public ResultSet ExtraerIdentificador(Producto objProducto) throws ClassNotFoundException, SQLException {
        String sentencia = "select id_Producto from Producto where nombre = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setString(1, objProducto.getNombre());

        return ps.executeQuery();
    }


    public ResultSet ExtraerProductos() throws ClassNotFoundException, SQLException {
        String Sentencia = "Select * from Producto";
        PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);

        return ps.executeQuery();
    }
}
