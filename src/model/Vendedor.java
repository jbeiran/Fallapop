
package model;

import java.util.ArrayList;

public class Vendedor implements Persona{
    private String nombre;
    private String telefono;
    
    private ArrayList<Valoracion> valoraciones = new ArrayList<>();

    public Vendedor(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    @Override
    public String getNombre(){
        return nombre;
    }
}
