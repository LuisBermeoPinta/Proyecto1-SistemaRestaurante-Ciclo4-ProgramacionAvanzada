    
package Presentacion;

import Clases.*;
import Logica.LogicaCliente;
import Logica.LogicaPedido;
import Logica.LogicaProducto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Sistema_Restaurante {
    static Scanner sc = new Scanner(System.in);
    static LogicaCliente objLogicaCliente = new LogicaCliente();
    static LogicaProducto objLogicaProducto = new LogicaProducto();
    static LogicaPedido objLogicaPedido = new LogicaPedido();
        
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Sistema_Restaurante app = new Sistema_Restaurante();
        
        
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
        */
    
        
        
            System.out.println("Sistema de Gestion de Pedidos");
            System.out.println("1) Rol de Administrador");
            System.out.println("2) Rol de Cocinero");
            System.out.println("3) Rol de Repartidor");
            System.out.print("Ingrese su Eleccion: ");
            opcion = sc.nextByte();    
            

        
        
        
        switch(opcion){
            case 1:
                ArrayList<Direccion> direcciones = new ArrayList<>();  
                ArrayList<Telefono> telefonos = new ArrayList<>();
                String calle1;
                String calle2;
                String tipo;
                String numTelf;
                
                System.out.print("Datos del Cliente");
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Cedula: ");
                String cedula = sc.nextLine();
                do{
                    System.out.println("Direccion: ");
                    System.out.println("Calle 1: ");
                    calle1 = sc.nextLine();
                    System.out.println("Calle 2: ");
                    calle2 = sc.nextLine();
                    System.out.println("Presiona 0 para Salir: ");
                    Direccion objDireccion = new Direccion(calle1, calle2);
                    direcciones.add(objDireccion);
                }while(sc.nextInt() != 0);                
                
                do{
                    System.out.println("Telefono: ");
                    System.out.println("Nombre: ");
                    tipo = sc.nextLine();
                    System.out.println("Numero de Telefono: ");
                    numTelf = sc.nextLine();
                    System.out.println("Presiona 0 para Salir: ");
                    Telefono objTelefono = new Telefono(tipo, numTelf);
                    telefonos.add(objTelefono);            
                }while(sc.nextInt() != 0);  
                
                Cliente objCliente = new Cliente(nombre, cedula, direcciones, telefonos);
                objLogicaCliente.InsertarLogicaCliente(objCliente);
                
                app.MostrarMenu(objPedidos);
                
                
                /*int elecccionCliente = 0;
                ArrayList<Cliente> lista_Cliente = objLogicaCliente.ExtraerLogicaClientes();
                System.out.println("Identificador          Nombre                   Cedula");
                for(Cliente client: lista_Cliente){
                    System.out.println("       " + client.getId_Cliente() + client.getNombre() + client.getCedula());
                }
                System.out.println("Selecione el Cliente: ");
                elecccionCliente = sc.nextInt();*/
                objLogicaCliente.InsertarLogicaDireccion(objCliente, objDireccion)
                
                app.MostrarMenu();                  
                
                //objLogicaCliente.InsertarLogicaCliente(objCliente)
                if(true){
                    System.out.println("Cliente registrado con Exito!\n");
                    ArrayList<Pedido> objPedidos = new ArrayList<>();
                    objPedidos.add(new Pedido("En Curso", "Mi Casa"));   
                    
                    if(objLogicaPedido.InsertarLogicaPedido(objPedidos.get(0))){
                        System.out.println("Pedido insertado con Exito!\n");
                        app.MostrarMenu(objPedidos);                      
                    }else{
                        System.out.println("No se puede registrar el pedido");
                    }              
                
                }else{
                    System.out.println("No se puedo registrar al Cliente");
                }
                
                
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
    public void MostrarMenu() throws ClassNotFoundException, SQLException{
        ArrayList<Pedido> objPedidos = new ArrayList<>();
        
        //La lista de productos extraida de la base de datos
        ArrayList<Producto> listaProductos = objLogicaProducto.ExtraerLogicaProducto();
        ArrayList<Producto> prod_Elegidos = new ArrayList<>();
        byte eleccion = 0;
        int cantidad = 0;
        do{
            System.out.println("Productos Disponibles");
            System.out.println("Indentificador " + "Nombre        " + "Precio       ");
            for(Producto prod: listaProductos){
                System.out.println("           " + prod.getId_Producto() + ") " + prod.getNombre() + "        " + prod.getPrecio());  
            }
            System.out.println("0 " + "Salir");
            System.out.print("Ingrese su Eleccion: ");
            eleccion = sc.nextByte();
            System.out.println("Ingrese la Cantidad que desea: ");
            cantidad = sc.nextInt();      
            
            
            
            if(eleccion != 0){
            }

            prod_Elegidos.get(eleccion - 1);
            ArrayList<Integer> cantidades = new ArrayList<>();
            cantidades.add(cantidad);

            for(Pedido ped: objPedidos){
                for(Producto prodEleg: prod_Elegidos){
                    objLogicaProducto.InsertarLogicaPedidoProducto(ped, prodEleg, cantidades);            

                }
            }
        }while(eleccion != 0);
    }
}

