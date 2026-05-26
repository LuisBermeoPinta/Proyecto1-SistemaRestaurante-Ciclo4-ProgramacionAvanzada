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
                    if (nuevoCliente.getCedula().length() == 10) {

                        if (objLogCliente.InsertarCliente(nuevoCliente)) {
                            System.out.println("Cliente registrado con exito!!");
                        } else {
                            System.out.println("No se pudo registrar el Cliente!!");
                        }
                    }else{
                        System.out.println("La Cedula no es Valida!!");
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
                objTelf.setTipo(sc.nextLine());

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
        MetodosCompartidos metodosComp = new MetodosCompartidos();

        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerClientes();
        ArrayList<Producto> lista_Prod = objLogProd.ConsultarProductos();
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
                //Luego Mostramos la lista de productos disponibles
                metodosComp.MostrarProductos(lista_Prod);
                /*Dentro de un Do While para que obligatoriamente se elija un producto y se termina
            cuando se presiona el numero 0
                 */
                do {
                    System.out.print("\nSelecione un Producto o Presione 0 para Terminar: ");
                    elec_Prod = sc.nextInt();

                    if (elec_Prod != 0) {

                        objProd = null;
                        //Se anade un control para verificar que el producto elegido exista
                        for (Producto prod : lista_Prod) {
                            if (prod.getId_Producto() == elec_Prod) {
                                objProd = prod;
                            }
                        }

                        //Solo si el producto existe, pedimos cantidad y guardamos
                        if (objProd != null) {

                            /*Creamos un nuevo objeto Producto_Pedido en cada iteracion ya que los objetos 
                            son Variables no primitivas que se pasan por referencia*/
                            objProdPed = new Producto_Pedido();

                            //objProdPed.setObjProd(objProd);
                            System.out.print("Ingrese la Cantidad: ");
                            cant = sc.nextInt();
                            objProdPed.setCantidad(cant);
                            //Una vez confirmada la cantidad se procede a guardar el objeto producto dentro de obj Producto_Pedido
                            objProdPed.setObjProd(objProd);
                            //Y ese mismo obj en una lista
                            lista_ProdPed.add(objProdPed);
                        } else {
                            System.out.println("Producto no válido.");
                        }

                    } else {
                        System.out.println("Productos elegidos con Exito!!");
                    }

                } while (elec_Prod != 0);

                //Luego se pide la direccion de entrega
                MostarDireccionCliente(lista_Dir);
                System.out.print("\nSelecione una Direccion a Entregar: ");
                elec_Dir = sc.nextInt();

                for (Direccion dir : lista_Dir) {
                    if (dir.getId_Direccion() == elec_Dir) {
                        objDir = dir;
                    }

                }
                sc.nextLine();
                //Luego se guarda esa lista de productos_Pedidos dentro del objeto Pedido ya que un pedido tiene muchos productos
                objPed.setObjProdPed(lista_ProdPed);

                //Se calcula el total dependiendo los productos elegidos
                total = objLogPed.CalcularTotal(objPed);

                //Y se guarda en cada atributo del obj Pedido el cliente, la direccion, el estado y el total 
                objPed.setObjCliente(objCliente);
                objPed.setObjDir(objDir);
                objPed.setEstado(estado);
                objPed.setTotal(total);

                //Se llama a la funcion que se encarga de cordinar con la base de datos para insertar el pedido 
                if (objLogPed.LogicaInsertarPedido(objPed)) {
                    System.out.println("Pedido insertado con Exito!!");
                } else {
                    System.out.println("No se pudo registrar el Pedido!!");
                }
                //Una vez insertado lo extraemos nuevamente para saber su ID
                Pedido ped = objLogPed.LogicaExtraerPedido(objCliente);

                // Con este obj con su ID procedemos a setearlo al objeto que teniamos antes
                objPed.setCod_Pedido(ped.getCod_Pedido());

                //Y ese mismo objeto lo guardamos en el historial pedido ya que este contiene objeto de tipo pedido
                objHistPed.setObjPedido(objPed);

                //Se insertar en la base de datos y si todo sale bien se muestra el mensaje de exito
                if (objLogPed.InsertarHistorial_Pedido(objHistPed)) {
                    System.out.println("Historial_Pedido insertado con Exito!!");
                }

                //Aqui llenamos el atributo pedido de la clase Producto_Pedido para saber que poductos pertenecen a que pedido
                for (Producto_Pedido prodPed : lista_ProdPed) {
                    prodPed.setObjPed(objPed);
                }

                //Una vez terminado el ciclo se inserta en la base de datos
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
