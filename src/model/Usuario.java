package model;

import java.util.ArrayList;

public class Usuario implements Persona{
    private String nombreDeUsuario;
    private String nombre;
    private String telefono;
    private String contr;
    
    private Monedero monedero;
    private ArrayList<Compra> historial = new ArrayList<>();
    
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
    
    @Override
    public String getNombre(){
        return nombre;
    }
}
