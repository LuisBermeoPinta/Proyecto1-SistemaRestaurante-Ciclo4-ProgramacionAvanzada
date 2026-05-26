package Presentacion;

import Clases.Cliente;
import Clases.Direccion;
import Clases.Historial_Pedido;
import Clases.Pedido;
import Clases.Producto;
import Clases.Producto_Pedido;
import Clases.Telefono;
import Logica.LogCliente;
import Logica.LogPed;
import Logica.LogProd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdministrador {

    Scanner sc = new Scanner(System.in);
    LogCliente objLogCliente = new LogCliente();
    LogPed objLogPed = new LogPed();
    LogProd objLogProd = new LogProd();
    MetodosCompartidos metodosComp = new MetodosCompartidos();

    public void MostrarMenuAdministrador() throws ClassNotFoundException, SQLException {
        byte eleccion = 0;
        do {
            System.out.println("\nREGISTRO DE CLIENTES\n");
            System.out.println("1) Ingresar Cliente");
            System.out.println("2) Ingresar Direccion");
            System.out.println("3) Ingresar Telefono");
            System.out.println("4) Ingresar Pedido");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: ");
            eleccion = sc.nextByte();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    Cliente nuevoCliente = PedirDatosCliente();

                    if (objLogCliente.InsertarCliente(nuevoCliente)) {
                        System.out.println("Cliente registrado con exito!!");
                    } else {
                        System.out.println("No se pudo registrar el Cliente!!");
                    }

                    break;

                case 2:
                    Cliente clienteConDirecciones = PedirDirCliente();
                    if (clienteConDirecciones.getDirecciones() != null) {

                        if (objLogCliente.InsertarLogicaDireccion(clienteConDirecciones)) {
                            System.out.println("Direccion registrada con exito!!");
                        } else {
                            System.out.println("No se pudo registrar la direccion!!");
                        }
                    }

                    break;

                case 3:
                    Cliente clienteConTelefonos = PedirTelfCliente();

                    if (clienteConTelefonos.getTelefonos() != null) {

                        if (objLogCliente.InsertarLogicaTelefono(clienteConTelefonos)) {
                            System.out.println("Telefono registrado con exito!!");
                        } else {
                            System.out.println("No se pudo registrar el telefono!!");
                        }
                    }

                    break;

                case 4:
                    /*ArrayList<Producto> lista_Prod = new ArrayList<>();
                    lista_Prod.add(new Producto("Papas", 1.25));
                    lista_Prod.add(new Producto("Refresco", 1.00));
                    lista_Prod.add(new Producto("Hamburguesa", 2.50));
                    lista_Prod.add(new Producto("Hot Dog", 2));
                    lista_Prod.add(new Producto("Pizza", 4));
                    lista_Prod.add(new Producto("Alitas BBQ", 3));
                    objLogProd.InsertarProducto(lista_Prod);*/
                    RegistrarPedido();
                    break;

                case 0:
                    System.out.println("Saliendo al Menu Principal");
                    break;

                default:
                    System.out.println("No existe esa opcion, elija otra!!");
            }

        } while (eleccion != 0);

    }

    public Cliente PedirDatosCliente() {
        Cliente objCliente = new Cliente();
        System.out.println("\nDATOS DEL CLIENTE");
        System.out.print("Nombre: ");
        objCliente.setNombre(sc.nextLine());

        System.out.print("Cedula: ");
        objCliente.setCedula(sc.nextLine());

        return objCliente;
    }

    public void MostrarMenuProductos(ArrayList<Producto> lista_Prod) throws ClassNotFoundException, SQLException {
        System.out.println("\nLISTA DE PRODUCTOS\n");
        System.out.printf("%-3S%12S%12S\n", "id", "nombre", "precio");
        for (Producto prod : lista_Prod) {
            System.out.printf("%-9d%-12s%s\n", prod.getId_Producto(), prod.getNombre(), prod.getPrecio());
        }
    }

    public void MostarDireccionCliente(ArrayList<Direccion> lista_Dir) {
        System.out.println("\nLISTA DE DIRECCIONES DISPONIBLES\n");
        System.out.printf("%-9S%-20S%S\n", "id", "calle1", "calle2");
        for (Direccion dir : lista_Dir) {
            System.out.printf("%-9d%-20s%s\n", dir.getId_Direccion(), dir.getCalle1(), dir.getCalle2());
        }
    }

    public Cliente PedirDirCliente() throws ClassNotFoundException, SQLException {
        Cliente objCliente = new Cliente();
        Direccion objDir;
        int opcion = 0;
        ArrayList<Direccion> direcciones = new ArrayList<>();
        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerClientes();

        if (!list_Clientes.isEmpty()) {
            metodosComp.MostrarClientes(list_Clientes);

            System.out.print("\nSelecione el Cliente: ");
            opcion = sc.nextInt();
            for (Cliente client : list_Clientes) {
                if (client.getId_Cliente() == opcion) {
                    objCliente = client;
                }

            }
            sc.nextLine();
            do {
                objDir = new Direccion();
                System.out.println("\nDIRECCION\n");
                System.out.print("Calle 1: ");
                objDir.setCalle1(sc.nextLine());

                System.out.print("Calle 2: ");
                objDir.setCalle2(sc.nextLine());
                direcciones.add(objDir);

                System.out.print("Presione 0 para Salir o cualquier otro numero para Continuar: ");
                opcion = sc.nextInt();
                sc.nextLine();
            } while (opcion != 0);
            objCliente.setDirecciones(direcciones);
        } else {
            System.out.println("No hay clientes disponibles!!");
        }

        return objCliente;
    }

    public Cliente PedirTelfCliente() throws ClassNotFoundException, SQLException {
        Cliente objCliente = new Cliente();
        Telefono objTelf = new Telefono();
        ArrayList<Telefono> telefonos = new ArrayList<>();
        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerClientes();
        int opcion = 0;

        if (!list_Clientes.isEmpty()) {
            metodosComp.MostrarClientes(list_Clientes);
            System.out.print("\nSelecione el Cliente: ");
            opcion = sc.nextInt();
            for (Cliente client : list_Clientes) {
                if (client.getId_Cliente() == opcion) {
                    objCliente = client;
                }

            }
            sc.nextLine();

            do {
                objTelf = new Telefono();
                System.out.println("\nTELEFONO\n");
                System.out.print("Nombre: ");
                objTelf.setNombre(sc.nextLine());

                System.out.print("Numero de Telefono: ");
                objTelf.setNum_Telefono(sc.nextLine());
                telefonos.add(objTelf);

                System.out.print("Presione 0 para Salir o cualquier otro numero para Continuar: ");
                opcion = sc.nextInt();
                sc.nextLine();
            } while (opcion != 0);
            objCliente.setTelefonos(telefonos);
        } else {
            System.out.println("No hay clientes disponibles!!");
        }
        return objCliente;

    }

    public void RegistrarPedido() throws ClassNotFoundException, SQLException {
        Pedido objPed = new Pedido();
        Cliente objCliente = new Cliente();
        Producto objProd;
        Producto_Pedido objProdPed;
        Direccion objDir = new Direccion();
        Historial_Pedido objHistPed = new Historial_Pedido();

        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerClientes();
        ArrayList<Producto> lista_Prod = objLogProd.ExtraerLogicaProducto();
        ArrayList<Producto> prod_Elegidos = new ArrayList<>();
        ArrayList<Producto_Pedido> lista_ProdPed = new ArrayList<>();

        int elec_Cliente = 0;
        int elec_Prod = 0;
        int elec_Dir = 0;
        double total = 0.0;
        String estado = "Pendiente";
        int cant = 0;
        if (!list_Clientes.isEmpty()) {
            //Mostrar Lista de Clientes
            metodosComp.MostrarClientes(list_Clientes);

            //Selecionar el Cliente
            System.out.print("\nSelecione el Cliente: ");
            elec_Cliente = sc.nextInt();
            sc.nextLine();

            //Encontrar ese cliente y asignarlo al objCliente
            for (Cliente client : list_Clientes) {
                if (client.getId_Cliente() == elec_Cliente) {
                    //Al ser un solo cliente no hace falta crear mas de un objCliente
                    objCliente = client;
                }

            }
            //Salida: un objCliente extraido del ArrayList list_Clientes
            ArrayList<Direccion> lista_Dir = objLogCliente.LogicaExtraerDireccion(objCliente);
            if (!lista_Dir.isEmpty()) {             
                //Luego Mostramnos la lista de productos disponibles
                MostrarMenuProductos(lista_Prod);
                /*Dentro de un Do While para que obligatoriamente se elija un producto y se termina
            cuando se presiona el numero 0
                 */
                do {
                    System.out.print("\nSelecione un Producto o Presione 0 para Terminar: ");
                    elec_Prod = sc.nextInt();

                    if (elec_Prod != 0) {
                        // 1. Buscamos el producto primero
                        objProd = null; // <--- MODIFICADO: Reiniciamos la referencia
                        for (Producto prod : lista_Prod) {
                            if (prod.getId_Producto() == elec_Prod) {
                                objProd = prod;
                            }
                        }

                        // 2. Solo si el producto existe, pedimos cantidad y guardamos
                        if (objProd != null) {
                            //prod_Elegidos.add(objProd);

                            // <--- MODIFICADO: Creamos UN SOLO objeto por cada producto seleccionado
                            objProdPed = new Producto_Pedido();
                            objProdPed.setObjProd(objProd);

                            System.out.print("Ingrese la Cantidad: ");
                            cant = sc.nextInt();
                            objProdPed.setCantidad(cant);
                            objProdPed.setObjProd(objProd);

                            // <--- MODIFICADO: Añadimos a la lista el objeto completo (producto + cantidad)
                            lista_ProdPed.add(objProdPed);
                        } else {
                            System.out.println("Producto no válido.");
                        }

                    } else {
                        System.out.println("Productos elegidos con Exito!!");
                    }

                } while (elec_Prod != 0);

                MostarDireccionCliente(lista_Dir);
                System.out.print("\nSelecione una Direccion a Entregar: ");
                elec_Dir = sc.nextInt();

                for (Direccion dir : lista_Dir) {
                    if (dir.getId_Direccion() == elec_Dir) {
                        objDir = dir;
                    }

                }
                sc.nextLine();
                
                objPed.setObjProdPed(lista_ProdPed);
                total = objLogPed.CalcularTotal(objPed);

                //Insertar Pedido con Datos
                objPed.setObjCliente(objCliente);
                objPed.setObjDir(objDir);
                objPed.setEstado(estado);
                objPed.setTotal(total);

                if(objLogPed.LogicaInsertarPedido(objPed)){
                    System.out.println("Pedido insertado con Exito!!");
                }else{
                    System.out.println("No se pudo registrar el Pedido!!");
                }
                
                Pedido ped = objLogPed.LogicaExtraerPedido(objCliente);
                objPed.setCod_Pedido(ped.getCod_Pedido());
                objHistPed.setObjPedido(objPed);

                if(objLogPed.InsertarHistorial_Pedido(objHistPed)){
                    System.out.println("Historial_Pedido insertado con Exito!!");
                }

                for (Producto_Pedido prodPed : lista_ProdPed) {
                    prodPed.setObjPed(objPed);
                }

                if (objLogPed.LogicaInsertarProducto_Pedido(lista_ProdPed)) {
                    System.out.println("Producto_Pedido insertado con Exito");
                } else {
                    System.out.println("Producto_Pedido no insertado!!");
                }

            } else {
                System.out.println("No hay direcciones disponibles!!");
            }
        } else {
            System.out.println("No hay clientes disponibles!!");
        }
    }
}
