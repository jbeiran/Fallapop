
package model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor implements Persona{
    private String nombre;
    private String telefono;
    
    private ArrayList<Valoracion> valoraciones = new ArrayList<>();

    public Vendedor(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void añadirValoracion(Valoracion valoracion){
        valoraciones.add(valoracion);
    }

    public String getTelefono(){
        return telefono;
    }
    
    @Override
    public String getNombre(){
        return nombre;
    }
}
