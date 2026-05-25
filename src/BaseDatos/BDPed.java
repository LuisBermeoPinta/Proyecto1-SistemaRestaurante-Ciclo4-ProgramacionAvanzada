package BaseDatos;

import Clases.Cliente;
import Clases.Historial_Pedido;
import Clases.Pedido;
import Clases.Producto_Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDPed {

    Conexion con = new Conexion();

    public ResultSet ExtraerIdentificador(Pedido objPedido, int id_Cliente) throws ClassNotFoundException, SQLException {
        String sentencia = "select cod_Pedido from Pedido where id_Cliente = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setInt(1, id_Cliente);

        return ps.executeQuery();
    }

    public void InsertarPedido(Pedido objPed) throws ClassNotFoundException, SQLException {
        // Consulta SQL parametrizada para evitar inyección SQL
        String Sentencia = "insert into Pedido (id_Cliente, estado, total, id_direccion_Entrega) "
                + "values (?, ?, ?, ?)";

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

    public int InsertarProducto_Pedido(Producto_Pedido objProdPed) throws ClassNotFoundException, SQLException {
        // Consulta SQL parametrizada para evitar inyección SQL
        String Sentencia = "insert into Producto_Pedido (cod_Pedido, id_Producto, cantidad) "
                + "values (?, ?, ?)";

        // Prepara la sentencia SQL con los parámetros
        PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
        ps.setInt(1, objProdPed.getObjPed().getCod_Pedido());
        ps.setInt(2, objProdPed.getObjProd().getId_Producto());
        ps.setInt(3, objProdPed.getCantidad());

        int resultado = ps.executeUpdate();
        // Ejecuta la inserción y retorna el resultado
        return resultado;
    }

    public ResultSet ConsultarPedidosPendientes() throws ClassNotFoundException, SQLException {
        String sentencia = "SELECT cod_Pedido, estado FROM Pedido WHERE estado IN ('Pendiente', 'En Preparacion')";

        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);

        return ps.executeQuery();
    }

    public int ActualizarEstadoPedido(Pedido objPed) throws SQLException, ClassNotFoundException {
        String sentencia;
        PreparedStatement ps;

        if (objPed.getEstado().equalsIgnoreCase("Pendiente ") || objPed.getEstado().equalsIgnoreCase("En Preparacion")) {
            sentencia = "UPDATE Pedido SET estado = ? WHERE cod_Pedido = ?";

            ps = con.getConnection().prepareStatement(sentencia);
            ps.setString(1, objPed.getEstado());
            ps.setInt(2, objPed.getCod_Pedido());

        } else {
            sentencia = "UPDATE Pedido SET estado = ?, receptor = ?, fecha_Hora_Entrega = ? WHERE cod_Pedido = ?";
            ps = con.getConnection().prepareStatement(sentencia);
            ps.setString(1, objPed.getEstado());
            ps.setString(2, objPed.getReceptor());
            ps.setObject(3, objPed.getFecha_Hora_Entrega());
            ps.setInt(4, objPed.getCod_Pedido());
        }

        return ps.executeUpdate();
    }

    public ResultSet ConsultarPedidosListos() throws ClassNotFoundException, SQLException {
        String sentencia = "SELECT cod_Pedido, estado, total FROM Pedido WHERE estado IN ('Listo para Entrega', 'En Camino')";

        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);

        return ps.executeQuery();
    }

    public void InsertarHistorial_Pedido(Historial_Pedido objHistPed) throws ClassNotFoundException, SQLException {
        String sentencia = "INSERT INTO historial_Pedido(cod_Pedido, estado)"
                + "VALUES(?, ?)";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setInt(1, objHistPed.getObjPedido().getCod_Pedido());
        ps.setString(2, objHistPed.getObjPedido().getEstado());

        ps.executeUpdate();
    }

    public ResultSet ExtraerPedidoXCodigo(int cod) throws ClassNotFoundException, SQLException {
        
        String sentencia = "SELECT "
                + "p.cod_Pedido, p.estado, p.total, p.fecha_Hora_Entrega, p.receptor, "
                + "c.id_Cliente, c.nombre AS nombre_cliente, c.cedula, "
                + "d.id_Direccion, d.calle1, d.calle2, "
                + "prod.id_Producto, prod.nombre AS nombre_producto, prod.precio, "
                + "pp.cantidad "
                + "FROM Pedido p "
                + "JOIN Cliente c ON p.id_Cliente = c.id_Cliente "
                + "JOIN Direccion d ON p.id_direccion_Entrega = d.id_Direccion "
                + "JOIN Producto_Pedido pp ON p.cod_Pedido = pp.cod_Pedido "
                + "JOIN Producto prod ON pp.id_Producto = prod.id_Producto "
                + "WHERE p.cod_Pedido = ?";

        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setInt(1, cod);
        return ps.executeQuery();
    }
    
    public ResultSet ConsultarPedidosXIDCliente(int id_Cliente) throws ClassNotFoundException, SQLException{
        String sentencia = "SELECT cod_Pedido, estado FROM Pedido WHERE id_Cliente = ?";

        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setInt(1, id_Cliente);

        return ps.executeQuery();        
    }
        
}
