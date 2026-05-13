
package Clases;

import java.util.ArrayList;


public class Cliente {
    
    private int id_Cliente;
    private String nombre;
    private String cedula;
    private ArrayList<Direccion> direcciones;
    private ArrayList<Telefono> telefonos;
    private ArrayList<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(int id_Cliente, String nombre, String cedula) {
        this.id_Cliente = id_Cliente;
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    

    public Cliente(String nombre, String cedula, ArrayList<Direccion> direccion, ArrayList<Telefono> telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direcciones = direccion;
        this.telefonos = telefono;
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

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
}
