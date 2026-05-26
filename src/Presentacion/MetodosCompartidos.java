package Presentacion;

import Clases.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetodosCompartidos {

    public void MostrarClientes(ArrayList<Cliente> list_Clientes) throws ClassNotFoundException, SQLException {
        System.out.println("\nLISTA DE CLIENTES\n");
        System.out.printf("%-3S%12S%12S\n", "id", "nombre", "cedula");
        for (Cliente client : list_Clientes) {
            System.out.printf("%-2d%11s%18s\n", client.getId_Cliente(), client.getNombre(), client.getCedula());
        }
    }
}
