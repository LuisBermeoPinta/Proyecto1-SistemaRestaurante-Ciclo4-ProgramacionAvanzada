package Presentacion;

import BaseDatos.BDPed;
import Clases.*;
import Logica.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema_Restaurante {

    Scanner sc = new Scanner(System.in);
    LogProd objLogProd = new LogProd();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Sistema_Restaurante app = new Sistema_Restaurante();
        app.MostrarMenuPrincipal();

    }

    public void MostrarMenuPrincipal() throws ClassNotFoundException, SQLException {
        byte eleccion = 0;
        do {
            System.out.println("\nSISTEMA RESTAURANTE\n");
            System.out.println("1) Rol de Administrador");
            System.out.println("2) Rol de Cocinero");
            System.out.println("3) Rol de Repartidor");
            System.out.println("4) Rol de Cliente");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: ");
            eleccion = sc.nextByte();

            switch (eleccion) {
                case 1:
                    MenuAdministrador menuAdmin = new MenuAdministrador();
                    menuAdmin.MostrarMenuAdministrador();
                    break;
                case 2:
                    MenuCocinero menuCocina = new MenuCocinero();
                    menuCocina.MostrarMenuCocinero();
                    break;
                case 3:
                    MenuRepartidor menuEntrega = new MenuRepartidor();
                    menuEntrega.MostrarMenuRepartidor();
                    break;

                case 4:
                    MenuCliente menuCliente = new MenuCliente();
                    menuCliente.MostrarMenuCliente();
                    break;
                    
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No existe esa opcion, elija otra!!");
            }

        } while (eleccion != 0);

    }
      

    /*public void RegistrarProductos(ArrayList<Producto> lista_Productos) throws ClassNotFoundException, SQLException {
        if (objLogProd.InsertarLogicaProducto(lista_Productos)) {
            System.out.println("Productos Ingresados con Exito!!");
        } else {
            System.out.println("Error no se pudieron ingresar los Productos");
        }

    }*/

}
