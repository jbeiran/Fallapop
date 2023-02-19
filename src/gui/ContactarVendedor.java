package gui;

import java.awt.CardLayout;
import java.util.StringJoiner;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Chat;
import model.Compra;
import model.Envio;
import model.Fallapop;
import model.Producto;
import model.Valoracion;
import model.Mensaje;

import conexion.Conexion;
import model.MetodoDeEnvio;
import model.MetodoDePago;
import model.Monedero;
import model.Pago;

public class ContactarVendedor extends javax.swing.JFrame {

    private static final String CHAT = "chat";
    private static final String COMPRAR = "comprar";
    private static final String COMPRA_EXITOSA = "compraExitosa";

    private Fallapop fallapop;
    private Producto producto;
    private VentanaPrincipal ventana;
    private Chat chat;
    private Conexion conexion;

    public ContactarVendedor(VentanaPrincipal ventana, Fallapop fallapop, Producto producto) {
        initComponents();

        this.ventana = ventana;
        this.fallapop = fallapop;
        this.producto = producto;
        this.chat = fallapop.crearChat();
        this.conexion = new Conexion(producto.getVendedor());

        conexion.recibirRespuesta(chat);

        iniciarInterfaz();
    }

    private CardLayout disposicion;
    private CardLayout disposicionPagar;

    private void iniciarInterfaz(){
        disposicion = (CardLayout) getContentPane().getLayout();
        disposicion.show(getContentPane(), CHAT);

        disposicionPagar = (CardLayout) comprarSubPanel.getLayout();
        disposicionPagar.show(comprarSubPanel, MetodoDePago.MONEDERO.toString());

        botonEnviar.addActionListener(e -> {

            String contenido = mensajeTF.getText();

            if(!contenido.isEmpty()){
                chat.enviarMensaje(fallapop.getUsuarioLogeado(), contenido);
                
                if(conexion.recibirRespuesta(chat)){
                    botonComprar.setEnabled(true);
                }

                mostrarChat();
                mensajeTF.setText("");
            }

        });

        botonValorar.addActionListener(e -> {

            ValorarVendedor valorarVendedor = new ValorarVendedor(this);
            valorarVendedor.setVisible(true);

            String descripcion = valorarVendedor.getDescripcion();
            Integer estrellas = valorarVendedor.getEstrellas();

            if(descripcion != null) {
                producto.getVendedor().añadirValoracion(
                        new Valoracion(descripcion, estrellas, fallapop.getUsuarioLogeado())
                );

                mostrarValoraciones();
            }

        });

        botonComprar.addActionListener(e -> {
            disposicion.show(getContentPane(), COMPRAR);
        });

        DefaultComboBoxModel<MetodoDePago> pagoModel = new DefaultComboBoxModel<>();
        pagoModel.addElement(MetodoDePago.MONEDERO);
        pagoModel.addElement(MetodoDePago.PAYPAL);

        pagoCB.setModel(pagoModel);
        pagoCB.addItemListener(e -> {
            MetodoDePago mPago = (MetodoDePago) pagoCB.getSelectedItem();
            disposicionPagar.show(comprarSubPanel, mPago.toString());
        });

        DefaultComboBoxModel<String> envioModel = new DefaultComboBoxModel<>();
        envioModel.addAll(List.of("Recoger", "Seur", "Correo"));

        envioCB.setModel(envioModel);
        envioCB.setSelectedItem("Recoger");

        botonSolicitar.addActionListener(e -> {
            String mEnvio = (String) envioCB.getSelectedItem();

            if(!mEnvio.equals("Recoger")){
                etiquetaAceptado.setVisible(true);
                etiquetaMetodoEnvio.setVisible(true);
                etiquetaMetodoEnvio.setText(mEnvio.toString());
            } else {
                etiquetaAceptado.setVisible(false);
                etiquetaMetodoEnvio.setVisible(false);
            }

        });

        botonPagar.addActionListener(e -> {

            MetodoDePago mPago = (MetodoDePago) pagoCB.getSelectedItem();

            Pago pago = new Pago(producto.getPrecio(), mPago);

            Envio envio;

            switch((String) envioCB.getSelectedItem()){
                case "Recoger":
                    envio = null;
                    break;
                case "Correo":
            //TODO: Construir una Direccion y pasarla en lugar de null
                    envio = new Envio(null, MetodoDeEnvio.CORREO);
                    break;
                case "Seur":
            //TODO: Construir una Direccion y pasarla en lugar de null
                    envio = new Envio(null, MetodoDeEnvio.SEUR);
                    break;
                default:
                    envio = null;
            }

            boolean conMonedero = mPago == MetodoDePago.MONEDERO;

            Compra compra = new Compra(pago, producto, envio);
            if(fallapop.getUsuarioLogeado().hacerCompra(compra, conMonedero))
            {
                ventana.getMenuPrincipal().actualizarSaldo();
                disposicion.show(getContentPane(), COMPRA_EXITOSA);
            } else {
                JOptionPane.showMessageDialog(
                        this, 
                        "No hay saldo suficiente.", 
                        "Error Saldo", 
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        botonTerminarCompra.addActionListener(e -> {
            this.setVisible(false);
        });

        Monedero monedero = fallapop.getUsuarioLogeado().getMonedero();
        etiquetaSaldo.setText(Double.toString(monedero.getSaldo()) + " €");

        etiquetaAceptado.setVisible(false);
        etiquetaMetodoEnvio.setVisible(false);

        etiquetaNombre.setText(producto.getVendedor().getNombre());
        etiquetaTelefono.setText(producto.getVendedor().getTelefono());

        etiquetaPrecio.setText(Double.toString(producto.getPrecio()) + " €");

        mostrarChat();
        mostrarValoraciones();
    }

    private void mostrarChat(){
        StringJoiner sj = new StringJoiner("\n");

        for(Mensaje mensaje : chat.getMensajes()){
            sj.add(mensaje.toString());
        }

        chatTA.setText(sj.toString());
    }

    private void mostrarValoraciones(){
        DefaultListModel<Valoracion> defaultListModel = new DefaultListModel<>();
        defaultListModel.addAll(producto.getVendedor().getValoraciones());

        valoracionesList.setModel(defaultListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        mensajeTF = new javax.swing.JTextField();
        botonEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaTelefono = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        valoracionesList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        chatTA = new javax.swing.JTextArea();
        botonValorar = new javax.swing.JButton();
        botonComprar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pagoCB = new javax.swing.JComboBox<>();
        comprarSubPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        etiquetaSaldo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        envioCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonSolicitar = new javax.swing.JButton();
        etiquetaAceptado = new javax.swing.JLabel();
        etiquetaMetodoEnvio = new javax.swing.JLabel();
        botonPagar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        etiquetaPrecio = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        botonTerminarCompra = new javax.swing.JButton();

        jLabel12.setText("jLabel12");

        getContentPane().setLayout(new java.awt.CardLayout());

        botonEnviar.setText("Enviar");

        jLabel1.setText("Vendedor");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Teléfono:");

        jLabel4.setText("Valoraciones:");

        jScrollPane2.setViewportView(valoracionesList);

        chatTA.setColumns(20);
        chatTA.setRows(5);
        chatTA.setFocusable(false);
        jScrollPane3.setViewportView(chatTA);

        botonValorar.setText("Valora a este vendedor");

        botonComprar.setText("Comprar producto");
        botonComprar.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mensajeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEnviar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonComprar, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(etiquetaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetaTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(botonValorar, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(etiquetaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(etiquetaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensajeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEnviar)
                    .addComponent(botonValorar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonComprar)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "chat");

        comprarSubPanel.setLayout(new java.awt.CardLayout());

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel11.setText("Pago con monedero");

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel13.setText("Saldo:");

        etiquetaSaldo.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(etiquetaSaldo)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addGap(100, 100, 100)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(etiquetaSaldo))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        comprarSubPanel.add(jPanel4, "Monedero");

        jLabel9.setText("Usuario:");

        jLabel10.setText("Contraseña:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        comprarSubPanel.add(jPanel5, "Paypal");

        jLabel5.setText("Método de pago:");

        jLabel6.setText("Solicitar método de envío");

        botonSolicitar.setText("Solicitar");

        etiquetaAceptado.setForeground(new java.awt.Color(0, 153, 0));
        etiquetaAceptado.setText("Método de envío aceptado: ");

        etiquetaMetodoEnvio.setForeground(new java.awt.Color(51, 153, 0));
        etiquetaMetodoEnvio.setText("CORREO");

        botonPagar.setText("Pagar");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel7.setText("Precio:");

        etiquetaPrecio.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        etiquetaPrecio.setText("30.0€");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pagoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comprarSubPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonSolicitar)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiquetaPrecio)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(envioCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(etiquetaAceptado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiquetaMetodoEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comprarSubPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(envioCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSolicitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaAceptado)
                            .addComponent(etiquetaMetodoEnvio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(etiquetaPrecio))
                        .addGap(110, 110, 110)
                        .addComponent(botonPagar)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, "comprar");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 48)); // NOI18N
        jLabel8.setText("Compra realizada con éxito");

        botonTerminarCompra.setText("Aceptar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(botonTerminarCompra)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel8)
                .addGap(48, 48, 48)
                .addComponent(botonTerminarCompra)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, "compraExitosa");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonComprar;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonPagar;
    private javax.swing.JButton botonSolicitar;
    private javax.swing.JButton botonTerminarCompra;
    private javax.swing.JButton botonValorar;
    private javax.swing.JTextArea chatTA;
    private javax.swing.JPanel comprarSubPanel;
    private javax.swing.JComboBox<String> envioCB;
    private javax.swing.JLabel etiquetaAceptado;
    private javax.swing.JLabel etiquetaMetodoEnvio;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPrecio;
    private javax.swing.JLabel etiquetaSaldo;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField mensajeTF;
    private javax.swing.JComboBox<MetodoDePago> pagoCB;
    private javax.swing.JList<Valoracion> valoracionesList;
    // End of variables declaration//GEN-END:variables
}
