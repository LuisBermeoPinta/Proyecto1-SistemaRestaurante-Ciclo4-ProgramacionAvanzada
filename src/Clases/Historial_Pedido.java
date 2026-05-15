
package Clases;


public class Historial_Pedido {
    private int id_Historial;
    private Pedido objPedido;
    private String estado;

    public Historial_Pedido() {
    }

    public Historial_Pedido(int id_Historial, Pedido objPedido, String estado) {
        this.id_Historial = id_Historial;
        this.objPedido = objPedido;
        this.estado = estado;
    }

    public int getId_Historial() {
        return id_Historial;
    }

    public void setId_Historial(int id_Historial) {
        this.id_Historial = id_Historial;
    }

    public Pedido getObjPedido() {
        return objPedido;
    }

    public void setObjPedido(Pedido objPedido) {
        this.objPedido = objPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
