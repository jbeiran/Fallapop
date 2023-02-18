package model;


public class CodigoDePromocion {
    private String codigo;
    private double descuento;

    public CodigoDePromocion(String codigo, double descuento) {
        if(descuento < 0.0 || descuento > 1.0)
            throw new IllegalArgumentException(
                "El porcentaje de descuento se debe especificar entre 0.0 y 1.0"
            );
        
        this.codigo = codigo;
        this.descuento = descuento;
    }
}
