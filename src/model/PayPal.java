package model;

public class PayPal extends MetodoDePago {

    public String usuario;
    public String contrasena;
    public String telefono;

    public PayPal(Double saldo,String usuario, String contrasena, String telefono) {
        super(saldo);
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void pagar(Double monto) {
        saldo -= monto;
    }
    
}