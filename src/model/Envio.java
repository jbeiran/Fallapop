package model;

import java.util.ArrayList;

public class Envio {

    public String empresa;
    public ArrayList<Direccion> direcciones;

    public Envio(String empresa) {
        this.empresa = empresa;
        direcciones = new ArrayList<Direccion>();
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public void addDireccion(Direccion direccion) {
        direcciones.add(direccion);
    }

    public void removeDireccion(int i) {
        direcciones.remove(i);
    }

    public Direccion verDireccion(int i) {
        return direcciones.get(i);
    }

    public ArrayList<Direccion> numDirecciones() {
        return direcciones;
    }

    @Override
    public String toString() {
        return "Envio{" + "empresa=" + empresa + '}';
    }
    
}
