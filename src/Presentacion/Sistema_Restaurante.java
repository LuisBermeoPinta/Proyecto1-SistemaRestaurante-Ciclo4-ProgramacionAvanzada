    
package Presentacion;

import Clases.*;
import Logica.LogCliente;
import Logica.LogPed;
import Logica.LogProd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Sistema_Restaurante {
        
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        
        //Objetos del Paquete Logica
        LogCliente objLogCliente = new LogCliente();
        LogProd objLogProd = new LogProd();
        LogPed objLogPed = new LogPed();
        
        //Objetos del paquete Clases
        Cliente objCliente = new Cliente();
        Direccion objDir = new Direccion();
        Telefono objTelf = new Telefono();
        
        
        
        Sistema_Restaurante app = new Sistema_Restaurante();
        
        app.MostrarMenuPrincipal(sc, objCliente, objDir, objTelf, objLogCliente, objLogProd);
        
        
        byte opcion;
        
        //Creacion del Objetos Producto
        ArrayList<Producto> objProductos = new ArrayList<>();
        objProductos.add(new Producto("Papas", 1.25));
        objProductos.add(new Producto("Refresco", 1.00));        
        objProductos.add(new Producto("Hamburguesa", 2.50));
        objProductos.add(new Producto("Hot dog", 2.00));
        objProductos.add(new Producto("Pizza", 4.00));
        objProductos.add(new Producto("Alitas BBQ", 3.00));
        
        /*for(Producto prod: objProductos){
            objLogicaProducto.InsertarLogicaProducto(prod);
        }
*/
        
       
        
        
        
        //Creacion del Objeto Direccion
        /*ArrayList<Direccion> objDireccion = new ArrayList<>();
        objDireccion.add(new Direccion(1, "Paris", "Paltas"));
        
        //Creacion del Objeto Telefomo
        ArrayList<Telefono> objTelefono = new ArrayList<>();
        objTelefono.add(new Telefono(1, "Casa", "1234567890"));    
        
        //Creacion del Objeto Pedido
        
        
        //Creacion del Objeto Cliente
        Cliente objCliente = new Cliente("Luis", "1105606659", objDireccion, objTelefono);
        
    
        
        
            System.out.println("Sistema de Gestion de Pedidos");
            System.out.println("1) Rol de Administrador");
            System.out.println("2) Rol de Cocinero");
            System.out.println("3) Rol de Repartidor");
            System.out.print("Ingrese su Eleccion: ");
            opcion = sc.nextByte(); 
            sc.nextLine();
            

        
        
        
        switch(opcion){
            case 1:
                ArrayList<Direccion> direcciones = new ArrayList<>();  
                ArrayList<Telefono> telefonos = new ArrayList<>();
                ArrayList<Pedido> pedidos = new ArrayList<>();
                String calle1;
                String calle2;
                String tipo;
                String numTelf;
                int eleccion;
                
                
                do{
                   

                }while(eleccion != 0);        
                objLogicaCliente.InsertarLogicaDireccion(objCliente, direcciones);
                
                    System.out.println("Telefono: ");
                    System.out.print("Nombre: ");
                    tipo = sc.nextLine();
                    System.out.print("Numero de Telefono: ");
                    numTelf = sc.nextLine();
                    System.out.print("Presiona 0 para Salir o cualquier otro numero si desea ingresar otro telefono: ");
                    eleccion = sc.nextInt();
                    sc.nextLine();
                    Telefono objTelefono = new Telefono(tipo, numTelf);
                    telefonos.add(objTelefono);            

                objLogicaCliente.InsertarLogicaTelefono(objCliente, telefonos);

                Pedido objPedido = new Pedido("En Proceso");
                objLogicaPedido.InsertarLogicaPedido(objPedido, objCliente);

                app.MostrarMenuGeneral(objPedido, objCliente);
                
                
                int elecccionCliente = 0;
                ArrayList<Cliente> lista_Cliente = objLogicaCliente.ExtraerLogicaClientes();
                System.out.println("Identificador          Nombre                   Cedula");
                for(Cliente client: lista_Cliente){
                    System.out.println("       " + client.getId_Cliente() + client.getNombre() + client.getCedula());
                }
                System.out.println("Selecione el Cliente: ");
                elecccionCliente = sc.nextInt();
                //objLogicaCliente.InsertarLogicaDireccion(objCliente, objDireccion)
              
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
              
        }
    
        
        
    }
    public void MostrarMenuGeneral(Pedido objPedido, Cliente objCliente) throws ClassNotFoundException, SQLException{
        
        //La lista de productos extraida de la base de datos
        ArrayList<Producto> listaProductos = objLogicaProducto.ExtraerLogicaProducto();
        ArrayList<Byte> prod_Elegidos = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();  
        Cliente objCliente = new Cliente();
        
        byte eleccion = 0;
        int cantidad = 0;
        do{
            System.out.println("\nProductos Disponibles");
            System.out.println("ID " + "    Nombre        " + "Precio       ");
            for(Producto prod: listaProductos){
                System.out.printf("%-1d %7s %4.2f %n",prod.getId_Producto(), prod.getNombre(), prod.getPrecio());  
            }
            System.out.println("0 " + "Salir");
            System.out.print("Ingrese su Eleccion: ");
            eleccion = sc.nextByte();
            
            if(eleccion != 0){
                System.out.println("Ingrese la Cantidad que desea: ");
                cantidad = sc.nextInt();  
            }
            prod_Elegidos.add(eleccion);
            cantidades.add(cantidad);

        }while(eleccion != 0);
        if(objLogicaProducto.InsertarLogicaPedidoProducto(objPedido, prod_Elegidos, cantidades, objCliente)){
            System.out.println("No se");
        }
*/
    }



    
    public void MostrarMenuPrincipal(Scanner sc, Cliente objCliente, Direccion objDir, Telefono objTelf, LogCliente objLogCliente, LogProd objLogProd) throws ClassNotFoundException, SQLException{
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
                    MostrarMenuAdministrador(sc, objCliente, objDir, objTelf, objLogCliente, objLogProd);
                    break;
                case 2:
                    MostrarMenuCocinero(sc);
                    break;
                case 3:
                    MostrarMenuRepartidor(sc);
                    break;

                case 4:
                    MostrarMenuCliente(sc);
                    break;
                default: 
                    System.out.println("Opcion no Valida!");
            }
            
        }while(eleccion != 0);
        
    }
    
    public void MostrarMenuAdministrador(Scanner sc, Cliente objCliente, Direccion objDir, Telefono objTelf, LogCliente objLogCliente, LogProd objLogProd) throws ClassNotFoundException, SQLException{
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

                    System.out.println("\nDATOS DEL CLIENTE");
                    System.out.print("Nombre: ");
                    objCliente.setNombre(sc.nextLine());

                    System.out.print("Cedula: ");
                    objCliente.setCedula(sc.nextLine());

                    //objLogCliente.InsertarLogicaCliente(objCliente);        

                    break;

                case 2:

                    System.out.println("\nDIRECCION\n");
                    System.out.print("Calle 1: ");
                    objDir.setCalle1(sc.nextLine());

                    System.out.print("Calle 2: ");
                    objDir.setCalle2(sc.nextLine());


                    break;

                case 3:
                    System.out.println("\nTELEFONO\n");
                    System.out.print("Nombre: ");
                    objTelf.setNombre(sc.nextLine());

                    System.out.print("Numero de Telefono: ");
                    objTelf.setNum_Telefono(sc.nextLine());

                    break;
                    
                case 4:
                    RegistrarPedido(sc, objLogCliente, objLogProd);
                    break;
                default: 
                    System.out.println("Saliendo...");
            }    
            
        }while(eleccion != 0);
        
    }
    
    public void MostrarMenuCocinero(Scanner sc){
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
    
    public void MostrarMenuRepartidor(Scanner sc){
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
    
    public void MostrarMenuCliente(Scanner sc){
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
    
    public void MostrarClientes(LogCliente objLogCliente) throws ClassNotFoundException, SQLException{
        ArrayList<Cliente> list_Clientes = objLogCliente.ExtraerLogicaClientes();
        System.out.println("\nLISTA DE CLIENTES\n");
        System.out.printf("%-3S%12S%12S\n", "id", "nombre", "cedula");
        for(Cliente client: list_Clientes){  
            System.out.printf("%-2d%11s%18s\n", client.getId_Cliente(), client.getNombre(), client.getCedula());
        } 
    }  
    
    public void MostrarMenuProductos(LogProd objLogProd) throws ClassNotFoundException, SQLException{
        ArrayList<Producto> lista_Prod = objLogProd.ExtraerLogicaProducto();
        System.out.println("\nLISTA DE PRODUCTOS\n");
        System.out.printf("%-3S%12S%12S\n", "id", "nombre", "precio");
        for(Producto prod: lista_Prod){
            System.out.printf("%-9d%-12s%s\n", prod.getId_Producto(), prod.getNombre(), prod.getPrecio());            
        }
    }
    
    public void RegistrarPedido(Scanner sc, LogCliente objlogCliente, LogProd objLogProd) throws ClassNotFoundException, SQLException{
        int elec_Cliente = 0;
        int elec_Prod = 0;
        MostrarClientes( objlogCliente);
        System.out.print("Selecione el Cliente");
        elec_Cliente = sc.nextInt();
        sc.nextLine();   
        
        MostrarMenuProductos(objLogProd);
        do{
        System.out.print("Selecione un Producto");
        elec_Prod = sc.nextInt();
        sc.nextLine();           
        }while(elec_Prod);
     
    }
}

