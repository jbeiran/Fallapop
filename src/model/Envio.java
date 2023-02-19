
package model;


public class Envio {
    private Direccion direccion;
    private MetodoDeEnvio metodoDeEnvio;

    public Envio(Direccion direccion, MetodoDeEnvio metodoDeEnvio) {
        this.direccion = direccion;
        this.metodoDeEnvio = metodoDeEnvio;
    }

    @Override
    public String toString() {
        return "Dirección: " + direccion + ", Método de envío: " + metodoDeEnvio;
    }
}
