package app;

import gui.IniciarSesion;
import gui.Registrarse;
import gui.MenuPrincipal;
import java.awt.CardLayout;

import javax.swing.JPanel;
import java.util.ArrayList;
import model.CodigoDePromocion;
import model.Producto;
import model.Usuario;

public class Fallapop extends javax.swing.JFrame {

    private static final String MENU_PRINCIPAL = "menuPrincipal";
    private static final String INICIAR_SESION = "iniciarSesion";
    private static final String REGISTRAR = "registrar";

    private Usuario usuarioLogeado = null;
    private ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    private ArrayList<Producto> catalogo;
    private ArrayList<CodigoDePromocion> codigosDePromocion;
    
    public Fallapop(
        ArrayList<Producto> catalogo,
        ArrayList<CodigoDePromocion> codigosDePromocion
    ) {
        super("Fallapop");

        this.catalogo = catalogo;
        this.codigosDePromocion = codigosDePromocion;

        usuariosRegistrados.add(new Usuario("rubisrage", "Rubén", "789472", "123", 100.0));
        
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
        
        IniciarSesion iniciarSesion = new IniciarSesion(this);
        Registrarse registrarse = new Registrarse(this);
        menuPrincipal = new MenuPrincipal(this);
        
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

    public boolean registrarUsuario(Usuario nuevoUsuario){
        for(Usuario usuario : usuariosRegistrados){
            if(usuario.getNombreDeUsuario().equals(nuevoUsuario.getNombreDeUsuario())){
                return false;
            }
        }

        usuariosRegistrados.add(nuevoUsuario);

        return iniciarSesion(nuevoUsuario.getNombreDeUsuario(), nuevoUsuario.getContr());
    }

    public boolean iniciarSesion(String nombreDeUsuario, String contr)
    {
        for(Usuario usuario : usuariosRegistrados){
            if(
                    usuario.getNombreDeUsuario().equals(nombreDeUsuario)
                    && usuario.getContr().equals(contr)
            ){
                usuarioLogeado = usuario;
                menuPrincipal.configurar();
                disposicion.show(panelPrincipal, MENU_PRINCIPAL);
                return true;
            }
        }

        return false;
    }

    public void cerrarSesion(){
        this.usuarioLogeado = null;

        disposicion.show(panelPrincipal, INICIAR_SESION);
    }

    public ArrayList<Producto> getCatalogo(){
        return this.catalogo;
    }

    public Usuario getUsuarioLogeado(){
        return usuarioLogeado;
    }
}
