
package Logica;

import BaseDatos.BDPedido;
import Clases.Pedido;
import java.sql.SQLException;

public class LogicaPedido {
    BDPedido objBDPedido = new BDPedido();

    public boolean InsertarLogicaPedido(Pedido objPedido) throws ClassNotFoundException, SQLException {
        if(objBDPedido.InsertarPedido(objPedido) == 1){
            return true;
        }
        return false;
               
    }
    
}
