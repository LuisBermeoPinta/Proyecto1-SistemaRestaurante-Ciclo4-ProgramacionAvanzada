
package Logica;

import BaseDatos.BDCliente;
import BaseDatos.BDEmpleado;
import Clases.Cliente;
import Clases.Direccion;
import Clases.Empleado;
import Clases.Pedido;
import Clases.Telefono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LogicaCliente {
    BDCliente objBDCliente = new BDCliente();
    BDEmpleado objBDEmpleado = new BDEmpleado();    
    public boolean InsertarLogicaCliente(Cliente objCliente) throws ClassNotFoundException, SQLException{
        if(objBDCliente.InsertarCliente(objCliente) == 1){
            return true;
        }
        return false;
        
    }
    
    public boolean InsertarLogicaDireccion(Cliente objCliente, ArrayList<Direccion> direcciones) throws ClassNotFoundException, SQLException{
        ResultSet rs = objBDCliente.ExtraerIdentificador(objCliente);
        int id = 0;
        if (rs.next()) {
            id = rs.getInt("id_Cliente");    
        }
        if(objBDCliente.InsertarDireccion(direcciones, id) == direcciones.size()){
            return true;
            
        }        
        return false;
    }

    public boolean InsertarLogicaTelefono(Cliente objCliente, ArrayList<Telefono> telefonos) throws ClassNotFoundException, SQLException{
        ResultSet rs = objBDCliente.ExtraerIdentificador(objCliente);
        int id = 0;
        if(rs.next()){
            id = rs.getInt("id_Cliente");
        }
        if(objBDCliente.InsertarTelefono(telefonos, id) == telefonos.size()){
            return true;
        }
        return false;

    }    
    public boolean InsertarLogicaPedido (Cliente objCliente, Empleado objEmpleado, ArrayList<Pedido> pedidos) throws ClassNotFoundException, SQLException{
        ResultSet rsCliente = objBDCliente.ExtraerIdentificador(objCliente);
        int id_Cliente = 0;
        if(rsCliente.next()){
            id_Cliente = rsCliente.getInt("id_Cliente");
        }
        
        ResultSet rsEmpleado =  objBDEmpleado.ExtraerIdentificador(objEmpleado);
        int id_Empleado = 0;
        if(rsEmpleado.next()){
            id_Empleado = rsEmpleado.getInt("id_Empleado");
        }        
        
        if(objBDCliente.InsertarPedido(pedidos, id_Cliente, id_Empleado) == pedidos.size()){
            return true;
            
        }
        return false;
        
        
    }
    
}
