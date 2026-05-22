
package Clases;


public class Direccion {
  
    private int id_Direccion;
    private Cliente objCliente;
    private String calle1;
    private String calle2;

    public Direccion() {
    }

    public Direccion(int id_Direccion, Cliente objCliente, String calle1, String calle2) {
        this.id_Direccion = id_Direccion;
        this.objCliente = objCliente;
        this.calle1 = calle1;
        this.calle2 = calle2;
    }
    
    
    public Direccion(int id_Direccion, String calle1, String calle2) {
        this.id_Direccion = id_Direccion;
        this.calle1 = calle1;
        this.calle2 = calle2;
    }

    public Direccion(String calle1, String calle2) {
        this.calle1 = calle1;
        this.calle2 = calle2;
    }
    

    public int getId_Direccion() {
        return id_Direccion;
    }

    public void setId_Direccion(int id_Direccion) {
        this.id_Direccion = id_Direccion;
    }

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }
    
    
        
        
    
}
