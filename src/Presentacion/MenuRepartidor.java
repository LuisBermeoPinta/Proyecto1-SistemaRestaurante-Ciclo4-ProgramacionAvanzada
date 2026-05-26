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
                    ArrayList<Pedido> list_Ped = objLogPed.ConsultarPedidosListos();
                    if (!list_Ped.isEmpty()) {
                        MostrarPedidosListos(list_Ped);
                    }else{
                        System.out.println("No hay pedidos Disponibles!!");
                    }
                    break;
                case 2:
                    list_Ped = objLogPed.ConsultarPedidosListos();
                    if (!list_Ped.isEmpty()) {
                        RegistrarEstadoPedido(list_Ped);
                    }else{
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

        MostrarPedidosListos(list_Ped);
        System.out.println("\nCAMBIO DE ESTADO");
        System.out.print("Seleccione el Pedido: ");
        elec_Ped = sc.nextInt();
        sc.nextLine();

        for (Pedido ped : list_Ped) {
            if (ped.getCod_Pedido() == elec_Ped && ped.getEstado().equalsIgnoreCase("Listo para Entrega")) {
                ped.setEstado("En Camino");
                objLogPed.ActualizarEstadoPedido(ped);
                objHistPed.setObjPedido(ped);
                objLogPed.InsertarHistorial_Pedido(objHistPed);

                System.out.print("Desea entregar el Pedido? (s/n): ");
                opcion = sc.nextLine();
                if (opcion.equalsIgnoreCase("s")) {
                    System.out.print("Ingrese el nombre de la persona que recibe el pedido: ");
                    ped.setReceptor(sc.nextLine());
                    ped.setFecha_Hora_Entrega(LocalDateTime.now());
                    ped.setEstado("Entregado");
                    objLogPed.ActualizarEstadoPedido(ped);
                    objHistPed.setObjPedido(ped);
                    objLogPed.InsertarHistorial_Pedido(objHistPed);

                }

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
