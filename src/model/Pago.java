package model;

public class Pago {

    private MetodoDePago metodo;

    public Pago(MetodoDePago metodo) {
        this.metodo = metodo;
    }

    public MetodoDePago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoDePago metodo) {
        this.metodo = metodo;
    }

    public void pagar(Double monto) {
        metodo.pagar(monto);
    }

}