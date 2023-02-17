package model;

public class Usuario {
    
    public String nombre;
    public String telefono;
    public Monedero monedero;
    public PayPal paypal[];
    public Tarjeta tarjeta[]; 
    public HistorialDeCompras historialDeCompras;

    public Usuario(String nombre, String telefono, Monedero monedero, PayPal paypal[], Tarjeta tarjeta[], HistorialDeCompras historialDeCompras) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.monedero = monedero;
        this.paypal = paypal;
        this.tarjeta = tarjeta;
        this.historialDeCompras = historialDeCompras;
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

    public Monedero getMonedero() {
        return monedero;
    }

    public void setMonedero(Monedero monedero) {
        this.monedero = monedero;
    }

    public PayPal[] getPaypal() {
        return paypal;
    }   

    public void setPaypal(PayPal[] paypal) {
        this.paypal = paypal;
    }

    public Tarjeta[] getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta[] tarjeta) {
        this.tarjeta = tarjeta;
    }

    public HistorialDeCompras getHistorialDeCompras() {
        return historialDeCompras;
    }

    public void setHistorialDeCompras(HistorialDeCompras historialDeCompras) {
        this.historialDeCompras = historialDeCompras;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", telefono=" + telefono + ", monedero=" + monedero + ", paypal=" + paypal + ", tarjeta=" + tarjeta + ", historialDeCompras=" + historialDeCompras + '}';
    }

}
