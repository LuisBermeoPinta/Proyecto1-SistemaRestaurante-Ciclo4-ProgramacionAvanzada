
package BaseDatos;

import Clases.Cliente;
import Clases.Direccion;
import Clases.Empleado;
import Clases.Pedido;
import Clases.Telefono;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BDCliente {
    
    Conexion con = new Conexion();
    
    public int InsertarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException  {
        // Consulta SQL parametrizada para evitar inyección SQL
        String Sentencia = "insert into Cliente (nombre, cedula) "
               + "values (?, ?)" ;
       
       
       // Prepara la sentencia SQL con los parámetros
       PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
       ps.setString(1, objCliente.getNombre());
       ps.setString(2, objCliente.getCedula());
       
       
       // Ejecuta la inserción y retorna el resultado
       return ps.executeUpdate();
    } 
    
    public ResultSet ExtraerClientes() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from cliente";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        return ps.executeQuery();
    }  
    
    
    public int InsertarDireccion(Direccion direccion, int id_Cliente) throws ClassNotFoundException, SQLException{
        int resultado = 0;
        String sentencia = "Insert into Direccion (id_Cliente, calle1, calle2)"
                + "values (?, ?, ?)";    
        
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setInt(1, id_Cliente);
        ps.setString(2, direccion.getCalle1());
        ps.setString(3,  direccion.getCalle2());    
        resultado += ps.executeUpdate();
        return resultado;
    }
    
    public int InsertarTelefono(ArrayList<Telefono> telefonos, int id_Cliente) throws ClassNotFoundException, SQLException{
        int resultado = 0;
        for(Telefono telf: telefonos){
            String Sentencia = "Insert into Telefono (id_Cliente, tipo, num_Telefono)"
                    + "values(?, ?, ?)";
            PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
            ps.setInt(1, id_Cliente);
            ps.setString(2, telf.getNombre());
            ps.setString(3, telf.getNum_Telefono());
            resultado += ps.executeUpdate();
            
        }
        return resultado;
        
    }
    
    public int InsertarPedido(ArrayList<Pedido> pedidos, int id_Cliente, int id_Empleado) throws ClassNotFoundException, SQLException{
        int resultado = 0;
        for(Pedido ped: pedidos){
            String Sentencia = "Insert into pedido (id_Cliente , id_Empleado, estado, total)" 
                    + "values(?, ?, ?, ?)";
            PreparedStatement ps = con.getConnection().prepareStatement(Sentencia);
            ps.setInt(1, id_Cliente);
            ps.setInt(2,id_Empleado);
            ps.setString(3, ped.getEstado());
            ps.setDouble(4,ped.getTotal());
            resultado += ps.executeUpdate();  
        }
        return resultado;
    }
        
    public ResultSet ExtraerIdentificador(Cliente objCliente) throws ClassNotFoundException, SQLException{
        String sentencia = "select id_Cliente from cliente where cedula = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
        ps.setString(1, objCliente.getCedula());

        return ps.executeQuery();
    }        
         
}
