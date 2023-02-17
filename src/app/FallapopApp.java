package app;

import gui.FallapopForm;
import model.Compra;
import model.Direccion;
import model.Envio;
import model.Estado;
import model.Fallapop;
import model.HistorialDeCompras;
import model.MetodoDePago;
import model.Monedero;
import model.Pago;
import model.PayPal;
import model.Tarjeta;

public class FallapopApp {

    private static void inicializar_datos(Fallapop fp){

        MetodoDePago pp1 = new PayPal(100.0, "Juan", "12345", "649186063");

        MetodoDePago pp2 = new PayPal(1000.0, "Pedro", "12335", "649186064");
        MetodoDePago pp3 = new PayPal(50.0, "Maria", "12345", "649186065");

        MetodoDePago monedero1 = new Monedero(100.0);
        MetodoDePago monedero2 = new Monedero(150.0);

        MetodoDePago tarjeta1 = new Tarjeta(100.0, "123456789", "Juan", "123");
        MetodoDePago tarjeta2 = new Tarjeta(1000.0, "123456788", "Pedro", "153");

        Pago pago1 = new Pago(monedero1);
        Pago pago2 = new Pago(pp1);
        Pago pago3 = new Pago(tarjeta1);

        Envio envio1 = new Envio("Correos");
        Envio envio2 = new Envio("Seur");
        Envio envio3 = new Envio("Nacex");

        Direccion direccion1 = new Direccion("Calle 1", 23, 4, "B");
        Direccion direccion2 = new Direccion("Calle 2", 24, 5, "C");
        Direccion direccion3 = new Direccion("Calle 3", 25, 6, "D");

        //Añadir direcciones a envios (1 a 1)
        envio1.addDireccion(direccion1);
        envio2.addDireccion(direccion2);
        envio3.addDireccion(direccion3);
        
        
        //Crear compras
        Compra compra1 = new Compra(pago1, envio1, Estado.PENDIENTE);
        Compra compra2 = new Compra(pago2, envio2, Estado.CANCELADO);
        Compra compra3 = new Compra(pago3, envio3, Estado.ENTREGADO);
        Compra compra4 = new Compra(pago1, envio2, Estado.PENDIENTE);
        Compra compra5 = new Compra(pago2, envio3, Estado.CANCELADO);
        Compra compra6 = new Compra(pago3, envio1, Estado.ENTREGADO);
        Compra compra7 = new Compra(pago1, envio3, Estado.PENDIENTE);

        HistorialDeCompras historial1 = new HistorialDeCompras();
        HistorialDeCompras historial2 = new HistorialDeCompras();

        historial1.addCompra(compra1);
        historial1.addCompra(compra2);
        historial1.addCompra(compra3);
        historial2.addCompra(compra4);
        historial2.addCompra(compra5);
        historial2.addCompra(compra6);
        historial2.addCompra(compra7);


        //Crear usuarios
        fp.addUsuario("Juan", "649186063", (Monedero) monedero1, new PayPal[]{(PayPal) pp1}, new Tarjeta[]{(Tarjeta) tarjeta1}, historial1);
        fp.addUsuario("Pedro", "649186064", (Monedero) monedero2, new PayPal[]{(PayPal) pp2}, new Tarjeta[]{(Tarjeta) tarjeta2}, historial2);
        fp.addUsuario("Maria", "649186065", (Monedero) monedero1, new PayPal[]{(PayPal) pp3}, new Tarjeta[]{(Tarjeta) tarjeta1}, null);
        
        //Crear productos
        fp.addProducto("Producto 1", 10.0, "Descripcion 1");
        fp.addProducto("Producto 2", 20.0, "Descripcion 2");
        fp.addProducto("Producto 3", 30.0, "Descripcion 3");
        fp.addProducto("Producto 4", 40.0, "Descripcion 4");

        //Añadir productos a compras
        fp.addCompra(pago3, envio3, Estado.ENTREGADO);
        fp.addCompra(pago2, envio2, Estado.CANCELADO);
        fp.addCompra(pago1, envio1, Estado.PENDIENTE);
    }

    public static void main(String[] args) {

        Fallapop fp = new Fallapop();
        inicializar_datos(fp);

        System.out.println("Usuarios: " + fp.numUsuarios().size());

        System.out.println("Productos: " + fp.numProductos().size());

        System.out.println("Compras: " + fp.numCompras().size());

        System.out.println("Usuario 1: " + fp.verUsuario(0).getNombre());

        System.out.println("Producto 1: " + fp.verProducto(0).getNombre());

        System.out.println("Compra 1: " + fp.verCompra(0).getEstado());

        fp.removeUsuario(0);

        fp.removeProducto(0);

        fp.removeCompra(0);

        System.out.println("Usuarios: " + fp.numUsuarios().size());

        System.out.println("Productos: " + fp.numProductos().size());

        System.out.println("Compras: " + fp.numCompras().size());

        System.out.println("Usuario 1: " + fp.verUsuario(0).getNombre());

        System.out.println("Producto 1: " + fp.verProducto(0).getNombre());

        System.out.println("Compra 1: " + fp.verCompra(0).getEstado());


    
        
        FallapopForm fallapopForm = new FallapopForm();
        fallapopForm.setVisible(true);
    
    }   
}