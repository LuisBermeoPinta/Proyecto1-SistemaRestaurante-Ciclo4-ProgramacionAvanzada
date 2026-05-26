package Presentacion;

import Clases.Historial_Pedido;
import Clases.Pedido;
import Logica.LogPed;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuRepartidor {

    Scanner sc = new Scanner(System.in);
    LogPed objLogPed = new LogPed();

    public void MostrarMenuRepartidor() throws ClassNotFoundException, SQLException {
        byte eleccion = 0;
        do {
            System.out.println("\n1) Consultar Pedidos Pendientes");
            System.out.println("2) Registrar el Estado del Pedido");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: ");
            eleccion = sc.nextByte();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    //Se Consultan los Pedidos que tengan en Estado adecuado para el Rol Repartidor
                    ArrayList<Pedido> list_Ped = objLogPed.ConsultarPedidosListos();

                    //Se encarga de validar si existen pedidos 
                    if (!list_Ped.isEmpty()) {
                        MostrarPedidosListos(list_Ped);
                    } else {
                        System.out.println("No hay pedidos Disponibles!!");
                    }
                    break;
                case 2:

                    list_Ped = objLogPed.ConsultarPedidosListos();
                    if (!list_Ped.isEmpty()) {
                        RegistrarEstadoPedido(list_Ped);
                    } else {
                        System.out.println("No hay pedidos Disponibles!!");
                    }
                    break;
                case 3:

                    break;
                default:
                    System.out.println("Saliendo...");
            }

        } while (eleccion != 0);
    }

    public void MostrarPedidosListos(ArrayList<Pedido> list_Ped) {
        System.out.println("\nPEDIDOS DISPONIBLES\n");
        System.out.printf("%-5S%8s%12S\n", "id", "total", "estado");
        for (Pedido ped : list_Ped) {
            System.out.printf("%-8d%4.2f%25s\n", ped.getCod_Pedido(), ped.getTotal(), ped.getEstado());
        }
    }

    public void RegistrarEstadoPedido(ArrayList<Pedido> list_Ped) throws SQLException, ClassNotFoundException {
        Historial_Pedido objHistPed = new Historial_Pedido();
        Pedido objPed = new Pedido();
        int elec_Ped;
        String opcion;

        //Se muestran los pedidos con su estado
        MostrarPedidosListos(list_Ped);
        System.out.println("\nCAMBIO DE ESTADO");
        System.out.print("Seleccione el Pedido: ");
        elec_Ped = sc.nextInt();
        sc.nextLine();

        //Se encuentra dentro de la lista de pedidos el objeto que el usuario eligio
        for (Pedido ped : list_Ped) {
            //Se Comprueba si concuerda la eleccion dentro de la lista y ademas tambien el estado
            if (ped.getCod_Pedido() == elec_Ped && ped.getEstado().equalsIgnoreCase("Listo para Entrega")) {
                //Se cambia el estado
                ped.setEstado("En Camino");

                //Se actualiza el estado en la base de datos
                objLogPed.ActualizarEstadoPedido(ped);

                //Y adicional se agrega el objeto con ese estado en concreto dentro de un atributo del objeto objHistPed
                objHistPed.setObjPedido(ped);

                //Y se Procede a insertar dentro de la base de datos ese objeto
                objLogPed.InsertarHistorial_Pedido(objHistPed);

                //Se comprueba si el usuario desea de una vez actualizar el estado de en camino a Listo para Entrega
                System.out.print("Desea entregar el Pedido? (s/n): ");
                opcion = sc.nextLine();
                //Se valida la opcion elegida
                if (opcion.equalsIgnoreCase("s")) {
                    //Y en caso de cumplirse se procede a pedir el nombre de la persona que recibe el pedido junto con la fecha y hora de entrega
                    System.out.print("Ingrese el nombre de la persona que recibe el pedido: ");
                    ped.setReceptor(sc.nextLine());
                    ped.setFecha_Hora_Entrega(LocalDateTime.now());
                    ped.setEstado("Entregado");

                    //Y finalmente se actualiza en la base de datos tanto el estado del pedido como el historial
                    objLogPed.ActualizarEstadoPedido(ped);
                    objHistPed.setObjPedido(ped);
                    objLogPed.InsertarHistorial_Pedido(objHistPed);

                }

                //Esto en caso de que el repartidor elija un pedido con el estado en Camino
            } else if (ped.getCod_Pedido() == elec_Ped && ped.getEstado().equalsIgnoreCase("En Camino")) {
                System.out.print("Ingrese el nombre de la persona que recibe el pedido: ");
                ped.setReceptor(sc.nextLine());
                ped.setFecha_Hora_Entrega(LocalDateTime.now());
                ped.setEstado("Entregado");
                objLogPed.ActualizarEstadoPedido(ped);
                objHistPed.setObjPedido(ped);
                objLogPed.InsertarHistorial_Pedido(objHistPed);

            }
        }
    }

}
