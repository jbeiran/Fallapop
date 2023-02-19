package app;

import gui.VentanaPrincipal;
import model.Producto;
import model.Vendedor;
import model.Fallapop;
import model.Usuario;

import java.util.ArrayList;
import java.util.Arrays;

public class FallapopApp {

    private static ArrayList<Producto> catalogo;

    private static void inicializar_model(Fallapop fallapop){
        fallapop.registrarUsuario(new Usuario("rubisrage", "Rubén Santana", "789472", "123", 100.0));

        Vendedor vendedor1 = new Vendedor("Pepe", "66719038");
        Vendedor vendedor2 = new Vendedor("Jose", "78273283");
        Vendedor vendedor3 = new Vendedor("Dei", "82349924");

        catalogo = new ArrayList<>(Arrays.asList(
            new Producto("Cholas", 10.0, "Cómodas, para ir a la playa", vendedor1),
            new Producto("Luna de Plutón", 30.0, "Una obra maestra", vendedor1),
            new Producto("Calcetines de Pokemon", 15.0, "Comodos, para llevar en invierno", vendedor3),
            new Producto("Manta", 20.0, "De seda de muy buena calidad", vendedor3),
            new Producto("Cacharro para Perro", 7.0, "Muy poco uso.", vendedor2)
        ));

        
        fallapop.setCatalogo(catalogo);

        // TODO: Crear CodigoDePromocion
        fallapop.setCodigosDePromocion(null);
    }

    public static void main(String[] args) {
        Fallapop fallapop = new Fallapop();

        inicializar_model(fallapop);

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal(fallapop).setVisible(true);
        });
    }   
}
