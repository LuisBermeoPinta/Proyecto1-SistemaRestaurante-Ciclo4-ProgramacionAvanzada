package Presentacion;

import Clases.Cliente;
import Clases.Producto;
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
    public void MostrarProductos(ArrayList<Producto> lista_Prod) throws ClassNotFoundException, SQLException {
        System.out.println("\nPRODUCTOS DISPONIBLES\n");
        System.out.printf("%-5S%-20S%S\n", "id", "nombre", "precio");
        for (Producto prod : lista_Prod) {
            System.out.printf("%-5d%-20s%s\n", prod.getId_Producto(), prod.getNombre(), prod.getPrecio());
        }
    }    
}


