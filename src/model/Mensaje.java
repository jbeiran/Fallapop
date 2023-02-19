package model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Mensaje {
    private String contenido;
    private LocalTime hora;
    
    private Persona emisor;

    public Mensaje(String contenido, LocalTime hora, Persona emisor) {
        this.contenido = contenido;
        this.hora = hora.truncatedTo(ChronoUnit.MINUTES);
        this.emisor = emisor;
    }   

    @Override
    public String toString() {
        return "[ " + hora.toString() + " ] " + emisor.getNombre() + ": " + contenido;
    }
}
