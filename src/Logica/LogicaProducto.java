
package Logica;

import BaseDatos.BDPedido;
import BaseDatos.BDProducto;
import Clases.Pedido;
import Clases.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class LogicaProducto {
    BDProducto objBDProducto = new BDProducto();       
    BDPedido objBDPedido = new BDPedido();
    
    public boolean InsertarLogicaProducto(Producto objProducto) throws ClassNotFoundException, SQLException{
        if(objBDProducto.InsertarProducto(objProducto) == 1){
            return true;
        }
        return false;
        
    }

    public ArrayList<Producto> ExtraerLogicaProducto() throws ClassNotFoundException, SQLException {
        ArrayList<Producto> listaProductos = objBDProducto.ExtraerProductos();
        return listaProductos;

    }
    
    public boolean InsertarLogicaPedidoProducto(Pedido objPedido, Producto objProducto, ArrayList<Integer> cantidades) throws ClassNotFoundException, SQLException{
        ResultSet rs1 = objBDProducto.ExtraerIdentificador(objProducto);
        int id_Producto = 0;
        int cod_Pedido = 0;
        if (rs1.next()) {
            id_Producto = rs1.getInt("id_Producto");    
        }
        
        ResultSet rs2 = objBDPedido.ExtraerIdentificador(objPedido);
        if (rs2.next()) {
            cod_Pedido = rs2.getInt("cod_Pedido");    
        }        
        
        if(objBDProducto.InsertarProductoPedido(cantidades, cod_Pedido, id_Producto) == cantidades.size()){
            return true;
            
        }        
        return false;
    }    
    
}
