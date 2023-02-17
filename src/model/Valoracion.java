package model;

public class Valoracion {

    public String descripcion;
    public Integer estrellas;

    public Valoracion(String descripcion, Integer estrellas) {
        this.descripcion = descripcion;
        this.estrellas = estrellas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }  
}