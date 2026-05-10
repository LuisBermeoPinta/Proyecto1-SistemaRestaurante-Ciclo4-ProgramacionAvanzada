
package Clases;


public class Producto {
    
    private int id_Producto;
    private String nombre;
    private double precio;

    public Producto() {
    }
    

    public Producto(int id_Producto, String nombre, double precio) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

    
    
    
}
