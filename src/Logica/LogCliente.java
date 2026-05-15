
package Logica;

import BaseDatos.BDCliente;
import BaseDatos.BDEmpl;
import Clases.Cliente;
import Clases.Direccion;
import Clases.Empleado;
import Clases.Pedido;
import Clases.Telefono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LogCliente {
    BDCliente objBDCliente = new BDCliente();
    BDEmpl objBDEmpleado = new BDEmpl();    
    public boolean InsertarLogicaCliente(Cliente objCliente) throws ClassNotFoundException, SQLException{
        if(objBDCliente.InsertarCliente(objCliente) == 1){
            return true;
        }
        return false;
        
    }
    
    public boolean InsertarLogicaDireccion(Cliente objCliente, ArrayList<Direccion> direcciones) throws ClassNotFoundException, SQLException{
        ResultSet rs = objBDCliente.ExtraerIdentificador(objCliente);
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
    }
    
    public ArrayList<Direccion> LogicaExtraerDireccion() throws ClassNotFoundException, SQLException{
        ArrayList<Direccion> lista_direcciones = new ArrayList<>();        
        ResultSet rs = objBDCliente.ExtraerDireccion();
        int id = 0;
        String calle1, calle2;
        
        while(rs.next()){
            id = rs.getInt("id_Cliente");
            calle1 = rs.getString("calle1");
            calle2 = rs.getString("calle2");
            Direccion objDir = new Direccion(id, calle1, calle2);
            lista_direcciones.add(objDir);
        }
        return lista_direcciones;

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
    
    public ArrayList<Cliente> ExtraerLogicaClientes() throws ClassNotFoundException, SQLException{
        ArrayList<Cliente> lista_Clientes = new ArrayList<>();        
        ResultSet rs = objBDCliente.ExtraerClientes();
        int id = 0;
        String nombre;
        String cedula;
        
        while(rs.next()){
            id = rs.getInt("id_Cliente");
            nombre = rs.getString("nombre");
            cedula = rs.getString("Cedula");
            Cliente objCliente = new Cliente(id, nombre, cedula);
            lista_Clientes.add(objCliente);
        }
        return lista_Clientes;

    } 
    
}
