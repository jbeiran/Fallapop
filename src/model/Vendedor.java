package model;

public class Vendedor {

    public String nombre;
    public String telefono;
    public Producto[] productos; 

    public Vendedor(String nombre, String telefono, Producto[] productos) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }    
}