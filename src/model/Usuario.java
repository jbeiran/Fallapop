package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements Persona{
    private String nombreDeUsuario;
    private String nombre;
    private String telefono;
    private String contr;
    
    private Monedero monedero;
    private ArrayList<Compra> historial = new ArrayList<>();
    private ArrayList<Producto> favoritos = new ArrayList<>();
    
    public Usuario(
            String nombreDeUsuario, 
            String nombre, 
            String telefono, 
            String contr, 
            double saldo
    ){
        this.nombreDeUsuario = nombreDeUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contr = contr;
        this.monedero = new Monedero(saldo);
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public String getContr() {
        return contr;
    }

    public Monedero getMonedero() {
        return monedero;
    }

    public boolean añadirFavorito(Producto favorito){
        if(!favoritos.contains(favorito))
            return favoritos.add(favorito);

        return false;
    }

    public boolean hacerCompra(Compra compra, boolean monedero){

        if(monedero){
            if(this.monedero.pagar(compra.getProducto().getPrecio())) {
                historial.add(compra);
                return true;
            } else {
                return false;
            }
        }

        historial.add(compra);
        return true;
    }


    public boolean eliminarFavorito(Producto favorito){
        return favoritos.remove(favorito);
    }

    public List<Producto> getFavoritos(){
        return favoritos;
    }
    
    @Override
    public String getNombre(){
        return nombre;
    }
}
