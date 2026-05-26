
package Clases;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
    private int cod_Pedido;
    private Cliente objCliente;
    private String estado;    
    private double total;
    private String receptor;
    private Direccion objDir;
    private LocalDateTime fecha_Hora_Entrega;
    private ArrayList<Producto_Pedido> objProdPed;

    public Pedido() {
    }

    public Pedido(int cod_Pedido, Cliente objCliente, String estado, double total, String receptor, Direccion objDir, LocalDateTime fecha_Hora_Entrega, ArrayList<Producto_Pedido> objProdPed) {
        this.cod_Pedido = cod_Pedido;
        this.objCliente = objCliente;
        this.estado = estado;
        this.total = total;
        this.receptor = receptor;
        this.objDir = objDir;
        this.fecha_Hora_Entrega = fecha_Hora_Entrega;
        this.objProdPed = objProdPed;
    }

    public int getCod_Pedido() {
        return cod_Pedido;
    }

    public void setCod_Pedido(int cod_Pedido) {
        this.cod_Pedido = cod_Pedido;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
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

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public Direccion getObjDir() {
        return objDir;
    }

    public void setObjDir(Direccion objDir) {
        this.objDir = objDir;
    }

    public LocalDateTime getFecha_Hora_Entrega() {
        return fecha_Hora_Entrega;
    }

    public void setFecha_Hora_Entrega(LocalDateTime fecha_Hora_Entrega) {
        this.fecha_Hora_Entrega = fecha_Hora_Entrega;
    }

    public ArrayList<Producto_Pedido> getObjProdPed() {
        return objProdPed;
    }

    public void setObjProdPed(ArrayList<Producto_Pedido> objProdPed) {
        this.objProdPed = objProdPed;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cod_Pedido=" + cod_Pedido + ", objCliente=" + objCliente + ", estado=" + estado + ", total=" + total + ", receptor=" + receptor + ", objDir=" + objDir + ", fecha_Hora_Entrega=" + fecha_Hora_Entrega + ", objProdPed=" + objProdPed + '}';
    }
    

}
