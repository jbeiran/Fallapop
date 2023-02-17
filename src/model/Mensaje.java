package model;

import java.util.Date;

public class Mensaje {

    public String emisor;
    public String receptor;
    public String contenido;
    public Date date;

    public Mensaje(String emisor, String receptor, String contenido, Date date) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.contenido = contenido;
        this.date = date;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }   

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "emisor=" + emisor + ", receptor=" + receptor + ", contenido=" + contenido + ", date=" + date + '}';
    }   
}