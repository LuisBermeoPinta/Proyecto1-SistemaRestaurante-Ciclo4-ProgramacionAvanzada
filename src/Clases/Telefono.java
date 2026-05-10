
package Clases;


public class Telefono {
    
    private int id_Telefono;
    private String tipo;
    private String num_Telefono;

    public Telefono(int id_Telefono, String tipo, String num_Telefono) {
        this.id_Telefono = id_Telefono;
        this.tipo = tipo;
        this.num_Telefono = num_Telefono;
    }

    public Telefono(String tipo, String num_Telefono) {
        this.tipo = tipo;
        this.num_Telefono = num_Telefono;
    }

    public int getId_Telefono() {
        return id_Telefono;
    }

    public void setId_Telefono(int id_Telefono) {
        this.id_Telefono = id_Telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNum_Telefono() {
        return num_Telefono;
    }

    public void setNum_Telefono(String num_Telefono) {
        this.num_Telefono = num_Telefono;
    }
    
    
    
}
