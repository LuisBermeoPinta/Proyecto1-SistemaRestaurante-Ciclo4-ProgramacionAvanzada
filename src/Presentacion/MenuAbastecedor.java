package Presentacion;

import Clases.Producto;
import Logica.LogProd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAbastecedor {

    Scanner sc = new Scanner(System.in);
    LogProd objLogProd = new LogProd();
    MetodosCompartidos metodosComp = new MetodosCompartidos();

    public void MostrarMenuAbastecedor() throws ClassNotFoundException, SQLException {
        ArrayList<Producto> list_Prod;
        byte eleccion = 0;
        do {
            System.out.println("\n1) Ingresar Producto");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: ");
            eleccion = sc.nextByte();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    IngresarProductos();

                    break;

                case 2:

                    /*list_Prod = objLogProd.ConsultarProductos();
                    if (!list_Prod.isEmpty()) {
                        EliminarProductos(list_Prod);
                    } else {
                        System.out.println("No hay Productos disponibles!!");
                    }*/
                    break;
                case 0:
                    System.out.println("Saliendo al Menu Principal");
                    break;

                default:
                    System.out.println("No existe esa opcion, elija otra!!");
            }

        } while (eleccion != 0);
    }

    public void IngresarProductos() throws ClassNotFoundException, SQLException {
        ArrayList<Producto> list_Prod = new ArrayList<>();
        Producto objProd;
        do {
            objProd = new Producto();
            System.out.print("Ingrese el nombre del producto: ");
            objProd.setNombre(sc.nextLine());
            System.out.print("Ingrese el Precio: ");
            objProd.setPrecio(sc.nextDouble());
            sc.nextLine();
            list_Prod.add(objProd);
            System.out.print("Desea ingresar mas Productos (s/n): ");
        }while(sc.nextLine().equalsIgnoreCase("s"));
        if(objLogProd.InsertarProducto(list_Prod)){
            System.out.println("Producto/s ingresados con Exito!!");
        }else{
            System.out.println("No se pudo insertar el Pedido!!");
        }
        
        
    }

    /*public void EliminarProductos(ArrayList<Producto> list_Prod) throws ClassNotFoundException, SQLException {
        int elec_Prod;
        String eleccion;

        metodosComp.MostrarProductos(list_Prod);
        System.out.print("Ingrese el ID del Producto: ");
        elec_Prod = sc.nextInt();
        for (Producto prod : list_Prod) {
            if (prod.getId_Producto() == elec_Prod) {
                System.out.print("Seguro que desea eliminar este Producto (s/n): ");
                eleccion = sc.nextLine();
                if (eleccion.equalsIgnoreCase("s")) {
                    if (objLogProd.EliminarProducto(prod)) {
                        System.out.println("Producto eliminado con Exito !!");
                    } else {
                        System.out.println("No se pudo eliminar el Producto");
                    }
                }
            } else {
                System.out.println("No existe esa opcion, elija otra!!");
            }
        }

    }*/
}
