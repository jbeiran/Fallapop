package model;

public enum MetodoDeEnvio {
    CORREO("Correo"),
    SEUR("Seur");
    
    private final String nombre;

    private MetodoDeEnvio(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
