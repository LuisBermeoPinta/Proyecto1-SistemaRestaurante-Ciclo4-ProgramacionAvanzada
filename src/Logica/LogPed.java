
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
import Clases.Producto_Pedido;

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



    public void LogicaInsertarPedido(Pedido objPed) throws ClassNotFoundException, SQLException {
        objBDPed.InsertarPedido(objPed);
    }
    
    public boolean LogicaInsertarProducto_Pedido(ArrayList<Producto_Pedido> lista_ProdPed) throws ClassNotFoundException, SQLException {
        int cn = 0;
        for(Producto_Pedido prodPed: lista_ProdPed){
            cn += objBDPed.InsertarProducto_Pedido(prodPed);
        }
        if(cn == lista_ProdPed.size()){
            return true;
        }
        return false;        
    }    
    
    public double CalcularTotal(ArrayList<Producto> prod_Elegidos){
        double total = 0.0;
        for(int i = 0; i < prod_Elegidos.size(); i ++){
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
}
