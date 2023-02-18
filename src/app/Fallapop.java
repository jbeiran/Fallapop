package app;

import gui.IniciarSesion;
import gui.Registrarse;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.util.ArrayList;
import model.CodigoDePromocion;
import model.Producto;
import model.Usuario;

public class Fallapop extends javax.swing.JFrame {

    private Usuario usuarioLogeado = null;
    private ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    private ArrayList<Producto> catalogo;
    private ArrayList<CodigoDePromocion> codigosDePromocion;
    
    public Fallapop(
        ArrayList<CodigoDePromocion> codigosDePromocion,
        ArrayList<Producto> catalogo
    ) {
        this.codigosDePromocion = codigosDePromocion;
        this.catalogo = catalogo;
        
        iniciarInterfaz();
    }
    
    JPanel panelPrincipal;
    CardLayout disposicion;
    
    private void iniciarInterfaz(){
        panelPrincipal = new JPanel();
        disposicion = new CardLayout();

        this.setContentPane(panelPrincipal);

        panelPrincipal.setLayout(disposicion);
        
        IniciarSesion iniciarSesion = new IniciarSesion(e -> {
            System.out.println("Se pulso ir a registrar");
            disposicion.show(panelPrincipal, "registrar");
        });

        Registrarse registrarse = new Registrarse(this);
        
        panelPrincipal.add(iniciarSesion, "iniciarSesion");
        panelPrincipal.add(registrarse, "registrarse");

        
        disposicion.show(panelPrincipal, "iniciarSesion");
    }

    public void irRegistrar(){
        disposicion.show(panelPrincipal, "registrar");
        System.out.println("Desde fallapop");
    }

    public void irIniciarSesion(){
        disposicion.show(panelPrincipal, "iniciarSesion");
    }
}
