
package Logica;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import BaseDatos.BDPed;
import Clases.Cliente;
import Clases.Direccion;
import Clases.Pedido;
import Clases.Producto;

public class LogPed {

    private BDPed objBDPed;
    //private ArrayList<Producto> lista_Prod;

    public LogPed(BDPed objBDPed){
        this.objBDPed = objBDPed;
        //this.lista_Prod = lista_Prod;
    }
    public ResultSet LogicaExtraerIndentificador(Pedido objPed, int id_Cliente){
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
    } 



    public boolean LogicaInsertarPedido(String estado, int id_Cliente, int id_Dir, ArrayList<Integer> id_Producs, double total, int cant) throws ClassNotFoundException, SQLException {
        int id = 0;
        Pedido objPed = new Pedido(estado, total, );
        for(int i = 0; i < id_Producs.size(); i ++){
            if(objBDPed.InsertarPedido(objPedido, id_Cliente)(objBDPed, id) == 1){
                return true;
            
            }  
        }
      
        return false;
    }
    
    public double CalcularTotal(ArrayList<Producto> lista_Prod, ArrayList<Integer> prod_Elegidos){
        double total = 0.0;
        for(int i = 0; i < prod_Elegidos.size(); i ++){
            if(lista_Prod.get(i).getId_Producto() == prod_Elegidos.get(i)){
                total += lista_Prod.get(i).getPrecio();
            }
        }
        return total;
    } 
}
