package Logica;

import BaseDatos.BDCliente;
import Clases.Cliente;
import Clases.Direccion;
import Clases.Pedido;
import Clases.Telefono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogCliente {

    BDCliente objBDCliente = new BDCliente();

    public boolean InsertarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException {
        if (objCliente.getNombre() != null && !objCliente.getNombre().isEmpty() && objCliente.getCedula().length() == 10) {
            if (objBDCliente.InsertarCliente(objCliente) == 1) {
                return true;
            }else{
                return false;
            }
        }
        return false;

    }

    public boolean InsertarLogicaDireccion(Cliente objCliente) throws ClassNotFoundException, SQLException {
        int cn = 0;
        for (Direccion dir : objCliente.getDirecciones()) {
            cn += objBDCliente.InsertarDireccion(dir, objCliente);
        }

        if (cn == objCliente.getDirecciones().size()) {
            return true;

        }
        return false;
    }

    public boolean InsertarLogicaTelefono(Cliente objCliente) throws ClassNotFoundException, SQLException {
        int cn = 0;
        for (Telefono telf : objCliente.getTelefonos()) {
            cn += objBDCliente.InsertarTelefono(telf, objCliente);
        }

        if (cn == objCliente.getTelefonos().size()) {
            return true;

        }
        return false;
    }

    public ArrayList<Direccion> LogicaExtraerDireccion(Cliente objCliente) throws ClassNotFoundException, SQLException {
        ArrayList<Direccion> lista_direcciones = new ArrayList<>();
        ResultSet rs = objBDCliente.ExtraerDireccion(objCliente);
        int id_Dir, id_Cliente;
        String calle1, calle2;

        while (rs.next()) {
            id_Dir = rs.getInt("id_Direccion");
            calle1 = rs.getString("calle1");
            calle2 = rs.getString("calle2");
            Direccion objDir = new Direccion(id_Dir, objCliente, calle1, calle2);
            lista_direcciones.add(objDir);
        }
        return lista_direcciones;

    }

    /*public boolean InsertarLogicaPedido (Cliente objCliente, Empleado objEmpleado, ArrayList<Pedido> pedidos) throws ClassNotFoundException, SQLException{
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
        
        
    }*/
    public ArrayList<Cliente> ExtraerClientes() throws ClassNotFoundException, SQLException {
        ArrayList<Cliente> lista_Clientes = new ArrayList<>();
        ResultSet rs = objBDCliente.ExtraerClientes();
        int id = 0;
        String nombre;
        String cedula;

        while (rs.next()) {
            id = rs.getInt("id_Cliente");
            nombre = rs.getString("nombre");
            cedula = rs.getString("Cedula");
            Cliente objCliente = new Cliente(id, nombre, cedula);
            lista_Clientes.add(objCliente);
        }
        return lista_Clientes;

    }

    public boolean ComprobarSiExisteClientes() throws ClassNotFoundException, SQLException {
        ResultSet rs = objBDCliente.ExtraerClientes();
        while (rs.next()) {
            return true;
        }
        return false;

    }
    

}
