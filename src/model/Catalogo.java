package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalogo {
    ArrayList<Producto> productos;

    public Catalogo(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> buscar(String s){
        String busqueda = s.toLowerCase();

        return productos
            .stream()
            .filter(producto -> producto.getNombre().toLowerCase().startsWith(busqueda))
            .collect(Collectors.toList());
    }
}
