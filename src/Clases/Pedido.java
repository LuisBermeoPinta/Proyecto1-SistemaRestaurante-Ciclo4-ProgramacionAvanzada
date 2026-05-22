
package Clases;

import java.util.ArrayList;

public class Pedido {
    private int cod_Pedido;
    private Cliente objCliente;
    private Empleado objEmpl;
    private String estado;    
    private double total;
    private Direccion objDir;
    private String fecha_Hora_Entrega;
    private ArrayList<Producto_Pedido> objProdPed;

    public Pedido() {
    }

    public Pedido(int cod_Pedido, Cliente objCliente, Empleado objEmpl, String estado, double total, Direccion objDir, String fecha_Hora_Entrega, ArrayList<Producto_Pedido> objProdPed) {
        this.cod_Pedido = cod_Pedido;
        this.objCliente = objCliente;
        this.objEmpl = objEmpl;
        this.estado = estado;
        this.total = total;
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

    public Empleado getObjEmpl() {
        return objEmpl;
    }

    public void setObjEmpl(Empleado objEmpl) {
        this.objEmpl = objEmpl;
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

    public Direccion getObjDir() {
        return objDir;
    }

    public void setObjDir(Direccion objDir) {
        this.objDir = objDir;
    }

    public String getFecha_Hora_Entrega() {
        return fecha_Hora_Entrega;
    }

    public void setFecha_Hora_Entrega(String fecha_Hora_Entrega) {
        this.fecha_Hora_Entrega = fecha_Hora_Entrega;
    }

    public ArrayList<Producto_Pedido> getObjProdPed() {
        return objProdPed;
    }

    public void setObjProdPed(ArrayList<Producto_Pedido> objProdPed) {
        this.objProdPed = objProdPed;
    }

}
