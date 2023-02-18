
package model;


public class Valoracion {
    private String description;
    private Integer estrellas;
    
    private Usuario publicador;

    public Valoracion(String description, Integer estrellas, Usuario publicador) {
        if(estrellas < 1 || estrellas > 5)
            throw new IllegalArgumentException(
                    "Las estrellas deben estar entre 1 y 5"
            );
        
        this.description = description;
        this.estrellas = estrellas;
        this.publicador = publicador;
    }
}
