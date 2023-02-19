package gui;

import java.awt.CardLayout;

import model.Fallapop;
import model.Monedero;
import model.Usuario;

public class MenuPrincipal extends javax.swing.JPanel {

    private static final String NAVEGADOR = "navegador";
    private static final String CATALOGO = "catalogo";
    private static final String HISTORIAL = "historial";
    private static final String FAVORITOS = "favoritos";

    private VentanaPrincipal ventana;
    private Fallapop fallapop;

    public MenuPrincipal(VentanaPrincipal ventana, Fallapop fallapop) {
        initComponents();

        this.fallapop = fallapop;
        this.ventana = ventana;

        iniciarInterfaz();
    }

    private CardLayout disposicion;

    public void iniciarInterfaz(){
        botonMenuPrincipal.addActionListener(e -> {
            disposicion.show(subPanel, NAVEGADOR);
        });

        botonCerrarSesion.addActionListener(e -> {
            fallapop.cerrarSesion();
            ventana.irIniciarSesion();
        });

        disposicion = new CardLayout();
        subPanel.setLayout(disposicion);

        PanelCatalogo catalogo = new PanelCatalogo(ventana, fallapop);
        Navegador navegador = new Navegador(this);

        subPanel.add(catalogo, CATALOGO);
        subPanel.add(navegador, NAVEGADOR);

        disposicion.show(subPanel, NAVEGADOR);
    }

    public void configurar(){
        Usuario usuario = fallapop.getUsuarioLogeado();

        Monedero monedero = usuario.getMonedero();
        etiquetaSaldo.setText("Saldo: " + monedero.getSaldo() + " €");

        etiquetaNombre.setText(usuario.getNombre());
    }

    public void irHistorial(){
        disposicion.show(subPanel, HISTORIAL);
    }

    public void irListaFavoritos(){
        disposicion.show(subPanel, FAVORITOS);
    }

    public void irPanelCatalogo(){
        disposicion.show(subPanel, CATALOGO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaSaldo = new javax.swing.JLabel();
        botonMenuPrincipal = new javax.swing.JButton();
        botonCerrarSesion = new javax.swing.JButton();
        subPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        jPanel1.add(etiquetaNombre);
        jPanel1.add(etiquetaSaldo);

        botonMenuPrincipal.setText("Menú principal");
        jPanel1.add(botonMenuPrincipal);

        botonCerrarSesion.setText("Cerrar sesión");
        jPanel1.add(botonCerrarSesion);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(subPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonMenuPrincipal;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaSaldo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel subPanel;
    // End of variables declaration//GEN-END:variables
}
