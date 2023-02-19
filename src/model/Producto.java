package model;


public class Producto {
    private String nombre;
    private double precio;
    private String descripcion;
    
    private Vendedor vendedor;

    public Producto(String nombre, double precio, String descripcion, Vendedor vendedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.vendedor = vendedor;
    }
    
    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public Vendedor getVendedor(){
        return vendedor;
    }

    @Override
    public String toString(){
        return nombre + " - Precio propuesto: " + precio + " €";
    }
}
