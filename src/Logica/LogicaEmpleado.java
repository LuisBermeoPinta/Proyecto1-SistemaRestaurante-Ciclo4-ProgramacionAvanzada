
package Logica;

import BaseDatos.BDEmpleado;
import Clases.Empleado;
import java.sql.SQLException;


public class LogicaEmpleado {
    BDEmpleado objBDEmpleado = new BDEmpleado();
    
    public boolean InsertarLogicaEmpleado(Empleado objEmpleado) throws ClassNotFoundException, SQLException{
        if(objBDEmpleado.InsertarEmpleado(objEmpleado) == 1){
            return true;
        }
        return false;
        
    }    
    
}
