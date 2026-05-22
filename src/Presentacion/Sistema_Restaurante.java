    
package Presentacion;

import BaseDatos.BDPed;
import Clases.*;
import Logica.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Sistema_Restaurante {
    private Scanner sc;  
    private LogCliente objLogCliente;
    private LogProd objLogProd;
    private LogPed objLogPed;
    private BDPed objBDPed;
    //private ArrayList<Producto> lista_Productos;
    
    public Sistema_Restaurante(){
        this.sc = new Scanner(System.in);
        this.objLogCliente = new LogCliente();
        this.objLogProd = new LogProd();
        this.objBDPed = new BDPed();
        this.objLogPed = new LogPed(objBDPed);
    
    }

        
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Sistema_Restaurante app = new Sistema_Restaurante();
        app.MostrarMenuPrincipal();
        
    }


    public void MostrarMenuPrincipal() throws ClassNotFoundException, SQLException{
        byte eleccion = 0;
        do{
            System.out.println("\nSISTEMA RESTAURANTE\n");
            System.out.println("1) Rol de Administrador");
            System.out.println("2) Rol de Cocinero");
            System.out.println("3) Rol de Repartidor");
            System.out.println("4) Rol de Cliente");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: "); 
            eleccion = sc.nextByte();

            switch(eleccion){
                case 1:
                    MostrarMenuAdministrador();
                    break;
                case 2:
                    MostrarMenuCocinero();
                    break;
                case 3:
                    MostrarMenuRepartidor();
                    break;

                case 4:
                    MostrarMenuCliente();
                    break;
                default: 
                    System.out.println("SALIENDO...");
            }
            
        }while(eleccion != 0);
        
    }
   
    
    public void MostrarMenuAdministrador() throws ClassNotFoundException, SQLException{
        byte eleccion = 0;
        do{
            System.out.println("\nREGISTRO DE CLIENTES\n");
            System.out.println("1) Ingresar Cliente");
            System.out.println("2) Ingresar Direccion");
            System.out.println("3) Ingresar Telefono");
            System.out.println("4) Ingresar Pedido");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: ");  
            eleccion = sc.nextByte();
            sc.nextLine();


            switch(eleccion){
                case 1:
                    Cliente nuevoCliente = PedirDatosCliente();
                 
                    if(objLogCliente.InsertarLogicaCliente(nuevoCliente))
                        System.out.println("Cliente registrado con exito!!");
                    else
                        System.out.println("No se pudo registrar el Cliente!!");

                    break;

                case 2:
                    Cliente clienteConDirecciones = PedirDirCliente();
                    
                    if(objLogCliente.InsertarLogicaDireccion(clienteConDirecciones))
                        System.out.println("Direccion registrada con exito!!");
                    else
                        System.out.println("No se pudo registrar la direccion!!");

                    break;

                case 3:
                    Cliente clienteConTelefonos = PedirTelfCliente();
                     
                    if(objLogCliente.InsertarLogicaTelefono(clienteConTelefonos))
                        System.out.println("Telefono registrado con exito!!");
                    else
                        System.out.println("No se pudo registrar el telefono!!");                    

                    break;
                    
                case 4:
                    RegistrarPedido();
                    break;
                default: 
                    System.out.println("Saliendo...");
            }    
            
        }while(eleccion != 0);
        
    }
    
    public void MostrarMenuCocinero(){
        byte eleccion = 0;
        do{
            System.out.println("1) Consultar Pedidos Pendientes");
            System.out.println("2) Registrar el Estado del Pedido");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: "); 
            eleccion = sc.nextByte();
            sc.nextLine();

            switch(eleccion){
                case 1:
                    MostrarPedidos();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default: 
                    System.out.println("Saliendo...");
            }   
            
        }while(eleccion != 0);
    }
    
    public void MostrarMenuRepartidor(){
        byte eleccion = 0;
        do{
            System.out.println("1) Consultar Pedidos Pendientes");
            System.out.println("2) Registrar el Estado del Pedido");
            System.out.println("3) Confirmar Entrega");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: ");  
            eleccion = sc.nextByte();
            sc.nextLine();

            switch(eleccion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default: 
                    System.out.println("Saliendo...");
            }    
        
        }while(eleccion != 0);
    }
    
    public void MostrarMenuCliente(){
        byte eleccion = 0;
        do{
            System.out.println("1) Consultar el Pedido Actual");
            System.out.println("2) Consultar el Historial del Pedido");
            System.out.println("0) Salir\n");
            System.out.print("Ingrese su Eleccion: ");  
            eleccion = sc.nextByte();
            sc.nextLine();

            switch(eleccion){
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default: 
                    System.out.println("Saliendo...");
            }    
        
        }while(eleccion != 0);
    }
    
    public void MostrarPedidos(){
        
    }
    
    public void MostrarClientes(ArrayList<Cliente> list_Clientes) throws ClassNotFoundException, SQLException{
        System.out.println("\nLISTA DE CLIENTES\n");
        System.out.printf("%-3S%12S%12S\n", "id", "nombre", "cedula");
        for(Cliente client: list_Clientes){  
            System.out.printf("%-2d%11s%18s\n", client.getId_Cliente(), client.getNombre(), client.getCedula());
        } 
    }  
    
    public void MostrarMenuProductos(ArrayList<Producto> lista_Prod) throws ClassNotFoundException, SQLException{
        System.out.println("\nLISTA DE PRODUCTOS\n");
        System.out.printf("%-3S%12S%12S\n", "id", "nombre", "precio");
        for(Producto prod: lista_Prod){
            System.out.printf("%-9d%-12s%s\n", prod.getId_Producto(), prod.getNombre(), prod.getPrecio());            
        }
    }
    
    public void RegistrarPedido() throws ClassNotFoundException, SQLException{
        Pedido objPed = new Pedido();
        Cliente objCliente = new Cliente();
        Producto objProd;
        Producto_Pedido objProdPed;
        Direccion objDir = new Direccion();
        
        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerLogicaClientes();
        ArrayList<Producto> lista_Prod = objLogProd.ExtraerLogicaProducto();
        ArrayList<Producto> prod_Elegidos = new ArrayList<>();
        ArrayList<Producto_Pedido> lista_ProdPed = new ArrayList<>();

        int elec_Cliente = 0;
        int elec_Prod = 0;
        int elec_Dir = 0;
        double total = 0.0;
        String estado = "Pendiente";
        int cant = 0;
        
        //Mostrar Lista de Clientes
        MostrarClientes(list_Clientes);
        
        //Selecionar el Cliente
        System.out.print("\nSelecione el Cliente: ");
        elec_Cliente = sc.nextInt();
        sc.nextLine();  
        
        //Encontrar ese cliente y asignarlo al objCliente
        for(Cliente client: list_Clientes){
            if(client.getId_Cliente() == elec_Cliente){
                objCliente = client;
            }
            
        }
        
        //Mostrar la lista de productos disponibles
        MostrarMenuProductos(lista_Prod); 
        do {
            System.out.print("\nSelecione un Producto: ");
            elec_Prod = sc.nextInt();

            if(elec_Prod != 0){
                // 1. Buscamos el producto primero
                objProd = null; // <--- MODIFICADO: Reiniciamos la referencia
                for(Producto prod: lista_Prod){
                     if(prod.getId_Producto() == elec_Prod){
                         objProd = prod;
                     }
                }

                // 2. Solo si el producto existe, pedimos cantidad y guardamos
                if(objProd != null){
                    prod_Elegidos.add(objProd);

                    // <--- MODIFICADO: Creamos UN SOLO objeto por cada producto seleccionado
                    objProdPed = new Producto_Pedido(); 
                    objProdPed.setObjProd(objProd);

                    System.out.print("Ingrese la Cantidad: ");
                    cant = sc.nextInt();
                    objProdPed.setCantidad(cant);

                    // <--- MODIFICADO: Añadimos a la lista el objeto completo (producto + cantidad)
                    lista_ProdPed.add(objProdPed); 
                } else {
                    System.out.println("Producto no válido.");
                }
            }
        } while(elec_Prod != 0);
        

        ArrayList<Direccion> lista_Dir = objLogCliente.LogicaExtraerDireccion(objCliente);
        MostarDireccionCliente(lista_Dir);
        System.out.print("\nSelecione una Direccion a Entregar: ");
        elec_Dir = sc.nextInt();   
        
        for(Direccion dir: lista_Dir){
             if(dir.getId_Direccion() == elec_Dir){
                objDir = dir;
            }

        }        
        sc.nextLine();                  
             
        
        total = objLogPed.CalcularTotal(prod_Elegidos);
        
        //Insertar Pedido con Datos
        objPed.setObjCliente(objCliente);
        objPed.setObjDir(objDir);
        objPed.setEstado(estado);
        objPed.setTotal(total);
        
        objLogPed.LogicaInsertarPedido(objPed);
        Pedido ped = objLogPed.LogicaExtraerPedido(objCliente);
        objPed.setCod_Pedido(ped.getCod_Pedido());
        
        for(Producto_Pedido prodPed: lista_ProdPed){
            prodPed.setObjPed(objPed);
        }
        
        if(objLogPed.LogicaInsertarProducto_Pedido(lista_ProdPed)){
            System.out.println("Producto_Pedido insertado con Exito");
        }else{
            System.out.println("Producto_Pedido no insertado con Exito");
        }
        
     
    }
    
    public Cliente PedirDatosCliente(){   
        Cliente objCliente = new Cliente();
        System.out.println("\nDATOS DEL CLIENTE");
        System.out.print("Nombre: ");
        objCliente.setNombre(sc.nextLine());

        System.out.print("Cedula: ");
        objCliente.setCedula(sc.nextLine()); 
        
        return objCliente;
    }
    
    public Cliente PedirDirCliente() throws ClassNotFoundException, SQLException{
        Cliente objCliente = new Cliente();
        Direccion objDir;
        ArrayList<Direccion> direcciones = new ArrayList<>();
        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerLogicaClientes();        
        int opcion = 0;
        
        MostrarClientes(list_Clientes);
        
        System.out.print("\nSelecione el Cliente: ");
        opcion = sc.nextInt();
        for(Cliente client: list_Clientes){
            if(client.getId_Cliente() == opcion){
                 objCliente = client;
            }

        }
        sc.nextLine();           
        //if(objLogCliente.ComprobarSiExisteClientes()){
            do{     
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
            }while(opcion != 0);        
            objCliente.setDirecciones(direcciones);        
            
        //}else{
            //System.out.println("No existen Cliente, por favor crear uno!!");
        //}    
        return objCliente;
    }
    
    public Cliente PedirTelfCliente() throws ClassNotFoundException, SQLException{
        Cliente objCliente = new Cliente();
        Telefono objTelf = new Telefono();
        ArrayList<Telefono> telefonos = new ArrayList<>();       
        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerLogicaClientes();   
        int opcion = 0;
        
        MostrarClientes(list_Clientes);    
        System.out.print("\nSelecione el Cliente: ");
        opcion = sc.nextInt();
        for(Cliente client: list_Clientes){
            if(client.getId_Cliente() == opcion){
                 objCliente = client;
            }

        }        
        sc.nextLine();
        
        do{
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
        }while(opcion != 0);
        objCliente.setTelefonos(telefonos); 
        
        return objCliente;
        
    }
    
    public void MostarDireccionCliente(ArrayList<Direccion> lista_Dir){
        System.out.println("\nLISTA DE DIRECCIONES DISPONIBLES\n");
        System.out.printf("%-3S%12S%12S\n", "id", "calle1", "calle2");
        for(Direccion dir: lista_Dir){  
            System.out.printf("%-2d%11s%18s\n", dir.getId_Direccion(), dir.getCalle1(), dir.getCalle2());
        }         
    }
    
    public void RegistrarProductos(ArrayList<Producto> lista_Productos) throws ClassNotFoundException, SQLException{
        if(objLogProd.InsertarLogicaProducto(lista_Productos))
            System.out.println("Productos Ingresados con Exito!!");
        else
            System.out.println("Error no se pudieron ingresar los Productos");

    }
    
    
    
}

