
package Logica;

import BaseDatos.BDEmpl;
import Clases.Empleado;
import java.sql.SQLException;


public class LogEmpl {
    BDEmpl objBDEmpleado = new BDEmpl();
    
    public boolean InsertarLogicaEmpleado(Empleado objEmpleado) throws ClassNotFoundException, SQLException{
        if(objBDEmpleado.InsertarEmpleado(objEmpleado) == 1){
            return true;
        }
        return false;
        
    }    
    
}
