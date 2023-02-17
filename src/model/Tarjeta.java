package model;

public class Tarjeta extends MetodoDePago {

    public String numero;
    public String titular;
    public String CVC;

    public Tarjeta(Double saldo, String numero, String titular, String CVC) {
        super(saldo);
        this.numero = numero;
        this.titular = titular;
        this.CVC = CVC;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void pagar(Double monto) {
        this.saldo -= monto;
    }
}
