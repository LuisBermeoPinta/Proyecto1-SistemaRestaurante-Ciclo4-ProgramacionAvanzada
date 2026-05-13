
package Logica;

import BaseDatos.BDCliente;
import BaseDatos.BDPedido;
import Clases.Cliente;
import Clases.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogPed {
    BDPedido objBDPedido = new BDPedido();
    BDCliente objBDCliente = new BDCliente();

    public boolean InsertarLogicaPedido(Pedido objPedido, Cliente objCliente) throws ClassNotFoundException, SQLException {
        ResultSet rs = objBDCliente.ExtraerIdentificador(objCliente);
        int id = 0;
        if (rs.next()) {
            id = rs.getInt("id_Cliente");    
        }
        if(objBDPedido.InsertarPedido(objPedido, id) == 1){
            return true;
            
        }        
        return false;
    }
}
