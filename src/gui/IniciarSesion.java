package gui;

import javax.swing.JOptionPane;

import model.Fallapop;


public class IniciarSesion extends javax.swing.JPanel {

    private VentanaPrincipal ventana;
    private Fallapop fallapop;
    
    public IniciarSesion(VentanaPrincipal ventana, Fallapop fallapop) {
        initComponents();

        iniciarInterfaz();
        
        this.fallapop = fallapop;
        this.ventana = ventana;
    }

    public void iniciarInterfaz(){
        botonRegistrarse.addActionListener(e -> {
            ventana.irRegistrar();
        });

        botonIniciarSesion.addActionListener(e -> {
            if(fallapop.iniciarSesion(nombreDeUsuarioTF.getText(), contraseñaPF.getText())){

                ventana.irMenuPrincipal();

            } else {
                JOptionPane.showMessageDialog(
                        ventana, 
                        "Credenciales incorrectas.",
                        "Credenciales incorrectas",
                        JOptionPane.ERROR_MESSAGE
                        );
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreDeUsuarioTF = new javax.swing.JTextField();
        contraseñaPF = new javax.swing.JPasswordField();
        botonIniciarSesion = new javax.swing.JButton();
        botonRegistrarse = new javax.swing.JButton();

        jLabel1.setText("Nombre de usuario:");

        jLabel2.setText("Contraseña:");

        botonIniciarSesion.setText("Iniciar sesión");

        botonRegistrarse.setText("Registrarse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreDeUsuarioTF)
                            .addComponent(contraseñaPF, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreDeUsuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contraseñaPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(botonIniciarSesion)
                .addGap(18, 18, 18)
                .addComponent(botonRegistrarse)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JPasswordField contraseñaPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nombreDeUsuarioTF;
    // End of variables declaration//GEN-END:variables
}
