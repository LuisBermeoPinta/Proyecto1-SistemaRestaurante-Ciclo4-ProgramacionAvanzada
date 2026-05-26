package Presentacion;

import Clases.Cliente;
import Clases.Historial_Pedido;
import Clases.Pedido;
import Clases.Producto_Pedido;
import Logica.LogCliente;
import Logica.LogPed;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {

    Scanner sc = new Scanner(System.in);
    LogPed objLogPed = new LogPed();
    LogCliente objLogCliente = new LogCliente();
    MetodosCompartidos metodosComp = new MetodosCompartidos();

    public void MostrarMenuCliente() throws ClassNotFoundException, SQLException {
        byte eleccion = 0;
        do {
            System.out.println("\n1) Consultar por codigo del Pedido");
            System.out.println("2) Consultar el Pedido Actual");
            System.out.println("3) Consultar el Historial del Pedido");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: ");
            eleccion = sc.nextByte();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    MostrarPedidoXCodigo();

                    break;
                case 2:
                    ConsultarPedidosIDCliente();
                    break;
                case 3:
                    MostrarHistoriaPedido();
                    break;
                default:
                    System.out.println("Saliendo...");
            }

        } while (eleccion != 0);
    }

    public void MostrarPedidoXCodigo() throws ClassNotFoundException, SQLException {
        int cod;
        Pedido objPed;
        System.out.print("Ingrese el Codigo del Pedido: ");
        cod = sc.nextInt();

        //Llama a la funcion que se encarga de coordinar con la base de datos para extraer el Pedido mediante el codigo del mismo
        objPed = objLogPed.ExtraerPedidoXCodigo(cod);
        //Se anade un control en caso de que no se encuentre el pedido
        if (objPed != null) {

            MostrarPedidoCompleto(objPed);
        } else {
            System.out.println("Codigo no valido!!");
        }
    }

    public void ConsultarPedidosIDCliente() throws ClassNotFoundException, SQLException {
        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerClientes();
        Pedido objPed = new Pedido();
        int elec_Cliente, elec_Ped;

        //Se anade un control en caso de que no haya clientes de los cuales selecionar su pedido
        if (!list_Clientes.isEmpty()) {
            metodosComp.MostrarClientes(list_Clientes);

            System.out.print("\nIngrese el Cliente: ");
            elec_Cliente = sc.nextInt();

            for (Cliente client : list_Clientes) {
                //En caso de que la eleccion del usuario se la correcta se procede a mostrarle los pedidos de dicho cliente seleccionado
                if (client.getId_Cliente() == elec_Cliente) {
                    ArrayList<Pedido> list_Ped = objLogPed.ConsultarPedidoXIDCliente(elec_Cliente);
                    MostrarPedido(list_Ped);
                    System.out.print("\nSelecione el Pedido: ");
                    elec_Ped = sc.nextInt();
                    for (Pedido ped : list_Ped) {
                        if (ped.getCod_Pedido() == elec_Ped) {
                            //Y una vez todo bien se extrae el pedido de dicho cliente
                            objPed = objLogPed.ExtraerPedidoXCodigo(elec_Ped);
                            //Y se muestra
                            MostrarPedidoCompleto(objPed);
                        }
                    }
                }

            }
        } else {
            System.out.println("No hay clientes disponibles!!");
        }

    }

    public void MostrarHistoriaPedido() throws ClassNotFoundException, SQLException {
        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerClientes();
        ArrayList<Historial_Pedido> list_HistPed = new ArrayList<>();
        Pedido objPed = new Pedido();
        int elec_Cliente, elec_Ped;

        if (!list_Clientes.isEmpty()) {
            /*En caso de que si existan clientes se procede a pedir el ID del mismo 
            junto con el ID del pedido correspondiente a dicho cliente*/
            metodosComp.MostrarClientes(list_Clientes);
            System.out.print("\nIngrese el Cliente: ");
            elec_Cliente = sc.nextInt();

            for (Cliente client : list_Clientes) {
                if (client.getId_Cliente() == elec_Cliente) {
                    ArrayList<Pedido> list_Ped = objLogPed.ConsultarPedidoXIDCliente(elec_Cliente);
                    MostrarPedido(list_Ped);
                    System.out.print("\nSelecione el Pedido: ");
                    elec_Ped = sc.nextInt();
                    for (Pedido ped : list_Ped) {
                        if (ped.getCod_Pedido() == elec_Ped) {
                            
                            /*Luego se asigna el historial pedido a una lista gracias a la eleccion 
                            del usuario ya que este corresponde al mismo ID del pedido*/
                            list_HistPed = objLogPed.ConsultarHistorialPedido(elec_Ped);
                            
                            //Y finalmente se muestra el Historial de ese Pedido
                            MostrarHistorialPedido(list_HistPed);
                        }
                    }
                }

            }
        } else {
            System.out.println("No hay clientes disponibles!!");
        }
    }

    public void MostrarPedido(ArrayList<Pedido> list_Ped) {
        System.out.println("\nPEDIDOS DISPONIBLES\n");
        System.out.printf("%-3S%12S\n", "id", "estado");
        for (Pedido ped : list_Ped) {
            System.out.printf("%-9d%s\n", ped.getCod_Pedido(), ped.getEstado());
        }
    }

    public void MostrarPedidoCompleto(Pedido objPed) {
        System.out.println("\n+========================+");
        System.out.println("| INFORMACION DEL PEDIDO |");
        System.out.println("+========================+\n");
        System.out.printf("%S", "Datos del Cliente\n");
        System.out.printf("%-5S%-10S%-10S%n", "ID", "Nombre", "Cedula");
        System.out.printf("%-5d%-10S%-10S%n", objPed.getObjCliente().getId_Cliente(), objPed.getObjCliente().getNombre(), objPed.getObjCliente().getCedula());

        System.out.printf("%n%-9S%-9S%-20S%-17S%-15S%n", "Codigo", "Total", "Estado", "Entregado a", "Fecha y Hora de Entrega");

        System.out.printf("%-9S%-9.2f%-20S%-17S%-15s%n",
                objPed.getCod_Pedido(),
                objPed.getTotal(),
                objPed.getEstado(),
                objPed.getReceptor(),
                String.format("%1$td/%1$tm/%1$tY %1$tH:%1$tM:%1$tS", objPed.getFecha_Hora_Entrega()));

        System.out.printf("%n%-5S%-20S%-12S%n", "ID", "Nombre Producto", "Precio");
        for (Producto_Pedido prodPed : objPed.getObjProdPed()) {
            System.out.printf("%-5d%-20s%-12.2f%n",
                    prodPed.getObjProd().getId_Producto(),
                    prodPed.getObjProd().getNombre(),
                    prodPed.getObjProd().getPrecio());
        }
    }

    public void MostrarHistorialPedido(ArrayList<Historial_Pedido> list_HistPed) {
        int cn = 1;
        System.out.println("\n+======================+");
        System.out.println("| HISTORIAL DEL PEDIDO |");
        System.out.println("+======================+");  
        for(Historial_Pedido histPed: list_HistPed){
            System.out.println("HISTORIAL #" + cn);
            cn ++;
            System.out.printf("%-5S%-20S%-10S%n", "ID", "Codigo del Pedido", "Estado");
            System.out.printf("%-14S%-11S%-15S%n",histPed.getId_Historial(), histPed.getObjPedido().getCod_Pedido(), histPed.getEstado() );
            System.out.println("==================================================\n");
        }
        

    }

}
