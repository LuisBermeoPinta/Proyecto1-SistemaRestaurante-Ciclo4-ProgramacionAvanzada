package Presentacion;

import Clases.Historial_Pedido;
import Clases.Pedido;
import Logica.LogPed;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCocinero {

    Scanner sc = new Scanner(System.in);
    LogPed objLogPed = new LogPed();

    public void MostrarMenuCocinero() throws ClassNotFoundException, SQLException {
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

                    ArrayList<Pedido> list_Ped = objLogPed.ConsultarPedidosPendientes();
                    if (!list_Ped.isEmpty()) {
                        MostrarPedidosPendientes(list_Ped);
                    } else {
                        System.out.println("No hay pedidos pendientes!!");
                    }
                    break;
                case 2:

                    list_Ped = objLogPed.ConsultarPedidosPendientes();
                    if (!list_Ped.isEmpty()) {
                        RegistrarEstadoPedido(list_Ped);
                    } else {
                        System.out.println("No hay pedidos disponibles!!");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo al Menu Principal");
                    break;
                default:
                    System.out.println("No existe esa opcion, elija otra!!");
            }

        } while (eleccion != 0);
    }

    public void MostrarPedidosPendientes(ArrayList<Pedido> list_Ped) throws ClassNotFoundException, SQLException {
        System.out.println("\nPEDIDOS DISPONIBLES\n");
        System.out.printf("%-3S%12S\n", "id", "estado");
        for (Pedido ped : list_Ped) {
            System.out.printf("%-9d%s\n", ped.getCod_Pedido(), ped.getEstado());
        }
    }

    public void RegistrarEstadoPedido(ArrayList<Pedido> list_Ped) throws ClassNotFoundException, SQLException {
        Historial_Pedido objHistPed = new Historial_Pedido();
        Pedido objPed = new Pedido();
        int elec_Ped;
        String opcion;

        MostrarPedidosPendientes(list_Ped);
        System.out.println("\nCAMBIO DE ESTADO");
        System.out.print("Seleccione el Pedido: ");
        elec_Ped = sc.nextInt();

        sc.nextLine();

        for (Pedido ped : list_Ped) {
            if (ped.getCod_Pedido() == elec_Ped && ped.getEstado().equalsIgnoreCase("Pendiente")) {
                ped.setEstado("En Preparacion");
                //Se actualiza el estado del pedido 
                if (objLogPed.ActualizarEstadoPedido(ped)) {
                    System.out.println("Estado cambiado con Exito!!");
                } else {
                    System.out.println("No se pudo cambiar el estado!!");
                }
                objHistPed.setObjPedido(ped);

                //Se guarda el historial de ese pedido
                objLogPed.InsertarHistorial_Pedido(objHistPed);

                /*En caso de querer de una vez confirmar la entrega del pedido
                el estado pasa de En preparacion a Listo para la Entega*/
                System.out.print("Desea entregar el Pedido? (s/n): ");
                opcion = sc.nextLine();
                if (opcion.equalsIgnoreCase("s")) {
                    ped.setEstado("Listo para Entrega");
                    //Se actualiza el estado en la base de datos
                    if (objLogPed.ActualizarEstadoPedido(ped)) {
                        System.out.println("\nEstado cambiado con Exito!!");
                    } else {
                        System.out.println("\nNo se pudo cambiar el estado!!");
                    }
                    objHistPed.setObjPedido(ped);

                    //Y tambien el Historial del Pedido
                    objLogPed.InsertarHistorial_Pedido(objHistPed);

                }
                //En caso de que haya seleccionado n aqui nuevamnte se le pregunta si desea Entregar el Pedido
            } else if (ped.getCod_Pedido() == elec_Ped && ped.getEstado().equalsIgnoreCase("En Preparacion")) {
                System.out.print("Desea entregar el Pedido? (s/n): ");
                opcion = sc.nextLine();
                if (opcion.equalsIgnoreCase("s")) {
                    ped.setEstado("Listo para Entrega");
                    if (objLogPed.ActualizarEstadoPedido(ped)) {
                        System.out.println("\nEstado cambiado con Exito!!");
                    } else {
                        System.out.println("\nNo se pudo cambiar el estado!!");
                    }
                    objHistPed.setObjPedido(ped);
                    objLogPed.InsertarHistorial_Pedido(objHistPed);
                }
            } else {
                System.out.println("El pedido no Existe!!");
            }

        }

    }
}
