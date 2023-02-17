package model;

public class Monedero extends MetodoDePago {

    public Monedero(Double saldo) {
        super(saldo);
    }

    @Override
    public void pagar(Double monto) {
        saldo -= monto;
    }
}