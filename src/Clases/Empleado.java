package Clases;

import java.util.ArrayList;


public class Empleado {
    private int id_Empleado;
    private String nombre;
    private String rol;
    private ArrayList<Pedido> pedidos;

    public Empleado(int id_Empleado, String nombre, String rol, ArrayList<Pedido> pedidos) {
        this.id_Empleado = id_Empleado;
        this.nombre = nombre;
        this.rol = rol;
        this.pedidos = pedidos;
    }

    public Empleado(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
    
    
    
}
