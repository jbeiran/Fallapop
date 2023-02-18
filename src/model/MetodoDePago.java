package model;

public enum MetodoDePago {
    PAYPAL("Paypal"),
    MONEDERO("Monedero"),
    TARJETA_DE_CREDITO("Tarjeta de crédito");
    
    
    private final String nombre;
    
    MetodoDePago(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
