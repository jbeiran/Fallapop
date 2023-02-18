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
            double sueldo
    ){
        this.nombre = nombre;
        this.telefono = telefono;
        this.contr = contr;
        this.monedero = new Monedero(sueldo);
    }
    
    @Override
    public String getNombre(){
        return nombre;
    }
}
