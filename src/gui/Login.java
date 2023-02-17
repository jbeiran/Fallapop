package gui;

import java.awt.event.ActionListener; // Función que se ejecuta cuando se haga login/register
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Login extends JPanel {
    JTextField username = new JTextField(20);
    JPasswordField password = new JPasswordField(20);

    public Login(ActionListener onLogin, ActionListener onRegister) {
        initComponents(onLogin, onRegister);
    }

    private void initComponents(ActionListener onLogin, ActionListener onRegister){
        // De arriba abajo, como flex-direction: column
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);

        this.setLayout(layout);


        this.add(new JLabel("Username:"));

        JPanel tmp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tmp.add(username);

        this.add(tmp);

        this.add(new JLabel("Password:"));

        tmp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tmp.add(password);

        this.add(tmp);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(onLogin);
        this.add(loginButton);

        JButton goToRegister = new JButton("Or register instead");
        goToRegister.addActionListener(onRegister);
        this.add(goToRegister);
    }
}
