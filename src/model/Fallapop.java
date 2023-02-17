package model;
import java.util.ArrayList;

public class Fallapop {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Producto> productos;
    private ArrayList<Compra> compras;

    public Fallapop() {
        usuarios = new ArrayList<Usuario>();
        productos = new ArrayList<Producto>();
        compras = new ArrayList<Compra>();
    }

    public void addUsuario(String nombre, String telefono, Monedero monedero, PayPal paypal[], Tarjeta tarjeta[], HistorialDeCompras historialDeCompras) {
        Usuario usuario = new Usuario(nombre, telefono, monedero, paypal, tarjeta, historialDeCompras);
        usuarios.add(usuario);
    }

    public void addProducto(String nombre, Double precio, String descripcion) {
        Producto producto = new Producto(nombre, precio, descripcion);
        productos.add(producto);
    }

    public void addCompra(Pago pago, Envio envio, Estado estado) {
        Compra compra = new Compra(pago, envio, estado);
        compras.add(compra);
    }

    public void removeUsuario(int i) { usuarios.remove(i);}

    public void removeProducto(int i) { productos.remove(i); }

    public void removeCompra(int i) { compras.remove(i); }

    public Usuario verUsuario(int i) { return usuarios.get(i); }

    public Producto verProducto(int i) { return productos.get(i); }

    public Compra verCompra(int i) { return compras.get(i); }

    public ArrayList<Usuario> numUsuarios() { return usuarios; }

    public ArrayList<Producto> numProductos() { return productos; }

    public ArrayList<Compra> numCompras() { return compras; }

    public void setUsuarios(ArrayList<Usuario> usuarios) { this.usuarios = usuarios; }

    public void setProductos(ArrayList<Producto> productos) { this.productos = productos; }

    public void setCompras(ArrayList<Compra> compras) { this.compras = compras; }

    public ArrayList<Usuario> getUsuarios() { return usuarios; }

    public ArrayList<Producto> getProductos() { return productos; }

    public ArrayList<Compra> getCompras() { return compras; }
    
}