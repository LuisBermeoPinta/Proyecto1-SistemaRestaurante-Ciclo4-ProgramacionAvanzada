
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
    BDProd objBDProd = new BDProd();       
    BDPed objBDPed = new BDPed();
    
    public boolean InsertarProducto(ArrayList<Producto> lista_Productos) throws ClassNotFoundException, SQLException{
        int cn = 0;
        for(Producto prod: lista_Productos){
            cn += objBDProd.InsertarProducto(prod);
        }
        if(cn == lista_Productos.size()){
            return true;
        }
        return false;
       
    }


    public ArrayList<Producto> ConsultarProductos() throws ClassNotFoundException, SQLException {
        ArrayList<Producto> list_Prod = new ArrayList<>();
        ResultSet rs = objBDProd.ExtraerProductos();
        Producto objProd;
        
        while(rs.next()){
            objProd = new Producto();
            objProd.setId_Producto(rs.getInt("id_Producto"));
            objProd.setNombre(rs.getString("nombre"));
            objProd.setPrecio(rs.getDouble("precio"));
            
            list_Prod.add(objProd);
        }
        return list_Prod;
    }

}
