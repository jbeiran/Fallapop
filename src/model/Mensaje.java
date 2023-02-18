package model;

import java.time.LocalDate;

public class Mensaje {
    private String contenido;
    private LocalDate fecha;
    
    private Persona emisor;

    public Mensaje(String contenido, LocalDate fecha, Persona emisor) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.emisor = emisor;
    }   
}
