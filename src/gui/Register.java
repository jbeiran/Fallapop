package gui;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class Register extends JPanel {
    public Register(ActionListener onRegister, ActionListener goToLogin) {
        
        this.add(new JLabel("Aquí irían los campos del register"));

        JButton registerButton = new JButton("Register");
        JButton goToLoginButton = new JButton("Go back to login");

        registerButton.addActionListener(onRegister);
        goToLoginButton.addActionListener(goToLogin);

        JPanel southPane = new JPanel(new FlowLayout(FlowLayout.CENTER));

        southPane.add(registerButton);
        southPane.add(goToLoginButton);

        this.add(southPane, BorderLayout.SOUTH);
    }
}
