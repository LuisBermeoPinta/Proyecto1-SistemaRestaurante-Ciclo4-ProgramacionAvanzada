
package Logica;

import BaseDatos.BDProducto;
import Clases.Producto;
import java.sql.SQLException;
import java.util.ArrayList;


public class LogicaProducto {
    BDProducto objBDProducto = new BDProducto();       
    
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
    
}
