    
package Presentacion;

import Clases.*;
import Logica.LogicaCliente;
import Logica.LogicaProducto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Sistema_Restaurante {
    static Scanner sc = new Scanner(System.in);
    static LogicaCliente objLogicaCliente = new LogicaCliente();
    static LogicaProducto objLogicaProducto = new LogicaProducto();
        
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
        
        for(Producto prod: objProductos){
            objLogicaProducto.InsertarLogicaProducto(prod);
        }
        
       
        
        
        
        //Creacion del Objeto Direccion
        ArrayList<Direccion> objDireccion = new ArrayList<>();
        objDireccion.add(new Direccion(1, "Paris", "Paltas"));
        
        //Creacion del Objeto Telefomo
        ArrayList<Telefono> objTelefono = new ArrayList<>();
        objTelefono.add(new Telefono(1, "Casa", "1234567890"));    
        
        //Creacion del Objeto Pedido
        ArrayList<Pedido> objPedidos = new ArrayList<>();
        objPedidos.add(new Pedido("En Curso", 12.0, "Mi Casa", "Viernes 29 de Junio a las 12:30", objProductos));
        
        
        //Creacion del Objeto Cliente
        Cliente objCliente = new Cliente("Luis", "1105606659", objDireccion, objTelefono, objPedidos);
    
        
        
            System.out.println("Sistema de Gestion de Pedidos");
            System.out.println("1) Rol de Administrador");
            System.out.println("2) Rol de Cocinero");
            System.out.println("3) Rol de Repartidor");
            System.out.print("Ingrese su Eleccion: ");
            opcion = sc.nextByte();    
            

        
        
        
        switch(opcion){
            case 1:
                if(objLogicaCliente.InsertarLogicaCliente(objCliente)){
                    System.out.println("Cliente registrado con Exito!\n");
                    app.MostrarMenu();                
                
                
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
        ArrayList<Producto> listaProductos = objLogicaProducto.ExtraerLogicaProducto();
        System.out.println("Productos Disponibles");
        System.out.println("Indentificador " + "Nombre        " + "Precio       ");
        for(Producto prod: listaProductos){
            System.out.println(prod.getId_Producto() + ") " + prod.getNombre() + "        " + prod.getPrecio());  
        }
        System.out.println("0 " + "Salir");
        System.out.print("Ingrese su Eleccion: ");
        byte eleccion = sc.nextByte();
        ArrayList<Producto> prod_Elegidos = new ArrayList<>();
        prod_Elegidos.get(eleccion);
        
    }
}

