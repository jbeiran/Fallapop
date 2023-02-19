
package model;


public class Valoracion {
    private String descripcion;
    private Integer estrellas;
    
    private Usuario publicador;

    public Valoracion(String descripcion, Integer estrellas, Usuario publicador) {
        if(estrellas < 1 || estrellas > 5)
            throw new IllegalArgumentException(
                    "Las estrellas deben estar entre 1 y 5"
            );
        
        this.descripcion = descripcion;
        this.estrellas = estrellas;
        this.publicador = publicador;
    }

    @Override
    public String toString() {
        return "[ " + estrellas + " estrellas ] " + descripcion + " - " 
            + publicador.getNombre();
    }
}
