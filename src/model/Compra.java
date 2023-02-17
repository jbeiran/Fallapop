package model;

public class Compra {

    public Pago pago;
    public Envio envio;
    public Estado estado;

    public Compra(Pago pago, Envio envio, Estado estado) {
        this.pago = pago;
        this.envio = envio;
        this.estado = estado;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }    
}

