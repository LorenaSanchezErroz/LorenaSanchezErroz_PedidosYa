package javabeans;

import java.io.Serializable;

public class Pedido implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String id;
    private int clienteId;
    private String producto;
    private int cantidad;

    public Pedido() {
    }

    public Pedido(String id, int clienteId, String producto, int cantidad) {
        this.id = id;
        this.clienteId = clienteId;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %d\n", id, clienteId, producto, cantidad);
    }
}
