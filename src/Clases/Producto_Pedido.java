
package Clases;


public class Producto_Pedido {
    private Pedido objPed;
    private Producto objProd;
    private int cantidad;

    public Producto_Pedido() {
    }
    

    public Producto_Pedido(Pedido objPed, Producto objProd, int cantidad) {
        this.objPed = objPed;
        this.objProd = objProd;
        this.cantidad = cantidad;
    }


    public Pedido getObjPed() {
        return objPed;
    }


    public void setObjPed(Pedido objPed) {
        this.objPed = objPed;
    }


    public Producto getObjProd() {
        return objProd;
    }


    public void setObjProd(Producto objProd) {
        this.objProd = objProd;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
}
