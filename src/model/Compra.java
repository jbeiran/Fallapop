package model;

public class Compra {
    private Pago pago;
    private Producto producto;
    private Envio envio;

    public Compra(Pago pago, Producto producto, Envio envio) {
        this.pago = pago;
        this.producto = producto;
        this.envio = envio;
    }
    
    
}
