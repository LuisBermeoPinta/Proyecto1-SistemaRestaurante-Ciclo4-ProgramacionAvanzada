
package Clases;


public class Telefono {
    
    private int id_Telefono;
    private String nombre;
    private String num_Telefono;

    public Telefono() {
    }

    public Telefono(int id_Telefono, String nombre, String num_Telefono) {
        this.id_Telefono = id_Telefono;
        this.nombre = nombre;
        this.num_Telefono = num_Telefono;
    }

    public Telefono(String nombre, String num_Telefono) {
        this.nombre = nombre;
        this.num_Telefono = num_Telefono;
    }

    public int getId_Telefono() {
        return id_Telefono;
    }

    public void setId_Telefono(int id_Telefono) {
        this.id_Telefono = id_Telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_Telefono() {
        return num_Telefono;
    }

    public void setNum_Telefono(String num_Telefono) {
        this.num_Telefono = num_Telefono;
    }
    
    
    
}
