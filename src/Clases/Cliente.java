
package Clases;

import java.util.ArrayList;


public class Cliente {
    
    private int id_Cliente;
    private String nombre;
    private String cedula;
    private ArrayList<Direccion> direccion;
    private ArrayList<Telefono> telefono;
    private ArrayList<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, ArrayList<Direccion> direccion, ArrayList<Telefono> telefono, ArrayList<Pedido> pedidos) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pedidos = pedidos;
    }
    

    public Cliente(int id_Cliente, String nombre) {
        this.id_Cliente = id_Cliente;
        this.nombre = nombre;
    }

    public Cliente(int id_Cliente, String nombre, String cedula, ArrayList<Direccion> direccion, ArrayList<Telefono> telefono, ArrayList<Pedido> pedidos) {
        this.id_Cliente = id_Cliente;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pedidos = pedidos;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<Direccion> direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Telefono> getTelefono() {
        return telefono;
    }

    public void setTelefono(ArrayList<Telefono> telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
}
