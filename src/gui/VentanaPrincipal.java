package gui;

import java.awt.CardLayout;
import javax.swing.JPanel;

import model.Fallapop;


public class VentanaPrincipal extends javax.swing.JFrame {

    private static final String MENU_PRINCIPAL = "menuPrincipal";
    private static final String INICIAR_SESION = "iniciarSesion";
    private static final String REGISTRAR = "registrar";

    private Fallapop fallapop;

    public VentanaPrincipal(Fallapop fallapop) {
        super("Fallapop");
        
        this.fallapop = fallapop;
        
        iniciarInterfaz();
    }
    
    private JPanel panelPrincipal;
    private CardLayout disposicion;
    private MenuPrincipal menuPrincipal;
    
    private void iniciarInterfaz(){
        panelPrincipal = new JPanel();
        disposicion = new CardLayout();

        this.setContentPane(panelPrincipal);

        panelPrincipal.setLayout(disposicion);
        
        IniciarSesion iniciarSesion = new IniciarSesion(this, fallapop);
        Registrarse registrarse = new Registrarse(this, fallapop);
        menuPrincipal = new MenuPrincipal(this, fallapop);
        
        panelPrincipal.add(iniciarSesion, INICIAR_SESION);
        panelPrincipal.add(registrarse, REGISTRAR);
        panelPrincipal.add(menuPrincipal, MENU_PRINCIPAL);

        
        disposicion.show(panelPrincipal, INICIAR_SESION);
    }

    public void irRegistrar(){
        disposicion.show(panelPrincipal, REGISTRAR);
    }

    public void irIniciarSesion(){
        disposicion.show(panelPrincipal, INICIAR_SESION);
    }

    public void irMenuPrincipal(){
                menuPrincipal.configurar();
                disposicion.show(panelPrincipal, MENU_PRINCIPAL);
    }

}
