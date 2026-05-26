
package Logica;

import BaseDatos.BDPed;
import BaseDatos.BDProd;
import Clases.Cliente;
import Clases.Pedido;
import Clases.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogProd {
    BDProd objBDProducto = new BDProd();       
    BDPed objBDPedido = new BDPed();
    
    public boolean InsertarProducto(ArrayList<Producto> lista_Productos) throws ClassNotFoundException, SQLException{
        int cn = 0;
        for(Producto prod: lista_Productos){
            cn += objBDProducto.InsertarProducto(prod);
        }
        if(cn == lista_Productos.size()){
            return true;
        }
        return false;
       
    }

    public ArrayList<Producto> ExtraerLogicaProducto() throws ClassNotFoundException, SQLException {
        ArrayList<Producto> listaProductos = objBDProducto.ExtraerProductos();
        return listaProductos;

    }
    
    /*public boolean InsertarLogicaPedidoProducto(Pedido objPedido, Producto objProducto, ArrayList<Integer> cantidades) throws ClassNotFoundException, SQLException{
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
    }    */
    
    
        /*public boolean InsertarLogicaPedidoProducto(Pedido objPedido, ArrayList<Byte> prod_Elegidos, ArrayList<Integer> cantidades, Cliente objCliente) throws ClassNotFoundException, SQLException{
        ResultSet rs1 = objBDPedido.ExtraerIdentificador(objPedido, objCliente);
        int cod_Pedido = 0;

        if (rs1.next()) {
            cod_Pedido = rs1.getInt("cod_Pedido");    
        }        
        
        if(objBDProducto.InsertarProductoPedido(cantidades, cod_Pedido, prod_Elegidos) == cantidades.size()){
            return true;
            
        }        
        return false;
    }   
    */
}
