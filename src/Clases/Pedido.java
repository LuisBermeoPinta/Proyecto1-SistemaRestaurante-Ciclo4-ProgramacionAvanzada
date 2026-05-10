
package Clases;

import java.util.ArrayList;

public class Pedido {
    private int cod_Pedido;
    private String estado;    
    private double total;
    private String direccion_Entrega;
    private String fecha_Hora_Entrega;
    private ArrayList<Producto> productos;

    public Pedido() {
    }

    public Pedido(String estado, String direccion_Entrega) {
        this.estado = estado;
        this.direccion_Entrega = direccion_Entrega;
    }
    

    public Pedido(String estado, double total, String direccion_Entrega, String fecha_Hora_Entrega, ArrayList<Producto> productos) {
        this.estado = estado;
        this.total = total;
        this.direccion_Entrega = direccion_Entrega;
        this.fecha_Hora_Entrega = fecha_Hora_Entrega;
        this.productos = productos;
    }
    
    

    
    public Pedido(int cod_Pedido, String estado, double total, String direccion_Entrega, String fecha_Hora_Entrega, ArrayList<Producto> productos) {
        this.cod_Pedido = cod_Pedido;
        this.estado = estado;
        this.total = total;
        this.direccion_Entrega = direccion_Entrega;
        this.fecha_Hora_Entrega = fecha_Hora_Entrega;
        this.productos = productos;
    }

    public Pedido(int cod_Pedido, String estado, double total, ArrayList<Producto> productos) {
        this.cod_Pedido = cod_Pedido;
        this.estado = estado;
        this.total = total;
        this.productos = productos;
    }

    public Pedido(String estado, double total, ArrayList<Producto> productos) {
        this.estado = estado;
        this.total = total;
        this.productos = productos;
    }
    
    

    public int getCod_Pedido() {
        return cod_Pedido;
    }

    public void setCod_Pedido(int cod_Pedido) {
        this.cod_Pedido = cod_Pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDireccion_Entrega() {
        return direccion_Entrega;
    }

    public void setDireccion_Entrega(String direccion_Entrega) {
        this.direccion_Entrega = direccion_Entrega;
    }

    public String getFecha_Hora_Entrega() {
        return fecha_Hora_Entrega;
    }

    public void setFecha_Hora_Entrega(String fecha_Hora_Entrega) {
        this.fecha_Hora_Entrega = fecha_Hora_Entrega;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    
    
    
    
    
    
    
    
            
    
}
