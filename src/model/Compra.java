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

    public Compra(Pago pago, Producto producto) {
        this.pago = pago;
        this.producto = producto;
        this.envio = null;
    }
    
    public Producto getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(producto.toString());
        sb.append(" | ");

        sb.append(pago.toString());

        if(envio != null){
            sb.append(" | ");
            sb.append(envio.toString());
        }

        return sb.toString();
    }
}

