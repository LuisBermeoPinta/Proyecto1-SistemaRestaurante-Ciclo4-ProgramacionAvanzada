package Logica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import BaseDatos.BDPed;
import Clases.Cliente;
import Clases.Direccion;
import Clases.Historial_Pedido;
import Clases.Pedido;
import Clases.Producto;
import Clases.Producto_Pedido;
import java.security.Timestamp;

public class LogPed {

    private BDPed objBDPed;
    //private ArrayList<Producto> lista_Prod;

    public LogPed(BDPed objBDPed) {
        this.objBDPed = objBDPed;
        //this.lista_Prod = lista_Prod;
    }

    /*public ResultSet LogicaExtraerIndentificador(Pedido objPed, int id_Cliente){
        ResultSet rs = objBDPed.BDExtraerIdentificador();
        int id = 0;
        int cn = 0;
        if (rs.next()) {
            id = rs.getInt("id_Cliente");    
        }
        for(Direccion dir: direcciones){
            cn = objBDCliente.InsertarDireccion(dir, id);
        }
        
        if(cn == direcciones.size()){
            return true;
            
        }        
        return false;
    } */
    public void LogicaInsertarPedido(Pedido objPed) throws ClassNotFoundException, SQLException {
        objBDPed.InsertarPedido(objPed);
    }

    public boolean LogicaInsertarProducto_Pedido(ArrayList<Producto_Pedido> lista_ProdPed) throws ClassNotFoundException, SQLException {
        int cn = 0;
        for (Producto_Pedido prodPed : lista_ProdPed) {
            cn += objBDPed.InsertarProducto_Pedido(prodPed);
        }
        if (cn == lista_ProdPed.size()) {
            return true;
        }
        return false;
    }

    public double CalcularTotal(ArrayList<Producto> prod_Elegidos) {
        double total = 0.0;
        for (int i = 0; i < prod_Elegidos.size(); i++) {
            total += prod_Elegidos.get(i).getPrecio();
        }
        return total;
    }

    public Pedido LogicaExtraerPedido(Cliente objCliente) throws ClassNotFoundException, SQLException {
        Pedido objPed = new Pedido();
        ResultSet rs = objBDPed.ExtraerPedido(objCliente);
        if (rs.next()) {
            objPed.setCod_Pedido(rs.getInt("cod_Pedido"));

        }
        return objPed;

    }

    public ArrayList<Pedido> ConsultarPedidosPendientes() throws ClassNotFoundException, SQLException {
        ArrayList<Pedido> list_Ped = new ArrayList<>();
        ResultSet rs = objBDPed.ConsultarPedidosPendientes();
        Pedido objPed;
        while (rs.next()) {
            objPed = new Pedido();
            objPed.setCod_Pedido(rs.getInt("cod_Pedido"));
            objPed.setEstado(rs.getString("estado"));
            list_Ped.add(objPed);
        }
        return list_Ped;
    }

    public boolean ActualizarEstadoPedido(Pedido objPed) throws SQLException, ClassNotFoundException {
        if (objBDPed.ActualizarEstadoPedido(objPed) == 1) {
            return true;
        }
        return false;
    }

    public ArrayList<Pedido> ConsultarPedidosListos() throws SQLException, ClassNotFoundException {
        ArrayList<Pedido> list_Ped = new ArrayList<>();
        ResultSet rs = objBDPed.ConsultarPedidosListos();
        Pedido objPed;
        while (rs.next()) {
            objPed = new Pedido();
            objPed.setCod_Pedido(rs.getInt("cod_Pedido"));
            objPed.setEstado(rs.getString("estado"));
            objPed.setTotal(rs.getDouble("total"));
            list_Ped.add(objPed);
        }
        return list_Ped;
    }

    public void InsertarHistorial_Pedido(Historial_Pedido objHistPed) throws ClassNotFoundException, SQLException {
        objBDPed.InsertarHistorial_Pedido(objHistPed);
    }

    public Pedido ExtraerPedidoXCodigo(int cod) throws ClassNotFoundException, SQLException {
        Pedido objPed = new Pedido();
        Cliente objCliente = new Cliente();
        Direccion objDir = new Direccion();
        ArrayList<Producto_Pedido> lista_ProdPed = new ArrayList<>();

        ResultSet rs = objBDPed.ExtraerPedidoXCodigo(cod);
        while (rs.next()) {
            if (objPed.getCod_Pedido() == 0) {
                //Llenamos el objeto Direccion
                objDir.setId_Direccion(rs.getInt("id_Direccion"));
                objDir.setCalle1(rs.getString("calle1"));
                objDir.setCalle2(rs.getString("calle2"));

                //Llenamos el objeto Cliente
                objCliente.setId_Cliente(rs.getInt("id_Cliente"));
                objCliente.setNombre(rs.getString("nombre_Cliente"));
                objCliente.setCedula(rs.getString("cedula"));

                //Llenamos el objeto Pedido
                objPed.setCod_Pedido(rs.getInt("cod_Pedido"));
                objPed.setEstado(rs.getString("estado"));
                objPed.setTotal(rs.getDouble("total"));
                objPed.setReceptor(rs.getString("receptor"));

                // LocalDateTime desde DATETIME
                java.sql.Timestamp timestamp = rs.getTimestamp("fecha_Hora_Entrega");
                if (timestamp != null) {
                    objPed.setFecha_Hora_Entrega(timestamp.toLocalDateTime());
                }

            }
            Producto objProd = new Producto();
            Producto_Pedido objProdPed = new Producto_Pedido();
            //Llenamos el objeto Producto
            objProd.setId_Producto(rs.getInt("id_Producto"));
            objProd.setNombre(rs.getString("nombre_Producto"));
            objProd.setPrecio(rs.getDouble("precio"));

            //Llenamos el objeto Producto_Pedido
            objProdPed.setObjProd(objProd);
            objProdPed.setCantidad(rs.getInt("cantidad"));
            objProdPed.setObjPed(objPed);
            
            lista_ProdPed.add(objProdPed);

        }
        objPed.setObjProdPed(lista_ProdPed);
        return objPed;
    }
    
    public ArrayList<Pedido> ConsultarPedidosXIDCliente(int id) throws ClassNotFoundException, SQLException{
        Pedido objPed;
        ArrayList<Pedido> list_Pedido = new ArrayList<>();
        ResultSet rs = objBDPed.ConsultarPedidosXIDCliente(id);
        while(rs.next()){
            objPed = new Pedido();
            objPed.setCod_Pedido(rs.getInt("cod_Pedido"));
            objPed.setEstado(rs.getString("estado"));
            list_Pedido.add(objPed);
        }
        
        return list_Pedido;
    }
}
