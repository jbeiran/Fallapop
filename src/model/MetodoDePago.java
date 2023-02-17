package model;

public class MetodoDePago {

    public Double saldo;

    public MetodoDePago(Double saldo) {
        this.saldo = saldo;
    }

    public void pagar(Double monto) {
        this.saldo -= monto;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
