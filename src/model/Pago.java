package model;

public class Pago {
    private double importe;
    
    private MetodoDePago metodoDePago;
    private CodigoDePromocion codigoDePromocion;
    
    public Pago(double importe, MetodoDePago metodoDePago) {
        this.importe = importe;
        this.metodoDePago = metodoDePago;
        this.codigoDePromocion = null;
    }

    public Pago(
        double importe, 
        MetodoDePago metodoDePago, 
        CodigoDePromocion codigoDePromocion
    ) {
        this.importe = importe;
        this.metodoDePago = metodoDePago;
        this.codigoDePromocion = codigoDePromocion;
    }
}
